package com.toin.glp.utils;

import com.toin.glp.api.ApiFactory;
import com.toin.glp.api.ApiName;
import com.toin.glp.base.utils.T;
import com.toin.glp.models.BaseResult;

import java.util.Map;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 发送短信管理类 Created by hb on 16/9/16.
 */
public class SendMessageUtils {

    //忘记密码
    public static final String REFI_LOGIN_SMS = "REFI_LOGIN_SMS";
    //注册
    public static final String REGISTER_MOBILE = "REGISTER_MOBILE";
    public static final String ANONYMOUS      = "anonymous";

    public static Subscription sendMessage(String phone, String token, String type,
                                           OnSendMessageFinishedListener listener) {
        Map<String, Object> params = ApiFactory.get_base_map();
        params.put("service", ApiName.SEND_MESSAGE);
        params.put("partner_id", "188888888");
        params.put("token", token);
        params.put("mobile", phone);
        params.put("template", type);
        ApiFactory factory = new ApiFactory();
        return factory.get_weijin().getBaseApiSingleton().sendMsg(params)
                .map(baseResult -> baseResult).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
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
                            T.showShort("发送成功");
                            listener.onSendSuccess();
                        } else {
                            T.showShort(baseResult.error_message);
                            listener.onSendError();
                        }
                    }
                });
    }
}
