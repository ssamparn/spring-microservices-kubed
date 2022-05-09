package com.microservices.kubed.creditcard.model;

import lombok.Data;

import java.sql.Date;

@Data
public class Card {
    private int cardId;
    private int customerId;
    private String cardNumber;
    private String cardType;
    private int totalLimit;
    private int amountUsed;
    private int availableAmount;
    private Date createDt;
}