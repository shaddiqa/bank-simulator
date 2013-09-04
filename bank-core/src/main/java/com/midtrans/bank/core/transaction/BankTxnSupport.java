package com.midtrans.bank.core.transaction;

import com.midtrans.bank.core.BankConstants;
import org.hibernate.Transaction;
import org.jpos.ee.DB;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISOSource;
import org.jpos.transaction.Context;
import org.jpos.transaction.TxnSupport;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 8/17/13
 * Time: 12:33 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class BankTxnSupport extends TxnSupport implements BankConstants {
    @Override
    public void commit(long id, Serializable context) {
        send((Context) context);
    }

    @Override
    public void abort(long id, Serializable context) {
    }

    private void send(Context ctx) {
        try {
            ISOSource source = (ISOSource) ctx.get(BankConstants.SOURCE);
            ISOMsg response = (ISOMsg) ctx.get(BankConstants.RESPONSE);
            source.send(response);
        } catch (Exception e) {
            error(e);
        }
    }

    protected DB openDB(Context ctx) {
        DB db = (DB) ctx.get(DB);
        if(db == null) {
            db = new DB();
            db.open();
            Transaction txn = db.beginTransaction();
            ctx.put(DB,db);
            ctx.put(TX,txn);
        }
        return db;
    }

    protected void closeDB(Context ctx) {
        DB db = (DB) ctx.get(DB);
        if(db != null) {
            Transaction tx = (Transaction) ctx.get(TX);
            if(tx != null) {
                try {
                    tx.commit();
                } catch (Exception e) {
                    tx.rollback();
                }
            }
            db.close();
        }

        ctx.remove(DB);
        ctx.remove(TX);
    }
}
