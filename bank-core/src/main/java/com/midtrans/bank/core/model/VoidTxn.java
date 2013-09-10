package com.midtrans.bank.core.model;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/10/13
 * Time: 10:01 AM
 * To change this template use File | Settings | File Templates.
 */
public class VoidTxn {
    private Long id;

    private Integer traceNumber;

    private Long amount;

    private boolean reversal;

    private Transaction transaction;

    private Date createdAt;

    public VoidTxn() {
        this.amount = 0L;
        this.reversal = false;
        this.createdAt = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTraceNumber() {
        return traceNumber;
    }

    public void setTraceNumber(Integer traceNumber) {
        this.traceNumber = traceNumber;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public boolean isReversal() {
        return reversal;
    }

    public void setReversal(boolean reversal) {
        this.reversal = reversal;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
