package com.midtrans.bank.logic.transaction;

import com.midtrans.bank.core.model.BankISOResponse;
import com.midtrans.bank.core.model.CommandTypeCondition;
import com.midtrans.bank.core.transaction.BankTxnSupport;
import com.midtrans.bank.logic.dao.impl.BankISOResponseDao;
import org.jpos.ee.DB;
import org.jpos.transaction.Context;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/4/13
 * Time: 7:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class FindBankISOResponses extends BankTxnSupport {
    BankISOResponseDao dao;

    @Override
    protected int doPrepare(long id, Context ctx) throws Exception {
        DB db = openDB(ctx);

        dao = new BankISOResponseDao(db);

        CommandTypeCondition ctc = (CommandTypeCondition) ctx.get(CTC);

        List<BankISOResponse> bankISOResponses = dao.findBy(ctc);

        ctx.put(BIRS, bankISOResponses);

        closeDB(ctx);
        return PREPARED | NO_JOIN;
    }
}
