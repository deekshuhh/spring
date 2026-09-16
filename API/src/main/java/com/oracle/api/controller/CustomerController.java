package com.oracle.api.controller;


import com.oracle.api.Model.Customer;
//import com.oracle.api.dto.CustomerDto;
import com.oracle.api.dto.CustomerRequest;
import com.oracle.api.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping()
    public ResponseEntity<List<Customer>> getAllCustomers(){
        return new ResponseEntity<>(customerService.getAllCustomer(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable int id) {
        return new ResponseEntity<>(customerService.getCustomer(id), HttpStatus.FOUND);
    }

    @PostMapping()
    public ResponseEntity<Customer> addCustomers(@RequestBody CustomerRequest request){

        Customer customer = customerService.createCustomer(request);
        if(customer == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        return ResponseEntity.status(HttpStatus.CREATED).body(customer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCompleteCustomer(@RequestBody CustomerRequest request) {
        return new ResponseEntity<>(customerService.updateCustomer(request), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public Customer patchCustomer(@PathVariable int id, @RequestParam String name) {
        return customerService.patchCustomer(id, name);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable int id) {
          customerService.deleteCustomer(id);
    }

}

