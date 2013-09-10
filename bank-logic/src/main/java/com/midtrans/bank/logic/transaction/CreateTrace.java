package com.midtrans.bank.logic.transaction;

import com.midtrans.bank.core.model.Terminal;
import com.midtrans.bank.core.model.Trace;
import com.midtrans.bank.core.transaction.BankTxnSupport;
import org.jpos.transaction.AbortParticipant;
import org.jpos.transaction.Context;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/10/13
 * Time: 1:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class CreateTrace extends BankTxnSupport implements AbortParticipant {
    @Override
    protected int doPrepare(long id, Context ctx) throws Exception {
        return createTrace(ctx);
    }

    @Override
    protected int doPrepareForAbort(long id, Context ctx) throws Exception {
        return createTrace(ctx);
    }

    private int createTrace(Context ctx) {
        Terminal terminal = (Terminal) ctx.get(TERMINAL);
        Integer traceNumber = (Integer) ctx.get(TRACE_NUMBER);

        ctx.put(BANK_TRACE, Trace.create(terminal, traceNumber));

        return PREPARED | NO_JOIN;
    }
}
