package com.microservices.kubed.customerloan.config;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CustomerLoanServiceInfoContributor implements InfoContributor {

    public static Map<String, String> customer_loan_info;
    static {
        customer_loan_info = new HashMap<>();
        customer_loan_info.put("name", "loan-microservice");
        customer_loan_info.put("description", "bank-application");
        customer_loan_info.put("version", "1.0.0");
    }

    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("customer-loan-info", customer_loan_info);
    }
}
