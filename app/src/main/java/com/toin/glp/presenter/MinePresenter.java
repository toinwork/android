package com.toin.glp.presenter;

import com.toin.glp.contract.MineContract;
import com.toin.glp.models.UserInfoModel;

/**
 * 忘记密码 Created by hb on 16/6/26.
 */
public class MinePresenter extends MineContract.Presenter implements
        MineContract.Interactor.OnGetMineInfoSuccessListener {

    @Override
    public void onSuccess() {

    }

    @Override
    public void getUserInfo() {
        if (mView != null) {
            mInterator.getUserInfo(this);
        }
    }

    @Override
    public void getUesrInfoSuccess(UserInfoModel model) {
        if (mView != null) {
            mView.setUserInfo(model);
        }
    }
}
