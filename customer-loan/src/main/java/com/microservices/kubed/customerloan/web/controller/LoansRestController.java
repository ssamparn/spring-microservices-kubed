package com.microservices.kubed.customerloan.web.controller;

import com.microservices.kubed.customerloan.entity.LoanEntity;
import com.microservices.kubed.customerloan.model.Customer;
import com.microservices.kubed.customerloan.repository.LoansDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LoansRestController {

    private final LoansDataRepository loansRepository;

    @PostMapping("/loans")
    public ResponseEntity<List<LoanEntity>> getLoansDetails(@RequestBody Customer customer) {

        List<LoanEntity> loans = loansRepository.findByCustomerIdOrderByStartDateDesc(customer.getCustomerId());

        return new ResponseEntity<>(loans, HttpStatus.OK);
    }
}
