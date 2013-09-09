package com.midtrans.bank.logic.transaction;

import com.midtrans.bank.core.transaction.BankTxnSupport;
import org.jpos.transaction.Context;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/9/13
 * Time: 3:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class DoEcho extends BankTxnSupport {
    @Override
    protected int doPrepare(long id, Context ctx) throws Exception {
        ctx.put(TXN_TIME, new Date());

        return PREPARED | NO_JOIN;
    }
}
