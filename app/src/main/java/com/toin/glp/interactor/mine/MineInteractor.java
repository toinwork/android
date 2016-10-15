package com.toin.glp.interactor.mine;

import com.toin.glp.api.ApiFactory;
import com.toin.glp.base.utils.helper.RxSchedulers;
import com.toin.glp.contract.mine.MineContract;
import com.toin.glp.models.UserInfoModel;

import java.util.Map;

import rx.Observable;

/**
 * 我的 Created by hb on 16/10/14.
 */
public class MineInteractor implements MineContract.Interactor {

    /**
     * 获取用户资料
     * 
     * @param params
     * @return
     */
    @Override
    public Observable<UserInfoModel> getUserInfo(Map<String, Object> params) {
        return ApiFactory.weijinApi.getUserInfo(params).compose(new RxSchedulers().io_main());
    }
}
