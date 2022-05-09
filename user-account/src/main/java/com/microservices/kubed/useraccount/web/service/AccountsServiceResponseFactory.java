package com.microservices.kubed.useraccount.web.service;

import com.microservices.kubed.useraccount.entity.AccountsEntity;
import com.microservices.kubed.useraccount.model.Account;
import org.springframework.stereotype.Service;

@Service
public class AccountsServiceResponseFactory {

    public Account createAccountResponse(AccountsEntity accountsEntity) {
        return Account.builder()
                .accountNumber(accountsEntity.getAccountNumber())
                .customerId(accountsEntity.getCustomerId())
                .accountType(accountsEntity.getAccountType())
                .branchAddress(accountsEntity.getBranchAddress())
                .createDt(accountsEntity.getCreateDt())
                .build();
    }
}