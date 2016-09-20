package com.toin.glp.presenter;

import com.toin.glp.StringUtils;
import com.toin.glp.contract.LoginContract;

import rx.Subscription;

/**
 * 登录 Created by hb on 16/4/6.
 */
public class LoginPresenter extends LoginContract.Presenter implements
        LoginContract.Interactor.OnLoginFinishedListener {

    @Override
    public void login(String userName, String password, String code) {
        if (mView != null) {
            mView.showProgress(StringUtils.API_LOGIN);
        }
        Subscription s = mInterator.login(userName, password, code, this);
        if (s != null) {
            mRxManage.add(s);
        }
    }

    @Override
    public void checkLogin(String userName, String password) {
        mInterator.checkLogin(userName, password, this);
    }

    @Override
    public void getAccount() {
        if (mView != null) {
            mView.setAccountInfo(mInterator.getAccount());
        }
    }

    @Override
    public void setClickable() {
        if (mView != null) {
            mView.hideProgress();
        }
    }

    @Override
    public void setUnClickable() {
        if (mView != null) {
            mView.hideProgress();
        }
    }

    @Override
    public void showVerifyCode(String code) {
        if (mView != null) {
            mView.showVerifyCode(code);
        }
    }

    @Override
    public void onSuccess() {
        if (mView != null) {
            mView.hideProgress();
            mView.navigateToHome();
            mView.finishActivity();
        }
    }

    @Override
    public void onError() {
        if (mView != null) {
            mView.hideProgress();
        }
    }
}
