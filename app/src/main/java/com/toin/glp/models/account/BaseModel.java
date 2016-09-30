package com.toin.glp.models.account;

/**
 * Created by hb on 16/9/29.
 */
public class BaseModel {

    /**
     * PRDCODE :
     * MOBILE : 15606924171
     * LOANSTATUS :
     * PAGEMAXNUM : 10
     * PAGENO : 1
     * tranChl : phone
     * tranCode : queryLoanList
     * Token : netfinworks82de62402c4149d5bf67695e6958bd0d
     * RESULTCODE : SF100
     * RESULTMSG : tokenéªè¯éè¯¯ï¼
     * is_valid_token : T
     */

    private String PRDCODE;
    private String MOBILE;
    private String LOANSTATUS;
    private int PAGEMAXNUM;
    private int PAGENO;
    private String tranChl;
    private String tranCode;
    private String Token;
    private String RESULTCODE;
    private String RESULTMSG;
    private String is_valid_token;

    public String getPRDCODE() {
        return PRDCODE;
    }

    public void setPRDCODE(String PRDCODE) {
        this.PRDCODE = PRDCODE;
    }

    public String getMOBILE() {
        return MOBILE;
    }

    public void setMOBILE(String MOBILE) {
        this.MOBILE = MOBILE;
    }

    public String getLOANSTATUS() {
        return LOANSTATUS;
    }

    public void setLOANSTATUS(String LOANSTATUS) {
        this.LOANSTATUS = LOANSTATUS;
    }

    public int getPAGEMAXNUM() {
        return PAGEMAXNUM;
    }

    public void setPAGEMAXNUM(int PAGEMAXNUM) {
        this.PAGEMAXNUM = PAGEMAXNUM;
    }

    public int getPAGENO() {
        return PAGENO;
    }

    public void setPAGENO(int PAGENO) {
        this.PAGENO = PAGENO;
    }

    public String getTranChl() {
        return tranChl;
    }

    public void setTranChl(String tranChl) {
        this.tranChl = tranChl;
    }

    public String getTranCode() {
        return tranCode;
    }

    public void setTranCode(String tranCode) {
        this.tranCode = tranCode;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String Token) {
        this.Token = Token;
    }

    public String getRESULTCODE() {
        return RESULTCODE;
    }

    public void setRESULTCODE(String RESULTCODE) {
        this.RESULTCODE = RESULTCODE;
    }

    public String getRESULTMSG() {
        return RESULTMSG;
    }

    public void setRESULTMSG(String RESULTMSG) {
        this.RESULTMSG = RESULTMSG;
    }

    public String getIs_valid_token() {
        return is_valid_token;
    }

    public void setIs_valid_token(String is_valid_token) {
        this.is_valid_token = is_valid_token;
    }
}
