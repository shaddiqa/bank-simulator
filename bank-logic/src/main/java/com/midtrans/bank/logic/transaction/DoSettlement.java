package com.midtrans.bank.logic.transaction;

import com.midtrans.bank.core.model.SettlementParameter;
import com.midtrans.bank.core.model.SettlementTxn;
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
        SettlementTxn settlementTxn = (SettlementTxn) ctx.get(SETTLE_TXN);

        ctx.put(SETTLE_TXN, settlementTxn);

        assertTrue(terminal.getCount().equals(parameter.getDebitSales().getCount()), "95");
        assertTrue(terminal.getAmount().equals(parameter.getDebitSales().getAmount()), "95");

        return PREPARED | NO_JOIN;
    }
}
