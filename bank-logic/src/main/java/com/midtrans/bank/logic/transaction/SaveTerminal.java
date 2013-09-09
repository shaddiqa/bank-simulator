package com.midtrans.bank.logic.transaction;

import com.midtrans.bank.core.model.Terminal;
import com.midtrans.bank.core.model.Transaction;
import com.midtrans.bank.core.transaction.BankTxnSupport;
import com.midtrans.bank.logic.dao.impl.TerminalDao;
import org.jpos.ee.DB;
import org.jpos.transaction.Context;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/6/13
 * Time: 10:26 AM
 * To change this template use File | Settings | File Templates.
 */
public class SaveTerminal extends BankTxnSupport {
    TerminalDao dao;

    @Override
    protected int doPrepare(long id, Context ctx) throws Exception {
        DB db = openDB(ctx);

        dao = new TerminalDao(db);

        Terminal terminal = (Terminal) ctx.get(TERMINAL);

        Long valueBefore = (Long) ctx.get(VALBEFORE);
        Long valueAfter = (Long) ctx.get(VALAFTER);

        long valueChange = valueAfter - valueBefore;
        terminal.setAmount(terminal.getAmount() + valueChange);

        Transaction txn = (Transaction) ctx.get(TXN);
        if(valueChange < 0 && txn.getAmount().equals(txn.getVoidAmount())) {
            terminal.setCount(terminal.getCount() - 1);
        }else if(valueChange > 0 && txn.getVoidAmount() ==  0) {
            terminal.setCount(terminal.getCount() + 1);
        }

        dao.saveOrUpdate(terminal);

        closeDB(ctx);
        return PREPARED | NO_JOIN;
    }
}