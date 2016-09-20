package com.toin.glp.ui.mine;

import android.view.View;

import com.toin.glp.R;
import com.toin.glp.StringUtils;
import com.toin.glp.base.BaseActivity;

/**
 * 关于我们 Created by hb on 16/6/26.
 */
public class AboutUsActivity extends BaseActivity implements View.OnClickListener {
    @Override
    protected int initLayout() {
        return R.layout.activity_about_us;
    }

    @Override
    protected void initView() {
        setOnClick(R.id.btn_back);
    }

    @Override
    protected void initData() {
        setActionTitle(StringUtils.TITLE_ABOUT_US);
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_back:
                finish();
                break;
        }
    }
}
