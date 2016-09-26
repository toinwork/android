package com.toin.glp.ui;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.toin.glp.App;
import com.toin.glp.Navigation;
import com.toin.glp.R;
import com.toin.glp.base.BaseActivity;
import com.toin.glp.base.utils.PatternUtils;
import com.toin.glp.base.utils.SharedPreferencesUtil;
import com.toin.glp.base.utils.T;
import com.toin.glp.contract.ForgetPasswordContract;
import com.toin.glp.interactor.ForgetPasswordInteractor;
import com.toin.glp.presenter.ForgetPasswordPresenter;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.Bind;

/**
 * 忘记密码 Created by hb on 16/9/12.
 */
public class ForgetPasswordActivity extends
        BaseActivity<ForgetPasswordPresenter, ForgetPasswordInteractor> implements
        ForgetPasswordContract.View, View.OnClickListener {
    @Bind(R.id.tv_register)
    TextView      registerTv;
    @Bind(R.id.tv_code)
    TextView      checkCodeTv;
    @Bind(R.id.et_phone)
    EditText      phoneEt;
    @Bind(R.id.et_code)
    EditText      codeEt;
    @Bind(R.id.et_pwd)
    EditText      pwdEt;
    @Bind(R.id.et_pwd_again)
    EditText      pwdAgainEt;
    private Timer timer = null;

    @Override
    protected int initLayout() {
        return R.layout.activity_register;
    }

    @Override
    protected void initView() {
        setOnClick(R.id.tv_code, R.id.btn_back, R.id.tv_register, R.id.tv_login);
    }

    @Override
    protected void initData() {
        String TITLE = getResources().getString(R.string.reset_password);
        String BTNCONTENT = getResources().getString(R.string.sure);
        setActionTitle(TITLE);
        registerTv.setText(BTNCONTENT);
//        setAccount();
    }

    private void setAccount() {
        String account = SharedPreferencesUtil.getStringValue(App.context, "phone");
        if (!TextUtils.isEmpty(account)) {
            phoneEt.setText(account);
            phoneEt.setSelection(account.length());
        }
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mInterator);
    }

    public void startTimer() {
        checkCodeTv.setEnabled(false);
        timer = new Timer();
        final TimerTask timerTask = new TimerTask() {
            int count = 60;

            @Override
            public void run() {
                count--;
                checkCodeTv.post(new Runnable() {
                    @Override
                    public void run() {
                        if (count == 0) {
                            checkCodeTv.setEnabled(true);
                            checkCodeTv.setText(getString(R.string.get_code));
                            closeTimer();
                        } else {
                            String text = String.format("%d秒", count);
                            checkCodeTv.setText(text);
                        }
                    }
                });
            }
        };
        timer.schedule(timerTask, 0, 1000);
    }

    @Override
    public void closeTimer() {
        if (timer != null) {
            timer.cancel();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_code:
                //发送验证码
                String mobile = phoneEt.getText().toString();
                if (TextUtils.isEmpty(mobile)) {
                    T.showLong(App.context.getString(R.string.phone_number_null));
                    return;
                }
                if (!PatternUtils.isPhoneNum(mobile)) {
                    T.showLong(getString(R.string.mobile_illegal));
                    return;
                }
                mPresenter.sendCode(mobile);
                break;
            case R.id.tv_register:
                //忘记密码
                String userName = phoneEt.getText().toString().trim();
                String code = codeEt.getText().toString().trim();
                String password = pwdEt.getText().toString().trim();
                String passwordAgain = pwdAgainEt.getText().toString().trim();
                if (TextUtils.isEmpty(userName)) {
                    T.showLong(App.context.getString(R.string.phone_number_null));
                    return;
                }
                if (!PatternUtils.isPhoneNum(userName)) {
                    T.showLong(App.context.getString(R.string.mobile_illegal));
                    return;
                }
                if (TextUtils.isEmpty(code)) {
                    T.showLong(App.context.getString(R.string.check_code_cannot_be_empty));
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    T.showLong(App.context.getString(R.string.password_null));
                    return;
                }
                if (password.length() < 6 || password.length() > 16) {
                    T.showLong(App.context.getString(R.string.password_length_illegal));
                    return;
                }
                if (!password.equals(passwordAgain)) {
                    T.showLong(App.context.getString(R.string.password_is_not_equels_old_password));
                    return;
                }
                mPresenter.setLoginPwd(userName, code, password, passwordAgain);
                break;
            case R.id.tv_login:
                //已有账号,登录
                closeTimer();
                Navigation.goPage(this, LoginActivity.class);
                break;
            case R.id.btn_back:
                closeTimer();
                finish();
                break;
        }
    }

    @Override
    public void navigateToLogin() {
        closeTimer();
        Navigation.goPage(this, LoginActivity.class);
    }

    @Override
    public boolean onKeyDown(final int keyCode, final KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            closeTimer();
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
