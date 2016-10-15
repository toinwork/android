package com.toin.glp.base;

import android.content.Context;

/**
 * Created by hb on 16/4/22.
 */
public abstract class BasePresenter<E extends BaseInterator, T extends BaseViews> {
    public Context  context;
    public E        mInterator;
    public T        mView;
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

    public void showProgress(String msg) {
        if (mView != null) {
            mView.showProgress(msg);
        }
    }

    public void hideProgress() {
        if (mView != null) {
            mView.hideProgress();
        }
    }

}
