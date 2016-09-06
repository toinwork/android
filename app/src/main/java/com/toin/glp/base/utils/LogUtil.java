package com.toin.glp.base.utils;

import android.util.Log;

import com.toin.glp.Config;

/**
 * Created by baixiaokang on 16/4/28.
 */
public class LogUtil {

    private static final int JSON_INDENT = 4;

    public static void d(String tag, String data) {
        if (!Config.MDEBUG) {
            return;
        }
        Log.d(tag, data);

//        try {
//            Log.d(tag, new JSONObject(data).toString(JSON_INDENT));
//        } catch (JSONException e) {
//            try {
//                Log.d(tag, new JSONArray(data).toString(JSON_INDENT));
//            } catch (JSONException ei) {
//                Log.d(tag, data);
//            }
//        }
    }
}
