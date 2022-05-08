package com.microservices.kubed.creditcard.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Data
@Configuration
@ConfigurationProperties(prefix = "cards")
public class CardServiceConfigProps {
    private String msg;
    private String buildVersion;
    private Map<String, String> mailDetails;
    private List<String> activeBranches;
}
