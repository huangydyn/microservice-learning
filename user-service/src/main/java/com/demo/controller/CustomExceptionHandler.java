package com.demo.controller;

import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CustomExceptionHandler {
    /**
     * 熔断全局异常
     */
    @ExceptionHandler(DegradeException.class)
    public Map handlerDegradeException(){
        return new HashMap(){{
            put("code", HttpStatus.TOO_MANY_REQUESTS.value());
            put("msg", "服务熔断");
        }};
    }
}