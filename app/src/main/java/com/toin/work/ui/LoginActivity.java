package com.toin.work.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.toin.work.Navigation;
import com.toin.work.R;
import com.toin.work.base.BaseActivity;
import com.toin.work.contract.LoginContract;
import com.toin.work.interactor.LoginInteractor;
import com.toin.work.presenter.LoginPresenter;

import butterknife.Bind;

public class LoginActivity extends BaseActivity<LoginPresenter, LoginInteractor> implements
        LoginContract.View, View.OnClickListener {
    @Bind(R.id.et_phone)
    EditText              idEt;
    @Bind(R.id.et_pwd)
    EditText              pwdEt;
    @Bind(R.id.tv_login)
    TextView              loginTv;

    private String        userName = null;
    private String        passWord = null;

    @Override
    protected int initLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        setUnClickable();
        loginTv.setOnClickListener(this);
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
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mInterator);
    }

    @Override
    public void setClickable() {
        loginTv.setBackgroundDrawable(getResources().getDrawable(R.drawable.shape_login_action));
        loginTv.setTextColor(getResources().getColor(R.color.action_color));
        loginTv.setClickable(true);
    }

    @Override
    public void setUnClickable() {
        loginTv.setBackgroundDrawable(getResources().getDrawable(R.drawable.shape_login_gray));
        loginTv.setClickable(false);
    }

    @Override
    public void navigateToHome() {
        Navigation.goPage(this, MainActivity.class);
    }

    @Override
    public void setAccountInfo(int account) {
        if (account > 0) {
            idEt.setText(String.valueOf(account));
        } else {
            idEt.setText("");
        }
    }

    @Override
    public void onClick(View v) {
        mPresenter.login(idEt.getText().toString().trim(), pwdEt.getText().toString().trim());
    }

}
