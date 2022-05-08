package com.microservices.kubed.customerloan.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "LOAN_TABLE")
public class LoanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LOAN_NUMBER")
    private int loanNumber;

    @Column(name = "CUSTOMER_ID")
    private int customerId;

    @Column(name="START_DATE")
    private Date startDate;

    @Column(name = "LOAN_TYPE")
    private String loanType;

    @Column(name = "TOTAL_LOAN")
    private int totalLoan;

    @Column(name = "AMOUNT_PAID")
    private int amountPaid;

    @Column(name = "OUTSTANDING_LOAN_AMOUNT")
    private int outstandingAmount;

    @Column(name = "CREATION_DATE")
    private String createDate;

}
