package com.midtrans.bank.transaction;

import org.jpos.transaction.Context;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 8/17/13
 * Time: 12:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class Send extends BankTxnSupport {
    @Override
    protected int doPrepare(long id, Context ctx) throws Exception {
        return PREPARED | READONLY;
    }

    @Override
    public void commit(long id, Serializable context) {
        send((Context) context);
    }

    @Override
    public void abort(long id, Serializable context) {
        send((Context) context);
    }

    private void send(Context ctx) {

    }
}
