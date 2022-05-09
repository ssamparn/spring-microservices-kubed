package com.microservices.kubed.customerloan.service;

import com.microservices.kubed.customerloan.entity.LoanEntity;
import com.microservices.kubed.customerloan.model.Loan;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoansServiceResponseFactory {

    public List<Loan> createLoansResponse(List<LoanEntity> loansEntity) {
        return loansEntity.stream()
                .map(loanEntity -> {
                    Loan loan = new Loan();
                    loan.setLoanNumber(loanEntity.getLoanNumber());
                    loan.setCustomerId(loanEntity.getCustomerId());
                    loan.setStartDate(loanEntity.getStartDate());
                    loan.setLoanType(loanEntity.getLoanType());
                    loan.setTotalLoan(loanEntity.getTotalLoan());
                    loan.setAmountPaid(loanEntity.getAmountPaid());
                    loan.setOutstandingAmount(loanEntity.getOutstandingAmount());
                    loan.setCreateDate(loanEntity.getCreateDate());
                    return loan;
                }).collect(Collectors.toList());
    }
}
