package com.toin.glp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import com.toin.glp.base.utils.UserCache;
import com.toin.glp.ui.LoginActivity;
import com.toin.glp.ui.account.AccountDetailActivity;
import com.toin.glp.ui.account.RepaymentPlanActivity;
import com.toin.glp.ui.home.BusinessIntroductionActivity;
import com.toin.glp.ui.mine.EditActivity;

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
        App.logout();
        UserCache.getInstance().clearUser();
        UserCache.saveToken(context, "");
        Intent intent = new Intent(context, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.putExtra(LoginActivity.PAGETYPE, LoginActivity.TYPE_LOGOUT);
        context.startActivity(intent);
    }

    /**
     * 检查登陆状态
     *
     * @param activity
     * @return
     */
    public static boolean checkLogin(Activity activity) {
        if (TextUtils.isEmpty(App.token)) {
            Navigation.logout(activity);
            return false;
        } else {
            return true;
        }
    }

    /**
     * 跳转到账单详情
     *
     * @param activity
     * @param id
     */
    public static void goAccountDetailPage(Activity activity, String id) {
        Intent intent = new Intent(activity, AccountDetailActivity.class);
        intent.putExtra(AccountDetailActivity.EXTRA_ID, id);
        activity.startActivity(intent);
    }

    public static void goRepayPlanPage(Activity activity, String id) {
        Intent intent = new Intent(activity, RepaymentPlanActivity.class);
        intent.putExtra(AccountDetailActivity.EXTRA_ID, id);
        activity.startActivity(intent);
    }

    /**
     * 跳转到编辑页面
     *
     * @param activity
     * @param name
     * @param requestCodePageName
     * @param pageTypeName
     */
    public static void goEditPage(Activity activity, String name, int requestCodePageName,
                                  String pageTypeName) {
        Intent intent = new Intent(activity, EditActivity.class);
        intent.putExtra(EditActivity.EXTRA_CONTENT, name);
        intent.putExtra(EditActivity.EXTRA_PAGE_TYPE, pageTypeName);
        activity.startActivityForResult(intent, requestCodePageName);
    }

    /**
     * 业务介绍页面
     *
     * @param activity
     * @param pageType
     */
    public static void goBusinessIntroPage(Activity activity, String pageType) {
        Intent intent = new Intent(activity, BusinessIntroductionActivity.class);
        intent.putExtra(BusinessIntroductionActivity.PAGETYPE, pageType);
        activity.startActivity(intent);
    }

    /**
     * 跳转到登录页
     *
     * @param activity
     */
    public static void goLoginPage(Activity activity) {
        Intent intent = new Intent(activity, LoginActivity.class);
        intent.putExtra(LoginActivity.PAGETYPE, LoginActivity.TYPE_LOGIN);
        activity.startActivity(intent);
    }
}
