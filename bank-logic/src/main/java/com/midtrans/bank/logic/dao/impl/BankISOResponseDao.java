package com.midtrans.bank.logic.dao.impl;

import com.midtrans.bank.core.model.BankISOResponse;
import org.jpos.ee.DB;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/4/13
 * Time: 2:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class BankISOResponseDao extends AbstractBankDao<BankISOResponse> {

    public BankISOResponseDao(DB db) {
        super(db);
    }

}
