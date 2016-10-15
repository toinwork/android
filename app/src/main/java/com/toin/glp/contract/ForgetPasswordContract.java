package com.toin.glp.contract;

import com.toin.glp.base.BaseInterator;
import com.toin.glp.base.BasePresenter;
import com.toin.glp.base.BaseView;
import com.toin.glp.models.BaseResult;

import java.util.Map;

import rx.Observable;

/**
 * 忘记密码 Created by hb on 16/6/17.
 */
public interface ForgetPasswordContract {
    interface Interactor extends BaseInterator {

        /**
         * 设置登录密码
         * @param params
         * @return
         */
        Observable<BaseResult> setLoginPwd(Map<String, Object> params);

        /**
         * 验证短信
         *
         * @param params
         * @return
         */
        Observable<BaseResult> checkCode(Map<String, Object> params);

        /**
         * 发送验证码
         * 
         * @param phone
         * @return
         */
        Observable<BaseResult> sendCode(String phone);
    }

    interface View extends BaseView {

        void navigateToLogin();

        void startTimer();

        void closeTimer();

    }

    abstract class Presenter extends BasePresenter<Interactor, View> {
        public abstract void setLoginPwd(String userName, String code, String password);

        public abstract void sendCode(String phone);

        @Override
        public void onStart() {

        }
    }
}
