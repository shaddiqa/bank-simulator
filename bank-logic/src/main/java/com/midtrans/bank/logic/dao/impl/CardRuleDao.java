package com.midtrans.bank.logic.dao.impl;

import com.midtrans.bank.core.model.CardRule;
import org.jpos.ee.DB;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/4/13
 * Time: 2:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class CardRuleDao extends AbstractBankDao<CardRule> {

    public CardRuleDao(DB db) {
        super(db);
    }

}
