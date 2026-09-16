// "use strict";

// JSON data received as a string (for example, from a banking API response).
const customerJsonString = `{
  "customerId": "CUST100245",
  "customerName": "Ananya Sharma",
  "pan": "BQZPS4821L",
  "accounts": [{
    "accountNumber": "SB1002456789",
    "branch": { "branchName": "MG Road Branch" },
    "currentBalance": 84500.75
  }]
}`;

const customer = JSON.parse(customerJsonString);
const primaryAccount = customer.accounts[0];

console.log("Customer Name:", customer.customerName);
console.log("PAN:", customer.pan);
console.log("Branch Name:", primaryAccount.branch.branchName);
console.log("Current Balance: ₹" + primaryAccount.currentBalance.toFixed(2));
