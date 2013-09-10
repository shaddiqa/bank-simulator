package com.midtrans.bank.logic.transaction;

import com.midtrans.bank.core.model.Terminal;
import com.midtrans.bank.core.transaction.BankTxnSupport;
import org.jpos.transaction.Context;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/10/13
 * Time: 12:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class UpdateBatchTerminal extends BankTxnSupport {
    @Override
    protected int doPrepare(long id, Context ctx) throws Exception {
        Terminal terminal = (Terminal) ctx.get(TERMINAL);

        Long amount = (Long) ctx.get(AMOUNT);

        terminal.setBatchAmount(terminal.getBatchAmount() + amount);
        terminal.setBatchCount(terminal.getBatchCount() + 1);

        ctx.put(TERMINAL, terminal);

        return PREPARED | NO_JOIN;
    }
}
