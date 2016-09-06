package com.toin.glp.base.utils;

import android.app.Application;

import com.toin.glp.models.UserModel;

/**
 * Created by hb on 16/4/14.
 */
public class UserCache {

    public static final String ACCOUNT = "account"; // 账号
    public static final String TOKEN = "token";  //token
    public static final String MOBILE = "mobile";
    public static final String UNAME = "uname";
    private static volatile UserCache instance;
    private Application appContext;
    private UserModel userModel;

    public UserCache() {

    }

    public static UserCache getInstance() {
        if (instance == null) {
            synchronized (UserCache.class) {
                if (instance == null) {
                    instance = new UserCache();
                }
            }
        }
        return instance;
    }

    public void setAppContext(Application appContext) {
        this.appContext = appContext;
    }

    /**
     * 保存用户信息
     *
     * @param userModel
     */
    public void saveUserInfo(UserModel userModel) {
        if (userModel == null) {
            return;
        }
        this.userModel = userModel;
        SharedPreferencesUtil.saveIntValue(appContext, ACCOUNT, userModel.getAccount());
        SharedPreferencesUtil.saveStringValue(appContext, TOKEN, userModel.getToken());
        SharedPreferencesUtil.saveStringValue(appContext, MOBILE, userModel.getMobile());
        SharedPreferencesUtil.saveStringValue(appContext, UNAME, userModel.getUname());
    }

    /**
     * 获取用户信息
     *
     * @return
     */
    public UserModel getUser() {
        if (userModel == null) {
            userModel = new UserModel();
            int account = SharedPreferencesUtil.getIntValue(appContext, ACCOUNT);
            String token = SharedPreferencesUtil.getStringValue(appContext, TOKEN);
            String mobile = SharedPreferencesUtil.getStringValue(appContext, MOBILE);
            String uname = SharedPreferencesUtil.getStringValue(appContext, UNAME);
            userModel.setToken(token);
            userModel.setAccount(account);
            userModel.setMobile(mobile);
            userModel.setUname(uname);
        }
        return userModel;
    }

    /**
     * 清空用户信息
     */
    public void clearUser() {
        UserModel user = getUser();
        user.setToken("");
        user.setUname("");
        user.setMobile("");
        saveUserInfo(user);
    }
}
