package com.toin.glp.ui.mine;

import android.view.View;

import com.toin.glp.Navigation;
import com.toin.glp.R;
import com.toin.glp.StringUtils;
import com.toin.glp.base.BaseFragment;
import com.toin.glp.contract.MineContract;
import com.toin.glp.models.UserInfoModel;

/**
 * 我的 Created by hb on 16/6/26.
 */
public class MineFragment extends BaseFragment implements
        View.OnClickListener, MineContract.View {

    @Override
    protected int initLayout() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView() {
        setOnClick(R.id.rl_header, R.id.btn_back, R.id.rl_company, R.id.rl_modify_password,
                R.id.rl_feedback, R.id.rl_about_us, R.id.tv_exit);
    }

    @Override
    protected void initData() {
        setActionTitle(StringUtils.TAB_TAG_MINE);
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
        }
    }

    @Override
    public void setUserInfo(UserInfoModel model) {

    }

}
