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

    private boolean active;

    private Long amount;

    private Terminal terminal;

    private Integer traceNumber;

    private String cardNumber;

    private String cardExpire;

    private Date txnTime;

    private String referenceNumber;

    private String authorizationId;

    private String responseCode;

    private Integer voidTraceNumber;

    private Long voidAmount;

    private boolean voidFlag;

    private boolean reversalFlag;

    private String batchNumber;

    public Transaction() {
        this.active = true;
        this.amount = 0L;
        this.voidAmount = 0L;
        this.voidFlag = false;
        this.reversalFlag = false;
    }

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

    public Terminal getTerminal() {
        return terminal;
    }

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
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

    public String getAuthorizationId() {
        return authorizationId;
    }

    public void setAuthorizationId(String authorizationId) {
        this.authorizationId = authorizationId;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public Integer getVoidTraceNumber() {
        return voidTraceNumber;
    }

    public void setVoidTraceNumber(Integer voidTraceNumber) {
        this.voidTraceNumber = voidTraceNumber;
    }

    public Long getVoidAmount() {
        return voidAmount;
    }

    public void setVoidAmount(Long voidAmount) {
        this.voidAmount = voidAmount;
    }

    public boolean isVoidFlag() {
        return voidFlag;
    }

    public void setVoidFlag(boolean voidFlag) {
        this.voidFlag = voidFlag;
    }

    public boolean isReversalFlag() {
        return reversalFlag;
    }

    public void setReversalFlag(boolean reversalFlag) {
        this.reversalFlag = reversalFlag;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }
}
