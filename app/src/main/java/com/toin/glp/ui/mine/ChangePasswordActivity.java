package com.toin.glp.ui.mine;

import android.view.View;

import com.toin.glp.R;
import com.toin.glp.StringUtils;
import com.toin.glp.base.BaseActivity;

/**
 * 修改密码
 * Created by hb on 16/6/26.
 */
public class ChangePasswordActivity extends BaseActivity implements View.OnClickListener {
    @Override
    protected int initLayout() {
        return R.layout.activity_change_password;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        setActionTitle(StringUtils.TITLE_CHANGE_PWD);
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
