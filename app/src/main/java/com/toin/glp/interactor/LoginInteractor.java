package com.toin.glp.interactor;

import android.text.TextUtils;

import com.toin.glp.App;
import com.toin.glp.R;
import com.toin.glp.api.ApiFactory;
import com.toin.glp.api.BaseSubscriber;
import com.toin.glp.base.utils.PatternUtils;
import com.toin.glp.base.utils.SharedPreferencesUtil;
import com.toin.glp.base.utils.T;
import com.toin.glp.base.utils.UserCache;
import com.toin.glp.contract.LoginContract;
import com.toin.glp.models.UserModel;

import java.util.Map;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static com.toin.glp.contract.LoginContract.Interactor;

/**
 * 登录 Created by hb on 16/4/6.
 */
public class LoginInteractor implements LoginContract.Interactor {

    @Override
    public void checkLogin(String userName, String password,
                           Interactor.OnLoginFinishedListener listener) {
        boolean error = false;
        if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(password) || password.length() < 6
                || password.length() > 16) {
            listener.setUnClickable();
            error = true;
        }
        if (!error) {
            listener.setClickable();
        }
    }

    @Override
    public String getAccount() {
        String account = SharedPreferencesUtil.getStringValue(App.context, "phone");
        if (!TextUtils.isEmpty(account)) {
            return account;
        }
        return "";
    }

    @Override
    public Subscription login(final String username, final String password,
                              final OnLoginFinishedListener listener) {
        if (!PatternUtils.isPhoneNum(username)) {
            T.showLong(App.context.getString(R.string.mobile_illegal));
            listener.onError();
            return null;
        }
        if (TextUtils.isEmpty(username)) {
            T.showShort("用户名不能为空");
            listener.onError();
            return null;
        }
        if (TextUtils.isEmpty(password)) {
            T.showShort("密码不能为空");
            listener.onError();
            return null;
        }
        if (password.length() < 6 || password.length() > 16) {
            T.showShort("密码长度为6-16位");
            listener.onError();
            return null;
        }
        Map<String, Object> params = ApiFactory.get_base_map();
        params.put("service", "login_member");
        params.put("partner_id", "188888888");
        params.put("login_pwd", password);
        params.put("mobile", username);
        ApiFactory factory = new ApiFactory();
        return factory.get_weijin().getBaseApiSingleton().login(params).map(userModel -> userModel)
                .subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseSubscriber<UserModel>() {
                    @Override
                    public void onCompleted() {
                        listener.onFinish();
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        listener.onError();
                    }

                    @Override
                    public void get_model(UserModel userModel) {
                        if (userModel.is_success.equals("T")) {
                            T.showShort("登录成功");
                            App.token = userModel.getToken();
                            App.phone = userModel.getMobile_star();
                            SharedPreferencesUtil.saveStringValue(App.context, "phone",
                                    userModel.getMobile_star());
                            UserCache.saveToken(App.context, userModel.getToken());
                            listener.onSuccess();
                        } else {
                            T.showShort("用户名或密码错误");
                        }
                    }
                });
    }
}
