package com.microservices.kubed.creditcard.config;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CreditCardServiceInfoContributor implements InfoContributor {

    public static Map<String, String> credit_card_info;
    static {
        credit_card_info = new HashMap<>();
        credit_card_info.put("name", "card-microservice");
        credit_card_info.put("description", "bank-application");
        credit_card_info.put("version", "1.0.0");
    }

    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("credit-card-info", credit_card_info);
    }
}
