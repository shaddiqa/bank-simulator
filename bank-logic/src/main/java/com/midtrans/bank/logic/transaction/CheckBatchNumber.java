package com.midtrans.bank.logic.transaction;

import com.midtrans.bank.core.model.BatchTxn;
import com.midtrans.bank.core.model.Terminal;
import com.midtrans.bank.core.transaction.BankTxnSupport;
import com.midtrans.bank.logic.dao.impl.BatchTxnDao;
import org.jpos.ee.DB;
import org.jpos.transaction.Context;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/10/13
 * Time: 8:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class CheckBatchNumber extends BankTxnSupport {
    BatchTxnDao dao;

    @Override
    protected int doPrepare(long id, Context ctx) throws Exception {
        DB db = openDB(ctx);

        dao = new BatchTxnDao(db);

        Terminal terminal = (Terminal) ctx.get(TERMINAL);
        String batchNumber = ctx.getString(BATCH_NUMBER);

        BatchTxn batchTxn = dao.findBy(terminal, batchNumber);

        assertNull(batchTxn, "12");

        closeDB(ctx);
        return PREPARED | NO_JOIN;
    }
}
