package com.midtrans.bank.core.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/10/13
 * Time: 6:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class SettlementParameterTest {
    @Test
    public void testCreate() {
        String param = "000000000000000000000000000000009000009000000000000000000000000000000000000000000000000000";

        Assert.assertEquals(param, SettlementParameter.create(param).toString());
    }
}
