package com.oracle.api.repository;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import com.oracle.api.Model.Customer;
import org.apache.catalina.util.CustomObjectInputStream;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomerRepository {
    HashMap<Integer, Customer> map = new HashMap<>();

    public CustomerRepository() {
    }

    public Customer createCustomer(int id, int balance, String name) {

        if(!map.containsKey(id)) {
            Customer customer = new Customer(id, balance, name);
            map.put(id, customer);
            return map.get(id);
        }
        return map.get(id);
    }

    public Customer getCustomer(int id) {
        return map.get(id);
    }

    public List<Customer> getAllCustomer() {
        return new ArrayList<>(map.values());
    }

    public Customer updateCustomer(int id, int balance, String name) {
        Customer customer = map.get(id);
        customer.setBalance(balance);
        customer.setName(name);
        map.put(id, customer);
        return customer;
    }

    public Customer patchCustomer(int id, String name) {
        Customer customer = map.get(id);
        customer.setName(name);
        map.put(id, customer);
        return map.get(id);
    }

    public void deleteCustomer(int id) {
        map.remove(id);
    }
}
