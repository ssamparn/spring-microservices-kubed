package com.microservices.kubed.customerloan.model;

import lombok.Data;

import java.sql.Date;

@Data
public class Loan {
    private int loanNumber;
    private int customerId;
    private Date startDate;
    private String loanType;
    private int totalLoan;
    private int amountPaid;
    private int outstandingAmount;
    private String createDate;
}