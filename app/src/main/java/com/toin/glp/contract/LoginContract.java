package com.toin.glp.contract;

import com.toin.glp.api.BaseApiFinishListener;
import com.toin.glp.base.BaseInterator;
import com.toin.glp.base.BasePresenter;
import com.toin.glp.base.BaseView;

import rx.Subscription;

/**
 * Created by hb on 16/6/17.
 */
public interface LoginContract {
    interface Interactor extends BaseInterator{

        interface OnLoginFinishedListener extends BaseApiFinishListener{
            void setClickable();

            void setUnClickable();
        }

        void checkLogin(String userName, String password, OnLoginFinishedListener listener);

        int getAccount();

        Subscription login(String userName, String password, OnLoginFinishedListener listener);
    }

    interface View extends BaseView{

        void setClickable();

        void setUnClickable();

        void navigateToHome();

        void setAccountInfo(int account);
    }

    abstract class Presenter extends BasePresenter<Interactor,View>{
        public abstract void login(String userName, String password);

        public abstract void checkLogin(String userName, String password);

        //获取本地缓存的account
        public abstract void getAccount();

        @Override
        public void onStart() {

        }
    }
}
