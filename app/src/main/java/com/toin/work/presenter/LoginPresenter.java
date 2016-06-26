package com.toin.work.presenter;

import android.os.Handler;

import com.toin.work.contract.LoginContract;

/**
 * Created by hb on 16/4/6.
 */
public class LoginPresenter extends LoginContract.Presenter implements
        LoginContract.Interactor.OnLoginFinishedListener {

    @Override
    public void login(String userName, String password) {
        if (mView != null) {
            mView.showProgress();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (mView != null) {
                        mView.hideProgress();
                    }
                }
            }, 1500);
        }
        mRxManage.add(mInterator.login(userName, password, this));
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
            mView.setClickable();
            mView.hideProgress();
        }
    }

    @Override
    public void setUnClickable() {
        if (mView != null) {
            mView.setUnClickable();
            mView.hideProgress();
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
    public void onFinish() {
        if (mView != null) {
            mView.hideProgress();
        }
    }
}
