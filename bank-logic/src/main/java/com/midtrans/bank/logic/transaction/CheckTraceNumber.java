package com.midtrans.bank.logic.transaction;

import com.midtrans.bank.core.model.Terminal;
import com.midtrans.bank.core.model.Transaction;
import com.midtrans.bank.core.transaction.BankTxnSupport;
import com.midtrans.bank.logic.dao.impl.TransactionDao;
import org.jpos.ee.DB;
import org.jpos.transaction.Context;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/6/13
 * Time: 10:54 AM
 * To change this template use File | Settings | File Templates.
 */
public class CheckTraceNumber extends BankTxnSupport {
    TransactionDao dao;

    @Override
    protected int doPrepare(long id, Context ctx) throws Exception {
        DB db = openDB(ctx);

        dao = new TransactionDao(db);

        Terminal terminal = (Terminal) ctx.get(TERMINAL);
        Integer traceNumber = (Integer) ctx.get(TRACE_NUMBER);

        Transaction txn = dao.checkTraceNumber(terminal, traceNumber);

        assertNull(txn, "Trace number is used");

        closeDB(ctx);
        return PREPARED | NO_JOIN;
    }
}
