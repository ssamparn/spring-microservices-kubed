package com.microservices.kubed.useraccount.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class Properties {
    private String msg;
    private String buildVersion;
    private Map<String, String> mailDetails;
    private List<String> activeBranches;
}
