package com.midtrans.bank.logic.transaction;

import com.midtrans.bank.core.model.Transaction;
import com.midtrans.bank.core.transaction.BankTxnSupport;
import com.midtrans.bank.logic.dao.impl.TransactionDao;
import org.jpos.ee.DB;
import org.jpos.transaction.Context;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 8/17/13
 * Time: 9:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class SaveTransaction extends BankTxnSupport {
    TransactionDao dao;

    @Override
    protected int doPrepare(long id, Context ctx) throws Exception {
        DB db = openDB(ctx);

        dao = new TransactionDao(db);

        Transaction txn = (Transaction) ctx.get(TXN);

        dao.saveOrUpdate(txn);

        ctx.put(TXN, txn);

        closeDB(ctx);
        return PREPARED | NO_JOIN;
    }
}
