package com.midtrans.bank.core.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/3/13
 * Time: 3:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class Bank {
    private Long id;

    private boolean active;

    private String name;

    private String note;

    private String header;

    private String port;

    private Set<Card> cards = new HashSet<Card>();

    private Set<BankTransConfiguration> bankTransConfigurations = new HashSet<BankTransConfiguration>();

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public Set<Card> getCards() {
        return cards;
    }

    public void setCards(Set<Card> cards) {
        this.cards = cards;
    }

    public Set<BankTransConfiguration> getBankTransConfigurations() {
        return bankTransConfigurations;
    }

    public void setBankTransConfigurations(Set<BankTransConfiguration> bankTransConfigurations) {
        this.bankTransConfigurations = bankTransConfigurations;
    }
}
