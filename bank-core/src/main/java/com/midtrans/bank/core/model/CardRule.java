package com.midtrans.bank.core.model;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/3/13
 * Time: 3:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class CardRule {
    private Long id;

    private String note;

    private Card card;

    private Lookup lookupOfCommandType;

    private Lookup lookupOfConditionType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Lookup getLookupOfCommandType() {
        return lookupOfCommandType;
    }

    public void setLookupOfCommandType(Lookup lookupOfCommandType) {
        this.lookupOfCommandType = lookupOfCommandType;
    }

    public Lookup getLookupOfConditionType() {
        return lookupOfConditionType;
    }

    public void setLookupOfConditionType(Lookup lookupOfConditionType) {
        this.lookupOfConditionType = lookupOfConditionType;
    }
}
