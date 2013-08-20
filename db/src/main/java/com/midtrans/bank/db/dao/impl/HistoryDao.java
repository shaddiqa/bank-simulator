package com.midtrans.bank.db.dao.impl;

import com.midtrans.bank.core.model.History;
import org.jpos.ee.DB;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 8/17/13
 * Time: 9:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class HistoryDao extends AbstractBankDao<History> {

    protected HistoryDao(DB db) {
        super(db);
    }
}
