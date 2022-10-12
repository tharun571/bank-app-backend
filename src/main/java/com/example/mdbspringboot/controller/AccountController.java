package com.example.mdbspringboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mdbspringboot.model.Account;
import com.example.mdbspringboot.repository.AccountRepository;

@RestController
public class AccountController {

    @Autowired
    AccountRepository accountRepository;
    
    @RequestMapping("/")
    public String account() {
        return "Account";
    }

    @PostMapping("/addAccount")
    public String saveAccount(@RequestBody Account account) {
        accountRepository.save(account);
        return "Added account with id: " + account.getAccountNumber();
    }

    @GetMapping("/getBalance/{accountNumber}")
    public Integer getBalance(@PathVariable Integer accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber).getBalance();
    }

    @PostMapping("/updateBalance/{accountNumber}/{amount}")
    public String updateBalance(@PathVariable Integer accountNumber, @PathVariable Integer amount) {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        if (account.getBalance() + amount < 0) {
            return "Insufficient funds";
        }
        
        List<Integer> transactions = account.getTransactions();
        if(transactions == null) transactions = new ArrayList<Integer>();
        transactions.add(amount);
        account.setTransactions(transactions);
        account.setBalance(account.getBalance() + amount);
        accountRepository.save(account);
        return "Updated balance";
        
    }
    
    @GetMapping("/getTransactions/{accountNumber}")
    public List<Integer> getTransactions(@PathVariable Integer accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber).getTransactions();
    }
}
