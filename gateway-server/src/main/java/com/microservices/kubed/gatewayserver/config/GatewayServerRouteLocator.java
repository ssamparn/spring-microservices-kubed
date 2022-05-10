package com.microservices.kubed.gatewayserver.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class GatewayServerRouteLocator {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeBuilder) {
        return routeBuilder.routes()
                .route(p -> p
                        .path("/gateway/get-accounts/**")
                        .filters(f -> f.rewritePath("/gateway/get-accounts/(?<segment>.*)", "/${segment}")
                                .addResponseHeader("X-Response-Time", new Date().toString()))
                        .uri("lb://ACCOUNTS"))
                .route(p -> p
                        .path("/gateway/get-loans/**")
                        .filters(f -> f.rewritePath("/gateway/get-loans/(?<segment>.*)", "/${segment}")
                                .addResponseHeader("X-Response-Time", new Date().toString()))
                        .uri("lb://LOANS"))
                .route(p -> p
                        .path("/gateway/get-cards/**")
                        .filters(f -> f.rewritePath("/gateway/get-cards/(?<segment>.*)", "/${segment}")
                                .addResponseHeader("X-Response-Time", new Date().toString()))
                        .uri("lb://CARDS"))
                .build();
    }
}