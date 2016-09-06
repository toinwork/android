package com.toin.glp.ui.mine;

import android.view.View;

import com.toin.glp.R;
import com.toin.glp.StringUtils;
import com.toin.glp.base.BaseActivity;

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
