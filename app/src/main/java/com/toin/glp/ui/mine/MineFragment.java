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
import com.toin.glp.api.BaseSubscriber;
import com.toin.glp.base.BaseFragment;
import com.toin.glp.base.utils.RxBus.RxBus;
import com.toin.glp.base.utils.T;
import com.toin.glp.event.CompanyInfoEvent;
import com.toin.glp.models.CompanyInfoModel;
import com.toin.glp.models.UserInfoModel;

import java.util.Map;

import butterknife.Bind;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 我的 Created by hb on 16/6/26.
 */
public class MineFragment extends BaseFragment implements View.OnClickListener {

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
            httpGetCompanyInfo();
        }

        Subscription rx = RxBus.getDefault().toObserverable(CompanyInfoEvent.class)
                .subscribe(new Subscriber<CompanyInfoEvent>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(CompanyInfoEvent event) {
                        nameTv.setText("欢迎您," + event.name);
                    }
                });
        addSubscription(rx);
    }

    private void httpGetCompanyInfo() {
        ApiFactory factory = new ApiFactory();
        Map<String, Object> params = ApiFactory.get_base_map();
        params.put("service", ApiName.QUERY_ENTERPRISE);
        params.put("partner_id", "188888888");
        params.put("token", App.token);
        Subscription s = factory.get_weijin().getBaseApiSingleton().getUserInfo(params)
                .map(model -> model).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseSubscriber<UserInfoModel>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void get_model(UserInfoModel result) {
                        if (result.is_success.equals("T")) {
                            setInfo(result.result);
                        } else {
                            T.showShort(result.getError_message());
                        }
                    }

                });
        addSubscription(s);
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
    public void initPresenter() {
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

}
