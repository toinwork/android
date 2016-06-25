package com.toin.work.ui;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;

import com.toin.work.Navigation;
import com.toin.work.R;
import com.toin.work.base.BaseActivity;
import com.toin.work.base.utils.DensityUtil;
import com.toin.work.base.utils.T;
import com.toin.work.ui.workplace.WorkPlaceActivity;
import com.toin.work.widget.xcSlideView.XCSlideView;

import java.util.Date;

/**
 * Created by hb on 16/4/6.
 */
public class MainActivity extends BaseActivity implements View.OnClickListener {

    private long        mLastBackTime = 0;
    private long        TIME_DIFF     = 2 * 1000;
    private XCSlideView leftSlideView;

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        setOnClick(R.id.btn_back);
        View mineView = LayoutInflater.from(this).inflate(R.layout.activity_mine, null);
        leftSlideView = XCSlideView.create(this, XCSlideView.Positon.LEFT);
        leftSlideView.setMenuView(this, mineView);
        leftSlideView.setMenuWidth(DensityUtil.getScreenWidthAndHeight(this)[0] * 7 / 9);
        leftSlideView.findViewById(R.id.tv_workplace).setOnClickListener(v -> Navigation.goPage(MainActivity.this,WorkPlaceActivity.class));
    }

    @Override
    protected void initData() {

    }

    @Override
    public void initPresenter() {

    }

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
