package com.midtrans.bank.logic.transaction;

import com.midtrans.bank.core.model.Transaction;
import com.midtrans.bank.core.transaction.BankTxnSupport;
import org.jpos.transaction.Context;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/6/13
 * Time: 1:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class CreateTransaction extends BankTxnSupport {
    @Override
    protected int doPrepare(long id, Context ctx) throws Exception {
        Transaction txn = new Transaction();

        ctx.put(VALBEFORE, txn.calcSettleAmount());

        ctx.put(TXN, txn);

        return PREPARED | NO_JOIN;
    }
}
