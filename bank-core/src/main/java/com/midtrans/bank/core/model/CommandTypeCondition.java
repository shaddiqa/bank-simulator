package com.midtrans.bank.core.model;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/3/13
 * Time: 3:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class CommandTypeCondition {
    private Long pkCommTypeCond;

    private boolean active;

    private String note;

    private BankTransConfiguration bankTransConfiguration;

    private Lookup lookupOfConditionType;

    public Long getPkCommTypeCond() {
        return pkCommTypeCond;
    }

    public void setPkCommTypeCond(Long pkCommTypeCond) {
        this.pkCommTypeCond = pkCommTypeCond;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public BankTransConfiguration getBankTransConfiguration() {
        return bankTransConfiguration;
    }

    public void setBankTransConfiguration(BankTransConfiguration bankTransConfiguration) {
        this.bankTransConfiguration = bankTransConfiguration;
    }

    public Lookup getLookupOfConditionType() {
        return lookupOfConditionType;
    }

    public void setLookupOfConditionType(Lookup lookupOfConditionType) {
        this.lookupOfConditionType = lookupOfConditionType;
    }
}
