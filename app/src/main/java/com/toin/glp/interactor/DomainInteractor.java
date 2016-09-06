package com.toin.glp.interactor;

import com.toin.glp.App;
import com.toin.glp.api.BaseApiFinishListener;
import com.toin.glp.contract.DomainContract;

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
