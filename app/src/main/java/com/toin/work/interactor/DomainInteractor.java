package com.toin.work.interactor;

import com.toin.work.App;
import com.toin.work.api.BaseApiFinishListener;
import com.toin.work.contract.DomainContract;

import rx.Subscription;

/**
 * Created by hb on 16/6/26.
 */
public class DomainInteractor implements DomainContract.Interactor {
    @Override
    public Subscription setDomain(String url, BaseApiFinishListener listener) {
        if(url.equals("hanbin")){
            App.domain = "hanbin";
            listener.onSuccess();
        }
        return new Subscription() {
            @Override
            public void unsubscribe() {

            }

            @Override
            public boolean isUnsubscribed() {
                return false;
            }
        };
    }
}
