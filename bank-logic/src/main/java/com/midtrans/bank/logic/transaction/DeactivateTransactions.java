package com.midtrans.bank.logic.transaction;

import com.midtrans.bank.core.model.Terminal;
import com.midtrans.bank.core.transaction.BankTxnSupport;
import com.midtrans.bank.logic.dao.impl.TransactionDao;
import org.jpos.ee.DB;
import org.jpos.transaction.Context;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/9/13
 * Time: 12:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class DeactivateTransactions extends BankTxnSupport {
    TransactionDao dao;

    @Override
    protected int doPrepare(long id, Context ctx) throws Exception {
        DB db = openDB(ctx);

        dao = new TransactionDao(db);

        String command = ctx.getString(COMMAND);
        Terminal terminal = (Terminal) ctx.get(TERMINAL);

        dao.deactivate(terminal, command.equals("SettlementTrailer"));

        closeDB(ctx);
        return PREPARED | NO_JOIN;
    }
}
