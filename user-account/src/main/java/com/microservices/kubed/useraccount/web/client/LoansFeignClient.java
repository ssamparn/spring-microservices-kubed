package com.microservices.kubed.useraccount.web.client;

import com.microservices.kubed.useraccount.model.Customer;
import com.microservices.kubed.useraccount.model.Loan;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("loans")
public interface LoansFeignClient {

    @PostMapping(value = "loans", consumes = MediaType.APPLICATION_JSON_VALUE)
    List<Loan> getLoanDetails(@RequestBody Customer customer);
}
