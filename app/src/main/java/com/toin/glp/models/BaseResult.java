package com.toin.glp.models;

import com.toin.glp.App;
import com.toin.glp.Navigation;

/**
 * Created by hb on 16/3/17.
 */
public class BaseResult {
    public String _input_charset;
    public String is_success;
    public String error_code;
    public String error_message;
    public String verifyCode;

    public String get_input_charset() {
        return _input_charset;
    }

    public void set_input_charset(String _input_charset) {
        this._input_charset = _input_charset;
    }

    public String getIs_success() {
        return is_success;
    }

    public void setIs_success(String is_success) {
        this.is_success = is_success;
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public String getError_message() {
        if (error_message.contains("token已过期")) {
            Navigation.logout(App.context);
        }
        return error_message;
    }

    public void setError_message(String error_message) {
        this.error_message = error_message;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

}
