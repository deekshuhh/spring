// "use strict";

const fundTransfer = {
  fromAccount: "SB1002456789",
  toAccount: "SB1009876543",
  amount: 12500,
  transferMode: "IMPS",
  remarks: "Monthly rent payment"
};

const fundTransferJson = JSON.stringify(fundTransfer, null, 2);
console.log(fundTransferJson);

// Exporting makes the object reusable by another JavaScript module if needed.
module.exports = { fundTransfer, fundTransferJson };
