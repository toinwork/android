package com.toin.glp.ui.mine;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.toin.glp.App;
import com.toin.glp.R;
import com.toin.glp.StringUtils;
import com.toin.glp.api.ApiFactory;
import com.toin.glp.api.ApiName;
import com.toin.glp.api.BaseSubscriber;
import com.toin.glp.base.BaseActivity;
import com.toin.glp.base.utils.SHA256;
import com.toin.glp.base.utils.T;
import com.toin.glp.models.BaseResult;

import java.util.Map;

import butterknife.Bind;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 修改密码 Created by hb on 16/6/26.
 */
public class ChangePasswordActivity extends BaseActivity implements View.OnClickListener {
    @Bind(R.id.et_old_pwd)
    EditText oldPwdEt;
    @Bind(R.id.et_new_pwd)
    EditText newPwdEt;
    @Bind(R.id.et_sure_pwd)
    EditText surePwdEt;

    @Override
    protected int initLayout() {
        return R.layout.activity_change_password;
    }

    @Override
    protected void initView() {
        setOnClick(R.id.btn_back, R.id.btn_commit);
    }

    @Override
    protected void initData() {
        setActionTitle(StringUtils.TITLE_CHANGE_PWD);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_back:
                finish();
                break;
            case R.id.btn_commit:
                String oldPwd = oldPwdEt.getText().toString().trim();
                String newPwd = newPwdEt.getText().toString().trim();
                String newAgainPwd = surePwdEt.getText().toString().trim();
                if (TextUtils.isEmpty(oldPwd)) {
                    T.showShort("原密码不能为空");
                    return;
                }
                if (TextUtils.isEmpty(newPwd)) {
                    T.showShort("新密码不能为空");
                    return;
                }
                if (newPwd.length() < 6 || newPwd.length() > 16) {
                    T.showShort(getString(R.string.password_length_illegal));
                    return;
                }
                if (TextUtils.isEmpty(newAgainPwd)) {
                    T.showShort("确认密码不能为空");
                    return;
                }
                if (!newPwd.equals(newAgainPwd)) {
                    T.showShort("确认密码必须和原密码一致");
                    return;
                }
                showProgress("设置中...");
                ApiFactory factory = new ApiFactory();
                Map<String, Object> params = ApiFactory.get_base_map();
                params.put("service", ApiName.MODIFY_LOGINPWD);
                params.put("partner_id", "188888888");
                params.put("token", App.token);
                params.put("orgin_pwd", oldPwd);
                params.put("login_pwd", SHA256.encryptPassword(newPwd, "SHA-256"));
                Subscription s = factory.get_weijin().getBaseApiSingleton().modifyPassword(params)
                        .map(baseResult -> baseResult).subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
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
                            public void get_model(BaseResult result) {
                                hideProgress();
                                if (result.is_success.equals("T")) {
                                    T.showShort("重置密码成功");
                                    hideProgress();
                                    finish();
                                } else {
                                    T.showShort("重置密码失败");
                                }
                            }
                        });
                addSubscription(s);
                break;
        }
    }
}
