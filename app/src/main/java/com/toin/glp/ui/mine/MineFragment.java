package com.toin.glp.ui.mine;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.toin.glp.App;
import com.toin.glp.Navigation;
import com.toin.glp.R;
import com.toin.glp.StringUtils;
import com.toin.glp.api.ApiFactory;
import com.toin.glp.api.ApiName;
import com.toin.glp.base.BaseFragment;
import com.toin.glp.base.utils.RxBus.RxBus;
import com.toin.glp.contract.mine.MineContract;
import com.toin.glp.event.CompanyInfoEvent;
import com.toin.glp.interactor.mine.MineInteractor;
import com.toin.glp.models.CompanyInfoModel;
import com.toin.glp.models.UserInfoModel;
import com.toin.glp.presenter.mine.MinePresenter;

import java.util.Map;

import butterknife.Bind;

/**
 * 我的 Created by hb on 16/6/26.
 */
public class MineFragment extends BaseFragment<MinePresenter, MineInteractor> implements
        View.OnClickListener, MineContract.View {

    @Bind(R.id.tv_name)
    TextView     nameTv;
    @Bind(R.id.ll_mine)
    LinearLayout mineLL;
    @Bind(R.id.ll_go_login)
    LinearLayout mLinearLayout;

    @Override
    protected int initLayout() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView() {
        setOnClick(R.id.rl_header, R.id.btn_back, R.id.rl_company, R.id.rl_modify_password,
                R.id.rl_feedback, R.id.rl_about_us, R.id.tv_exit, R.id.tv_login);
        if (TextUtils.isEmpty(App.token)) {
            mineLL.setVisibility(View.GONE);
            mLinearLayout.setVisibility(View.VISIBLE);
        } else {
            mineLL.setVisibility(View.VISIBLE);
            mLinearLayout.setVisibility(View.GONE);
        }
    }

    @Override
    protected void initData() {
        setActionTitle(StringUtils.TAB_TAG_MINE);
        if (!TextUtils.isEmpty(App.token)) {
            Map<String, Object> params = ApiFactory.get_base_map();
            params.put("service", ApiName.QUERY_ENTERPRISE);
            params.put("partner_id", "188888888");
            params.put("token", App.token);
            mPresenter.getUserInfo(params);
        }
        addSubscription(RxBus.getDefault().toObserverable(CompanyInfoEvent.class)
                .subscribe(event -> {
                    nameTv.setText("欢迎您," + event.name);
                }));
    }

    //渲染数据
    private void setInfo(String result) {
        JSONObject obj = JSON.parseObject(result);
        CompanyInfoModel companyInfoModel = new CompanyInfoModel();
        companyInfoModel.parse(obj);

        String content = "欢迎您,";
        String companyName = companyInfoModel.companyMemberInfo.companyName;
        if (!TextUtils.isEmpty(companyName)) {
            content = content + companyName;
        } else {
            if (!TextUtils.isEmpty(App.phone) && App.phone.length() >= 5) {
                String phone = App.phone.substring(0, 3) + "****"
                        + App.phone.substring(App.phone.length() - 4, App.phone.length());
                content = content + phone;
            }
        }
        nameTv.setText(content);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_company://企业资料
                Navigation.goPage(getActivity(), CompanyInformationActivity.class);
                break;
            case R.id.rl_modify_password://修改密码
                Navigation.goPage(getActivity(), ChangePasswordActivity.class);
                break;
            case R.id.rl_feedback://反馈我们
                Navigation.goPage(getActivity(), FeedbackActivity.class);
                break;
            case R.id.rl_about_us://关于我们
                Navigation.goPage(getActivity(), AboutUsActivity.class);
                break;
            case R.id.tv_exit:
                Navigation.logout(getActivity());
                break;
            case R.id.tv_login:
                Navigation.goLoginPage(getActivity());
                break;
        }
    }

    @Override
    public void setUserInfo(UserInfoModel model) {
        setInfo(model.result);
    }
}
