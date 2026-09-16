package com.oracle.api.dto;

import javax.print.DocFlavor;

public class CustomerRequest {
    private int id;
    private int balance;
    private String name;

    public CustomerRequest() {
    }

    public int getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
