package com.midtrans.bank.logic.transaction;

import com.midtrans.bank.core.model.BankISOResponse;
import com.midtrans.bank.core.transaction.BankTxnSupport;
import org.jpos.iso.ISODate;
import org.jpos.iso.ISOMsg;
import org.jpos.transaction.Context;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/4/13
 * Time: 3:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class GenerateResponse extends BankTxnSupport {
    @Override
    protected int doPrepare(long id, Context ctx) throws Exception {
        ISOMsg request = (ISOMsg) ctx.get(REQUEST);
        Date now = new Date();

        List<BankISOResponse> birs = (List<BankISOResponse>) ctx.get(BIRS);

        ISOMsg response = new ISOMsg();
        response.setMTI(responseMTI(ctx.getString(MTI)));
        for(BankISOResponse bir : birs) {
            switch(bir.getValueResponseType()) {
                case 0 :
                    response.set(bir.getFieldResponseNo(), ISODate.getDate(now));
                    break;
                case 1 :
                    response.set(bir.getFieldResponseNo(), ISODate.getTime(now));
                    break;
                case 2 :
                    response.set(bir.getFieldResponseNo(), Long.toString(System.currentTimeMillis()));
                    break;
                case 3 :
                    response.set(bir.getFieldResponseNo(), bir.getStaticValue());
                    break;
                case 4 :
                    response.set(bir.getFieldResponseNo(), request.getString(bir.getFieldRequestNo()));
                    break;
            }
        }

        if(response.hasField(39)) {
            ctx.put(RCODE, response.getString(39));
        }
        if(response.hasField(37)) {
            ctx.put(REFERENCE_NUMBER, response.getString(37));
        }

        if(response.hasField(13) && response.hasField(12)) {
            ctx.put(TXN_TIME, ISODate.parseISODate(response.getString(13) + response.getString(12)));
        }
        ctx.put(RESPONSE, response);

        return PREPARED | NO_JOIN;
    }
}