package com.toin.work.ui;

import android.view.View;
import android.widget.EditText;

import com.toin.work.Navigation;
import com.toin.work.R;
import com.toin.work.StringUtils;
import com.toin.work.base.BaseActivity;
import com.toin.work.contract.DomainContract;
import com.toin.work.interactor.DomainInteractor;
import com.toin.work.presenter.DomainPresenter;

import butterknife.Bind;

/**
 * 设置域名 Created by hb on 16/6/25.
 */
public class DomainNameActivity extends BaseActivity<DomainPresenter, DomainInteractor> implements
        View.OnClickListener, DomainContract.View {
    @Bind(R.id.et_domain)
    EditText domainEt;

    @Override
    protected int initLayout() {
        return R.layout.activity_domain_name;
    }

    @Override
    protected void initView() {
        setActionTitle(StringUtils.TITLE_DOMAIN);
        setOnClick(R.id.btn_sure);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mInterator);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_sure:
                String domain = domainEt.getText().toString().trim();
                mPresenter.setDomain(domain);
                break;
        }
    }

    @Override
    public void navegiteToLogin() {
        Navigation.goPage(this, LoginActivity.class);
        finish();
    }
}
