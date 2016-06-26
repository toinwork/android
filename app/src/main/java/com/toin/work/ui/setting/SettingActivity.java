package com.toin.work.ui.setting;

import android.view.View;

import com.toin.work.Navigation;
import com.toin.work.R;
import com.toin.work.StringUtils;
import com.toin.work.base.BaseActivity;

/**
 * 设置 Created by hb on 16/6/26.
 */
public class SettingActivity extends BaseActivity implements View.OnClickListener {
    @Override
    protected int initLayout() {
        return R.layout.activity_setting;
    }

    @Override
    protected void initView() {
        setOnClick(R.id.rl_header, R.id.btn_back, R.id.rl_feedback, R.id.rl_change_pwd,
                R.id.rl_help_center, R.id.rl_about_us);
    }

    @Override
    protected void initData() {
        setActionTitle(StringUtils.TITLE_SETTING);
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_header:
                Navigation.goPage(this, MineInfoActivity.class);
                break;
            case R.id.rl_change_pwd://修改密码
                Navigation.goPage(this, ChangePasswordActivity.class);
                break;
            case R.id.rl_feedback://反馈我们
                Navigation.goPage(this, FeedbackActivity.class);
                break;
            case R.id.rl_help_center://帮助中心
                Navigation.goPage(this, HelpCenterActivity.class);
                break;
            case R.id.rl_about_us://关于我们
                Navigation.goPage(this, AboutUsActivity.class);
                break;
            case R.id.btn_back:
                finish();
                break;
        }
    }
}
