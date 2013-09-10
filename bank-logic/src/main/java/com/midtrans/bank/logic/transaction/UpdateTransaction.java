package com.midtrans.bank.logic.transaction;

import com.midtrans.bank.core.model.Transaction;
import com.midtrans.bank.core.transaction.BankTxnSupport;
import org.jpos.transaction.AbortParticipant;
import org.jpos.transaction.Context;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/10/13
 * Time: 10:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class UpdateTransaction extends BankTxnSupport implements AbortParticipant {
    @Override
    protected int doPrepare(long id, Context ctx) throws Exception {
        return updateTransaction(ctx);
    }

    @Override
    protected int doPrepareForAbort(long id, Context ctx) throws Exception {
        if(ctx.get(TXN) == null) {
            return PREPARED | NO_JOIN;
        }

        return updateTransaction(ctx);
    }

    private int updateTransaction(Context ctx) {
        Date txnTime = (Date) ctx.get(TXN_TIME);
        String refNo = ctx.getString(REFERENCE_NUMBER);
        String authId = ctx.getString(AUTHORIZATION_ID);
        String rCode = ctx.getString(RCODE);

        Transaction txn = (Transaction) ctx.get(TXN);
        txn.setTxnTime(txnTime);
        txn.setReferenceNumber(refNo);
        txn.setAuthorizationId(authId);
        txn.setResponseCode(rCode);

        ctx.put(TXN, txn);

        return PREPARED | NO_JOIN;
    }
}
