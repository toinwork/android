package com.toin.glp.ui;

import android.os.Handler;

import com.toin.glp.base.BaseActivity;
import com.toin.glp.Navigation;
import com.toin.glp.R;

/**
 * Created by hb on 16/4/14.
 */
public class SplashActivity extends BaseActivity {
    @Override
    protected int initLayout() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //                if (Navigation.checkLogin(SplashActivity.this)) {
                //主页
                Navigation.goPage(SplashActivity.this, MainActivity.class);
                //                }
                finish();
            }
        }, 1500);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void initPresenter() {

    }
}
