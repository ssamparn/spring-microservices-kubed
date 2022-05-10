package com.microservices.kubed.gatewayserver.filter;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.Objects;

@Component
public class FilterUtility {

    public static final String REQUEST_TRACE_ID = "X-Request-Trace-Id";

    public String getRequestTraceId(HttpHeaders requestHeaders) {
        if (requestHeaders.get(REQUEST_TRACE_ID) != null) {
            return Objects.requireNonNull(requestHeaders.get(REQUEST_TRACE_ID)).stream().findFirst().get();
        }
        return null;
    }

    public ServerWebExchange setRequestTraceId(ServerWebExchange exchange, String requestTraceId) {
        return this.setRequestHeader(exchange, REQUEST_TRACE_ID, requestTraceId);
    }

    public ServerWebExchange setRequestHeader(ServerWebExchange exchange, String name, String value) {
        return exchange.mutate().request(exchange.getRequest().mutate().header(name, value).build()).build();
    }
}
