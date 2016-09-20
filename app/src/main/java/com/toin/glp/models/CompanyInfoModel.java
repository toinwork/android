package com.toin.glp.models;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by hb on 16/9/18.
 */
public class CompanyInfoModel {

    public String            responseMessage;
    public String            responseCode;
    public CompanyMemberInfo companyMemberInfo;

    public CompanyInfoModel parse(JSONObject jsonObject) {
        responseMessage = jsonObject.getString("responseMessage");
        responseCode = jsonObject.getString("responseCode");
        JSONObject obj = jsonObject.getJSONObject("companyMemberInfo");
        companyMemberInfo = new CompanyMemberInfo();
        companyMemberInfo.parse(obj);
        return this;
    }
}
