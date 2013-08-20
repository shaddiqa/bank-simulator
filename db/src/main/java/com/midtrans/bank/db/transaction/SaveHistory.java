package com.midtrans.bank.db.transaction;

import com.midtrans.bank.core.transaction.BankTxnSupport;
import com.midtrans.bank.db.dao.impl.HistoryDao;
import org.jpos.transaction.Context;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 8/17/13
 * Time: 9:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class SaveHistory extends BankTxnSupport {
    HistoryDao dao;

    @Override
    protected int doPrepare(long id, Context ctx) throws Exception {
        String command = ctx.getString(COMMAND);
        String bank = ctx.getString(BANK);
        String mid = ctx.getString(MID);
        String tid = ctx.getString(TID);
        Integer traceNumber = (Integer) ctx.get(TRACE_NUMBER);
        String status = ctx.getString(STATUS);
        Date requestedAt = (Date) ctx.get(REQUESTED_AT);

        return PREPARED;
    }
}
