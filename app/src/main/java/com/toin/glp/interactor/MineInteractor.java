package com.toin.glp.interactor;

import com.toin.glp.App;
import com.toin.glp.api.ApiFactory;
import com.toin.glp.api.ApiName;
import com.toin.glp.base.utils.T;
import com.toin.glp.contract.MineContract;
import com.toin.glp.models.UserInfoModel;

import java.util.Map;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * 忘记密码 Created by hb on 16/6/26.
 */
public class MineInteractor implements MineContract.Interactor {

    /**
     * 获取用户信息
     * 
     * @pagain
     * @param listener
     * @return
     */
    @Override
    public Subscription getUserInfo(OnGetMineInfoSuccessListener listener) {
        Map<String, Object> params = ApiFactory.get_base_map();
        params.put("service", ApiName.QUERY_ENTERPRISE);
        params.put("partner_id", "188888888");
        params.put("token", App.token);
        ApiFactory factory = new ApiFactory();
        return factory.get_weijin().getBaseApiSingleton().getUserInfo(params)
                .map(new Func1<UserInfoModel, UserInfoModel>() {
                    @Override
                    public UserInfoModel call(UserInfoModel model) {
                        return model;
                    }
                }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<UserInfoModel>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(UserInfoModel result) {
                        if (result.is_success.equals("T")) {
                            listener.getUesrInfoSuccess(result);
                        } else {
                            T.showShort(result.getError_message());
                            listener.onError();
                        }
                    }
                });
    }

}
