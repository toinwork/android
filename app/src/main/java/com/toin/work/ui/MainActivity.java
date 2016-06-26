package com.toin.work.ui;

import android.view.KeyEvent;

import com.toin.work.R;
import com.toin.work.base.BaseExitActivity;
import com.toin.work.base.utils.T;

import java.util.Date;

/**
 * Created by hb on 16/4/6.
 */
public class MainActivity extends BaseExitActivity {

    private long        mLastBackTime = 0;
    private long        TIME_DIFF     = 2 * 1000;


    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void initPresenter() {

    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            long now = new Date().getTime();
            if (now - mLastBackTime < TIME_DIFF) {
                return super.onKeyDown(keyCode, event);
            } else {
                mLastBackTime = now;
                T.showShort("再按一次返回键退出");
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
