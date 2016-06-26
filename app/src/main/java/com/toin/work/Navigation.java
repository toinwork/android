package com.toin.work;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import com.toin.work.base.utils.UserCache;
import com.toin.work.ui.DomainNameActivity;
import com.toin.work.ui.LoginActivity;

/**
 * 负责页面间跳转参数的封装
 */
public class Navigation {

    private Navigation() {

    }

    public static <T> void goPage(Context context, Class<T> cls) {
        Intent intent = new Intent(context, cls);
        context.startActivity(intent);
    }

    public static <T> void goPage4Result(Activity activity, Class<T> cls, int requestCode) {
        Intent intent = new Intent(activity, cls);
        activity.startActivityForResult(intent, requestCode);
    }

    /**
     * 登出
     *
     * @param context
     */
    public static void logout(Context context) {
        //        JPushInterface.clearAllNotifications(context);
        //
        //        UserCache.logout(context);
        //        UserCache.clearUser(context);
        //        UserCache.clearAccount(context);
        //        App.logout();
        //        //停止推送
        //        JPushInterface.stopPush(context);
        //
        App.logout();
        UserCache.getInstance().clearUser();
        Intent intent = new Intent(context, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);

        //  每个接收器都会收到 调动finish（）关闭activity
    }

    /**
     * 检查登陆状态
     * 
     * @param activity
     * @return
     */
    public static boolean checkLogin(Activity activity) {
        if (TextUtils.isEmpty(App.token) || App.account == 0) {
            if (TextUtils.isEmpty(App.domain)) {
                Navigation.goPage(activity, DomainNameActivity.class);
            } else {
                Navigation.logout(activity);
            }
            return false;
        } else {
            return true;
        }
    }

}
