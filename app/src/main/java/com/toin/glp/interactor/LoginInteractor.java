package com.toin.glp.interactor;

import android.text.TextUtils;

import com.toin.glp.App;
import com.toin.glp.api.ApiFactory;
import com.toin.glp.base.utils.SharedPreferencesUtil;
import com.toin.glp.base.utils.helper.RxSchedulers;
import com.toin.glp.contract.LoginContract;
import com.toin.glp.models.UserModel;

import java.util.Map;

import rx.Observable;

/**
 * 登录 Created by hb on 16/4/6.
 */
public class LoginInteractor implements LoginContract.Interactor {

    @Override
    public String getAccount() {
        String account = SharedPreferencesUtil.getStringValue(App.context, "phone");
        if (!TextUtils.isEmpty(account)) {
            return account;
        }
        return "";
    }

    @Override
    public Observable<UserModel> login(Map<String, Object> params) {
        return ApiFactory.weijin().login(params).map(userModel -> userModel)
                .compose(RxSchedulers.io_main());
    }
}
