package com.midtrans.bank.logic.transaction;

import com.midtrans.bank.core.model.Terminal;
import com.midtrans.bank.core.model.Transaction;
import com.midtrans.bank.core.transaction.BankTxnSupport;
import org.jpos.transaction.Context;

import java.util.Date;

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

        Date now = new Date();
        String refNo = Long.toHexString(System.currentTimeMillis());
        String authId = "AUTH";

        ctx.put(TXN_TIME, now);
        ctx.put(REFERENCE_NUMBER, refNo);
        ctx.put(AUTHORIZATION_ID, authId);

        txn.setAmount((Long) ctx.get(AMOUNT));
        txn.setTerminal((Terminal) ctx.get(TERMINAL));
        txn.setTraceNumber((Integer) ctx.get(TRACE_NUMBER));
        txn.setCardNumber(ctx.getString(CARD_NUMBER));
        txn.setCardExpire(ctx.getString(CARD_EXPIRE));
        txn.setTxnTime(now);
        txn.setReferenceNumber(refNo);
        txn.setAuthorizationId(authId);

        ctx.put(VALAFTER, txn.calcSettleAmount());

        ctx.put(TXN, txn);

        return PREPARED | NO_JOIN;
    }
}
