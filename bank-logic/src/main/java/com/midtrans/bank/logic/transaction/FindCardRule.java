package com.midtrans.bank.logic.transaction;

import com.midtrans.bank.core.model.BankTransConfiguration;
import com.midtrans.bank.core.model.CardRule;
import com.midtrans.bank.core.transaction.BankTxnSupport;
import com.midtrans.bank.logic.dao.impl.CardRuleDao;
import org.jpos.ee.DB;
import org.jpos.transaction.Context;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/4/13
 * Time: 3:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class FindCardRule extends BankTxnSupport {
    CardRuleDao dao;

    @Override
    protected int doPrepare(long id, Context ctx) throws Exception {
        DB db = openDB(ctx);

        dao = new CardRuleDao(db);

        BankTransConfiguration btc = (BankTransConfiguration) ctx.get(BTC);
        String cardNumber = ctx.getString(CARD_NUMBER);
        String cardExpire = ctx.getString(CARD_EXPIRE);

        CardRule cr = dao.findBy(btc, cardNumber, cardExpire);

        ctx.put(CR, cr);

        closeDB(ctx);
        return PREPARED | NO_JOIN;
    }
}
