package com.toin.glp.ui;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.toin.glp.App;
import com.toin.glp.Navigation;
import com.toin.glp.R;
import com.toin.glp.base.BaseActivity;
import com.toin.glp.base.utils.PatternUtils;
import com.toin.glp.base.utils.T;
import com.toin.glp.contract.RegisterContract;
import com.toin.glp.interactor.RegisterInteractor;
import com.toin.glp.presenter.RegisterPresenter;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.Bind;

/**
 * 注册页面 Created by hb on 16/9/12.
 */
public class RegisterActivity extends BaseActivity<RegisterPresenter, RegisterInteractor> implements
        RegisterContract.View, View.OnClickListener {
    @Bind(R.id.tv_register)
    TextView      registerTv;
    @Bind(R.id.tv_login)
    TextView      loginTv;
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
    @Bind(R.id.check_user_agreement)
    CheckBox      userAgreementCheckBox;
    @Bind(R.id.ll_user_agreement)
    LinearLayout  userAgreementLL;

    @Override
    protected int initLayout() {
        return R.layout.activity_register;
    }

    @Override
    protected void initView() {
        setOnClick(R.id.tv_code, R.id.btn_back, R.id.tv_register, R.id.tv_login,
                R.id.tv_user_agreement);
    }

    @Override
    protected void initData() {
        String TITLE = getResources().getString(R.string.register);
        loginTv.setVisibility(View.VISIBLE);
        userAgreementLL.setVisibility(View.VISIBLE);
        setActionTitle(TITLE);
        registerTv.setText(TITLE);
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mInterator);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_code:
                //发送验证码
                String mobile = phoneEt.getText().toString();
                if (!PatternUtils.isPhoneNum(mobile)) {
                    T.showLong(getString(R.string.mobile_illegal));
                    return;
                }
                mPresenter.sendCode(mobile);
                break;
            case R.id.tv_register:
                //注册
                mobile = phoneEt.getText().toString().trim();
                String checkCode = codeEt.getText().toString().trim();
                String pwd = pwdEt.getText().toString().trim();
                String pwdAgain = pwdAgainEt.getText().toString().trim();
                if (TextUtils.isEmpty(mobile)) {
                    T.showLong(App.context.getString(R.string.phone_number_null));
                    return;
                }
                if (!PatternUtils.isPhoneNum(mobile)) {
                    T.showLong(getString(R.string.mobile_illegal));
                    return;
                }
                if (TextUtils.isEmpty(checkCode)) {
                    T.showLong(getString(R.string.check_code_cannot_be_empty));
                    return;
                }
                if (TextUtils.isEmpty(pwd)) {
                    T.showLong(getString(R.string.password_null));
                    return;
                }
                if (pwd.length() < 6 || pwd.length() > 16) {
                    T.showLong(getString(R.string.password_length_illegal));
                    return;
                }
                if (!pwd.equals(pwdAgain)) {
                    T.showLong(getString(R.string.password_is_not_equels_old_password));
                    return;
                }
                if (!userAgreementCheckBox.isChecked()) {
                    T.showShort(getString(R.string.user_agreement_illegal));
                    return;
                }
                mPresenter.register(mobile, checkCode, pwd, pwdAgain);
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
            case R.id.tv_user_agreement:
                Navigation.goPage(this, UserAgreementActivity.class);
                break;
        }
    }

    @Override
    public void navigateToHome() {
        closeTimer();
        Navigation.goPage(this, LoginActivity.class);
    }

    @Override
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
    public boolean onKeyDown(final int keyCode, final KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            closeTimer();
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
