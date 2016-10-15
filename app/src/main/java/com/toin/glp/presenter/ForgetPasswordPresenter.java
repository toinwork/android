package com.toin.glp.presenter;

import com.toin.glp.StringUtils;
import com.toin.glp.api.ApiFactory;
import com.toin.glp.api.ApiName;
import com.toin.glp.api.BaseSubscriber;
import com.toin.glp.base.utils.SHA256;
import com.toin.glp.contract.ForgetPasswordContract;
import com.toin.glp.models.BaseResult;
import com.toin.glp.utils.SendMessageUtils;

import java.util.Map;

/**
 * 忘记密码 Created by hb on 16/6/26.
 */
public class ForgetPasswordPresenter extends ForgetPasswordContract.Presenter {

    /**
     * 重置密码成功
     */
    public void resetPwdSuccess() {
        if (mView != null) {
            mView.hideProgress();
            mView.navigateToLogin();
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
    public void setLoginPwd(String userName, String code, String password) {
        if (mView != null) {
            showProgress(StringUtils.API_SURE);
            Map<String, Object> params = ApiFactory.get_base_map();
            params.put("service", ApiName.VERIFY_MESSAGE);
            params.put("partner_id", "188888888");
            params.put("token", "anonymous");
            params.put("mobile", userName);
            params.put("template", SendMessageUtils.REFI_LOGIN_SMS);
            params.put("msg_code", code);
            mRxManage.add(mInterator.checkCode(params)
                    .subscribe(new BaseSubscriber<BaseResult>() {
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
     * 验证验证码成功,重置密码
     * 
     * @param phone
     * @param code
     * @param password
     */
    public void checkCodeSuccess(String phone, String code, String password) {
        if (mView != null) {
            Map<String, Object> params = ApiFactory.get_base_map();
            params.put("service", ApiName.SET_LOGIN_PWD);
            params.put("partner_id", "188888888");
            params.put("token", "anonymous");
            params.put("identity_no", phone);
            params.put("identity_type", "MOBILE");
            params.put("login_pwd", SHA256.encryptPassword(password, "SHA-256"));
            params.put("msg_code", code);
            mRxManage.add(mInterator.setLoginPwd(params).subscribe(
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
                                mView.showMsg(StringUtils.API_RESET_SUCCESS);
                                resetPwdSuccess();
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
