package com.midtrans.bank.logic.dao.impl;

import com.midtrans.bank.core.model.Trace;
import com.midtrans.bank.core.model.Transaction;
import com.midtrans.bank.core.model.VoidTxn;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.jpos.ee.DB;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/10/13
 * Time: 10:09 AM
 * To change this template use File | Settings | File Templates.
 */
public class VoidTxnDao extends AbstractBankDao<VoidTxn> {

    public VoidTxnDao(DB db) {
        super(db);
    }

    public VoidTxn findBy(Transaction txn, Trace trace) {
        Criteria criteria = db.session().createCriteria(domainClass);

        criteria.add(Restrictions.eq("transaction", txn))
                .add(Restrictions.eq("trace", trace));
        return (VoidTxn) criteria.uniqueResult();
    }
}
