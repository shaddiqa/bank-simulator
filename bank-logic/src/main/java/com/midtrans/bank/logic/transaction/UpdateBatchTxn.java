package com.midtrans.bank.logic.transaction;

import com.midtrans.bank.core.model.BatchTxn;
import com.midtrans.bank.core.transaction.BankTxnSupport;
import org.jpos.transaction.AbortParticipant;
import org.jpos.transaction.Context;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/10/13
 * Time: 10:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class UpdateBatchTxn extends BankTxnSupport implements AbortParticipant {
    @Override
    protected int doPrepare(long id, Context ctx) throws Exception {
        return updateTransaction(ctx);
    }

    @Override
    protected int doPrepareForAbort(long id, Context ctx) throws Exception {
        if(ctx.get(BATCH_TXN) == null) {
            return PREPARED | NO_JOIN;
        }

        return updateTransaction(ctx);
    }

    private int updateTransaction(Context ctx) {
        Date txnTime = (Date) ctx.get(TXN_TIME);
        String refNo = ctx.getString(REFERENCE_NUMBER);
        String authId = ctx.getString(AUTHORIZATION_ID);
        String rCode = ctx.getString(RCODE);

        BatchTxn batchTxn = (BatchTxn) ctx.get(BATCH_TXN);
        batchTxn.setTxnTime(txnTime);
        batchTxn.setReferenceNumber(refNo);
        batchTxn.setAuthorizationId(authId);
        batchTxn.setResponseCode(rCode);

        ctx.put(BATCH_TXN, batchTxn);

        return PREPARED | NO_JOIN;
    }
}
