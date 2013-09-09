package com.midtrans.bank.logic.util;

import com.midtrans.bank.core.model.SettlementBlock;
import com.midtrans.bank.core.model.Transaction;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/9/13
 * Time: 12:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class SettlementUtil {
    public static SettlementBlock createBatchBlock(List<Transaction> transactions) {
        int count = 0;
        long amount = 0L;

        for(Transaction txn : transactions) {
            amount += calculateAmount(txn);
            count++;
        }

        return new SettlementBlock(count, amount);
    }

    public static Long calculateAmount(Transaction txn) {
        if(txn.isReversalFlag()) {
            return 0L;
        }

        if(txn.isVoidFlag()) {
            return txn.getAmount() - txn.getVoidAmount();
        }

        return txn.getAmount();
    }
}
