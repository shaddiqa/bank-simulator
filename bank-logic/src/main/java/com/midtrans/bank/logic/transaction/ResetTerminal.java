package com.midtrans.bank.logic.transaction;

import com.midtrans.bank.core.model.Terminal;
import com.midtrans.bank.core.transaction.BankTxnSupport;
import org.jpos.transaction.Context;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/9/13
 * Time: 1:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class ResetTerminal extends BankTxnSupport {
    @Override
    protected int doPrepare(long id, Context ctx) throws Exception {
        Terminal terminal = (Terminal) ctx.get(TERMINAL);

        ctx.put(TERMINAL, terminal.reset());

        return PREPARED | NO_JOIN;
    }
}
