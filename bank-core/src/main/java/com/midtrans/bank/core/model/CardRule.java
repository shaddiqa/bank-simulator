package com.midtrans.bank.core.model;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/3/13
 * Time: 3:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class CardRule {
    private Long pkCardRule;

    private String note;

    private Long fkCard;

    private Lookup lookupOfCommandType;

    private Lookup lookupOfConditionType;

    public Long getPkCardRule() {
        return pkCardRule;
    }

    public void setPkCardRule(Long pkCardRule) {
        this.pkCardRule = pkCardRule;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Long getFkCard() {
        return fkCard;
    }

    public void setFkCard(Long fkCard) {
        this.fkCard = fkCard;
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
