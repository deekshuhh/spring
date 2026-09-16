import {readFile} from "fs/promises";
/*const order={
    "OrderID":12434353553,
    "OrderDate":"2026-09-07T10:28:00.123Z",
    "Customer":{
        "Name":"John",
        "Email":"johndoe@gmail.com",
        "City":"Hyderabad"
    },
    "items":[{"product":"Door_mat","qauntity":2,"price":245},{"product":"Curtains","qauntity":1,"price":499}],
    "delivery_status":"Packing",
    "payment_completed":true,
    "COD":null    
};*/

const data=await readFile("order.json");

// ` for multi line string -> JSON TEXT 
// {} only for a JavaScript Object 

const parsedData=JSON.parse(data);
console.log(parsedData.Customer.Name);
console.log(parsedData.delivery_status);
console.log(parsedData.items[0].product);

parsedData.items.forEach(item =>{
    console.log(item.product, item.qauntity);
});

const prettyJsonString=JSON.stringify(parsedData,null,2);
console.log(parsedData);
console.log(prettyJsonString);