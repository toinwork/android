package com.toin.glp.models;

import java.util.List;

/**
 * Created by hb on 16/9/17.
 */
public class UserModel extends BaseResult {

    private String       avaliable_balance;  //avaliable_balance
    private String       frozen_balance;     //冻结余额
    private String       mobile_star;        //手机号码
    private String       token;              //登录 token
    private List<String> common_operation;
    private List<String> mycard_redenvelopes;

    public String get_input_charset() {
        return _input_charset;
    }

    public void set_input_charset(String _input_charset) {
        this._input_charset = _input_charset;
    }

    public String getAvaliable_balance() {
        return avaliable_balance;
    }

    public void setAvaliable_balance(String avaliable_balance) {
        this.avaliable_balance = avaliable_balance;
    }

    public String getFrozen_balance() {
        return frozen_balance;
    }

    public void setFrozen_balance(String frozen_balance) {
        this.frozen_balance = frozen_balance;
    }

    public String getMobile_star() {
        return mobile_star;
    }

    public void setMobile_star(String mobile_star) {
        this.mobile_star = mobile_star;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<String> getCommon_operation() {
        return common_operation;
    }

    public void setCommon_operation(List<String> common_operation) {
        this.common_operation = common_operation;
    }

    public List<String> getMycard_redenvelopes() {
        return mycard_redenvelopes;
    }

    public void setMycard_redenvelopes(List<String> mycard_redenvelopes) {
        this.mycard_redenvelopes = mycard_redenvelopes;
    }
}
