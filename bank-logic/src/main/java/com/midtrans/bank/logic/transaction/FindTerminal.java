package com.midtrans.bank.logic.transaction;

import com.midtrans.bank.core.model.Bank;
import com.midtrans.bank.core.model.Terminal;
import com.midtrans.bank.core.transaction.BankTxnSupport;
import com.midtrans.bank.logic.dao.impl.TerminalDao;
import org.jpos.ee.DB;
import org.jpos.transaction.Context;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/6/13
 * Time: 10:17 AM
 * To change this template use File | Settings | File Templates.
 */
public class FindTerminal extends BankTxnSupport {
    TerminalDao dao;

    @Override
    protected int doPrepare(long id, Context ctx) throws Exception {
        DB db = openDB(ctx);

        dao = new TerminalDao(db);

        Bank bank = (Bank) ctx.get(BANK);
        String mid = ctx.getString(MID);
        String tid = ctx.getString(TID);

        Terminal terminal = dao.findBy(bank, mid, tid);

        assertNotNull(terminal, "14");

        ctx.put(TERMINAL, terminal);

        closeDB(ctx);
        return PREPARED | NO_JOIN;
    }
}
