package com.microservices.kubed.useraccount.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Account {
    private long accountNumber;
    private int customerId;
    private String accountType;
    private String branchAddress;
    private LocalDate createDt;
}
