package com.midtrans.bank.logic.transaction;

import com.midtrans.bank.core.model.Terminal;
import com.midtrans.bank.core.transaction.BankTxnSupport;
import com.midtrans.bank.logic.dao.impl.TerminalDao;
import org.jpos.ee.DB;
import org.jpos.transaction.Context;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/9/13
 * Time: 1:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class ResetTerminal extends BankTxnSupport {
    TerminalDao dao;

    @Override
    protected int doPrepare(long id, Context ctx) throws Exception {
        DB db = openDB(ctx);

        dao = new TerminalDao(db);

        Terminal terminal = (Terminal) ctx.get(TERMINAL);

        dao.saveOrUpdate(terminal.reset());

        ctx.put(TERMINAL, terminal);

        closeDB(ctx);
        return PREPARED | NO_JOIN;
    }
}
