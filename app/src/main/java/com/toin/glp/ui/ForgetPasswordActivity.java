package com.toin.glp.ui;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.toin.glp.Navigation;
import com.toin.glp.R;
import com.toin.glp.base.BaseActivity;
import com.toin.glp.base.utils.PatternUtils;
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
    private Timer timer;

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
        String TITLE = getResources().getString(R.string.forget_password);
        String BTNCONTENT = getResources().getString(R.string.sure);
        loginTv.setVisibility(View.VISIBLE);
        setActionTitle(TITLE);
        registerTv.setText(BTNCONTENT);
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
                            timer.cancel();
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
                //忘记密码
                String userName = phoneEt.getText().toString().trim();
                String code = codeEt.getText().toString().trim();
                String password = pwdEt.getText().toString().trim();
                String passwordAgain = pwdAgainEt.getText().toString().trim();
                mPresenter.setLoginPwd(userName, code, password, passwordAgain);
                break;
            case R.id.tv_login:
                //已有账号,登录
                Navigation.goPage(this, LoginActivity.class);
                break;
            case R.id.btn_back:
                timer.cancel();
                finish();
                break;
        }
    }

    @Override
    public void navigateToLogin() {
        Navigation.goPage(this, LoginActivity.class);
    }
}
