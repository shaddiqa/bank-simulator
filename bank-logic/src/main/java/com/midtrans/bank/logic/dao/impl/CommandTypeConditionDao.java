package com.midtrans.bank.logic.dao.impl;

import com.midtrans.bank.core.model.BankTransConfiguration;
import com.midtrans.bank.core.model.CardRule;
import com.midtrans.bank.core.model.CommandTypeCondition;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.jpos.ee.DB;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/4/13
 * Time: 3:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class CommandTypeConditionDao extends AbstractBankDao<CommandTypeCondition> {

    public CommandTypeConditionDao(DB db) {
        super(db);
    }

    public CommandTypeCondition findBy(BankTransConfiguration btc, CardRule cr) {
        Criteria criteria = db.session().createCriteria(domainClass);

        criteria.createAlias("bankISOResponses", "birs")
                .add(Restrictions.eq("bankTransConfiguration", btc))
                .add(Restrictions.eq("lookupOfConditionType", cr.getLookupOfConditionType()));
        return (CommandTypeCondition) criteria.uniqueResult();
    }
}
