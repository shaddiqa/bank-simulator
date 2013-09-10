package com.midtrans.bank.logic.transaction;

import com.midtrans.bank.core.model.SettlementTxn;
import com.midtrans.bank.core.transaction.BankTxnSupport;
import org.jpos.transaction.AbortParticipant;
import org.jpos.transaction.Context;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/10/13
 * Time: 10:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class UpdateSettlementTxn extends BankTxnSupport implements AbortParticipant {
    @Override
    protected int doPrepare(long id, Context ctx) throws Exception {
        return updateTransaction(ctx);
    }

    @Override
    protected int doPrepareForAbort(long id, Context ctx) throws Exception {
        if(ctx.get(SETTLE_TXN) == null) {
            return PREPARED | NO_JOIN;
        }

        return updateTransaction(ctx);
    }

    private int updateTransaction(Context ctx) {
        Date txnTime = (Date) ctx.get(TXN_TIME);
        String refNo = ctx.getString(REFERENCE_NUMBER);
        String rCode = ctx.getString(RCODE);

        SettlementTxn settlementTxn = (SettlementTxn) ctx.get(SETTLE_TXN);
        settlementTxn.setTxnTime(txnTime);
        settlementTxn.setReferenceNumber(refNo);
        settlementTxn.setResponseCode(rCode);

        ctx.put(SETTLE_TXN, settlementTxn);

        return PREPARED | NO_JOIN;
    }
}
