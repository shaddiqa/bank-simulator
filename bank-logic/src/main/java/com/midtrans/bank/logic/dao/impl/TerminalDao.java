package com.midtrans.bank.logic.dao.impl;

import com.midtrans.bank.core.model.Bank;
import com.midtrans.bank.core.model.Terminal;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.jpos.ee.DB;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/6/13
 * Time: 10:14 AM
 * To change this template use File | Settings | File Templates.
 */
public class TerminalDao extends AbstractBankDao<Terminal> {

    public TerminalDao(DB db) {
        super(db);
    }

    public Terminal findBy(Bank bank, String mid, String tid) {
        Criteria criteria = db.session().createCriteria(domainClass);

        criteria.add(Restrictions.eq("bank", bank))
                .add(Restrictions.eq("mid", mid))
                .add(Restrictions.eq("tid", tid))
                .add(Restrictions.eq("active", true));
        return (Terminal) criteria.uniqueResult();
    }
}
