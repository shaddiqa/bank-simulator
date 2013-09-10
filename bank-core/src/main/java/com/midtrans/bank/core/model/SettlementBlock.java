package com.midtrans.bank.core.model;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/9/13
 * Time: 10:53 AM
 * To change this template use File | Settings | File Templates.
 */
public class SettlementBlock {
    private Integer count;
    private Long amount;

    public SettlementBlock(Integer count, Long amount) {
        this.count = count;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format("%03d%012d", count, amount);
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
}
