package com.toin.glp.ui.mine;

import com.toin.glp.R;
import com.toin.glp.StringUtils;
import com.toin.glp.base.BaseActivity;

/**
 * 企业资料 Created by hb on 16/9/5.
 */
public class CompanyInformationActivity extends BaseActivity {
    @Override
    protected int initLayout() {
        return R.layout.activity_company_information;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        setActionTitle(StringUtils.TITLE_COMPANY_INFO);
    }

    @Override
    public void initPresenter() {

    }
}
