package com.midtrans.bank.listener;

import com.midtrans.bank.BankConstants;
import org.jpos.core.Configurable;
import org.jpos.core.Configuration;
import org.jpos.core.ConfigurationException;
import org.jpos.iso.ISORequestListener;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 8/17/13
 * Time: 12:06 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class BankRequestListener implements ISORequestListener, Configurable, BankConstants {

    Configuration cfg;

    @Override
    public void setConfiguration(Configuration cfg) throws ConfigurationException {
        this.cfg = cfg;
    }
}
