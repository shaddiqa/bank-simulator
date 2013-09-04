package com.midtrans.bank.core.model;

import java.util.ArrayList;
import java.util.List;

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

    private List<Card> cards = new ArrayList<Card>();

    private List<BankTransConfiguration> bankTransConfigurations = new ArrayList<BankTransConfiguration>();

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

    public List getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public List<BankTransConfiguration> getBankTransConfigurations() {
        return bankTransConfigurations;
    }

    public void setBankTransConfigurations(List<BankTransConfiguration> bankTransConfigurations) {
        this.bankTransConfigurations = bankTransConfigurations;
    }
}
