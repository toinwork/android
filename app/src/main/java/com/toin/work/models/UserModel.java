package com.toin.work.models;

/**
 * Created by hb on 16/4/14.
 */
public class UserModel {

    /**
     * account : 10000
     * mobile : 13588007561
     * uname : 小强
     * token : 7d4acad7dda7f5378509f180a04e0869
     */

    private int account;
    private String mobile;
    private String uname;
    private String token;

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
