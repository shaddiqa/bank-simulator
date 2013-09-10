package com.midtrans.bank.core.model;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/10/13
 * Time: 12:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class Trace {
    private Long id;

    private boolean active;

    private Terminal terminal;

    private Integer traceNumber;

    public Trace() {
    }

    public Trace(Terminal terminal, Integer traceNumber) {
        this.active = true;
        this.terminal = terminal;
        this.traceNumber = traceNumber;
    }

    public static Trace create(Terminal terminal, Integer traceNumber) {
        return new Trace(terminal, traceNumber);
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

    public Integer getTraceNumber() {
        return traceNumber;
    }

    public void setTraceNumber(Integer traceNumber) {
        this.traceNumber = traceNumber;
    }
}
