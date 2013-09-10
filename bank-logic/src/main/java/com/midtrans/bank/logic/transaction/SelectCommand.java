package com.midtrans.bank.logic.transaction;

import com.midtrans.bank.core.model.Command;
import com.midtrans.bank.core.transaction.BankTxnSupport;
import com.midtrans.bank.logic.dao.impl.CommandDao;
import org.jpos.ee.DB;
import org.jpos.transaction.Context;
import org.jpos.transaction.GroupSelector;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/5/13
 * Time: 9:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class SelectCommand extends BankTxnSupport implements GroupSelector {
    CommandDao dao;

    @Override
    public String select(long id, Serializable context) {
        Context ctx = (Context) context;
        String header = ctx.getString(HEADER);
        String mti = ctx.getString(MTI);
        String pCode = ctx.getString(PCODE);

        DB db = openDB(ctx);

        dao = new CommandDao(db);

        Command command = dao.findBy(header, mti, pCode);

        ctx.put(COMMAND, command.getName());
        ctx.put(BANK, command.getBank());

        closeDB(ctx);
        return cfg.get(command.getName());
    }

    @Override
    public int prepare(long id, Serializable context) {
        return PREPARED | NO_JOIN;
    }
}
