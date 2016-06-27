package com.toin.work.contract;

import com.toin.work.api.BaseApiFinishListener;
import com.toin.work.base.BaseInterator;
import com.toin.work.base.BasePresenter;
import com.toin.work.base.BaseView;

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
