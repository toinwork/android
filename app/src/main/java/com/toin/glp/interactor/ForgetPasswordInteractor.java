package com.toin.glp.interactor;

import com.toin.glp.api.ApiFactory;
import com.toin.glp.base.utils.helper.RxSchedulers;
import com.toin.glp.contract.ForgetPasswordContract;
import com.toin.glp.models.BaseResult;
import com.toin.glp.utils.SendMessageUtils;

import java.util.Map;

import rx.Observable;

/**
 * 忘记密码 Created by hb on 16/6/26.
 */
public class ForgetPasswordInteractor implements ForgetPasswordContract.Interactor {

    /**
     * 重置密码
     *
     * @param params
     * @return
     */
    @Override
    public Observable<BaseResult> setLoginPwd(Map<String, Object> params ) {
        return ApiFactory.weijinApi.setLoginpwd(params).map(baseResult -> baseResult)
                .compose(RxSchedulers.io_main());
    }

    /**
     * 验证短信
     * 
     * @param params
     * @return
     */
    @Override
    public Observable<BaseResult> checkCode(Map<String, Object> params) {
        //先验证短信
        return ApiFactory.weijinApi.checkMsg(params).map(baseResult -> baseResult)
                .compose(RxSchedulers.io_main());
    }

    @Override
    public Observable<BaseResult> sendCode(String phone) {
        return SendMessageUtils.sendMessage(phone, SendMessageUtils.ANONYMOUS,
                SendMessageUtils.REFI_LOGIN_SMS);
    }
}
