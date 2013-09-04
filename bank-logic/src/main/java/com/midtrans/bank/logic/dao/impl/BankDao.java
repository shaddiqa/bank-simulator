package com.midtrans.bank.logic.dao.impl;

import com.midtrans.bank.core.model.Bank;
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
public class BankDao extends AbstractBankDao<Bank> {

    public BankDao(DB db) {
        super(db);
    }

    public Bank findBy(String header, String mti, String pCode) {
        Criteria criteria = db.session().createCriteria(domainClass);

        criteria.createAlias("bankTransConfigurations", "btc")
                .add(Restrictions.eq("header", header))
                .add(Restrictions.eq("btc.mti", mti))
                .add(Restrictions.eq("btc.processingCode", pCode))
                .setMaxResults(1);
        return (Bank) criteria.uniqueResult();
    }
}
