package com.toin.glp.contract;

import com.toin.glp.base.BaseInterator;
import com.toin.glp.base.BasePresenter;
import com.toin.glp.base.BaseView;
import com.toin.glp.models.UserModel;

import java.util.Map;

import rx.Observable;

/**
 * 登录 Created by hb on 16/6/17.
 */
public interface LoginContract {
    interface Interactor extends BaseInterator {

        String getAccount();

        Observable<UserModel> login(Map<String, Object> params);
    }

    interface View extends BaseView {

        void navigateToHome();

        void setAccountInfo(String account);
    }

    abstract class Presenter extends BasePresenter<Interactor, View> {
        public abstract void login(String userName, String password);

        //获取本地缓存的account
        public abstract void getAccount();

        @Override
        public void onStart() {

        }
    }
}
