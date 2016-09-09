package com.toin.glp.ui.mine;

import android.view.View;
import android.widget.TextView;

import com.toin.glp.R;
import com.toin.glp.StringUtils;
import com.toin.glp.base.BaseActivity;

import butterknife.Bind;

/**
 * 企业资料 Created by hb on 16/9/5.
 */
public class CompanyInformationActivity extends BaseActivity implements View.OnClickListener {
    @Bind(R.id.tv_name)
    TextView nameTv;
    @Bind(R.id.tv_organize_code)
    TextView organizeCodeTv;
    @Bind(R.id.tv_tax_number)
    TextView taxNumberTv;
    @Bind(R.id.tv_address)
    TextView addressTv;
    @Bind(R.id.tv_corporate)
    TextView corporateTv;
    @Bind(R.id.tv_model)
    TextView modelTv;
    @Bind(R.id.tv_industry)
    TextView industryTv;
    @Bind(R.id.tv_contact)
    TextView contactTv;

    @Override
    protected int initLayout() {
        return R.layout.activity_company_information;
    }

    @Override
    protected void initView() {
        setOnClick(R.id.btn_back);
    }

    @Override
    protected void initData() {
        setActionTitle(StringUtils.TITLE_COMPANY_INFO);
        nameTv.setText("hanbin");
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_back://后退
                finish();
                break;
        }
    }
}
