package com.microservices.kubed.creditcard.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "CARDS_TABLE")
public class CardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CARD_ID")
    private int cardId;

    @Column(name = "CUSTOMER_ID")
    private int customerId;

    @Column(name = "CARD_NUMBER")
    private String cardNumber;

    @Column(name = "CARD_TYPE")
    private String cardType;

    @Column(name = "TOTAL_LIMIT")
    private int totalLimit;

    @Column(name = "AMOUNT_USED")
    private int amountUsed;

    @Column(name = "AVAILABLE_AMOUNT")
    private int availableAmount;

    @Column(name = "CREATION_DATE")
    private Date createDt;

}
