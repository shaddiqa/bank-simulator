package com.midtrans.bank.logic.transaction;

import com.midtrans.bank.core.model.Transaction;
import com.midtrans.bank.core.transaction.BankTxnSupport;
import org.jpos.transaction.Context;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/10/13
 * Time: 10:48 AM
 * To change this template use File | Settings | File Templates.
 */
public class CheckBalance extends BankTxnSupport {
    @Override
    protected int doPrepare(long id, Context ctx) throws Exception {
        Transaction txn = (Transaction) ctx.get(TXN);
        Long amount = (Long) ctx.get(AMOUNT);

        Long balance = txn.getAmount() - txn.getVoidAmount();

        assertTrue(balance.compareTo(amount) >= 0, "Balance is less than the amount to be void");

        return PREPARED | NO_JOIN;
    }
}
