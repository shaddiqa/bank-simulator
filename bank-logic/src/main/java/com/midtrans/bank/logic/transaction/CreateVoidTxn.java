package com.midtrans.bank.logic.transaction;

import com.midtrans.bank.core.model.Transaction;
import com.midtrans.bank.core.model.VoidTxn;
import com.midtrans.bank.core.transaction.BankTxnSupport;
import org.jpos.transaction.Context;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/10/13
 * Time: 10:19 AM
 * To change this template use File | Settings | File Templates.
 */
public class CreateVoidTxn extends BankTxnSupport {
    @Override
    protected int doPrepare(long id, Context ctx) throws Exception {
        Long amount = (Long) ctx.get(AMOUNT);
        Integer traceNumber = (Integer) ctx.get(TRACE_NUMBER);
        Transaction txn = (Transaction) ctx.get(TXN);

        VoidTxn voidTxn = new VoidTxn();
        voidTxn.setAmount(amount);
        voidTxn.setTraceNumber(traceNumber);
        voidTxn.setTransaction(txn);

        ctx.put(VOID_TXN, voidTxn);

        return PREPARED | NO_JOIN;
    }
}
