package com.toin.glp.interactor;

import android.text.TextUtils;

import com.toin.glp.App;
import com.toin.glp.api.ApiFactory;
import com.toin.glp.base.utils.MD5;
import com.toin.glp.base.utils.SharedPreferencesUtil;
import com.toin.glp.base.utils.T;
import com.toin.glp.contract.LoginContract;
import com.toin.glp.models.UserModel;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static com.toin.glp.contract.LoginContract.Interactor;

/**
 * Created by hb on 16/4/6.
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
    public int getAccount() {
        int account = SharedPreferencesUtil.getIntValue(App.context, "account");
        if (account > 0) {
            return account;
        }
        return 0;
    }

    @Override
    public Subscription login(final String username, final String password,
                              final OnLoginFinishedListener listener) {
        // Mock login. I'm creating a handler to delay the answer a couple of seconds
        if (username.equals("hanb") && password.equals("111111")) {
            listener.onSuccess();
        }
        Map<String, Object> params = new HashMap<>();
        params.put("email", username);
        params.put("passwd", MD5.toMD5(password).toUpperCase(Locale.CHINA));
        ApiFactory factory = new ApiFactory();
        return factory.get_weijin().getBaseApiSingleton().login(params)
                .map(userModel -> userModel)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<UserModel>() {
                    @Override
                    public void onCompleted() {
                        listener.onFinish();
                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.onError();
                    }

                    @Override
                    public void onNext(UserModel userModel) {
                        T.showShort("登录成功");
                        //                        App.token = userModel.getToken();
                        //                        App.account = userModel.getAccount();
                        //                        UserCache.getInstance().saveUserInfo(userModel);
                        //                        SharedPreferencesUtil.saveIntValue(App.context, "account",
                        //                                userModel.getAccount());
                        listener.onSuccess();
                    }
                });
    }
}
