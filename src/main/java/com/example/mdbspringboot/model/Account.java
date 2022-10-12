package com.example.mdbspringboot.model;


import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Account")
public class Account {
    
    @Id
    private Integer accountNumber;
    private Integer balance;

    private List<Integer> transactions;

    public Account( Integer accountNumber, Integer balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.transactions = null;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public List<Integer> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Integer> transactions) {
        this.transactions = transactions;
    }
}
