package com.toin.glp.api;

/**
 * Created by hb on 16/3/9.
 */
public class ApiName {
    //维金相关
    //验证短信
    public static final String VERIFY_MESSAGE              = "verify_msg";
    //发送短信
    public static final String SEND_MESSAGE                = "send_msg";
    //忘记密码
    public static final String SET_LOGIN_PWD               = "set_loginpwd";
    //查询企业用户信息
    public static final String QUERY_ENTERPRISE            = "query_enterprise";
    //会员反馈
    public static final String MEMBER_FEEDBACK             = "member_feedback";
    //重置密码
    public static final String MODIFY_LOGINPWD             = "modify_loginpwd";
    //修改企业用户信息
    public static final String UPDATE_ENTERPRISE_USER_DATA = "update_enterprise_user_data";
    //注册
    public static final String CREATE_ENTERPRISE_MEMBER    = "create_enterprise_member";
    //账单相关

    //账单列表
    public static final String QUERY_LOAN_LIST             = "queryLoanList";
    //账单详情
    public static final String QUERY_PUTOUT_APPLY_DETAIL   = "queryPutoutApplyDetail";
    //还款计划
    public static final String REPAY_PLAN                  = "repayPlan";
    //获取消息
    public static final String BUSINESS_NOTIFICATION       = "businessNotification";
    //消息设置为已读
    public static final String CHANGE_INFO_STATUS          = "changeInfoStatus";

}
