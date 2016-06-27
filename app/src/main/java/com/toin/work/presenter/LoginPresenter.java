package com.toin.work.presenter;

import com.toin.work.StringUtils;
import com.toin.work.contract.LoginContract;

/**
 * Created by hb on 16/4/6.
 */
public class LoginPresenter extends LoginContract.Presenter implements
        LoginContract.Interactor.OnLoginFinishedListener {

    @Override
    public void login(String userName, String password) {
        if (mView != null) {
            mView.showProgress(StringUtils.API_LOGIN);
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
}
