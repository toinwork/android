package com.toin.glp.presenter;

import com.toin.glp.StringUtils;
import com.toin.glp.contract.RegisterContract;
import com.toin.glp.utils.OnSendMessageFinishedListener;

/**
 * 注册 Created by hb on 16/6/26.
 */
public class RegisterPresenter extends RegisterContract.Presenter implements
        RegisterContract.Interactor.OnRegisterSuccessListener, OnSendMessageFinishedListener{

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

    /**
     * 先验证短信
     *
     * @param userName
     * @param code
     * @param password
     * @param passwordAgain
     */
    @Override
    public void register(String userName, String code, String password, String passwordAgain) {
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
            mInterator.register(phone, code, password, passwordAgain, this);
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
