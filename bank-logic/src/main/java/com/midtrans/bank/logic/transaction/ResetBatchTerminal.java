package com.midtrans.bank.logic.transaction;

import com.midtrans.bank.core.model.Terminal;
import com.midtrans.bank.core.transaction.BankTxnSupport;
import org.jpos.transaction.AbortParticipant;
import org.jpos.transaction.Context;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/10/13
 * Time: 12:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class ResetBatchTerminal extends BankTxnSupport implements AbortParticipant {
    @Override
    protected int doPrepare(long id, Context ctx) throws Exception {
        return resetBatchTerminal(ctx);
    }

    @Override
    protected int doPrepareForAbort(long id, Context ctx) throws Exception {
        return resetBatchTerminal(ctx);
    }

    private int resetBatchTerminal(Context ctx) {
        Terminal terminal = (Terminal) ctx.get(TERMINAL);

        ctx.put(TERMINAL, terminal.resetBatch());

        return PREPARED | NO_JOIN;
    }
}
