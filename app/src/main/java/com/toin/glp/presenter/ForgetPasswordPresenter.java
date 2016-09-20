package com.toin.glp.presenter;

import com.toin.glp.StringUtils;
import com.toin.glp.contract.ForgetPasswordContract;
import com.toin.glp.utils.OnSendMessageFinishedListener;

/**
 * 忘记密码 Created by hb on 16/6/26.
 */
public class ForgetPasswordPresenter extends ForgetPasswordContract.Presenter implements
        ForgetPasswordContract.Interactor.OnSetPasswordFinishedListener,
        OnSendMessageFinishedListener {

    @Override
    public void onSuccess() {
        if (mView != null) {
            mView.hideProgress();
            mView.navigateToLogin();
            mView.finishActivity();
        }
    }

    @Override
    public void onError() {
        if (mView != null) {
            mView.hideProgress();
        }
    }

    /**
     * 先验证短信
     * 
     * @param userName
     * @param code
     * @param password
     * @param passwordAgain
     */
    @Override
    public void setLoginPwd(String userName, String code, String password, String passwordAgain) {
        if (mView != null) {
            mView.showProgress(StringUtils.API_SURE);
            mInterator.checkCode(userName, code, password, passwordAgain, this);
        }
    }

    @Override
    public void sendCode(String phone) {
        if (mView != null) {
            mView.showProgress(StringUtils.API_SEND);
            mInterator.sendCode(phone, this);
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
    public void checkCodeSuccess(String phone, String code, String password, String passwordAgain) {
        if (mView != null) {
            mInterator.setLoginPwd(phone, code, password, passwordAgain, this);
        }
    }

    @Override
    public void onSendSuccess() {
        if (mView != null) {
            mView.hideProgress();
            mView.startTimer();
        }
    }

    @Override
    public void onSendError() {
        if (mView != null) {
            mView.hideProgress();
        }
    }
}
