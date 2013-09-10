package com.midtrans.bank.logic.dao.impl;

import com.midtrans.bank.core.model.Terminal;
import com.midtrans.bank.core.model.Transaction;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.jpos.ee.DB;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 8/17/13
 * Time: 9:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class TransactionDao extends AbstractBankDao<Transaction> {

    public TransactionDao(DB db) {
        super(db);
    }

    /**
     * For batch upload
     * @param cardNumber
     * @param amount
     * @param traceNumber
     * @param cardExpire
     * @param terminal
     * @param txnTime
     * @param referenceNumber
     * @param responseCode
     * @return
     */
    public Transaction findBy(String cardNumber, Long amount, Integer traceNumber, String cardExpire, Terminal terminal, Date txnTime, String referenceNumber, String responseCode) {
        Criteria criteria = db.session().createCriteria(domainClass);

        criteria.createAlias("trace", "t")
                .add(Restrictions.eq("cardNumber", cardNumber))
                .add(Restrictions.eq("t.terminal", terminal))
                .add(Restrictions.eq("amount", amount));

        if(txnTime != null && referenceNumber != null) {
            criteria.add(Restrictions.eq("txnTime", txnTime))
                    .add(Restrictions.eq("referenceNumber", referenceNumber));
        }

        if(responseCode != null) {
            criteria.add(Restrictions.eq("responseCode", responseCode));
        }

        if(traceNumber != null) {
            criteria.add(Restrictions.eq("t.traceNumber", traceNumber));
        }

        if(cardExpire != null) {
            criteria.add(Restrictions.eq("cardExpire", cardExpire));
        }

        return (Transaction) criteria.uniqueResult();
    }

    /**
     * For reversal
     * @param cardNumber
     * @param amount
     * @param traceNumber
     * @param terminal
     * @return
     */
    public Transaction findBy(String cardNumber, Long amount, Integer traceNumber, Terminal terminal) {
        return findBy(cardNumber, amount, traceNumber, null, terminal, null, null, null);
    }

    /**
     * For void
     * @param cardNumber
     * @param amount
     * @param cardExpire
     * @param terminal
     * @param txnTime
     * @param referenceNumber
     * @return
     */
    public Transaction findBy(String cardNumber, Long amount, String cardExpire, Terminal terminal, Date txnTime, String referenceNumber) {
        return findBy(cardNumber, amount, null, cardExpire, terminal, txnTime, referenceNumber, null);
    }
}
