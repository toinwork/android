package com.toin.glp.contract.mine;

import com.toin.glp.base.BaseInterator;
import com.toin.glp.base.BasePresenter;
import com.toin.glp.base.BaseView;
import com.toin.glp.models.BaseResult;
import com.toin.glp.models.UserInfoModel;

import java.util.Map;

import rx.Observable;

/**
 * 企业资料 Created by hb on 16/10/14.
 */
public interface CompanyInformationContract {
    interface Interactor extends BaseInterator {
        /**
         * 获取用户信息
         *
         * @param params
         * @return
         */
        Observable<UserInfoModel> getUserInfo(Map<String, Object> params);

        /**
         * 修改用户信息
         * 
         * @param params
         * @return
         */
        Observable<BaseResult> modifyUserInfo(Map<String, Object> params);
    }

    interface View extends BaseView {

        void setInfo(String model);

        void setCompanyInfo();
    }

    abstract class Presenter extends BasePresenter<Interactor, View> {
        public abstract void getUserInfo(Map<String, Object> params);

        public abstract void modifyUserInfo(Map<String, Object> params);

        @Override
        public void onStart() {

        }
    }
}
