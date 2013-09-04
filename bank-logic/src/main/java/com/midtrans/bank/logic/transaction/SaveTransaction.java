package com.midtrans.bank.logic.transaction;

import com.midtrans.bank.core.model.BankTransConfiguration;
import com.midtrans.bank.core.model.CardRule;
import com.midtrans.bank.core.model.Transaction;
import com.midtrans.bank.core.transaction.BankTxnSupport;
import com.midtrans.bank.logic.dao.impl.TransactionDao;
import org.jpos.ee.DB;
import org.jpos.transaction.Context;

import java.util.Date;

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
        DB db = getDB(ctx);

        dao = new TransactionDao(db);

        BankTransConfiguration btc = (BankTransConfiguration) ctx.get(BTC);
        CardRule cr = (CardRule) ctx.get(CR);

        Transaction txn = new Transaction();
        txn.setAmount((Long) ctx.get(AMOUNT));
        txn.setMid(ctx.getString(MID));
        txn.setTid(ctx.getString(TID));
        txn.setTraceNumber((Integer) ctx.get(TRACE_NUMBER));
        txn.setCardNumber(ctx.getString(CARD_NUMBER));
        txn.setCardExpire(ctx.getString(CARD_EXPIRE));
        txn.setTxnTime((Date) ctx.get(TXN_TIME));
        txn.setReferenceNumber(ctx.getString(REFERENCE_NUMBER));
        txn.setResponseCode(ctx.getString(RCODE));
        txn.setBank(btc.getBank());
        txn.setLookupOfCommandType(cr.getLookupOfCommandType());
        txn.setLookupOfConditionType(cr.getLookupOfConditionType());

        dao.saveOrUpdate(txn);

        closeDB(ctx);
        return PREPARED | NO_JOIN;
    }
}
