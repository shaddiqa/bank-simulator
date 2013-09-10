package com.midtrans.bank.logic.transaction;

import com.midtrans.bank.core.model.Trace;
import com.midtrans.bank.core.model.Transaction;
import com.midtrans.bank.core.transaction.BankTxnSupport;
import org.jpos.transaction.Context;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/9/13
 * Time: 12:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class DoSale extends BankTxnSupport {
    @Override
    protected int doPrepare(long id, Context ctx) throws Exception {
        Transaction txn = (Transaction) ctx.get(TXN);

        txn.setAmount((Long) ctx.get(AMOUNT));
        txn.setTrace((Trace) ctx.get(BANK_TRACE));
        txn.setCardNumber(ctx.getString(CARD_NUMBER));
        txn.setCardExpire(ctx.getString(CARD_EXPIRE));

        ctx.put(VALAFTER, txn.calcSettleAmount());

        ctx.put(TXN, txn);

        return PREPARED | NO_JOIN;
    }
}
