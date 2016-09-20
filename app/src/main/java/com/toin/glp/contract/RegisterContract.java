package com.toin.glp.contract;

import com.toin.glp.api.BaseApiFinishListener;
import com.toin.glp.base.BaseInterator;
import com.toin.glp.base.BasePresenter;
import com.toin.glp.base.BaseView;
import com.toin.glp.utils.OnSendMessageFinishedListener;

import rx.Subscription;

/**
 * 忘记密码 Created by hb on 16/6/17.
 */
public interface RegisterContract {
    interface Interactor extends BaseInterator {

        interface OnRegisterSuccessListener extends BaseApiFinishListener {
            void setClickable();

            void setUnClickable();

            void checkCodeSuccess(String phone, String code, String password, String passwordAgain);
        }

        /**
         * 注册
         *
         * @param phone
         * @param code
         * @param password
         * @param passwordAgain
         * @return
         */
        Subscription register(String phone, String code, String password, String passwordAgain,
                              OnRegisterSuccessListener listener);

        /**
         * 验证短信
         *
         * @param phone
         * @param code
         * @param listener
         * @return
         */
        Subscription checkCode(String phone, String code, String password, String passwordAgain,
                               OnRegisterSuccessListener listener);

        /**
         * 发送验证码
         *
         * @param phone
         * @param listener
         * @return
         */
        Subscription sendCode(String phone, OnSendMessageFinishedListener listener);
    }

    interface View extends BaseView {

        void navigateToHome();

        void startTimer();

    }

    abstract class Presenter extends BasePresenter<Interactor, View> {
        public abstract void register(String userName, String code, String password,
                                      String passwordAgain);

        public abstract void sendCode(String phone);

        @Override
        public void onStart() {

        }
    }
}
