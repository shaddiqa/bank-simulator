package com.midtrans.bank.transaction;

import org.jpos.core.Configuration;
import org.jpos.core.ConfigurationException;
import org.jpos.iso.ISOMsg;
import org.jpos.transaction.Context;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 8/17/13
 * Time: 2:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class CardCheck extends BankTxnSupport {
    String[] r00;
    String[] r05;

    @Override
    protected int doPrepare(long id, Context ctx) throws Exception {
        ISOMsg request = (ISOMsg) ctx.get(REQUEST);
        if(request.hasField(2)) {
            String cardNumber = request.getString(2);

            if(Arrays.asList(r00).contains(cardNumber)) {
                ctx.put(RCODE, "00");
            } else if(Arrays.asList(r05).contains(cardNumber)) {
                ctx.put(RCODE, "05");
            } else {
                ctx.put(RCODE, "P5");
            }
        }

        return PREPARED | NO_JOIN;
    }

    @Override
    public void setConfiguration(Configuration cfg) throws ConfigurationException {
        super.setConfiguration(cfg);
        this.r00 = cfg.getAll("r00");
        this.r05 = cfg.getAll("r05");
    }
}
