package com.midtrans.bank.logic.transaction;

import com.midtrans.bank.core.BankConstants;
import com.midtrans.bank.core.model.BankTransConfiguration;
import org.jpos.core.Configurable;
import org.jpos.core.Configuration;
import org.jpos.core.ConfigurationException;
import org.jpos.transaction.Context;
import org.jpos.transaction.GroupSelector;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/5/13
 * Time: 9:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class SelectCommand implements GroupSelector, Configurable, BankConstants {

    Configuration cfg;

    @Override
    public void setConfiguration(Configuration cfg) throws ConfigurationException {
        this.cfg = cfg;
    }

    @Override
    public String select(long id, Serializable context) {
        Context ctx = (Context) context;

        BankTransConfiguration btc = (BankTransConfiguration) ctx.get(BTC);
        String command = btc.getLookupOfCommandType().getName();

        ctx.put(COMMAND, command);

        return cfg.get(command);
    }

    @Override
    public int prepare(long id, Serializable context) {
        return PREPARED | NO_JOIN;
    }

    @Override
    public void commit(long id, Serializable context) {
    }

    @Override
    public void abort(long id, Serializable context) {
    }
}
