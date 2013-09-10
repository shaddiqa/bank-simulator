package com.midtrans.bank.logic.dao.impl;

import com.midtrans.bank.core.model.Terminal;
import com.midtrans.bank.core.model.Trace;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.jpos.ee.DB;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/10/13
 * Time: 1:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class TraceDao extends AbstractBankDao<Trace> {

    public TraceDao(DB db) {
        super(db);
    }

    public Trace findBy(Terminal terminal, Integer traceNumber) {
        Criteria criteria = db.session().createCriteria(domainClass);

        criteria.add(Restrictions.eq("terminal", terminal))
                .add(Restrictions.eq("traceNumber", traceNumber))
                .add(Restrictions.eq("active", true));

        return (Trace) criteria.uniqueResult();
    }
}
