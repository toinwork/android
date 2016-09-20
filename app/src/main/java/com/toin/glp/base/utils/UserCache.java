package com.toin.glp.base.utils;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.toin.glp.models.UserModel;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by hb on 16/4/14.
 */
public class UserCache {
    public static final String        TEMP_FILE = "tempFile"; // 存放密钥的文件
    public static final String        USER_SP   = "user";    // 登录信息
    public static final String        ACCOUNT   = "account"; // 账号
    public static final String        TOKEN     = "token";   //token
    public static final String        MOBILE    = "mobile";
    public static final String        UNAME     = "uname";
    private static volatile UserCache instance;
    private Application               appContext;
    private UserModel                 userModel;

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
        //        SharedPreferencesUtil.saveIntValue(appContext, ACCOUNT, userModel.getAccount());
        //        SharedPreferencesUtil.saveStringValue(appContext, TOKEN, userModel.getToken());
        //        SharedPreferencesUtil.saveStringValue(appContext, MOBILE, userModel.getMobile());
        //        SharedPreferencesUtil.saveStringValue(appContext, UNAME, userModel.getUname());
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
            //            userModel.setToken(token);
            //            userModel.setAccount(account);
            //            userModel.setMobile(mobile);
            //            userModel.setUname(uname);
        }
        return userModel;
    }

    /**
     * 清空用户信息
     */
    public void clearUser() {
        UserModel user = getUser();
        //        user.setToken("");
        //        user.setUname("");
        //        user.setMobile("");
        saveUserInfo(user);
    }

    /**
     * 保存token
     *
     * @param context
     * @param token
     */
    public static void saveToken(Context context, String token) {
        SharedPreferences sp = context.getSharedPreferences(USER_SP, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        String enStr = null;
        OutputStream outStream = null;
        try {
            File innerDir = context.getFilesDir();
            outStream = new FileOutputStream(new File(innerDir, TEMP_FILE), false);
            byte[] rawKey = AesUtil.getRawKey();
            if (rawKey != null) {
                outStream.write(rawKey);
                enStr = AesUtil.encodeClientText(rawKey, token);
                editor.putString(TOKEN, enStr);
            }
        } catch (Exception e) {
        } finally {
            if (outStream != null) {
                try {
                    outStream.close();
                } catch (IOException e) {
                }
            }
        }
        editor.commit();
    }

    /**
     * 获取token
     *
     * @param context
     * @return
     */
    public static String getToken(Context context) {
        SharedPreferences sp = context.getSharedPreferences(USER_SP, Context.MODE_PRIVATE);
        File keyFile = new File(context.getFilesDir(), TEMP_FILE);

        String token = "";
        if (keyFile.exists()) {
            InputStream inStream = null;
            try {
                inStream = new FileInputStream(keyFile);
                ByteArrayOutputStream byteOutStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len = -1;
                while ((len = inStream.read(buffer)) != -1) {
                    byteOutStream.write(buffer, 0, len);
                }
                byte[] rawKey = byteOutStream.toByteArray();
                String str = null;
                str = sp.getString(TOKEN, "");
                if (!"".equals(str)) {
                    token = AesUtil.decodeClientText(rawKey, str);
                }
            } catch (Exception e) {
            } finally {
                if (inStream != null) {
                    try {
                        inStream.close();
                    } catch (IOException e) {
                    }
                }
            }
        } else {
            token = "";
        }

        return token;
    }
}
