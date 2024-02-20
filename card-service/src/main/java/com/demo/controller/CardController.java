package com.demo.controller;

import com.demo.model.Card;
import com.demo.service.CardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardController {

    private static Logger logger = LoggerFactory.getLogger(CardController.class);

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/cards/{cardNo}")
    public Card getCardByCardNo(@PathVariable("cardNo") Long cardNo) {
        logger.info("[UserService] get card by cardNo {}", cardNo);
        return cardService.getCardByCardNo(cardNo);
    }
}