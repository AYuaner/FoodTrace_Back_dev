package com.yuan.foodtrace.fabric.utils;

import com.alibaba.fastjson.JSONObject;

public final class ReturnUtils {

    private static JSONObject jsonObject = null;

    public static JSONObject returnFalse(String errorInfo) {
        jsonObject = new JSONObject();
        jsonObject.put("result", false);
        jsonObject.put("errorInfo", errorInfo);
        return jsonObject;
    }

    public static JSONObject returnNull(String errorInfo) {
        jsonObject = new JSONObject();
        jsonObject.put("result", null);
        jsonObject.put("errorInfo", errorInfo);
        return jsonObject;
    }
}
