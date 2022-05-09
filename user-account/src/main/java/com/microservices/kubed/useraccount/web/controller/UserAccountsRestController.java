package com.microservices.kubed.useraccount.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.microservices.kubed.useraccount.model.*;
import com.microservices.kubed.useraccount.properties.AccountServiceConfigProps;
import com.microservices.kubed.useraccount.web.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserAccountsRestController {

    private final AccountService accountsService;
    private final AccountServiceConfigProps configProps;

    @PostMapping("/account")
    public ResponseEntity<Account> getAccountDetails(@RequestBody Customer customer) {

        Account account = accountsService.getAccount(customer.getCustomerId());

        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @GetMapping("/account/properties")
    public ResponseEntity<String> getPropertyDetails() throws JsonProcessingException {

        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        ConfigProperties configProperties = new ConfigProperties(configProps.getMsg(), configProps.getBuildVersion(),
                configProps.getMailDetails(), configProps.getActiveBranches());

        String jsonString = objectWriter.writeValueAsString(configProperties);

        return new ResponseEntity<>(jsonString, HttpStatus.OK);
    }

    @PostMapping("/account/customer-details")
    public ResponseEntity<CustomerDetails> getCustomerDetail(@RequestBody Customer customer) {

        Account account = accountsService.getAccount(customer.getCustomerId());

        CustomerDetails customerDetails = accountsService.getCustomerDetails(customer, account);

        return new ResponseEntity<>(customerDetails, HttpStatus.OK);
    }
}
