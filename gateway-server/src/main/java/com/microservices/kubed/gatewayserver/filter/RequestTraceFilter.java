package com.microservices.kubed.gatewayserver.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Slf4j
@Component
public class RequestTraceFilter implements GlobalFilter {

    private String requestTraceId;

    @Autowired
    private FilterUtility filterUtility;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        HttpHeaders requestHeaders = exchange.getRequest().getHeaders();

        if (isTraceIdPresent(requestHeaders)) {
            log.debug("X-Request-Trace-Id found in tracing filter: {}", filterUtility.getRequestTraceId(requestHeaders));
        } else {
            requestTraceId = createRequestTraceId();
            exchange = filterUtility.setRequestTraceId(exchange, requestTraceId);
            log.debug("X-Request-Trace-Id generated tracing filter: {}", requestTraceId);
        }
        return chain.filter(exchange);
    }

    private String createRequestTraceId() {
        return UUID.randomUUID().toString();
    }

    private boolean isTraceIdPresent(HttpHeaders requestHeaders) {
        return filterUtility.getRequestTraceId(requestHeaders) != null;
    }

}
