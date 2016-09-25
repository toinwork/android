package com.toin.glp.api;

import android.widget.Toast;

import com.toin.glp.App;

import rx.Subscriber;

/**
 * Subscriber基类 Created by hb on 16/9/24.
 */
public abstract class BaseSubscriber<T> extends Subscriber {
    @Override
    public void onCompleted() {
    }

    @Override
    public void onError(Throwable e) {
        Toast.makeText(App.context, "当前网络不可用，请检查网络设置！", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNext(Object o) {
        get_model((T) o);
    }

    public abstract void get_model(T o);
}
