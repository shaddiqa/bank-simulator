package com.midtrans.bank.logic.dao.impl;

import com.midtrans.bank.core.model.Terminal;
import com.midtrans.bank.core.model.Transaction;
import org.hibernate.Criteria;
import org.hibernate.Query;
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

    private Transaction findBy(String cardNumber, Long amount, Integer traceNumber, String cardExpire, Terminal terminal, Date txnTime, String referenceNumber, String responseCode, boolean reversal) {
        Criteria criteria = db.session().createCriteria(domainClass);

        criteria.add(Restrictions.eq("cardNumber", cardNumber))
                .add(Restrictions.eq("cardExpire", cardExpire))
                .add(Restrictions.eq("terminal", terminal))
                .add(Restrictions.eq("active", true));

        if(txnTime != null && referenceNumber != null) {
            criteria.add(Restrictions.eq("txnTime", txnTime))
                    .add(Restrictions.eq("referenceNumber", referenceNumber));
        }

        if(responseCode != null) {
            criteria.add(Restrictions.eq("responseCode", responseCode));
        }

        if(reversal) {
            criteria.add(Restrictions.eq("voidTraceNumber", traceNumber))
                    .add(Restrictions.eq("voidAmount", amount));
        } else {
            if(traceNumber != null) {
                criteria.add(Restrictions.eq("traceNumber", traceNumber));
            }
            criteria.add(Restrictions.eq("amount", amount));
        }

        return (Transaction) criteria.uniqueResult();
    }

    /**
     * For reversal sale
     * @param cardNumber
     * @param amount
     * @param traceNumber
     * @param cardExpire
     * @param terminal
     * @return
     */
    public Transaction findBy(String cardNumber, Long amount, Integer traceNumber, String cardExpire, Terminal terminal) {
        return findBy(cardNumber, amount, traceNumber, cardExpire, terminal, null, null, null, false);
    }

    /**
     * For reversal void
     * @param cardNumber
     * @param amount
     * @param traceNumber
     * @param cardExpire
     * @param terminal
     * @param txnTime
     * @param referenceNumber
     * @return
     */
    public Transaction findBy(String cardNumber, Long amount, Integer traceNumber, String cardExpire, Terminal terminal, Date txnTime, String referenceNumber) {
        return findBy(cardNumber, amount, traceNumber, cardExpire, terminal, txnTime, referenceNumber, null, true);
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
        return findBy(cardNumber, amount, null, cardExpire, terminal, txnTime, referenceNumber, null, false);
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
        return findBy(cardNumber, amount, traceNumber, cardExpire, terminal, txnTime, referenceNumber, responseCode, false);
    }

    public int deactivate(Terminal terminal) {
        String hql = "update Transaction set active = false where terminal = :terminal";

        Query query = db.session().createQuery(hql);
        query.setParameter("terminal", terminal);

        return query.executeUpdate();
    }
}
