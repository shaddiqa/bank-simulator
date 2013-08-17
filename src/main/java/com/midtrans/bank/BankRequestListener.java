package com.midtrans.bank;

import org.jpos.core.Configurable;
import org.jpos.core.Configuration;
import org.jpos.core.ConfigurationException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISORequestListener;
import org.jpos.iso.ISOSource;
import org.jpos.iso.ISOUtil;
import org.jpos.iso.channel.NACChannel;
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
public class BankRequestListener implements ISORequestListener, Configurable, BankConstants {

    Configuration cfg;

    @Override
    public boolean process(ISOSource source, ISOMsg request) {
        try {
            Context ctx = new Context();
            ctx.put(SOURCE, source);
            ctx.put(HEADER, ISOUtil.hexString(((NACChannel) source).getHeader()));
            ctx.put(REQUEST, request);
            ctx.put(MTI, request.getMTI());
            ctx.put(PCODE, request.getString(3));

            Space sp = SpaceFactory.getSpace();
            sp.out("MainQueue", ctx);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void setConfiguration(Configuration cfg) throws ConfigurationException {
        this.cfg = cfg;
    }
}
