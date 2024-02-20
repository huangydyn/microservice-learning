package com.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class User {

    private Long id;

    private String name;

    @JsonIgnore
    private Long cardNo;

    private Card card;

    public User() {
    }

    public User(Long id, String name, Long cardNo) {
        this.id = id;
        this.name = name;
        this.cardNo = cardNo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCardNo() {
        return cardNo;
    }

    public void setCardNo(Long cardNo) {
        this.cardNo = cardNo;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
