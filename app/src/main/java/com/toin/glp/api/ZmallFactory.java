package com.toin.glp.api;

import android.text.TextUtils;

import com.toin.glp.App;
import com.toin.glp.Config;
import com.toin.glp.Navigation;
import com.toin.glp.models.UserModel;
import com.toin.glp.base.utils.MD5;
import com.toin.glp.base.utils.T;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import retrofit.Retrofit;

/**
 * Created by hb on 16/3/8.
 */
public class ZmallFactory {
    private volatile static Retrofit mRetrofit;

    //接口参数不变
    public static BaseApi getBaseApiSingleton(String url, Map<String, Object> params) {

        if (mRetrofit == null) {
            synchronized (Retrofit.class) {
                if (mRetrofit == null) {
                    mRetrofit = ZmallRefrofit.init();
                }
            }
        }
        //Authentication
        String clientType = android.os.Build.MODEL + "_" + android.os.Build.VERSION.RELEASE;
        String signStr = Config.apiVersion + url + "?" + getSortStr(params) + "_"
                + Config.appSecurity;
        if (!TextUtils.isEmpty(App.token)) {
            signStr += "_" + App.token;
        }
        String authStr = MD5.toMD5(signStr).toUpperCase(Locale.CHINA);

        mRetrofit.client().interceptors().clear();
        mRetrofit
                .client()
                .interceptors()
                .add(chain -> {
                    Request.Builder request = chain.request().newBuilder();
                    request.addHeader("Os-From", "ANDROID-" + clientType).addHeader(
                            "Authentication", authStr);
                    if (!TextUtils.isEmpty(App.token)) {
                        request.addHeader("Session-Token", App.token);
                    }
                    Request newRequest = request.build();
                    Response response = filter(chain.proceed(newRequest));
                    return response;
                });
        return mRetrofit.create(BaseApi.class);
    }

    //接口参数不变
    public static BaseApi getBaseApiSingleton1(String url, Map<String, Object> params) {
        if (mRetrofit == null) {
            synchronized (Retrofit.class) {
                if (mRetrofit == null) {
                    mRetrofit = ZmallRefrofit.init();
                }
            }
        }
        String signStr = Config.apiVersion + url;
        mRetrofit.client().interceptors().clear();
        mRetrofit.client().interceptors().add(chain -> {
            Request.Builder request = chain.request().newBuilder();
            request.addHeader("Authentication", signStr);
            Request newRequest = request.build();
            Response response = filter(chain.proceed(newRequest));
            return response;
        });
        return mRetrofit.create(BaseApi.class);
    }

    //接口参数不变
    public static BaseApi getSendFileAPISingleton(String url, Map<String, Object> params, File files) {
        if (params == null) {
            params = new HashMap<String, Object>();
        }
        if (files != null) {
            params.put("File" + files, "file");
        }
        if (mRetrofit == null) {
            synchronized (Retrofit.class) {
                if (mRetrofit == null) {
                    mRetrofit = ZmallRefrofit.init();
                }
            }
        }
        //Authentication
        String clientType = android.os.Build.MODEL + "_" + android.os.Build.VERSION.RELEASE;
        String signStr = Config.apiVersion + url + "?" + getSortStr(params) + "_"
                + Config.appSecurity;
        if (!TextUtils.isEmpty(App.token)) {
            signStr += "_" + App.token;
        }
        String authStr = MD5.toMD5(signStr).toUpperCase(Locale.CHINA);

        mRetrofit.client().interceptors().clear();
        mRetrofit
                .client()
                .interceptors()
                .add(chain -> {
                    Request.Builder request = chain.request().newBuilder();
                    request.addHeader("Os-From", "ANDROID-" + clientType).addHeader(
                            "Authentication", authStr);
                    if (!TextUtils.isEmpty(App.token)) {
                        request.addHeader("Session-Token", App.token);
                    }
                    Request newRequest = request.build();
                    Response response = filter(chain.proceed(newRequest));
                    return response;
                });
        return mRetrofit.create(BaseApi.class);
    }

    //过滤code
    private static Response filter(Response response) {
        if (response.code() != 200) {
            if (response.code() == 402 || response.code() == 403) {
                Navigation.logout(App.context);
            }
            String str = null;
            try {
                str = response.body().string();
            } catch (IOException e) {

            }
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jo = new JSONObject(str);
                    String error = jo.optString("msg");
                    T.showShort(error);
                } catch (JSONException e) {

                }
            }
            return null;
        } else {
            return response;
        }
    }

    /**
     * 获得排序后请求字符串
     *
     * @param params
     * @return
     */
    public static String getSortStr(Map<String, Object> params) {
        if (params == null || params.isEmpty()) {
            return "";
        }
        StringBuilder requestParams = new StringBuilder();
        Map<String, Object> tempMap = sortMapByKey(params);
        Set<String> keySet = tempMap.keySet();
        Object[] key = keySet.toArray();
        Arrays.sort(key);
        for (int i = 0; i < key.length; i++) {
            requestParams.append(key[i]);
            requestParams.append("=");
            requestParams.append(tempMap.get(key[i]).toString());
            if (i < key.length - 1) {
                requestParams.append("&");
            }
        }
        return requestParams.toString();
    }

    /**
     * 使用 Map按key进行排序
     *
     * @param map
     * @return
     */
    public static Map<String, Object> sortMapByKey(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        Map<String, Object> sortMap = new TreeMap<String, Object>((lhs, rhs) -> {
            return lhs.compareTo(rhs);
        });
        sortMap.putAll(map);
        return sortMap;
    }

    public static String toString(UserModel userModel) {
        String jsonString = "{\"account\":" + userModel.getAccount() + ",\"mobile\":"
                + userModel.getMobile() + ",\"uname\":" + userModel.getUname() + ",\"token\":"
                + userModel.getToken() + "}";
        return jsonString;
    }
}
