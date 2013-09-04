package com.midtrans.bank.logic.dao.impl;

import com.midtrans.bank.core.model.BankISOResponse;
import com.midtrans.bank.core.model.CommandTypeCondition;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.jpos.ee.DB;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/4/13
 * Time: 7:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class BankISOResponseDao extends AbstractBankDao<BankISOResponse> {

    public BankISOResponseDao(DB db) {
        super(db);
    }

    public List<BankISOResponse> findBy(CommandTypeCondition ctc) {
        Criteria criteria = db.session().createCriteria(domainClass);

        criteria.add(Restrictions.eq("commandTypeCondition", ctc));

        return criteria.list();
    }
}
