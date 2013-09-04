package com.midtrans.bank.logic.dao.impl;

import com.midtrans.bank.core.model.BankTransConfiguration;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.jpos.ee.DB;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/4/13
 * Time: 2:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class BankTransConfigurationDao extends AbstractBankDao<BankTransConfiguration> {

    public BankTransConfigurationDao(DB db) {
        super(db);
    }

    public BankTransConfiguration findBy(String header, String mti, String pCode) {
        Criteria criteria = db.session().createCriteria(domainClass);

        criteria.createAlias("bank", "b")
                .add(Restrictions.eq("b.header", header))
                .add(Restrictions.eq("mti", mti))
                .add(Restrictions.eq("processingCode", pCode));
        return (BankTransConfiguration) criteria.uniqueResult();
    }
}
