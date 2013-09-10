package com.midtrans.bank.logic.transaction;

import com.midtrans.bank.core.transaction.BankTxnSupport;
import org.jpos.iso.ISODate;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.packager.ISO87BPackager;
import org.jpos.transaction.AbortParticipant;
import org.jpos.transaction.Context;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/9/13
 * Time: 3:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class EchoResponse extends BankTxnSupport implements AbortParticipant {
    @Override
    protected int doPrepare(long id, Context ctx) throws Exception {
        return buildResponse(ctx);
    }

    @Override
    protected int doPrepareForAbort(long id, Context ctx) throws Exception {
        return buildResponse(ctx);
    }

    private int buildResponse(Context ctx) throws ISOException {
        String mti = ctx.getString(MTI);
        String pCode = ctx.getString(PCODE);
        Date txnTime = (Date) ctx.get(TXN_TIME, new Date());
        String nii = ctx.getString(NII);
        String tid = ctx.getString(TID);

        ctx.put(RESPONSE, createResponse(responseMTI(mti), pCode, txnTime, nii, tid));

        return PREPARED | NO_JOIN;
    }

    private ISOMsg createResponse(String mti, String pCode, Date txnTime, String nii, String tid) throws ISOException {
        ISOMsg response = new ISOMsg();

        response.setPackager(new ISO87BPackager());
        response.setMTI(mti);
        response.set(3, pCode);
        response.set(12, ISODate.getTime(txnTime));
        response.set(13, ISODate.getDate(txnTime));
        response.set(24, nii);
        response.set(41, tid);

        return response;
    }
}
