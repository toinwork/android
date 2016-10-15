package com.toin.glp.presenter.mine;

import com.toin.glp.api.BaseSubscriber;
import com.toin.glp.base.utils.T;
import com.toin.glp.contract.mine.MineContract;
import com.toin.glp.models.UserInfoModel;

import java.util.Map;

/**
 * 我的 Created by hb on 16/10/14.
 */
public class MinePresenter extends MineContract.Presenter {
    @Override
    public void getUserInfo(Map<String, Object> params) {
        mRxManage.add(mInterator.getUserInfo(params).subscribe(new BaseSubscriber<UserInfoModel>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void get_model(UserInfoModel result) {
                if (result.is_success.equals("T")) {
                    mView.setUserInfo(result);
                } else {
                    T.showShort(result.getError_message());
                }
            }

        }));
    }
}
