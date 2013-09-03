package com.midtrans.bank.core.model;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/3/13
 * Time: 3:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class Bank {
    private Long pkBank;

    private boolean active;

    private String name;

    private String note;

    private String header;

    private String port;

    public Long getPkBank() {
        return pkBank;
    }

    public void setPkBank(Long pkBank) {
        this.pkBank = pkBank;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
