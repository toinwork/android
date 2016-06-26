package com.toin.work.ui.setting;

import android.view.View;

import com.toin.work.R;
import com.toin.work.StringUtils;
import com.toin.work.base.BaseActivity;

/**
 * 反馈 Created by hb on 16/6/26.
 */
public class FeedbackActivity extends BaseActivity implements View.OnClickListener {
    @Override
    protected int initLayout() {
        return R.layout.activity_feedback;
    }

    @Override
    protected void initView() {
        setOnClick(R.id.btn_back, R.id.btn_commit);
    }

    @Override
    protected void initData() {
        setActionTitle(StringUtils.TITLE_FEEDBACK);
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
            case R.id.btn_commit:
                break;
        }
    }
}
