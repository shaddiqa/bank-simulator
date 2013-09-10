package com.midtrans.bank.logic.transaction;

import com.midtrans.bank.core.model.BatchTxn;
import com.midtrans.bank.core.transaction.BankTxnSupport;
import com.midtrans.bank.logic.dao.impl.BatchTxnDao;
import org.jpos.ee.DB;
import org.jpos.transaction.Context;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/10/13
 * Time: 1:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class SaveBatchTxn extends BankTxnSupport {
    BatchTxnDao dao;

    @Override
    protected int doPrepare(long id, Context ctx) throws Exception {
        DB db = openDB(ctx);

        dao = new BatchTxnDao(db);

        BatchTxn batchTxn = (BatchTxn) ctx.get(BATCH_TXN);

        dao.saveOrUpdate(batchTxn);

        closeDB(ctx);
        return PREPARED | NO_JOIN;
    }
}
