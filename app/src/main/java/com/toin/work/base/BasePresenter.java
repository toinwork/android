package com.toin.work.base;

import android.content.Context;

/**
 * Created by hb on 16/4/22.
 */
public abstract class BasePresenter<E, T> {
    public Context context;
    public E mInterator;
    public T mView;
    public RxManage mRxManage = new RxManage();

    public void setVM(T v, E m) {
        this.mView = v;
        this.mInterator = m;
        this.onStart();
    }

    public abstract void onStart();

    public void onDestroy() {
        mRxManage.clear();
    }
}
