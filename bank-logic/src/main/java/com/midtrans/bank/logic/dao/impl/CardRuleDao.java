package com.midtrans.bank.logic.dao.impl;

import com.midtrans.bank.core.model.BankTransConfiguration;
import com.midtrans.bank.core.model.CardRule;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.jpos.ee.DB;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/4/13
 * Time: 3:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class CardRuleDao extends AbstractBankDao<CardRule> {

    public CardRuleDao(DB db) {
        super(db);
    }

    public CardRule findBy(BankTransConfiguration btc, String cardNumber, String cardExpire) {
        Criteria criteria = db.session().createCriteria(domainClass);

        criteria.createAlias("card", "c")
                .add(Restrictions.eq("c.bank", btc.getBank()))
                .add(Restrictions.eq("c.cardNo", cardNumber))
                .add(Restrictions.eq("c.cardExpire", cardExpire))
                .add(Restrictions.eq("lookupOfCommandType", btc.getLookupOfCommandType()));
        return (CardRule) criteria.uniqueResult();
    }
}
