package com.microservices.kubed.gatewayserver.config;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class GatewayServerInfoContributor implements InfoContributor {

    public static Map<String, String> gateway_server_info;
    static {
        gateway_server_info = new HashMap<>();
        gateway_server_info.put("name", "gateway-server");
        gateway_server_info.put("description", "gateway-server-which-acts-as-api-gateway");
        gateway_server_info.put("version", "1.0.0");
    }

    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("gateway-server-info", gateway_server_info);
    }

}