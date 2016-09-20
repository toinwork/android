package com.toin.glp.models.account;

/**
 * 消息体 Created by hb on 16/9/19.
 */
public class MessageModel {
    private String CUSTNAME;
    private String CUSTNO;
    private String DETAIL;
    private String ID;
    private String INPUTDATE;
    private String PARAMINFO;
    private String SOURCE;
    private String STATUS;
    private String TYPE;
    private String USERID;

    public String getCUSTNAME() {
        return CUSTNAME;
    }

    public void setCUSTNAME(String CUSTNAME) {
        this.CUSTNAME = CUSTNAME;
    }

    public String getCUSTNO() {
        return CUSTNO;
    }

    public void setCUSTNO(String CUSTNO) {
        this.CUSTNO = CUSTNO;
    }

    public String getDETAIL() {
        return DETAIL;
    }

    public void setDETAIL(String DETAIL) {
        this.DETAIL = DETAIL;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getINPUTDATE() {
        return INPUTDATE;
    }

    public void setINPUTDATE(String INPUTDATE) {
        this.INPUTDATE = INPUTDATE;
    }

    public String getPARAMINFO() {
        return PARAMINFO;
    }

    public void setPARAMINFO(String PARAMINFO) {
        this.PARAMINFO = PARAMINFO;
    }

    public String getSOURCE() {
        return SOURCE;
    }

    public void setSOURCE(String SOURCE) {
        this.SOURCE = SOURCE;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public String getTYPE() {
        return TYPE;
    }

    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }

    public String getUSERID() {
        return USERID;
    }

    public void setUSERID(String USERID) {
        this.USERID = USERID;
    }
}
