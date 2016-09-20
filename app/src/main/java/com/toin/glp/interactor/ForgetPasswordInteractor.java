package com.toin.glp.interactor;

import android.text.TextUtils;

import com.toin.glp.App;
import com.toin.glp.R;
import com.toin.glp.StringUtils;
import com.toin.glp.api.ApiFactory;
import com.toin.glp.api.ApiName;
import com.toin.glp.base.utils.PatternUtils;
import com.toin.glp.base.utils.SHA256;
import com.toin.glp.base.utils.T;
import com.toin.glp.contract.ForgetPasswordContract;
import com.toin.glp.models.BaseResult;
import com.toin.glp.utils.OnSendMessageFinishedListener;
import com.toin.glp.utils.SendMessageUtils;

import java.util.Map;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * 忘记密码 Created by hb on 16/6/26.
 */
public class ForgetPasswordInteractor implements ForgetPasswordContract.Interactor {

    /**
     * 重置密码
     * 
     * @param mobile
     * @param code
     * @param password
     * @param passwordAgain
     * @param listener
     * @return
     */
    @Override
    public Subscription setLoginPwd(String mobile, String code, String password,
                                    String passwordAgain, OnSetPasswordFinishedListener listener) {
        if (!PatternUtils.isPhoneNum(mobile)) {
            T.showLong(App.context.getString(R.string.mobile_illegal));
            return null;
        }
        if (TextUtils.isEmpty(code)) {
            T.showLong(App.context.getString(R.string.check_code_cannot_be_empty));
            return null;
        }
        if (TextUtils.isEmpty(password)) {
            T.showLong(App.context.getString(R.string.password_null));
            return null;
        }
        if (password.length() < 6 || password.length() > 16) {
            T.showLong(App.context.getString(R.string.password_length_illegal));
            return null;
        }
        if (!password.equals(passwordAgain)) {
            T.showLong(App.context.getString(R.string.password_is_not_equels_old_password));
            return null;
        }
        Map<String, Object> params = ApiFactory.get_base_map();
        params.put("service", ApiName.SET_LOGIN_PWD);
        params.put("partner_id", "188888888");
        params.put("token", "anonymous");
        params.put("identity_no", mobile);
        params.put("identity_type", "MOBILE");
        params.put("login_pwd", SHA256.encryptPassword(password, "SHA-256"));
        params.put("msg_code", code);
        ApiFactory factory = new ApiFactory();
        return factory.get_weijin().getBaseApiSingleton().setLoginpwd(params)
                .map(new Func1<BaseResult, BaseResult>() {
                    @Override
                    public BaseResult call(BaseResult baseResult) {
                        return baseResult;
                    }
                }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<BaseResult>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(BaseResult baseResult) {
                        if (baseResult.is_success.equals("T")) {
                            T.showShort(StringUtils.API_RESET_SUCCESS);
                            listener.onSuccess();
                        } else {
                            T.showShort(baseResult.error_message);
                            listener.onError();
                        }
                    }
                });
    }

    /**
     * 验证短信
     * 
     * @param phone
     * @param code
     * @param password
     * @param passwordAgain
     * @param listener
     * @return
     */
    @Override
    public Subscription checkCode(String phone, String code, String password, String passwordAgain,
                                  OnSetPasswordFinishedListener listener) {
        if (TextUtils.isEmpty(phone)) {
            T.showLong(App.context.getString(R.string.phone_number_null));
            return null;
        }
        if (!PatternUtils.isPhoneNum(phone)) {
            T.showLong(App.context.getString(R.string.mobile_illegal));
            return null;
        }
        if (TextUtils.isEmpty(code)) {
            T.showLong(App.context.getString(R.string.check_code_cannot_be_empty));
            return null;
        }
        if (TextUtils.isEmpty(password)) {
            T.showLong(App.context.getString(R.string.password_null));
            return null;
        }
        if (password.length() < 6 || password.length() > 16) {
            T.showLong(App.context.getString(R.string.password_length_illegal));
            return null;
        }
        if (!password.equals(passwordAgain)) {
            T.showLong(App.context.getString(R.string.password_is_not_equels_old_password));
            return null;
        }
        Map<String, Object> params = ApiFactory.get_base_map();
        params.put("service", ApiName.VERIFY_MESSAGE);
        params.put("partner_id", "188888888");
        params.put("token", "anonymous");
        params.put("mobile", phone);
        params.put("template", SendMessageUtils.REFI_LOGIN_SMS);
        params.put("msg_code", code);
        ApiFactory factory = new ApiFactory();
        //先验证短信
        return factory.get_weijin().getBaseApiSingleton().checkMsg(params)
                .map(new Func1<BaseResult, BaseResult>() {
                    @Override
                    public BaseResult call(BaseResult baseResult) {
                        return baseResult;
                    }
                }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<BaseResult>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(BaseResult flagModel) {
                        if (flagModel.is_success.equals("T")) {
                            listener.checkCodeSuccess(phone, code, password, passwordAgain);
                        } else {
                            T.showShort(flagModel.error_message);
                            listener.onError();
                        }
                    }
                });
    }

    @Override
    public Subscription sendCode(String phone, OnSendMessageFinishedListener listener) {
        if (TextUtils.isEmpty(phone)) {
            T.showLong(App.context.getString(R.string.phone_number_null));
            return null;
        }
        if (!PatternUtils.isPhoneNum(phone)) {
            T.showLong(App.context.getString(R.string.mobile_illegal));
            return null;
        }
        return SendMessageUtils.sendMessage(phone, SendMessageUtils.ANONYMOUS,
                SendMessageUtils.REFI_LOGIN_SMS, listener);
    }
}
