package com.midtrans.bank.core;

import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISORequestListener;
import org.jpos.iso.ISOSource;
import org.jpos.space.Space;
import org.jpos.space.SpaceFactory;
import org.jpos.transaction.Context;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 8/17/13
 * Time: 12:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class BankRequestListener implements ISORequestListener, BankConstants {

    @Override
    public boolean process(ISOSource source, ISOMsg request) {
        try {
            Context ctx = new Context();
            ctx.put(SOURCE, source);
            ctx.put(REQUEST, request);

            Space sp = SpaceFactory.getSpace();
            sp.out("TxnQueue", ctx);

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
