package com.midtrans.bank.logic.transaction;

import com.midtrans.bank.core.model.Terminal;
import com.midtrans.bank.core.transaction.BankTxnSupport;
import com.midtrans.bank.logic.dao.impl.TerminalDao;
import org.jpos.ee.DB;
import org.jpos.transaction.AbortParticipant;
import org.jpos.transaction.Context;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/6/13
 * Time: 10:26 AM
 * To change this template use File | Settings | File Templates.
 */
public class SaveTerminal extends BankTxnSupport implements AbortParticipant {
    TerminalDao dao;

    @Override
    protected int doPrepare(long id, Context ctx) throws Exception {
        return saveTerminal(ctx);
    }

    @Override
    protected int doPrepareForAbort(long id, Context ctx) throws Exception {
        if(ctx.get(TERMINAL) == null) {
            return PREPARED | NO_JOIN;
        }

        return saveTerminal(ctx);
    }

    private int saveTerminal(Context ctx) {
        DB db = openDB(ctx);

        dao = new TerminalDao(db);

        Terminal terminal = (Terminal) ctx.get(TERMINAL);

        dao.saveOrUpdate(terminal);

        closeDB(ctx);
        return PREPARED | NO_JOIN;
    }
}