package com.toin.glp.ui;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.toin.glp.Navigation;
import com.toin.glp.R;
import com.toin.glp.base.BaseActivity;
import com.toin.glp.base.utils.T;
import com.toin.glp.contract.LoginContract;
import com.toin.glp.interactor.LoginInteractor;
import com.toin.glp.presenter.LoginPresenter;

import java.util.Date;

import butterknife.Bind;

public class LoginActivity extends BaseActivity<LoginPresenter, LoginInteractor> implements
        LoginContract.View, View.OnClickListener {
    public static final String PAGETYPE      = "pagetype";
    public static final String TYPE_LOGOUT   = "logout";
    public static final String TYPE_LOGIN    = "login";
    @Bind(R.id.et_phone)
    EditText                   idEt;
    @Bind(R.id.et_pwd)
    EditText                   pwdEt;
    @Bind(R.id.et_code)
    EditText                   codeEt;
    @Bind(R.id.ll_verify_code)
    LinearLayout               codeLL;
    @Bind(R.id.tv_code)
    TextView                   codeTv;
    @Bind(R.id.img_cancel)
    ImageView                  cancelImg;

    private String             userName      = null;
    private String             passWord      = null;
    private long               mLastBackTime = 0;
    private long               TIME_DIFF     = 2 * 1000;

    private String             type;

    @Override
    protected int initLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        setOnClick(R.id.tv_login, R.id.tv_register, R.id.tv_forget_password, R.id.img_cancel);
        setTextWatcher(1, idEt);
        setTextWatcher(2, pwdEt);
    }

    private void setTextWatcher(int type, EditText idEt) {
        idEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (type == 1) {//name
                    userName = s.toString();
                    if (!TextUtils.isEmpty(userName)) {
                        cancelImg.setVisibility(View.VISIBLE);
                    } else {
                        cancelImg.setVisibility(View.GONE);
                    }
                } else if (type == 2) {
                    passWord = s.toString();
                }
                mPresenter.checkLogin(userName, passWord);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    protected void initData() {
        mPresenter.getAccount();
        type = getIntent().getStringExtra(PAGETYPE);
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mInterator);
    }

    @Override
    public void navigateToHome() {
        Navigation.login(this);
    }

    @Override
    public void setAccountInfo(String account) {
        idEt.setText(account);
        idEt.setSelection(account.length());
    }

    @Override
    public void showVerifyCode(String code) {
        codeLL.setVisibility(View.VISIBLE);
        codeTv.setVisibility(View.VISIBLE);
        codeTv.setText("请输入验证码:" + code);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_login:
                mPresenter.login(idEt.getText().toString().trim(), pwdEt.getText().toString()
                        .trim(), codeEt.getText().toString().trim());
                break;
            case R.id.tv_register:
                Navigation.goPage(this, RegisterActivity.class);
                break;
            case R.id.tv_forget_password:
                Navigation.goPage(this, ForgetPasswordActivity.class);
                break;
            case R.id.img_cancel:
                idEt.setText("");
                break;
        }
    }

    @Override
    public boolean onKeyDown(final int keyCode, final KeyEvent event) {
        if (type.equals(TYPE_LOGOUT)) {
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                long now = new Date().getTime();
                if (now - mLastBackTime < TIME_DIFF) {
                    return super.onKeyDown(keyCode, event);
                } else {
                    mLastBackTime = now;
                    T.showShort("再按一次返回键退出");
                }
                return true;
            }
        } else {
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                finish();
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
