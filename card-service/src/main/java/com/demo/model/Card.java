package com.demo.model;

import java.util.Date;

public class Card {

    private Long cardNo;

    private String cardType;

    private Date expiredDate;

    public Card() {
    }

    public Card(Long cardNo, String cardType, Date expiredDate) {
        this.cardNo = cardNo;
        this.cardType = cardType;
        this.expiredDate = expiredDate;
    }

    public Long getCardNo() {
        return cardNo;
    }

    public void setCardNo(Long cardNo) {
        this.cardNo = cardNo;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }
}
