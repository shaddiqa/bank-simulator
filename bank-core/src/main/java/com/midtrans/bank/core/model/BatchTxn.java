package com.midtrans.bank.core.model;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/10/13
 * Time: 12:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class BatchTxn {
    private Long id;

    private Long amount;

    private Trace trace;

    private String cardNumber;

    private String cardExpire;

    private Date txnTime;

    private String referenceNumber;

    private String authorizationId;

    private String responseCode;

    private String batchNumber;

    private Date createdAt;

    public BatchTxn() {
        this.createdAt = new Date();
    }

    public BatchTxn(String cardNumber, String cardExpire, Long amount) {
        this.cardNumber = cardNumber;
        this.cardExpire = cardExpire;
        this.amount = amount;
        this.createdAt = new Date();
    }

    public static BatchTxn create(Transaction txn) {
        Long amount = txn.getAmount();
        String cardNumber = txn.getCardNumber();
        String cardExpire = txn.getCardExpire();

        return new BatchTxn(cardNumber, cardExpire, amount);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Trace getTrace() {
        return trace;
    }

    public void setTrace(Trace trace) {
        this.trace = trace;
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

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
