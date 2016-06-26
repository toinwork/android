package com.toin.work.ui;

import android.view.View;

import com.toin.work.Navigation;
import com.toin.work.R;
import com.toin.work.StringUtils;
import com.toin.work.base.BaseActivity;

/**
 * 设置域名 Created by hb on 16/6/25.
 */
public class DomainNameActivity extends BaseActivity implements View.OnClickListener {
    @Override
    protected int initLayout() {
        return R.layout.activity_domain_name;
    }

    @Override
    protected void initView() {
        setActionTitle(StringUtils.TITLE_DOMAIN);
        setOnClick(R.id.btn_sure);
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
            case R.id.btn_sure:
                Navigation.goPage(this, LoginActivity.class);
                break;
        }
    }
}
