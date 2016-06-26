package com.toin.work.api;

import com.toin.work.Config;
import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by hb on 16/3/7.
 */
public class ZmallRefrofit {

    private static OkHttpClient client           = null;

    public static Retrofit init() {
        client = new OkHttpClient();
        client.setReadTimeout(12, TimeUnit.SECONDS);

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Config.API_AGENT + Config.apiVersion)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build();
        return retrofit;
    }

}
