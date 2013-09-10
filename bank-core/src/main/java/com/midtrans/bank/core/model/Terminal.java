package com.midtrans.bank.core.model;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/6/13
 * Time: 9:49 AM
 * To change this template use File | Settings | File Templates.
 */
public class Terminal {
    private Long id;

    private boolean active;

    private String mid;

    private String tid;

    private Integer count;

    private Long amount;

    private Integer batchCount;

    private Long batchAmount;

    private Bank bank;

    public Terminal reset() {
        this.count = 0;
        this.amount = 0L;
        this.batchCount = 0;
        this.batchAmount = 0L;

        return this;
    }

    public Terminal resetBatch() {
        this.batchCount = 0;
        this.batchAmount = 0L;

        return this;
    }

    @Override
    public String toString() {
        return String.format("ID:%s MID:%s TID:%s", id, mid, tid);
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Integer getBatchCount() {
        return batchCount;
    }

    public void setBatchCount(Integer batchCount) {
        this.batchCount = batchCount;
    }

    public Long getBatchAmount() {
        return batchAmount;
    }

    public void setBatchAmount(Long batchAmount) {
        this.batchAmount = batchAmount;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
}
