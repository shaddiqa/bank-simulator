package com.midtrans.bank.logic.transaction;

import com.midtrans.bank.core.model.VoidTxn;
import com.midtrans.bank.core.transaction.BankTxnSupport;
import com.midtrans.bank.logic.dao.impl.VoidTxnDao;
import org.jpos.ee.DB;
import org.jpos.transaction.Context;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/10/13
 * Time: 10:10 AM
 * To change this template use File | Settings | File Templates.
 */
public class SaveVoidTxn extends BankTxnSupport {
    VoidTxnDao dao;

    @Override
    protected int doPrepare(long id, Context ctx) throws Exception {
        DB db = openDB(ctx);

        dao = new VoidTxnDao(db);

        VoidTxn voidTxn = (VoidTxn) ctx.get(VOID_TXN);

        dao.saveOrUpdate(voidTxn);

        closeDB(ctx);
        return PREPARED | NO_JOIN;
    }
}
