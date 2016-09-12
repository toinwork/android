package com.toin.glp.api;

import android.text.TextUtils;

import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.toin.glp.App;
import com.toin.glp.Navigation;
import com.toin.glp.base.utils.T;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import retrofit.Retrofit;

/**
 * Created by hb on 16/3/8.
 */
public class GlpWeiJinFactory {
    private volatile Retrofit mRetrofit;

    //接口参数不变
    public BaseApi getBaseApiSingleton() {
        if (mRetrofit == null) {
            synchronized (Retrofit.class) {
                if (mRetrofit == null) {
                    mRetrofit = GlpRefrofit.init_weijin();
                }
            }
        }
        mRetrofit.client().interceptors().clear();
        mRetrofit.client().interceptors().add(chain -> {
            Request.Builder request = chain.request().newBuilder();
            Request newRequest = request.build();
            Response response = filter(chain.proceed(newRequest));
            return response;
        });
        return mRetrofit.create(BaseApi.class);
    }

    //接口参数不变
    public BaseApi getBaseApiSingleton1() {
        if (mRetrofit == null) {
            synchronized (Retrofit.class) {
                if (mRetrofit == null) {
                    mRetrofit = GlpRefrofit.init_weijin();
                }
            }
        }
        mRetrofit.client().interceptors().clear();
        mRetrofit.client().interceptors().add(chain -> {
            Request.Builder request = chain.request().newBuilder();
            Request newRequest = request.build();
            Response response = filter(chain.proceed(newRequest));
            return response;
        });
        return mRetrofit.create(BaseApi.class);
    }

    //接口参数不变
    public BaseApi getSendFileAPISingleton(Map<String, Object> params, File files) {
        if (params == null) {
            params = new HashMap<String, Object>();
        }
        if (files != null) {
            params.put("File" + files, "file");
        }
        if (mRetrofit == null) {
            synchronized (Retrofit.class) {
                if (mRetrofit == null) {
                    mRetrofit = GlpRefrofit.init_weijin();
                }
            }
        }
        mRetrofit.client().interceptors().clear();
        mRetrofit.client().interceptors().add(chain -> {
            Request.Builder request = chain.request().newBuilder();
            Request newRequest = request.build();
            Response response = filter(chain.proceed(newRequest));
            return response;
        });
        return mRetrofit.create(BaseApi.class);
    }

    //过滤code
    private Response filter(Response response) {
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
}
