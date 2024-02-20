package com.demo.service;

import com.demo.model.Card;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class CardService {

    private final static ConcurrentHashMap<Long, Card> cardMap;

    static {
        cardMap = new ConcurrentHashMap<>();
        cardMap.put(10101L, new Card(10101L, "黑金卡", new Date(2022, 1, 1)));
        cardMap.put(202020L, new Card(202020L, "白金卡", new Date(2023, 2, 1)));
        cardMap.put(123456L, new Card(123456L, "绿色卡", new Date(2024, 3, 1)));
    }

    public Card getCardByCardNo(Long cardNo) {
        if (!cardMap.containsKey(cardNo)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "卡不存在");
        }
        return cardMap.get(cardNo);
    }
}
