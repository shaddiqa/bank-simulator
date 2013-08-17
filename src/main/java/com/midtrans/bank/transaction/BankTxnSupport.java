package com.midtrans.bank.transaction;

import com.midtrans.bank.BankConstants;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISOSource;
import org.jpos.transaction.Context;
import org.jpos.transaction.TxnSupport;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 8/17/13
 * Time: 12:33 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class BankTxnSupport extends TxnSupport implements BankConstants {
    @Override
    public void commit(long id, Serializable context) {
        send((Context) context);
    }

    @Override
    public void abort(long id, Serializable context) {
        send((Context) context);
    }

    private void send(Context ctx) {
        try {
            ISOSource source = (ISOSource) ctx.get(SOURCE);
            ISOMsg response = (ISOMsg) ctx.get(RESPONSE);
            source.send(response);
        } catch (Exception e) {
            error(e);
        }
    }
}
