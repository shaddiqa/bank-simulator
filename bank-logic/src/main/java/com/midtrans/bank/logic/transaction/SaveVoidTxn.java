package com.midtrans.bank.logic.transaction;

import com.midtrans.bank.core.model.Trace;
import com.midtrans.bank.core.model.Transaction;
import com.midtrans.bank.core.model.VoidTxn;
import com.midtrans.bank.core.transaction.BankTxnSupport;
import com.midtrans.bank.logic.dao.impl.VoidTxnDao;
import org.jpos.ee.DB;
import org.jpos.transaction.AbortParticipant;
import org.jpos.transaction.Context;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/10/13
 * Time: 10:10 AM
 * To change this template use File | Settings | File Templates.
 */
public class SaveVoidTxn extends BankTxnSupport implements AbortParticipant {
    VoidTxnDao dao;

    @Override
    protected int doPrepare(long id, Context ctx) throws Exception {
        return saveVoidTxn(ctx);
    }

    @Override
    protected int doPrepareForAbort(long id, Context ctx) throws Exception {
        if(ctx.get(VOID_TXN) == null) {
            Long amount = (Long) ctx.get(AMOUNT);
            String authId = ctx.getString(AUTHORIZATION_ID, "");
            String rCode = ctx.getString(RCODE);
            Trace trace = (Trace) ctx.get(TRACE);
            Transaction txn = (Transaction) ctx.get(TXN);

            VoidTxn voidTxn = new VoidTxn();
            voidTxn.setAmount(amount);
            voidTxn.setAuthorizationId(authId);
            voidTxn.setResponseCode(rCode);
            voidTxn.setTrace(trace);
            voidTxn.setTransaction(txn);

            ctx.put(VOID_TXN, voidTxn);
        }

        return saveVoidTxn(ctx);
    }

    private int saveVoidTxn(Context ctx) {
        DB db = openDB(ctx);

        dao = new VoidTxnDao(db);

        VoidTxn voidTxn = (VoidTxn) ctx.get(VOID_TXN);

        dao.saveOrUpdate(voidTxn);

        closeDB(ctx);
        return PREPARED | NO_JOIN;
    }
}
