// "use strict";

const fs = require("fs");
const path = require("path");
const { fundTransfer } = require("./fundTransfer");

const schema = JSON.parse(fs.readFileSync(path.join(__dirname, "schema.json"), "utf8"));

// A small schema validator for the keywords used in schema.json.
// In a production application, use a complete JSON Schema validator such as Ajv.
function validate(data, rules) {
  const errors = [];

  if (rules.type === "object" && (data === null || Array.isArray(data) || typeof data !== "object")) {
    return ["Request must be a JSON object."];
  }

  for (const field of rules.required || []) {
    if (!(field in data)) errors.push(`Missing required field: ${field}`);
  }

  for (const [field, value] of Object.entries(data)) {
    const rule = rules.properties[field];
    if (!rule) {
      if (rules.additionalProperties === false) errors.push(`Unexpected field: ${field}`);
      continue;
    }
    if (rule.type === "string" && typeof value !== "string") errors.push(`${field} must be a string.`);
    if (rule.type === "number" && (typeof value !== "number" || !Number.isFinite(value))) errors.push(`${field} must be a number.`);
    if (rule.pattern && typeof value === "string" && !new RegExp(rule.pattern).test(value)) errors.push(`${field} must match ${rule.pattern}.`);
    if (rule.enum && !rule.enum.includes(value)) errors.push(`${field} must be one of: ${rule.enum.join(", ")}.`);
    if (typeof value === "number" && rule.minimum !== undefined && value < rule.minimum) errors.push(`${field} must be at least ${rule.minimum}.`);
    if (typeof value === "number" && rule.maximum !== undefined && value > rule.maximum) errors.push(`${field} must not exceed ${rule.maximum}.`);
    if (typeof value === "string" && rule.minLength !== undefined && value.length < rule.minLength) errors.push(`${field} cannot be empty.`);
  }
  return errors;
}

const errors = validate(fundTransfer, schema);
if (errors.length === 0) {
  console.log("Fund transfer request is valid.");
} else {
  console.error("Fund transfer request is invalid:");
  errors.forEach((error) => console.error("- " + error));
  process.exitCode = 1;
}

module.exports = { validate };
