package com.midtrans.bank.core.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/3/13
 * Time: 3:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class BankTransConfiguration {
    private Long id;

    private boolean active;

    private String mti;

    private String name;

    private String processingCode;

    private Bank bank;

    private Lookup lookupOfCommandType;

    private List<CommandTypeCondition> commandTypeConditions = new ArrayList<CommandTypeCondition>();

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

    public String getMti() {
        return mti;
    }

    public void setMti(String mti) {
        this.mti = mti;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProcessingCode() {
        return processingCode;
    }

    public void setProcessingCode(String processingCode) {
        this.processingCode = processingCode;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Lookup getLookupOfCommandType() {
        return lookupOfCommandType;
    }

    public void setLookupOfCommandType(Lookup lookupOfCommandType) {
        this.lookupOfCommandType = lookupOfCommandType;
    }

    public List<CommandTypeCondition> getCommandTypeConditions() {
        return commandTypeConditions;
    }

    public void setCommandTypeConditions(List<CommandTypeCondition> commandTypeConditions) {
        this.commandTypeConditions = commandTypeConditions;
    }
}
