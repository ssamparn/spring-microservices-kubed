package com.microservices.kubed.customerloan.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.microservices.kubed.customerloan.model.ConfigProperties;
import com.microservices.kubed.customerloan.model.Customer;
import com.microservices.kubed.customerloan.model.Loan;
import com.microservices.kubed.customerloan.properties.LoanServiceConfigProps;
import com.microservices.kubed.customerloan.repository.LoansDataRepository;
import com.microservices.kubed.customerloan.service.LoansServiceResponseFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LoansRestController {

    private final LoansDataRepository loansRepository;
    private final LoanServiceConfigProps configProps;
    private final LoansServiceResponseFactory responseFactory;

    @PostMapping("/loans")
    public ResponseEntity<List<Loan>> getLoansDetails(@RequestBody Customer customer) {

        var loansEntity = loansRepository.findByCustomerIdOrderByStartDateDesc(customer.getCustomerId());

        var loans = responseFactory.createLoansResponse(loansEntity);

        return new ResponseEntity<>(loans, HttpStatus.OK);
    }

    @GetMapping("/loans/properties")
    public ResponseEntity<String> getPropertyDetails() throws JsonProcessingException {

        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        ConfigProperties properties = new ConfigProperties(configProps.getMsg(), configProps.getBuildVersion(),
                configProps.getMailDetails(), configProps.getActiveBranches());

        String jsonString = objectWriter.writeValueAsString(properties);

        return new ResponseEntity<>(jsonString, HttpStatus.OK);
    }
}
