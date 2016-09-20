package com.toin.glp.api;

import com.squareup.okhttp.RequestBody;
import com.toin.glp.models.BaseResult;
import com.toin.glp.models.UserInfoModel;
import com.toin.glp.models.UserModel;
import com.toin.glp.models.account.AccountsDetailModel;
import com.toin.glp.models.account.AccountsModel;
import com.toin.glp.models.account.MessageListModel;
import com.toin.glp.models.account.RepayPlanModel;
import com.toin.glp.models.account.SetMessageModel;

import java.util.Map;

import retrofit.http.Body;
import retrofit.http.FieldMap;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;
import rx.Observable;

/**
 * Created by hb on 16/3/8.
 */
public interface BaseApi {

    /**
     * 发送短信
     *
     * @param params
     * @return
     */
    @FormUrlEncoded
    @POST("member.do")
    Observable<BaseResult> sendMsg(@FieldMap Map<String, Object> params);

    /**
     * 验证短信
     *
     * @param params
     * @return
     */
    @FormUrlEncoded
    @POST("member.do")
    Observable<BaseResult> checkMsg(@FieldMap Map<String, Object> params);

    /**
     * 忘记密码
     *
     * @param params
     * @return
     */
    @FormUrlEncoded
    @POST("member.do")
    Observable<BaseResult> setLoginpwd(@FieldMap Map<String, Object> params);

    /**
     * 登陆
     *
     * @param params
     * @return
     */
    @FormUrlEncoded
    @POST("member.do")
    Observable<UserModel> login(@FieldMap Map<String, Object> params);

    /**
     * 获取企业用户信息
     *
     * @param params
     * @return
     */
    @FormUrlEncoded
    @POST("member.do")
    Observable<UserInfoModel> getUserInfo(@FieldMap Map<String, Object> params);

    /**
     * 修改企业用户信息
     *
     * @param params
     * @return
     */
    @FormUrlEncoded
    @POST("member.do")
    Observable<BaseResult> modifyUserInfo(@FieldMap Map<String, Object> params);

    /**
     * 修改密码
     *
     * @param params
     * @return
     */
    @FormUrlEncoded
    @POST("member.do")
    Observable<BaseResult> modifyPassword(@FieldMap Map<String, Object> params);

    /**
     * 反馈
     *
     * @param params
     * @return
     */
    @FormUrlEncoded
    @POST("member.do")
    Observable<BaseResult> feedback(@FieldMap Map<String, Object> params);

    /********************************* 账单相关接口 ********************************/

    /**
     * 账单列表
     *
     * @param requestBody
     * @return
     */
    @POST("service.do")
    Observable<AccountsModel> getAccountList(@Body RequestBody requestBody);

    /**
     * 账单详情
     *
     * @param requestBody
     * @return
     */
    @POST("service.do")
    Observable<AccountsDetailModel> getAccountDetail(@Body RequestBody requestBody);

    /**
     * 还款计划
     *
     * @param requestBody
     * @return
     */
    @POST("service.do")
    Observable<RepayPlanModel> getRepayPlan(@Body RequestBody requestBody);

    /**
     * 获取消息列表
     *
     * @param requestBody
     * @return
     */
    @POST("service.do")
    Observable<MessageListModel> getMessageList(@Body RequestBody requestBody);

    /**
     * 设置消息为已读
     * 
     * @param requestBody
     * @return
     */
    @POST("service.do")
    Observable<SetMessageModel> setMessageRead(@Body RequestBody requestBody);
}
