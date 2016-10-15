package com.toin.glp.ui.mine;

import android.view.View;
import android.widget.TextView;

import com.toin.glp.R;
import com.toin.glp.StringUtils;
import com.toin.glp.base.BaseActivity;

import butterknife.Bind;

/**
 * 关于我们 Created by hb on 16/6/26.
 */
public class AboutUsActivity extends BaseActivity implements View.OnClickListener {

    private String content = "普洛斯金融控股公司成立的意义在于，一方面为了给金融系统自身业务的发展提供增量；另一方面为了更好地促进物流系统的业务发展。除了立足于现有的物流系统业务之上，普洛斯还为供应链上的合作伙伴提供资金结算、资金融通的便利。\n"
                                   + "\n"
                                   + "普洛斯金融控股公司为物流企业在供应链方面提供了融资帮助。这个融资一方面帮助了金融企业本身发展，另一方面又对于物流的业务链产生了促进和支持。\n"
                                   + "\n"
                                   + "普洛斯也会在中新互联互通的业务里把政策用足用好用活。普洛斯金融控股公司，围绕物流的业务链、供应链上的金融服务，围绕贸易公司直接互相业务结算，相信会有一个光明的未来。";

    @Bind(R.id.tv_content)
    TextView       contentTv;
    @Bind(R.id.tv_title)
    TextView       titleTv;

    @Override
    protected int initLayout() {
        return R.layout.activity_about_us;
    }

    @Override
    protected void initView() {
        setOnClick(R.id.btn_back);
    }

    @Override
    protected void initData() {
        setActionTitle(StringUtils.TITLE_ABOUT_US);
        titleTv.setText("关于我们");
        contentTv.setText(content);
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
