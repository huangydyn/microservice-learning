package com.demo.controller;

import com.demo.model.Card;
import com.demo.service.CardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

// RefreshScope注解实现动态刷新
@RefreshScope
@RestController
public class CardController {

    // @Value标明discount为配置项
    @Value(value = "${discount:1.0}")
    private String discount;

    // 新增查询接口
    @GetMapping("/cards/discount")
    public String getDiscount() {
        return discount;
    }

    private static Logger logger = LoggerFactory.getLogger(CardController.class);

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/cards/{cardNo}")
    public Card getCardByCardNo(@PathVariable("cardNo") Long cardNo) {
        logger.info("[CardService] get card by cardNo {}", cardNo);
        return cardService.getCardByCardNo(cardNo);
    }
}