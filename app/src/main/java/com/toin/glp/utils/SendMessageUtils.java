package com.toin.glp.utils;

import com.toin.glp.api.ApiFactory;
import com.toin.glp.api.ApiName;
import com.toin.glp.base.utils.helper.RxSchedulers;
import com.toin.glp.models.BaseResult;

import java.util.Map;

import rx.Observable;

/**
 * 发送短信管理类 Created by hb on 16/9/16.
 */
public class SendMessageUtils {

    //忘记密码
    public static final String REFI_LOGIN_SMS  = "REFI_LOGIN_SMS";
    //注册
    public static final String REGISTER_MOBILE = "REGISTER_MOBILE";
    public static final String ANONYMOUS       = "anonymous";

    public static Observable<BaseResult> sendMessage(String phone, String token, String type) {
        Map<String, Object> params = ApiFactory.get_base_map();
        params.put("service", ApiName.SEND_MESSAGE);
        params.put("partner_id", "188888888");
        params.put("token", token);
        params.put("mobile", phone);
        params.put("template", type);
        return ApiFactory.weijinApi.sendMsg(params).map(baseResult -> baseResult)
                .compose(new RxSchedulers().io_main());
    }
}
