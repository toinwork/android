package com.toin.glp.base;

/**
 * BaseView的帮助类,BaseView的底层,为了方位在BaseActivity判断出错 Created by hb on 16/10/13.
 */
public interface BaseViews {
    void finishActivity();

    void hideProgress();

    void showProgress(String msg);

    void showMsg(String msg);
}
