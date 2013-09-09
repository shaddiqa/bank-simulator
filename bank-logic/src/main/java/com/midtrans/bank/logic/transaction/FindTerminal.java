package com.midtrans.bank.logic.transaction;

import com.midtrans.bank.core.model.BankTransConfiguration;
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

        BankTransConfiguration btc = (BankTransConfiguration) ctx.get(BTC);
        String mid = ctx.getString(MID);
        String tid = ctx.getString(TID);

        Terminal terminal = dao.findBy(btc.getBank(), mid, tid);

        assertNotNull(terminal, "No active terminal found");

        ctx.put(TERMINAL, terminal);

        closeDB(ctx);
        return PREPARED | NO_JOIN;
    }
}
