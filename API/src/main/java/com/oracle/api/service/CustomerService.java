package com.oracle.api.service;

import com.oracle.api.Model.Customer;
import com.oracle.api.dto.CustomerRequest;
import com.oracle.api.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {


    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(CustomerRequest request) {
        return customerRepository.createCustomer(request.getId(), request.getBalance(), request.getName());
    }

    public Customer updateCustomer(CustomerRequest request) {
        return customerRepository.updateCustomer(request.getId(), request.getBalance(), request.getName());

    }

    public Customer patchCustomer(int id, String name) {
        return customerRepository.patchCustomer(id, name);
    }


    public List<Customer> getAllCustomer() {
        return customerRepository.getAllCustomer();
    }

    public Customer getCustomer(int id) {
        return customerRepository.getCustomer(id);
    }

    public void deleteCustomer(int id) {
        customerRepository.deleteCustomer(id);
    }
}
