package com.microservices.kubed.useraccount.web.service;

import com.microservices.kubed.useraccount.entity.AccountsEntity;
import com.microservices.kubed.useraccount.model.*;
import com.microservices.kubed.useraccount.repository.AccountsRepository;
import com.microservices.kubed.useraccount.web.client.CardsFeignClient;
import com.microservices.kubed.useraccount.web.client.LoansFeignClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountsRepository accountsRepository;
    private final AccountsServiceResponseFactory responseFactory;
    private final CardsFeignClient cardsFeignClient;
    private final LoansFeignClient loansFeignClient;

    public Account getAccount(final Integer customerId) {
        AccountsEntity accountsEntity = accountsRepository.findByCustomerId(customerId);

        return responseFactory.createAccountResponse(accountsEntity);
    }

    @CircuitBreaker(name = "customer-details", fallbackMethod = "customerDetailsFallback")
    @Retry(name = "customer-details", fallbackMethod = "customerDetailsFallback")
    @RateLimiter(name = "customer-details")
    public CustomerDetails getCustomerDetails(final Customer customer, final Account account) {
        List<Loan> customerLoanDetails = loansFeignClient.getLoanDetails(customer);

        List<Card> customerCardDetails = cardsFeignClient.getCardDetails(customer);

        return CustomerDetails.builder()
                .account(account)
                .loans(customerLoanDetails)
                .cards(customerCardDetails)
                .build();
    }

    private CustomerDetails customerDetailsFallback(final Customer customer, final Account account, Throwable t) {
        List<Loan> customerLoanDetails = loansFeignClient.getLoanDetails(customer);

        return CustomerDetails.builder()
                .account(account)
                .loans(customerLoanDetails)
                .build();
    }
}
