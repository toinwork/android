package com.toin.glp.api;

import com.alibaba.fastjson.JSONObject;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.RequestBody;
import com.toin.glp.App;
import com.toin.glp.Config;
import com.toin.glp.utils.SystemUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hb on 16/9/12.
 */
public class ApiFactory {
    public GlpWeiJinFactory    weiJinFactory    = null;
    public GlpFinancingFactory financingFactory = null;

    public GlpFinancingFactory get_financing() {
        if (financingFactory == null) {
            financingFactory = new GlpFinancingFactory();
        }
        return financingFactory;
    }

    public GlpWeiJinFactory get_weijin() {
        if (weiJinFactory == null) {
            weiJinFactory = new GlpWeiJinFactory();
        }
        return weiJinFactory;
    }

    public static Map<String, Object> get_base_map() {
        Map<String, Object> params = new HashMap<>();
        params.put("_input_charset", "UTF-8");
        params.put("version", Config.VERSION);
        params.put("access_channel", "WAP");
        params.put("device_id", SystemUtils.getDeviceId(App.context));
        return params;
    }

    public static RequestBody get_request(Map<String, Object> params) {
        params.put("tranChl", "phone");
//                params.put("MOBILE",App.phone);
        params.put("MOBILE", "18605914471");
        String json = JSONObject.toJSONString(params).toString();
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"),
                json);
        return body;
    }
}
