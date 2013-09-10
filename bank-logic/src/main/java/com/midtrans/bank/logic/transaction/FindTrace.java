package com.midtrans.bank.logic.transaction;

import com.midtrans.bank.core.model.Terminal;
import com.midtrans.bank.core.model.Trace;
import com.midtrans.bank.core.transaction.BankTxnSupport;
import com.midtrans.bank.logic.dao.impl.TraceDao;
import org.jpos.transaction.Context;
import org.jpos.ee.DB;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/10/13
 * Time: 4:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class FindTrace extends BankTxnSupport {
    TraceDao dao;

    @Override
    protected int doPrepare(long id, Context ctx) throws Exception {
        DB db = openDB(ctx);

        dao = new TraceDao(db);

        Terminal terminal = (Terminal) ctx.get(TERMINAL);
        Integer traceNumber = (Integer) ctx.get(TRACE_NUMBER);

        Trace trace = dao.findBy(terminal, traceNumber);

        assertNotNull(trace, "12");

        ctx.put(BANK_TRACE, trace);

        closeDB(ctx);
        return PREPARED | NO_JOIN;
    }
}
