package com.midtrans.bank.logic.transaction;

import com.midtrans.bank.core.model.Terminal;
import com.midtrans.bank.core.model.Transaction;
import com.midtrans.bank.core.transaction.BankTxnSupport;
import com.midtrans.bank.logic.dao.impl.TransactionDao;
import com.midtrans.bank.logic.util.SettlementUtil;
import org.jpos.ee.DB;
import org.jpos.transaction.Context;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/9/13
 * Time: 12:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class CalculateBatch extends BankTxnSupport {
    TransactionDao dao;

    @Override
    protected int doPrepare(long id, Context ctx) throws Exception {
        DB db = openDB(ctx);

        dao = new TransactionDao(db);

        String command = ctx.getString(COMMAND);
        Terminal terminal = (Terminal) ctx.get(TERMINAL);

        List<Transaction> transactions = dao.findBy(terminal, command.equals("SettlementTrailer"));

        ctx.put(BATCH_BLOCK, SettlementUtil.createBatchBlock(transactions));

        closeDB(ctx);
        return PREPARED | NO_JOIN;
    }
}
