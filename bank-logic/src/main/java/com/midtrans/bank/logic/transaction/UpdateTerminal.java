package com.midtrans.bank.logic.transaction;

import com.midtrans.bank.core.model.Terminal;
import com.midtrans.bank.core.transaction.BankTxnSupport;
import org.jpos.transaction.Context;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/10/13
 * Time: 12:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class UpdateTerminal extends BankTxnSupport {
    @Override
    protected int doPrepare(long id, Context ctx) throws Exception {
        Terminal terminal = (Terminal) ctx.get(TERMINAL);

        Long valueBefore = (Long) ctx.get(VALBEFORE);
        Long valueAfter = (Long) ctx.get(VALAFTER);

        long valueChange = valueAfter - valueBefore;
        terminal.setAmount(terminal.getAmount() + valueChange);

        if(valueChange < 0 && valueAfter == 0) {
            terminal.setCount(terminal.getCount() - 1);
        }else if(valueChange > 0 && valueBefore ==  0) {
            terminal.setCount(terminal.getCount() + 1);
        }

        ctx.put(TERMINAL, terminal);

        return PREPARED | NO_JOIN;
    }
}
