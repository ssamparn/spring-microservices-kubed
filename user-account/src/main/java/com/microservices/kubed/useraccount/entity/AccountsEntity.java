package com.microservices.kubed.useraccount.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "ACCOUNTS_TABLE")
public class AccountsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ACCOUNT_NUMBER")
    private long accountNumber;

    @Column(name = "CUSTOMER_ID")
    private int customerId;

    @Column(name="ACCOUNT_TYPE")
    private String accountType;

    @Column(name = "BRANCH_ADDRESS")
    private String branchAddress;

    @Column(name = "CREATE_DATE")
    private LocalDate createDt;

}
