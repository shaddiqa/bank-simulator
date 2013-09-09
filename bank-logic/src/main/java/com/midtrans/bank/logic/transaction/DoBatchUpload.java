package com.midtrans.bank.logic.transaction;

import com.midtrans.bank.core.model.Transaction;
import com.midtrans.bank.core.transaction.BankTxnSupport;
import com.midtrans.bank.logic.util.SettlementUtil;
import org.jpos.transaction.Context;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/9/13
 * Time: 12:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class DoBatchUpload extends BankTxnSupport {
    @Override
    protected int doPrepare(long id, Context ctx) throws Exception {
        Transaction txn = (Transaction) ctx.get(TXN);
        String batchNumber = ctx.getString(BATCH_NUMBER);

        txn.setBatchNumber(batchNumber);

        ctx.put(VALAFTER, SettlementUtil.calculateAmount(txn));

        ctx.put(TXN, txn);

        return PREPARED | NO_JOIN;
    }
}
