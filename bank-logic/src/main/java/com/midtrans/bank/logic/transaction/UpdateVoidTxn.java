package com.midtrans.bank.logic.transaction;

import com.midtrans.bank.core.model.VoidTxn;
import com.midtrans.bank.core.transaction.BankTxnSupport;
import org.jpos.transaction.AbortParticipant;
import org.jpos.transaction.Context;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/10/13
 * Time: 10:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class UpdateVoidTxn extends BankTxnSupport implements AbortParticipant {
    @Override
    protected int doPrepare(long id, Context ctx) throws Exception {
        return updateTransaction(ctx);
    }

    @Override
    protected int doPrepareForAbort(long id, Context ctx) throws Exception {
        if(ctx.get(VOID_TXN) == null) {
            return PREPARED | NO_JOIN;
        }

        return updateTransaction(ctx);
    }

    private int updateTransaction(Context ctx) {
        String authId = ctx.getString(AUTHORIZATION_ID);
        String rCode = ctx.getString(RCODE);

        VoidTxn voidTxn = (VoidTxn) ctx.get(VOID_TXN);
        voidTxn.setAuthorizationId(authId);
        voidTxn.setResponseCode(rCode);

        ctx.put(VOID_TXN, voidTxn);

        return PREPARED | NO_JOIN;
    }
}
