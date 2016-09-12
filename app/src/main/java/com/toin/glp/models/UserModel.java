package com.toin.glp.models;

import java.util.List;

/**
 * Created by hb on 16/4/14.
 */
public class UserModel extends BaseResult {

    /**
     * _input_charset : UTF-8 avaliable_balance : 0.00 common_operation :
     * ["{\"operation_name\":\"rechage\"}"
     * ,"{\"operation_name\":\"transfer\"}","{\"operation_name\":\"withdraw\"}"
     * ,"{\"operation_name\":\"transactionlist\"}"] frozen_balance : 0.00
     * is_success : T mobile_star : 18968142405 mycard_redenvelopes :
     * ["{\"operation_name\":\"coupons\"}"
     * ,"{\"operation_name\":\"RedEnvelopes\"}"] token :
     * netfinworksf715d87115dd46cca2842f84d78d01b8
     */

    private String       avaliable_balance;
    private String       frozen_balance;
    private String       mobile_star;
    private String       token;
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

    public String getIs_success() {
        return is_success;
    }

    public void setIs_success(String is_success) {
        this.is_success = is_success;
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
