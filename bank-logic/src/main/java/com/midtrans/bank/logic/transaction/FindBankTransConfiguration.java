package com.midtrans.bank.logic.transaction;

import com.midtrans.bank.core.model.BankTransConfiguration;
import com.midtrans.bank.core.transaction.BankTxnSupport;
import com.midtrans.bank.logic.dao.impl.BankTransConfigurationDao;
import org.jpos.ee.DB;
import org.jpos.transaction.Context;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/4/13
 * Time: 3:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class FindBankTransConfiguration extends BankTxnSupport {
    BankTransConfigurationDao dao;

    @Override
    protected int doPrepare(long id, Context ctx) throws Exception {
        DB db = getDB(ctx);

        dao = new BankTransConfigurationDao(db);

        String header = ctx.getString(HEADER);
        String mti = ctx.getString(MTI);
        String pCode = ctx.getString(PCODE);

        BankTransConfiguration btc = dao.findBy(header, mti, pCode);

        ctx.put(BTC, btc);

        return PREPARED | NO_JOIN;
    }
}
