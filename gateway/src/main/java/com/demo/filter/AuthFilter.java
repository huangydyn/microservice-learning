package com.demo.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component("authFilter")
public class AuthFilter extends AbstractGatewayFilterFactory {

    private static final String authKeyValue = "123456";

    @Override
    public GatewayFilter apply(Object config) {
        return (exchange, chain) -> {
            if (!exchange.getRequest().getQueryParams().containsKey("x-api-key")) {
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "不允许访问");
            }
            String authKey = exchange.getRequest().getQueryParams().get("x-api-key").get(0);
            if (!authKey.equals(authKeyValue)) {
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "不允许访问");
            }
            return chain.filter(exchange);
        };
    }
}