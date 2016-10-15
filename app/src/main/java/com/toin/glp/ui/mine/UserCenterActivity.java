package com.toin.glp.ui.mine;

import com.toin.glp.R;
import com.toin.glp.StringUtils;
import com.toin.glp.base.BaseActivity;

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

}
