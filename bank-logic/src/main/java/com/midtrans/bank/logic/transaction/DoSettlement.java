package com.midtrans.bank.logic.transaction;

import com.midtrans.bank.core.model.SettlementParameter;
import com.midtrans.bank.core.model.Terminal;
import com.midtrans.bank.core.transaction.BankTxnSupport;
import org.jpos.transaction.Context;

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

        assertTrue(terminal.getCount().equals(parameter.getDebitSales().getCount()), "Count is not equal");
        assertTrue(terminal.getAmount().equals(parameter.getDebitSales().getAmount()), "Amount is not equal");

        return PREPARED | NO_JOIN;
    }
}
