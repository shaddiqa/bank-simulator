package com.midtrans.bank.logic.transaction;

import com.midtrans.bank.core.model.SettlementParameter;
import com.midtrans.bank.core.model.SettlementTxn;
import com.midtrans.bank.core.model.Terminal;
import com.midtrans.bank.core.transaction.BankTxnSupport;
import org.jpos.transaction.Context;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/9/13
 * Time: 11:38 AM
 * To change this template use File | Settings | File Templates.
 */
public class DoSettlementTrailer extends BankTxnSupport {
    @Override
    protected int doPrepare(long id, Context ctx) throws Exception {
        SettlementParameter parameter = (SettlementParameter) ctx.get(SETTLE_PARAM);
        Terminal terminal = (Terminal) ctx.get(TERMINAL);
        SettlementTxn settlementTxn = (SettlementTxn) ctx.get(SETTLE_TXN);

        Date now = new Date();
        String refNo = Long.toHexString(System.currentTimeMillis());

        settlementTxn.setTxnTime(now);
        settlementTxn.setReferenceNumber(refNo);

        ctx.put(TXN_TIME, now);
        ctx.put(REFERENCE_NUMBER, refNo);
        ctx.put(SETTLE_TXN, settlementTxn);

        assertTrue(terminal.getBatchCount().equals(parameter.getDebitSales().getCount()), "95");
        assertTrue(terminal.getBatchAmount().equals(parameter.getDebitSales().getAmount()), "95");

        return PREPARED | NO_JOIN;
    }
}
