package com.demo.service;

import com.demo.model.Card;
import com.demo.model.User;
import com.demo.webclient.CardClient;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserService {

    private static final ConcurrentHashMap<Long, User> users;

    private final CardClient cardClient;

    public UserService(CardClient cardClient) {
        this.cardClient = cardClient;
    }

    static {
        users = new ConcurrentHashMap<>();
        users.put(1L, new User(1L, "Adam", 10101L));
        users.put(2L, new User(2L, "Bob", 202020L));
        users.put(3L, new User(3L, "Casey", 123456L));
    }

    public User getUserById(Long id) {
        if (!users.containsKey(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "用户不存在");
        }
        User user = users.get(id);
        Card card = cardClient.getCardByCardNo(user.getCardNo());
        user.setCard(card);
        return user;
    }
}
