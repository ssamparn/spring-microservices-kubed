package com.microservices.kubed.useraccount.web.controller;

import com.microservices.kubed.useraccount.entity.AccountsEntity;
import com.microservices.kubed.useraccount.entity.CustomerEntity;
import com.microservices.kubed.useraccount.repository.AccountsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserAccountsRestController {

    private final AccountsRepository accountsRepository;

    @PostMapping("/account")
    public ResponseEntity<AccountsEntity> getAccountDetails(@RequestBody CustomerEntity customer) {

        AccountsEntity accounts = accountsRepository.findByCustomerId(customer.getCustomerId());

        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }
}
