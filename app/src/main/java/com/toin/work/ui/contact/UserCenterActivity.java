package com.toin.work.ui.contact;

import com.toin.work.R;
import com.toin.work.StringUtils;
import com.toin.work.base.BaseActivity;

/**
 * 通讯录——>个人中心 Created by hb on 16/6/26.
 */
public class UserCenterActivity extends BaseActivity {
    @Override
    protected int initLayout() {
        return R.layout.activity_user_center;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        setActionTitle(StringUtils.TITLE_USER_CENTER);
    }

    @Override
    public void initPresenter() {

    }
}
