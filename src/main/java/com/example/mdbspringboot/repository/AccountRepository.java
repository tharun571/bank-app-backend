package com.example.mdbspringboot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.mdbspringboot.model.Account;

public interface AccountRepository extends MongoRepository<Account, Integer> {

    @Query("{ 'accountNumber' : ?0 }")
    Account findByAccountNumber(Integer accountNumber);
}

