package com.midtrans.bank.logic.dao.impl;

import com.midtrans.bank.core.model.BatchTxn;
import org.jpos.ee.DB;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/10/13
 * Time: 2:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class BatchTxnDao extends AbstractBankDao<BatchTxn> {

    public BatchTxnDao(DB db) {
        super(db);
    }
}
