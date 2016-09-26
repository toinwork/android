package com.toin.glp.ui;

import android.view.View;
import android.widget.TextView;

import com.toin.glp.R;
import com.toin.glp.StringUtils;
import com.toin.glp.base.BaseActivity;

import butterknife.Bind;

/**
 * 用户协议 Created by hb on 16/9/26.
 */
public class UserAgreementActivity extends BaseActivity implements View.OnClickListener {

    @Bind(R.id.tv_content)
    TextView contentTv;

    @Override
    protected int initLayout() {
        return R.layout.activity_user_agreement;
    }

    @Override
    protected void initView() {
        setOnClick(R.id.btn_back);
    }

    @Override
    protected void initData() {
        setActionTitle(StringUtils.TITLE_USER_AGREEMENT);
        contentTv.setText(StringUtils.CONTENT_USER_AGREEMENT);
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
