package com.midtrans.bank.logic.transaction;

import com.midtrans.bank.core.model.Trace;
import com.midtrans.bank.core.model.Transaction;
import com.midtrans.bank.core.model.VoidTxn;
import com.midtrans.bank.core.transaction.BankTxnSupport;
import com.midtrans.bank.logic.dao.impl.VoidTxnDao;
import org.jpos.ee.DB;
import org.jpos.transaction.Context;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/10/13
 * Time: 10:15 AM
 * To change this template use File | Settings | File Templates.
 */
public class FindVoidTxn extends BankTxnSupport {
    VoidTxnDao dao;

    @Override
    protected int doPrepare(long id, Context ctx) throws Exception {
        DB db = openDB(ctx);

        dao = new VoidTxnDao(db);

        Transaction txn = (Transaction) ctx.get(TXN);
        Trace trace = (Trace) ctx.get(BANK_TRACE);

        VoidTxn voidTxn = dao.findBy(txn, trace);

        assertNotNull(voidTxn, "12");

        ctx.put(VOID_TXN, voidTxn);

        closeDB(ctx);
        return PREPARED | NO_JOIN;
    }
}
