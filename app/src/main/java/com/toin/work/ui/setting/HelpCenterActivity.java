package com.toin.work.ui.setting;

import android.view.View;

import com.toin.work.R;
import com.toin.work.StringUtils;
import com.toin.work.base.BaseActivity;

/**
 * Created by hb on 16/6/26.
 */
public class HelpCenterActivity extends BaseActivity implements View.OnClickListener {
    @Override
    protected int initLayout() {
        return R.layout.activity_help_center;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        setActionTitle(StringUtils.TITLE_HELP_CENTER);
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
