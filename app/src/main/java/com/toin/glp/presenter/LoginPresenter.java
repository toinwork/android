package com.toin.glp.presenter;

import com.toin.glp.StringUtils;
import com.toin.glp.api.ApiFactory;
import com.toin.glp.api.BaseSubscriber;
import com.toin.glp.base.utils.T;
import com.toin.glp.base.utils.UserCache;
import com.toin.glp.contract.LoginContract;
import com.toin.glp.models.UserModel;

import java.util.Map;

/**
 * 登录 Created by hb on 16/4/6.
 */
public class LoginPresenter extends LoginContract.Presenter {

    @Override
    public void login(String userName, String password) {
        showProgress(StringUtils.API_LOGIN);
        Map<String, Object> params = ApiFactory.get_base_map();
        params.put("service", "login_member");
        params.put("partner_id", "188888888");
        params.put("login_pwd", password);
        params.put("mobile", userName);
        mRxManage.add(mInterator.login(params).subscribe(new BaseSubscriber<UserModel>() {
            @Override
            public void onCompleted() {
                hideProgress();
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                hideProgress();
            }

            @Override
            public void get_model(UserModel userModel) {
                if (userModel.is_success.equals("T")) {
                    T.showShort(StringUtils.LOGIN_SUCCESS);
                    UserCache.getInstance().saveUserInfo(userModel);
                    loginSuccess();
                } else {
                    T.showShort("用户名或密码错误");
                }
            }
        }));
    }

    @Override
    public void getAccount() {
        if (mView != null) {
            mView.setAccountInfo(mInterator.getAccount());
        }
    }

    public void loginSuccess() {
        if (mView != null) {
            mView.hideProgress();
            mView.navigateToHome();
            mView.finishActivity();
        }
    }
}
