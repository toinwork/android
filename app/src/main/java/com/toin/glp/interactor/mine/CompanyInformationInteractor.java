package com.toin.glp.interactor.mine;

import com.toin.glp.api.ApiFactory;
import com.toin.glp.base.utils.helper.RxSchedulers;
import com.toin.glp.contract.mine.CompanyInformationContract;
import com.toin.glp.models.BaseResult;
import com.toin.glp.models.UserInfoModel;

import java.util.Map;

import rx.Observable;

/**
 * 企业资料 Created by hb on 16/10/14.
 */
public class CompanyInformationInteractor implements CompanyInformationContract.Interactor {
    /**
     * 获取企业资料
     * 
     * @param params
     * @return
     */
    @Override
    public Observable<UserInfoModel> getUserInfo(Map<String, Object> params) {
        return ApiFactory.weijinApi.getUserInfo(params).compose(new RxSchedulers().io_main());
    }

    /**
     * 修改企业资料
     * 
     * @param params
     * @return
     */
    @Override
    public Observable<BaseResult> modifyUserInfo(Map<String, Object> params) {
        return ApiFactory.weijinApi.modifyUserInfo(params).compose(new RxSchedulers().io_main());
    }
}
