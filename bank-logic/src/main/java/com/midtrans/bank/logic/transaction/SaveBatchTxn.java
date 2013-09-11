package com.midtrans.bank.logic.transaction;

import com.midtrans.bank.core.model.BatchTxn;
import com.midtrans.bank.core.transaction.BankTxnSupport;
import com.midtrans.bank.logic.dao.impl.BatchTxnDao;
import org.jpos.ee.DB;
import org.jpos.transaction.AbortParticipant;
import org.jpos.transaction.Context;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/10/13
 * Time: 1:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class SaveBatchTxn extends BankTxnSupport implements AbortParticipant {
    BatchTxnDao dao;

    @Override
    protected int doPrepare(long id, Context ctx) throws Exception {
        return saveBatchTxn(ctx);
    }

    @Override
    protected int doPrepareForAbort(long id, Context ctx) throws Exception {
        if(ctx.get(BATCH_TXN) == null) {
            return PREPARED | NO_JOIN;
        }

        return saveBatchTxn(ctx);
    }

    private int saveBatchTxn(Context ctx) {
        DB db = openDB(ctx);

        dao = new BatchTxnDao(db);

        BatchTxn batchTxn = (BatchTxn) ctx.get(BATCH_TXN);

        dao.saveOrUpdate(batchTxn);

        closeDB(ctx);
        return PREPARED | NO_JOIN;
    }
}