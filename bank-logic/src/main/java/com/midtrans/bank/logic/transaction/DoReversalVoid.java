package com.midtrans.bank.logic.transaction;

import com.midtrans.bank.core.model.Transaction;
import com.midtrans.bank.core.model.VoidTxn;
import com.midtrans.bank.core.transaction.BankTxnSupport;
import org.jpos.transaction.Context;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/9/13
 * Time: 12:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class DoReversalVoid extends BankTxnSupport {
    @Override
    protected int doPrepare(long id, Context ctx) throws Exception {
        Transaction txn = (Transaction) ctx.get(TXN);
        VoidTxn voidTxn = (VoidTxn) ctx.get(VOID_TXN);

        Date now = new Date();

        ctx.put(TXN_TIME, now);

        voidTxn.setReversal(true);
        txn.modifyVoidAmount(voidTxn);

        ctx.put(VALAFTER, txn.calcSettleAmount());

        ctx.put(VOID_TXN, voidTxn);
        ctx.put(TXN, txn);

        return PREPARED | NO_JOIN;
    }
}
