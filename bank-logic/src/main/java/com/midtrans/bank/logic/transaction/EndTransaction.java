package com.midtrans.bank.logic.transaction;

import com.midtrans.bank.core.BankConstants;
import com.midtrans.bank.core.transaction.BankTxnSupport;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISOSource;
import org.jpos.transaction.AbortParticipant;
import org.jpos.transaction.Context;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/4/13
 * Time: 1:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class EndTransaction extends BankTxnSupport implements AbortParticipant {
    @Override
    protected int doPrepare(long id, Context ctx) throws Exception {
        return PREPARED;
    }

    @Override
    protected int doPrepareForAbort(long id, Context ctx) throws Exception {
        return PREPARED;
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
        try {
            ISOSource source = (ISOSource) ctx.get(BankConstants.SOURCE);
            ISOMsg response = (ISOMsg) ctx.get(BankConstants.RESPONSE);
            source.send(response);
        } catch (Exception e) {
            error(e);
        }
    }
}
