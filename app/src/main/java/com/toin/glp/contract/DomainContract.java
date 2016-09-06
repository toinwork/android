package com.toin.glp.contract;

import com.toin.glp.api.BaseApiFinishListener;
import com.toin.glp.base.BaseInterator;
import com.toin.glp.base.BasePresenter;
import com.toin.glp.base.BaseView;

import rx.Subscription;

/**
 * 设置域名 Created by hb on 16/6/26.
 */
public interface DomainContract {
    interface Interactor extends BaseInterator {
        Subscription setDomain(String url, BaseApiFinishListener listener);
    }

    interface View extends BaseView {
        void navegiteToLogin();
    }

    abstract class Presenter extends BasePresenter<Interactor, View> {
        public abstract void setDomain(String url);
    }

}
