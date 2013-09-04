package com.midtrans.bank.core.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 8/17/13
 * Time: 8:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class Transaction implements Serializable {
    private Long id;

    private Long amount;

    private String mid;

    private String tid;

    private Integer traceNumber;

    private String cardNumber;

    private String cardExpire;

    private Date txnTime;

    private String referenceNumber;

    private String responseCode;

    private Bank bank;

    private Lookup lookupOfCommandType;

    private Lookup lookupOfConditionType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Integer getTraceNumber() {
        return traceNumber;
    }

    public void setTraceNumber(Integer traceNumber) {
        this.traceNumber = traceNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardExpire() {
        return cardExpire;
    }

    public void setCardExpire(String cardExpire) {
        this.cardExpire = cardExpire;
    }

    public Date getTxnTime() {
        return txnTime;
    }

    public void setTxnTime(Date txnTime) {
        this.txnTime = txnTime;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
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

    public Lookup getLookupOfConditionType() {
        return lookupOfConditionType;
    }

    public void setLookupOfConditionType(Lookup lookupOfConditionType) {
        this.lookupOfConditionType = lookupOfConditionType;
    }
}
