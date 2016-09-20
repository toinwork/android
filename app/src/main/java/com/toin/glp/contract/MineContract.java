package com.toin.glp.contract;

import com.toin.glp.api.BaseApiFinishListener;
import com.toin.glp.base.BaseInterator;
import com.toin.glp.base.BasePresenter;
import com.toin.glp.base.BaseView;
import com.toin.glp.models.UserInfoModel;

import rx.Subscription;

/**
 * 忘记密码 Created by hb on 16/6/17.
 */
public interface MineContract {
    interface Interactor extends BaseInterator {

        interface OnGetMineInfoSuccessListener extends BaseApiFinishListener {
            void getUesrInfoSuccess(UserInfoModel model);
        }

        /**
         * 获取个人信息
         * 
         * @return
         */
        Subscription getUserInfo(OnGetMineInfoSuccessListener listener);

    }

    interface View extends BaseView {

        void setUserInfo(UserInfoModel model);

    }

    abstract class Presenter extends BasePresenter<Interactor, View> {
        public abstract void getUserInfo();

        @Override
        public void onStart() {

        }
    }
}
