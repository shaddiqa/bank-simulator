package com.midtrans.bank.logic.transaction;

import com.midtrans.bank.core.model.SettlementParameter;
import com.midtrans.bank.core.model.SettlementTxn;
import com.midtrans.bank.core.model.Trace;
import com.midtrans.bank.core.transaction.BankTxnSupport;
import org.jpos.transaction.Context;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/10/13
 * Time: 2:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class CreateSettlementTxn extends BankTxnSupport {
    @Override
    protected int doPrepare(long id, Context ctx) throws Exception {
        Trace trace = (Trace) ctx.get(BANK_TRACE);
        String batchNumber = ctx.getString(BATCH_NUMBER);
        SettlementParameter parameter = (SettlementParameter) ctx.get(SETTLE_PARAM);

        SettlementTxn settlementTxn = new SettlementTxn();
        settlementTxn.setTrace(trace);
        settlementTxn.setBatchNumber(batchNumber);
        settlementTxn.setSettlementParameter(parameter.toString());

        ctx.put(SETTLE_TXN, settlementTxn);

        return PREPARED | NO_JOIN;
    }
}
