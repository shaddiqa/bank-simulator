package com.midtrans.bank.ws.util;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/4/13
 * Time: 10:55 AM
 * To change this template use File | Settings | File Templates.
 */
public class JsonUtil {
    private static Gson gson = getGson();

    public static Gson getGson() {
        if(gson == null) {
            gson = new GsonBuilder().
                    setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).
                    setPrettyPrinting().
                    setDateFormat("yyyy-MM-dd HH:mm:ss").
                    create();
        }

        return gson;
    }
}
