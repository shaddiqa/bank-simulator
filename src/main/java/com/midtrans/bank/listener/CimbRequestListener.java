package com.midtrans.bank.listener;

import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISOSource;
import org.jpos.space.Space;
import org.jpos.space.SpaceFactory;
import org.jpos.transaction.Context;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 8/17/13
 * Time: 2:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class CimbRequestListener extends BankRequestListener {
    @Override
    public boolean process(ISOSource source, ISOMsg request) {
        try {
            Context ctx = new Context();
            ctx.put(SOURCE, source);
            ctx.put(REQUEST, request);
            ctx.put(MTI, request.getMTI());
            ctx.put(PCODE, request.getString(3));

            Space sp = SpaceFactory.getSpace();
            sp.out("CimbQueue", ctx);

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
