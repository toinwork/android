package com.toin.glp.presenter;

import com.toin.glp.api.BaseApiFinishListener;
import com.toin.glp.contract.DomainContract;

/**
 * Created by hb on 16/6/26.
 */
public class DomainPresenter extends DomainContract.Presenter implements BaseApiFinishListener {
    @Override
    public void setDomain(String url) {
        if (mView != null) {
            mView.showProgress("");
        }
        mRxManage.add(mInterator.setDomain(url,this));
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onSuccess() {
        if (mView != null) {
            mView.hideProgress();
            mView.navegiteToLogin();
        }
    }
}
