package com.midtrans.bank.logic.transaction;

import com.midtrans.bank.core.model.SettlementParameter;
import com.midtrans.bank.core.model.SettlementTxn;
import com.midtrans.bank.core.model.Trace;
import com.midtrans.bank.core.transaction.BankTxnSupport;
import com.midtrans.bank.logic.dao.impl.SettlementTxnDao;
import org.jpos.ee.DB;
import org.jpos.transaction.AbortParticipant;
import org.jpos.transaction.Context;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/10/13
 * Time: 3:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class SaveSettlementTxn extends BankTxnSupport implements AbortParticipant {
    SettlementTxnDao dao;

    @Override
    protected int doPrepare(long id, Context ctx) throws Exception {
        return saveSettlementTxn(ctx);
    }

    @Override
    protected int doPrepareForAbort(long id, Context ctx) throws Exception {
        if(ctx.get(SETTLE_TXN) == null) {
            Date txnTime = (Date) ctx.get(TXN_TIME, new Date());
            String refNo = ctx.getString(REFERENCE_NUMBER, Long.toHexString(System.currentTimeMillis()));
            String batchNumber = ctx.getString(BATCH_NUMBER);
            SettlementParameter parameter = (SettlementParameter) ctx.get(SETTLE_PARAM);
            String rCode = ctx.getString(RCODE);
            Trace trace = (Trace) ctx.get(TRACE);

            SettlementTxn settlementTxn = new SettlementTxn();
            settlementTxn.setTxnTime(txnTime);
            settlementTxn.setReferenceNumber(refNo);
            settlementTxn.setBatchNumber(batchNumber);
            settlementTxn.setSettlementParameter(parameter.toString());
            settlementTxn.setResponseCode(rCode);
            settlementTxn.setTrace(trace);

            ctx.put(SETTLE_TXN, settlementTxn);
        }

        return saveSettlementTxn(ctx);
    }

    private int saveSettlementTxn(Context ctx) {
        DB db = openDB(ctx);

        dao = new SettlementTxnDao(db);

        SettlementTxn settlementTxn = (SettlementTxn) ctx.get(SETTLE_TXN);

        dao.saveOrUpdate(settlementTxn);

        closeDB(ctx);
        return PREPARED | NO_JOIN;
    }
}
