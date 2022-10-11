package com.example.demo.mdbspringboot.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Account")
public class Account {
    
    @Id
    private String id;

    private String accountNumber;
    private Integer balance;

    public Account(String id,String accountNumber, Integer balance) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }
}
