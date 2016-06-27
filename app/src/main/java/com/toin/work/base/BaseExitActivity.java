package com.toin.work.base;

import android.view.KeyEvent;
import android.view.View;

import com.toin.work.R;
import com.toin.work.base.utils.T;

import java.util.Date;

/**
 * Created by hb on 16/6/25.
 */
public abstract class BaseExitActivity extends BaseActivity implements View.OnClickListener {

    private long        mLastBackTime = 0;
    private long        TIME_DIFF     = 2 * 1000;
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_back:
                if (!leftSlideView.isShow()) {
                    leftSlideView.show();
                }
                break;
        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (!leftSlideView.isShow()) {
                long now = new Date().getTime();
                if (now - mLastBackTime < TIME_DIFF) {
                    return super.onKeyDown(keyCode, event);
                } else {
                    mLastBackTime = now;
                    T.showShort("再按一次返回键退出");
                }
                return true;
            } else {
                leftSlideView.dismiss();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
