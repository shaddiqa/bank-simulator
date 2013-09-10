package com.midtrans.bank.core.model;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/6/13
 * Time: 3:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class SettlementParameter {
    private SettlementBlock creditSales;

    private SettlementBlock creditRefund;

    private SettlementBlock debitSales;

    private SettlementBlock debitRefund;

    private SettlementBlock authSales;

    private SettlementBlock authRefund;

    public SettlementParameter(SettlementBlock creditSales, SettlementBlock creditRefund, SettlementBlock debitSales, SettlementBlock debitRefund, SettlementBlock authSales, SettlementBlock authRefund) {
        this.creditSales = creditSales;
        this.creditRefund = creditRefund;
        this.debitSales = debitSales;
        this.debitRefund = debitRefund;
        this.authSales = authSales;
        this.authRefund = authRefund;
    }

    public static SettlementParameter create(String param) {
        int csc = Integer.valueOf(param.substring(0,2));
        long csa = Long.valueOf(param.substring(3,14));
        int crc = Integer.valueOf(param.substring(15,17));
        long cra = Long.valueOf(param.substring(18,29));
        int dsc = Integer.valueOf(param.substring(30,32));
        long dsa = Long.valueOf(param.substring(33,44));
        int drc = Integer.valueOf(param.substring(45,47));
        long dra = Long.valueOf(param.substring(48,59));
        int asc = Integer.valueOf(param.substring(60,62));
        long asa = Long.valueOf(param.substring(63,74));
        int arc = Integer.valueOf(param.substring(75,77));
        long ara = Long.valueOf(param.substring(78,89));

        SettlementBlock creditSales = new SettlementBlock(csc, csa);
        SettlementBlock creditRefund = new SettlementBlock(crc, cra);
        SettlementBlock debitSales = new SettlementBlock(dsc, dsa);
        SettlementBlock debitRefund = new SettlementBlock(drc, dra);
        SettlementBlock authSales = new SettlementBlock(asc, asa);
        SettlementBlock authRefund = new SettlementBlock(arc, ara);

        return new SettlementParameter(creditSales, creditRefund, debitSales, debitRefund, authSales, authRefund);
    }

    public SettlementBlock getCreditSales() {
        return creditSales;
    }

    public void setCreditSales(SettlementBlock creditSales) {
        this.creditSales = creditSales;
    }

    public SettlementBlock getCreditRefund() {
        return creditRefund;
    }

    public void setCreditRefund(SettlementBlock creditRefund) {
        this.creditRefund = creditRefund;
    }

    public SettlementBlock getDebitSales() {
        return debitSales;
    }

    public void setDebitSales(SettlementBlock debitSales) {
        this.debitSales = debitSales;
    }

    public SettlementBlock getDebitRefund() {
        return debitRefund;
    }

    public void setDebitRefund(SettlementBlock debitRefund) {
        this.debitRefund = debitRefund;
    }

    public SettlementBlock getAuthSales() {
        return authSales;
    }

    public void setAuthSales(SettlementBlock authSales) {
        this.authSales = authSales;
    }

    public SettlementBlock getAuthRefund() {
        return authRefund;
    }

    public void setAuthRefund(SettlementBlock authRefund) {
        this.authRefund = authRefund;
    }
}
