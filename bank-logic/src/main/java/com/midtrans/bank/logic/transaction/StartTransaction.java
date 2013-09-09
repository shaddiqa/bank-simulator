package com.midtrans.bank.logic.transaction;

import com.midtrans.bank.core.model.SettlementParameter;
import com.midtrans.bank.core.transaction.BankTxnSupport;
import org.jpos.iso.ISODate;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISOUtil;
import org.jpos.iso.channel.NACChannel;
import org.jpos.transaction.Context;

import java.util.Date;

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
        if(request.hasField(4)) {
            ctx.put(AMOUNT, Long.valueOf(request.getString(4)));
        }
        ctx.put(CARD_NUMBER, request.getString(2));
        ctx.put(CARD_EXPIRE, request.getString(14));
        if(request.hasField(11)) {
            ctx.put(TRACE_NUMBER, Integer.valueOf(request.getString(11)));
        }
        ctx.put(NII, request.getString(24));
        ctx.put(TID, request.getString(41));
        ctx.put(MID, request.getString(42));

        Date txnTime = null;
        if(request.hasField(13) && request.hasField(12)) {
            txnTime = ISODate.parseISODate(request.getString(13) + request.getString(12));
        }
        ctx.put(TXN_TIME, txnTime);

        ctx.put(REFERENCE_NUMBER, request.getString(37));
        ctx.put(RCODE, request.getString(39));
        ctx.put(BATCH_NUMBER, request.getString(60));

        SettlementParameter parameter = null;
        if(request.hasField(63)) {
            parameter = new SettlementParameter(request.getString(63));
        }
        ctx.put(SETTLE_PARAM, parameter);

        return PREPARED | NO_JOIN;
    }
}
