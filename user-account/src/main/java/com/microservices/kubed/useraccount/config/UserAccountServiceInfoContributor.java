package com.microservices.kubed.useraccount.config;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserAccountServiceInfoContributor implements InfoContributor {

    public static Map<String, String> user_account_info;
    static {
        user_account_info = new HashMap<>();
        user_account_info.put("name", "accounts-microservice");
        user_account_info.put("description", "bank-application");
        user_account_info.put("version", "1.0.0");
    }

    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("user-account-info", user_account_info);
    }
}
