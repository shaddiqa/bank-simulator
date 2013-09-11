package com.midtrans.bank.logic.transaction;

import com.midtrans.bank.core.model.Terminal;
import com.midtrans.bank.core.model.Transaction;
import com.midtrans.bank.core.model.VoidTxn;
import com.midtrans.bank.core.transaction.BankTxnSupport;
import com.midtrans.bank.logic.dao.impl.TransactionDao;
import org.jpos.ee.DB;
import org.jpos.transaction.Context;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/6/13
 * Time: 11:04 AM
 * To change this template use File | Settings | File Templates.
 */
public class FindTransaction extends BankTxnSupport {
    TransactionDao dao;

    @Override
    protected int doPrepare(long id, Context ctx) throws Exception {
        DB db = openDB(ctx);

        dao = new TransactionDao(db);

        String cardNumber = ctx.getString(CARD_NUMBER);
        Long amount = (Long) ctx.get(AMOUNT);
        String cardExpire = ctx.getString(CARD_EXPIRE);
        Terminal terminal = (Terminal) ctx.get(TERMINAL);
        String command = ctx.getString(COMMAND);
        Date txnTime = (Date) ctx.get(TXN_TIME);
        String referenceNumber = ctx.getString(REFERENCE_NUMBER);
        String responseCode = ctx.getString(RCODE);
        String batchNumber = ctx.getString(BATCH_NUMBER);
        Integer traceNumber = (Integer) ctx.get(TRACE_NUMBER);

        Transaction txn = null;

        if("void".equals(command)) {
            txn = dao.findBy(cardNumber, amount, cardExpire, terminal, txnTime, referenceNumber);
        } else if ("batchupload".equals(command)) {
            txn = dao.findBy(cardNumber, amount, Integer.valueOf(batchNumber.substring(4,10)), cardExpire, terminal, txnTime, referenceNumber, responseCode);
        } else if("reversalsale".equals(command)) {
            txn = dao.findBy(cardNumber, amount, traceNumber, terminal);
        } else if("reversalvoid".equals(command)) {
            VoidTxn voidTxn = (VoidTxn) ctx.get(VOID_TXN);
            txn = voidTxn.getTransaction();
        }

        assertNotNull(txn, "12");

        ctx.put(VALBEFORE, txn.calcSettleAmount());

        ctx.put(TXN, txn);

        closeDB(ctx);
        return PREPARED | NO_JOIN;
    }
}
