package com.midtrans.bank.logic.transaction;

import com.midtrans.bank.core.transaction.BankTxnSupport;
import org.jpos.transaction.AbortParticipant;
import org.jpos.transaction.Context;

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
}
