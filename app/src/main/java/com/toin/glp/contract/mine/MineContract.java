package com.toin.glp.contract.mine;

import com.toin.glp.base.BaseInterator;
import com.toin.glp.base.BasePresenter;
import com.toin.glp.base.BaseView;
import com.toin.glp.models.UserInfoModel;

import java.util.Map;

import rx.Observable;

/**
 * 我的
 * Created by hb on 16/10/14.
 */
public interface MineContract {
    interface Interactor extends BaseInterator {
        /**
         * 获取用户信息
         * 
         * @param params
         * @return
         */
        Observable<UserInfoModel> getUserInfo(Map<String, Object> params);
    }

    interface View extends BaseView {

        void setUserInfo(UserInfoModel model);
    }

    abstract class Presenter extends BasePresenter<Interactor, View> {
        public abstract void getUserInfo(Map<String, Object> params);

        @Override
        public void onStart() {

        }
    }
}
