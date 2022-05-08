package com.microservices.kubed.useraccount.model;

import com.microservices.kubed.useraccount.entity.AccountsEntity;
import lombok.Data;

import java.util.List;

@Data
public class CustomerDetails {

    private AccountsEntity accounts;
    private List<Loan> loans;
    private List<Card> cards;

}
