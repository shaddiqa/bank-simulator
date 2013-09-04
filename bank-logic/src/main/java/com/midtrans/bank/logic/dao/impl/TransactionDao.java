package com.midtrans.bank.logic.dao.impl;

import com.midtrans.bank.core.model.Transaction;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.jpos.ee.DB;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 8/17/13
 * Time: 9:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class TransactionDao extends AbstractBankDao<Transaction> {

    protected TransactionDao(DB db) {
        super(db);
    }

    public Transaction findBy(String referenceNumber) {
        Criteria criteria = db.session().createCriteria(domainClass);
        criteria.add(Restrictions.eq("referenceNumber", referenceNumber));
        return (Transaction) criteria.uniqueResult();
    }
}
