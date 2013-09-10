package com.midtrans.bank.logic.dao.impl;

import com.midtrans.bank.core.model.BatchTxn;
import com.midtrans.bank.core.model.Terminal;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
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

    public BatchTxn findBy(Terminal terminal, String batchNumber) {
        Criteria criteria = db.session().createCriteria(domainClass);

        criteria.createAlias("trace", "t")
                .add(Restrictions.eq("batchNumber", batchNumber))
                .add(Restrictions.eq("t.terminal", terminal))
                .add(Restrictions.eq("t.active", true));

        return (BatchTxn) criteria.uniqueResult();
    }
}
