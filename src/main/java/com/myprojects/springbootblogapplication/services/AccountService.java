package com.myprojects.springbootblogapplication.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myprojects.springbootblogapplication.models.Account;
import com.myprojects.springbootblogapplication.repositories.AccountRepository;

@Service
public class AccountService {
    
    @Autowired
    private AccountRepository accountRepository;

    public Account save(Account account) {
        return accountRepository.save(account);
    }

    public Optional<Account> findByEmail(String email) {
        return accountRepository.findOneByEmail(email);
    }

}
