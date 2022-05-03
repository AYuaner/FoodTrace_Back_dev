package com.yuan.foodtrace.auth.utils;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public class ReturnUtils {

    private static JSONObject jsonObject;

    public static JSONObject returnFalseResultWithReason(String reason) {
        jsonObject = new JSONObject();
        jsonObject.put("result", false);
        jsonObject.put("errorInfo", reason);
        return jsonObject;
    }

    public static JSONObject returnTrueResult() {
        jsonObject = new JSONObject();
        jsonObject.put("result", true);
        return jsonObject;
    }

    public static <T> JSONObject returnListData(List<T> data) {
        jsonObject = new JSONObject();
        jsonObject.put("listData", data);
        return jsonObject;
    }
}
