package com.midtrans.bank.logic.transaction;

import com.midtrans.bank.core.model.SettlementParameter;
import com.midtrans.bank.core.model.Terminal;
import com.midtrans.bank.core.transaction.BankTxnSupport;
import org.jpos.transaction.Context;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/9/13
 * Time: 11:32 AM
 * To change this template use File | Settings | File Templates.
 */
public class DoSettlement extends BankTxnSupport {
    @Override
    protected int doPrepare(long id, Context ctx) throws Exception {
        Terminal terminal = (Terminal) ctx.get(TERMINAL);
        SettlementParameter parameter = (SettlementParameter) ctx.get(SETTLE_PARAM);

        Date now = new Date();
        String refNo = Long.toHexString(System.currentTimeMillis());

        ctx.put(TXN_TIME, now);
        ctx.put(REFERENCE_NUMBER, refNo);

        assertTrue(terminal.getCount().equals(parameter.getDebitSales().getCount()), "95");
        assertTrue(terminal.getAmount().equals(parameter.getDebitSales().getAmount()), "95");

        return PREPARED | NO_JOIN;
    }
}
