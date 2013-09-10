package com.midtrans.bank.logic.transaction;

import com.midtrans.bank.core.model.Trace;
import com.midtrans.bank.core.transaction.BankTxnSupport;
import com.midtrans.bank.logic.dao.impl.TraceDao;
import org.jpos.ee.DB;
import org.jpos.transaction.AbortParticipant;
import org.jpos.transaction.Context;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/10/13
 * Time: 1:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class SaveTrace extends BankTxnSupport implements AbortParticipant {
    TraceDao dao;

    @Override
    protected int doPrepare(long id, Context ctx) throws Exception {
        return saveTrace(ctx);
    }

    @Override
    protected int doPrepareForAbort(long id, Context ctx) throws Exception {
        String rCode = ctx.getString(RC);

        if("94".equals(rCode)) {
            return PREPARED | NO_JOIN;
        }

        return saveTrace(ctx);
    }

    private int saveTrace(Context ctx) {
        DB db = openDB(ctx);

        dao = new TraceDao(db);

        Trace trace = (Trace) ctx.get(BANK_TRACE);

        dao.saveOrUpdate(trace);

        closeDB(ctx);
        return PREPARED | NO_JOIN;
    }
}
