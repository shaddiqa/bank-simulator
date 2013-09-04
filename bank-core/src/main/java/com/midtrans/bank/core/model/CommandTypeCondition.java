package com.midtrans.bank.core.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/3/13
 * Time: 3:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class CommandTypeCondition {
    private Long id;

    private boolean active;

    private String note;

    private BankTransConfiguration bankTransConfiguration;

    private Lookup lookupOfConditionType;

    private Set<BankISOResponse> bankISOResponses = new HashSet<BankISOResponse>();

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

    public Set<BankISOResponse> getBankISOResponses() {
        return bankISOResponses;
    }

    public void setBankISOResponses(Set<BankISOResponse> bankISOResponses) {
        this.bankISOResponses = bankISOResponses;
    }
}
