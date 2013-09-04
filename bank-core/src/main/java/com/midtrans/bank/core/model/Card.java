package com.midtrans.bank.core.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/3/13
 * Time: 3:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class Card {
    private Long id;

    private boolean active;

    private Date activatedDate;

    private String cardExpire;

    private String cardNo;

    private String cvv;

    private Bank bank;

    private Set<CardRule> cardRules = new HashSet<CardRule>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getActivatedDate() {
        return activatedDate;
    }

    public void setActivatedDate(Date activatedDate) {
        this.activatedDate = activatedDate;
    }

    public String getCardExpire() {
        return cardExpire;
    }

    public void setCardExpire(String cardExpire) {
        this.cardExpire = cardExpire;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Set<CardRule> getCardRules() {
        return cardRules;
    }

    public void setCardRules(Set<CardRule> cardRules) {
        this.cardRules = cardRules;
    }
}
