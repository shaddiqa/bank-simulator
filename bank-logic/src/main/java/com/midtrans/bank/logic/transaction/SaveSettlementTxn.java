package com.midtrans.bank.logic.transaction;

import com.midtrans.bank.core.model.SettlementTxn;
import com.midtrans.bank.core.transaction.BankTxnSupport;
import com.midtrans.bank.logic.dao.impl.SettlementTxnDao;
import org.jpos.ee.DB;
import org.jpos.transaction.Context;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/10/13
 * Time: 3:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class SaveSettlementTxn extends BankTxnSupport {
    SettlementTxnDao dao;

    @Override
    protected int doPrepare(long id, Context ctx) throws Exception {
        DB db = openDB(ctx);

        dao = new SettlementTxnDao(db);

        SettlementTxn settlementTxn = (SettlementTxn) ctx.get(SETTLE_TXN);

        dao.saveOrUpdate(settlementTxn);

        closeDB(ctx);
        return PREPARED | NO_JOIN;
    }
}
