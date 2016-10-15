package com.toin.glp.ui.home;

import android.view.View;
import android.widget.TextView;

import com.toin.glp.R;
import com.toin.glp.base.BaseActivity;

import butterknife.Bind;

/**
 * 业务介绍 Created by hb on 16/9/13.
 */
public class BusinessIntroductionActivity extends BaseActivity implements View.OnClickListener {
    public static final String PAGETYPE = "pagetype";
    public static final String PAGE_A   = "a";
    public static final String PAGE_B   = "b";
    public static final String PAGE_C   = "c";
    private String             pageType;
    @Bind(R.id.tv_content)
    TextView                   contentTv;
    @Bind(R.id.tv_title)
    TextView                   titleTv;

    @Override
    protected int initLayout() {
        return R.layout.activity_business_introduction;
    }

    @Override
    protected void initView() {
        setOnClick(R.id.btn_back);
    }

    @Override
    protected void initData() {
        pageType = getIntent().getStringExtra(PAGETYPE);
        String TITLE = "";
        String CONTENT = "";
        if (pageType.equals(PAGE_A)) {
            TITLE = "融资租赁";
            CONTENT = "GLP致力于为客户提供一站式仓储、设备、资金综合解决方案。通过融资租赁为客户提供制冷系统、自动分拣线、叉车、货架、托盘等设备融资，协助企业专注于发展其核心业务，提高企业综合效益。";
        } else if (pageType.equals(PAGE_B)) {
            TITLE = "保理服务";
            CONTENT = "GLP着眼于构建物流生态金融服务体系，依托仓储设施，深入挖掘物流行业资金需求特性，设计多种保理产品，满足企业个性化需求，提高中小微企业运营效率，实现跨越发展。";

        } else if (pageType.equals(PAGE_C)) {
            TITLE = "供应链金融";
            CONTENT = "GLP创立了食品供应链金融模式，通过国内外采购融资，现货质押贷款，下游企业保理等产品，为客户提供全链条金融服务。运用现有科技，实现全程可视化查看、管理，跟踪货物流及资金流，提升企业管理效率。";
        }
        titleTv.setText(TITLE);
        contentTv.setText(" \u3000\u3000" + CONTENT);
        setActionTitle(TITLE);
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
