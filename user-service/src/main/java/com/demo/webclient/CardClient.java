package com.demo.webclient;

import com.demo.model.Card;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "card-service", url = "localhost:9001")
public interface CardClient {

    @GetMapping("/cards/{cardNo}")
    Card getCardByCardNo(@PathVariable("cardNo") Long cardNo);
}
