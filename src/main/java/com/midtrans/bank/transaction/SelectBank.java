package com.midtrans.bank.transaction;

import com.midtrans.bank.BankConstants;
import org.jpos.core.Configurable;
import org.jpos.core.Configuration;
import org.jpos.core.ConfigurationException;
import org.jpos.transaction.Context;
import org.jpos.transaction.GroupSelector;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 8/17/13
 * Time: 8:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class SelectBank  implements GroupSelector, BankConstants, Configurable {

    Configuration cfg;

    @Override
    public String select(long id, Serializable context) {
        Context ctx = (Context) context;
        String header = ctx.getString(HEADER);
        return cfg.get(header);
    }

    @Override
    public int prepare(long id, Serializable context) {
        return PREPARED | READONLY | NO_JOIN;
    }

    @Override
    public void commit(long id, Serializable context) {
    }

    @Override
    public void abort(long id, Serializable context) {
    }

    @Override
    public void setConfiguration(Configuration cfg) throws ConfigurationException {
        this.cfg = cfg;
    }
}
