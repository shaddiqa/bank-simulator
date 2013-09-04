package com.midtrans.bank.logic.transaction;

import com.midtrans.bank.core.model.BankTransConfiguration;
import com.midtrans.bank.core.model.CardRule;
import com.midtrans.bank.core.model.CommandTypeCondition;
import com.midtrans.bank.core.transaction.BankTxnSupport;
import com.midtrans.bank.logic.dao.impl.CommandTypeConditionDao;
import org.jpos.ee.DB;
import org.jpos.transaction.Context;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/4/13
 * Time: 4:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class FindCommandTypeCondition extends BankTxnSupport {
    private static final String TIMEOUT = "Time Out";
    private static final String LATERESPONSE = "Late Response";
    private static final String NORESPONSE = "No Response";

    CommandTypeConditionDao dao;

    @Override
    protected int doPrepare(long id, Context ctx) throws Exception {
        DB db = getDB(ctx);

        dao = new CommandTypeConditionDao(db);

        BankTransConfiguration btc = (BankTransConfiguration) ctx.get(BTC);
        CardRule rc = (CardRule) ctx.get(CR);

        CommandTypeCondition ctc = dao.findBy(btc, rc);

        String conditionType = ctc.getLookupOfConditionType().getName();

        if(TIMEOUT.equals(conditionType) || NORESPONSE.equals(conditionType)) {
            return NO_JOIN;
        } else if(LATERESPONSE.equals(conditionType)) {
            Thread.sleep(5000L);
        }

        ctx.put(CTC, ctc);

        return PREPARED | NO_JOIN;
    }
}
