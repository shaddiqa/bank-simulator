package com.midtrans.bank.logic.dao.impl;

import com.midtrans.bank.core.model.SettlementTxn;
import org.jpos.ee.DB;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/10/13
 * Time: 2:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class SettlementTxnDao extends AbstractBankDao<SettlementTxn> {

    public SettlementTxnDao(DB db) {
        super(db);
    }
}
