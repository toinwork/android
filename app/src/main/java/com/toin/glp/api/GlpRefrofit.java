package com.toin.glp.api;

import com.toin.glp.Config;
import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by hb on 16/3/7.
 */
public class GlpRefrofit {

    private static OkHttpClient client        = null;

    public static Retrofit init_financing() {
        client = new OkHttpClient();
        client.setReadTimeout(12, TimeUnit.SECONDS);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Config.API_FINANCING)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()).client(client).build();
        return retrofit;
    }

    public static Retrofit init_weijin() {
        client = new OkHttpClient();
        client.setReadTimeout(12, TimeUnit.SECONDS);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Config.API_WEIJIN)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()).client(client).build();
        return retrofit;
    }

}
