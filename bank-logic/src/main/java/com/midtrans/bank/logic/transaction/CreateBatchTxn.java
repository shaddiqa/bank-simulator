package com.midtrans.bank.logic.transaction;

import com.midtrans.bank.core.model.BatchTxn;
import com.midtrans.bank.core.model.Transaction;
import com.midtrans.bank.core.transaction.BankTxnSupport;
import org.jpos.transaction.Context;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/10/13
 * Time: 1:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class CreateBatchTxn extends BankTxnSupport {
    @Override
    protected int doPrepare(long id, Context ctx) throws Exception {
        Transaction txn = (Transaction) ctx.get(TXN);

        ctx.put(BATCH_TXN, BatchTxn.create(txn));

        return PREPARED | NO_JOIN;
    }
}
