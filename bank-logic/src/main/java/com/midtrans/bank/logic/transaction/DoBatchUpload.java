package com.midtrans.bank.logic.transaction;

import com.midtrans.bank.core.model.BatchTxn;
import com.midtrans.bank.core.model.Trace;
import com.midtrans.bank.core.transaction.BankTxnSupport;
import org.jpos.transaction.Context;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/9/13
 * Time: 12:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class DoBatchUpload extends BankTxnSupport {
    @Override
    protected int doPrepare(long id, Context ctx) throws Exception {
        BatchTxn batchTxn = (BatchTxn) ctx.get(BATCH_TXN);
        Trace trace = (Trace) ctx.get(BANK_TRACE);
        String batchNumber = ctx.getString(BATCH_NUMBER);
        Date now = new Date();
        String refNo = Long.toHexString(System.currentTimeMillis());
        String authId = "AUTH";

        batchTxn.setTrace(trace);
        batchTxn.setBatchNumber(batchNumber);
        batchTxn.setTxnTime(now);
        batchTxn.setReferenceNumber(refNo);
        batchTxn.setAuthorizationId(authId);

        ctx.put(TXN_TIME, now);
        ctx.put(REFERENCE_NUMBER, refNo);
        ctx.put(AUTHORIZATION_ID, authId);

        ctx.put(BATCH_TXN, batchTxn);

        return PREPARED | NO_JOIN;
    }
}
