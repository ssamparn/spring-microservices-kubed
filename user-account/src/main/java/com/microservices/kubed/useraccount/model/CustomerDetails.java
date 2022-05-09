package com.microservices.kubed.useraccount.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CustomerDetails {
    private Account account;
    private List<Loan> loans;
    private List<Card> cards;
}
