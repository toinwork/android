package com.toin.glp.presenter;

import com.toin.glp.App;
import com.toin.glp.StringUtils;
import com.toin.glp.api.ApiFactory;
import com.toin.glp.api.ApiName;
import com.toin.glp.api.BaseSubscriber;
import com.toin.glp.base.utils.SHA256;
import com.toin.glp.base.utils.SharedPreferencesUtil;
import com.toin.glp.contract.RegisterContract;
import com.toin.glp.models.BaseResult;
import com.toin.glp.utils.SendMessageUtils;

import java.util.Map;

/**
 * 注册 Created by hb on 16/6/26.
 */
public class RegisterPresenter extends RegisterContract.Presenter {

    /**
     * 注册成功
     */
    public void registerSuccess() {
        if (mView != null) {
            mView.hideProgress();
            mView.navigateToHome();
            mView.finishActivity();
        }
    }

    /**
     * 先验证短信
     *
     * @param userName
     * @param code
     * @param password
     */
    @Override
    public void register(String userName, String code, String password) {
        if (mView != null) {
            showProgress(StringUtils.API_SURE);
            Map<String, Object> params = ApiFactory.get_base_map();
            params.put("service", ApiName.VERIFY_MESSAGE);
            params.put("partner_id", "188888888");
            params.put("token", "anonymous");
            params.put("mobile", userName);
            params.put("template", SendMessageUtils.REGISTER_MOBILE);
            params.put("msg_code", code);
            mRxManage.add(mInterator.checkCode(params).subscribe(
                    new BaseSubscriber<BaseResult>() {
                        @Override
                        public void onCompleted() {
                            hideProgress();
                        }

                        @Override
                        public void onError(Throwable e) {
                            super.onError(e);
                            hideProgress();
                        }

                        @Override
                        public void get_model(BaseResult flagModel) {
                            if (flagModel.is_success.equals("T")) {
                                //验证码验证成功
                                checkCodeSuccess(userName, code, password);
                            } else {
                                mView.showMsg(flagModel.getError_message());
                                hideProgress();
                            }
                        }
                    }));
        }
    }

    /**
     * 发送验证码
     * 
     * @param phone
     */
    @Override
    public void sendCode(String phone) {
        if (mView != null) {
            showProgress(StringUtils.API_SEND);
            mRxManage.add(mInterator.sendCode(phone).subscribe(new BaseSubscriber<BaseResult>() {
                @Override
                public void onCompleted() {
                    hideProgress();
                }

                @Override
                public void onError(Throwable e) {
                    super.onError(e);
                    hideProgress();
                }

                @Override
                public void get_model(BaseResult baseResult) {
                    if (baseResult.is_success.equals("T")) {
                        mView.showMsg(StringUtils.SEND_SUCCESS);
                        sendSuccessAndStartTimer();
                    } else {
                        mView.showMsg(baseResult.getError_message());
                        hideProgress();
                    }
                }
            }));
        }
    }

    /**
     * 验证码验证成功
     * 
     * @param phone
     * @param code
     * @param password
     */
    public void checkCodeSuccess(String phone, String code, String password) {
        if (mView != null) {
            Map<String, Object> params = ApiFactory.get_base_map();
            params.put("service", ApiName.CREATE_ENTERPRISE_MEMBER);
            params.put("partner_id", "188888888");
            params.put("token", "anonymous");
            params.put("login_name", phone);
            params.put("loginnametype", 2);
            params.put("loginpassword", SHA256.encryptPassword(password, "SHA-256"));
            mRxManage.add(mInterator.register(params).subscribe(
                    new BaseSubscriber<BaseResult>() {
                        @Override
                        public void onCompleted() {
                            hideProgress();
                        }

                        @Override
                        public void onError(Throwable e) {
                            super.onError(e);
                            hideProgress();
                        }

                        @Override
                        public void get_model(BaseResult baseResult) {
                            if (baseResult.is_success.equals("T")) {
                                mView.showMsg(StringUtils.API_REGISTER_SUCCESS);
                                SharedPreferencesUtil.saveStringValue(App.context, "phone", phone);
                                App.phone = phone;
                                registerSuccess();
                            } else {
                                mView.showMsg(baseResult.getError_message());
                                hideProgress();
                            }
                        }
                    }));
        }
    }

    /**
     * 短信发送成功,启动定时器
     */
    public void sendSuccessAndStartTimer() {
        if (mView != null) {
            mView.hideProgress();
            mView.startTimer();
        }
    }

}
