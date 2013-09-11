package com.midtrans.bank.logic.transaction;

import com.midtrans.bank.core.model.BatchTxn;
import com.midtrans.bank.core.model.Trace;
import com.midtrans.bank.core.transaction.BankTxnSupport;
import com.midtrans.bank.logic.dao.impl.BatchTxnDao;
import org.jpos.ee.DB;
import org.jpos.transaction.AbortParticipant;
import org.jpos.transaction.Context;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/10/13
 * Time: 1:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class SaveBatchTxn extends BankTxnSupport implements AbortParticipant {
    BatchTxnDao dao;

    @Override
    protected int doPrepare(long id, Context ctx) throws Exception {
        return saveBatchTxn(ctx);
    }

    @Override
    protected int doPrepareForAbort(long id, Context ctx) throws Exception {
        if(ctx.get(BATCH_TXN) == null) {
            Long amount = (Long) ctx.get(AMOUNT);
            String cardNumber = ctx.getString(CARD_NUMBER);
            String cardExpire = ctx.getString(CARD_EXPIRE);
            Date txnTime = (Date) ctx.get(TXN_TIME, new Date());
            String refNo = ctx.getString(REFERENCE_NUMBER, Long.toHexString(System.currentTimeMillis()));
            String authId = ctx.getString(AUTHORIZATION_ID, "");
            String rCode = ctx.getString(RCODE);
            String batchNumber = ctx.getString(BATCH_NUMBER);
            Trace trace = (Trace) ctx.get(TRACE);

            BatchTxn batchTxn = new BatchTxn();
            batchTxn.setAmount(amount);
            batchTxn.setCardNumber(cardNumber);
            batchTxn.setCardExpire(cardExpire);
            batchTxn.setTxnTime(txnTime);
            batchTxn.setReferenceNumber(refNo);
            batchTxn.setAuthorizationId(authId);
            batchTxn.setResponseCode(rCode);
            batchTxn.setBatchNumber(batchNumber);
            batchTxn.setTrace(trace);

            ctx.put(BATCH_TXN, batchTxn);
        }

        return saveBatchTxn(ctx);
    }

    private int saveBatchTxn(Context ctx) {
        DB db = openDB(ctx);

        dao = new BatchTxnDao(db);

        BatchTxn batchTxn = (BatchTxn) ctx.get(BATCH_TXN);

        dao.saveOrUpdate(batchTxn);

        closeDB(ctx);
        return PREPARED | NO_JOIN;
    }
}
