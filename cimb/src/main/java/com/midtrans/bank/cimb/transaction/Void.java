package com.midtrans.bank.cimb.transaction;

import com.midtrans.bank.core.transaction.BankTxnSupport;
import org.jpos.iso.ISODate;
import org.jpos.iso.ISOMsg;
import org.jpos.transaction.Context;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: rolanfirwandy
 * Date: 8/19/13
 * Time: 6:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class Void extends BankTxnSupport {

    @Override
    protected int doPrepare(long id, Context ctx) throws Exception {
        ISOMsg request = (ISOMsg) ctx.get(REQUEST);

        //TODO Add database for better simulation

        ISOMsg response = new ISOMsg();
        response.setMTI("0210");
        response.set(3, request.getString(3));
        response.set(4, request.getString(4));
        response.set(11, request.getString(11));

        Date now = new Date();
        response.set(12, ISODate.getTime(now));
        response.set(13, ISODate.getDate(now));

        response.set(24, request.getString(24));
        response.set(37, Long.toHexString(System.currentTimeMillis()));
        response.set(39, ctx.getString(RCODE, "00"));
        response.set(41, request.getString(41));

        ctx.put(RESPONSE, response);

        return PREPARED;
    }
}
