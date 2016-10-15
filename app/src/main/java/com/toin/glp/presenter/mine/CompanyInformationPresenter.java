package com.toin.glp.presenter.mine;

import com.toin.glp.StringUtils;
import com.toin.glp.api.BaseSubscriber;
import com.toin.glp.base.utils.T;
import com.toin.glp.contract.mine.CompanyInformationContract;
import com.toin.glp.models.BaseResult;
import com.toin.glp.models.UserInfoModel;

import java.util.Map;

/**
 * 企业资料 Created by hb on 16/10/14.
 */
public class CompanyInformationPresenter extends CompanyInformationContract.Presenter {
    @Override
    public void getUserInfo(Map<String, Object> params) {
        mRxManage.add(mInterator.getUserInfo(params).subscribe(new BaseSubscriber<UserInfoModel>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
            }

            @Override
            public void get_model(UserInfoModel result) {
                if (result.is_success.equals("T")) {
                    mView.setInfo(result.result);
                } else {
                    T.showShort(result.getError_message());
                }
            }
        }));
    }

    @Override
    public void modifyUserInfo(Map<String, Object> params) {
        mRxManage.add(mInterator.modifyUserInfo(params).subscribe(new BaseSubscriber<BaseResult>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
            }

            @Override
            public void get_model(BaseResult baseResult) {
                if (baseResult.is_success.equals("T")) {
                    T.showShort(StringUtils.API_SUCCESS);
                    mView.setCompanyInfo();
                } else {
                    T.showShort(baseResult.getError_message());
                }
            }
        }));
    }
}
