package com.tianci.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Create by tianci
 * 2018/12/10 15:07
 */
public class JsonUtil {
    public static String toJson(Object object) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }
}
