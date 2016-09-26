package com.toin.glp.ui;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.toin.glp.Navigation;
import com.toin.glp.R;
import com.toin.glp.base.BaseActivity;
import com.toin.glp.contract.LoginContract;
import com.toin.glp.interactor.LoginInteractor;
import com.toin.glp.presenter.LoginPresenter;

import butterknife.Bind;

public class LoginActivity extends BaseActivity<LoginPresenter, LoginInteractor> implements
        LoginContract.View, View.OnClickListener {
    @Bind(R.id.et_phone)
    EditText       idEt;
    @Bind(R.id.et_pwd)
    EditText       pwdEt;
    @Bind(R.id.img_cancel)
    ImageView      cancelImg;

    private String userName = null;
    private String passWord = null;

    @Override
    protected int initLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        setOnClick(R.id.btn_back, R.id.tv_login, R.id.tv_register, R.id.tv_forget_password,
                R.id.img_cancel);
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
        setActionTitle("账户登录");
        mPresenter.getAccount();
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
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_login:
                mPresenter.login(idEt.getText().toString().trim(), pwdEt.getText().toString()
                        .trim());
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
            case R.id.btn_back:
                finish();
                break;
        }
    }

    @Override
    public boolean onKeyDown(final int keyCode, final KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
