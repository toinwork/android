package com.toin.glp.ui.mine;

import android.view.View;

import com.toin.glp.R;
import com.toin.glp.StringUtils;
import com.toin.glp.base.BaseActivity;

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
