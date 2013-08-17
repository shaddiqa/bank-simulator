package com.midtrans.bank.transaction;

import org.jpos.transaction.Context;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 8/17/13
 * Time: 12:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class Sale extends BankTxnSupport {
    @Override
    protected int doPrepare(long id, Context ctx) throws Exception {
        return super.doPrepare(id, ctx);
    }
}
