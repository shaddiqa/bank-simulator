package com.midtrans.bank.logic.transaction;

import com.midtrans.bank.core.model.Trace;
import com.midtrans.bank.core.model.Transaction;
import com.midtrans.bank.core.transaction.BankTxnSupport;
import com.midtrans.bank.logic.dao.impl.TransactionDao;
import org.jpos.ee.DB;
import org.jpos.transaction.AbortParticipant;
import org.jpos.transaction.Context;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 8/17/13
 * Time: 9:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class SaveTransaction extends BankTxnSupport implements AbortParticipant {
    TransactionDao dao;

    @Override
    protected int doPrepare(long id, Context ctx) throws Exception {
        return saveTransaction(ctx);
    }

    @Override
    protected int doPrepareForAbort(long id, Context ctx) throws Exception {
        if(ctx.get(TXN) == null) {
            Long amount = (Long) ctx.get(AMOUNT);
            String cardNumber = ctx.getString(CARD_NUMBER);
            String cardExpire = ctx.getString(CARD_EXPIRE);
            Date txnTime = (Date) ctx.get(TXN_TIME, new Date());
            String refNo = ctx.getString(REFERENCE_NUMBER, Long.toHexString(System.currentTimeMillis()));
            String authId = ctx.getString(AUTHORIZATION_ID, "");
            String rCode = ctx.getString(RCODE);
            Trace trace = (Trace) ctx.get(TRACE);

            Transaction txn = new Transaction();
            txn.setAmount(amount);
            txn.setCardNumber(cardNumber);
            txn.setCardExpire(cardExpire);
            txn.setTxnTime(txnTime);
            txn.setReferenceNumber(refNo);
            txn.setAuthorizationId(authId);
            txn.setResponseCode(rCode);
            txn.setTrace(trace);

            ctx.put(TXN, txn);
        }

        return saveTransaction(ctx);
    }

    private int saveTransaction(Context ctx) {
        DB db = openDB(ctx);

        dao = new TransactionDao(db);

        Transaction txn = (Transaction) ctx.get(TXN);

        dao.saveOrUpdate(txn);

        ctx.put(TXN, txn);

        closeDB(ctx);
        return PREPARED | NO_JOIN;
    }
}
