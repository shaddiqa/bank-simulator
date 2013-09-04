package com.midtrans.bank.logic.transaction;

import com.midtrans.bank.core.transaction.BankTxnSupport;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISOUtil;
import org.jpos.iso.channel.NACChannel;
import org.jpos.transaction.Context;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/4/13
 * Time: 1:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class StartTransaction extends BankTxnSupport {
    @Override
    protected int doPrepare(long id, Context ctx) throws Exception {
        NACChannel source = (NACChannel) ctx.get(SOURCE);
        ISOMsg request = (ISOMsg) ctx.get(REQUEST);

        ctx.put(HEADER, ISOUtil.hexString(source.getHeader()));
        ctx.put(MTI, request.getMTI());
        ctx.put(PCODE, request.getString(3));
        ctx.put(AMOUNT, request.getString(4));
        ctx.put(CARD_NUMBER, request.getString(2));
        ctx.put(CARD_EXPIRE, request.getString(14));
        ctx.put(TRACE_NUMBER, request.getString(11));
        ctx.put(TID, request.getString(41));
        ctx.put(MID, request.getString(42));

        return PREPARED | NO_JOIN;
    }
}
