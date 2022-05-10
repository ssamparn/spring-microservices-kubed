package com.microservices.kubed.gatewayserver.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import reactor.core.publisher.Mono;

import static com.microservices.kubed.gatewayserver.filter.FilterUtility.REQUEST_TRACE_ID;

@Slf4j
@Configuration
public class ResponseTraceFilter {

    @Autowired
    private FilterUtility filterUtility;

    @Bean
    public GlobalFilter postGlobalFilter() {
        return (exchange, chain) -> {
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                HttpHeaders requestHeaders = exchange.getRequest().getHeaders();
                String requestTraceId = filterUtility.getRequestTraceId(requestHeaders);
                log.debug("Updated the correlation id to the outbound headers {}", requestTraceId);
                exchange.getResponse().getHeaders().add(REQUEST_TRACE_ID, requestTraceId);
            }));
        };
    }
}
