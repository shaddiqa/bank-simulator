package com.midtrans.bank.logic.dao.impl;

import com.midtrans.bank.core.model.Command;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.jpos.ee.DB;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/10/13
 * Time: 11:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class CommandDao extends AbstractBankDao<Command> {

    public CommandDao(DB db) {
        super(db);
    }

    public Command findBy(String header, String mti, String processingCode) {
        Criteria criteria = db.session().createCriteria(domainClass);

        criteria.createAlias("bank", "b")
                .add(Restrictions.eq("b.header", header))
                .add(Restrictions.eq("b.active", true))
                .add(Restrictions.eq("mti", mti))
                .add(Restrictions.eq("processingCode", processingCode));

        return (Command) criteria.uniqueResult();
    }
}
