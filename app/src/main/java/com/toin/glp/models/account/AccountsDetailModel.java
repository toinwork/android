package com.toin.glp.models.account;

import java.util.List;

/**
 * 账单详情 Created by hb on 16/9/19.
 */
public class AccountsDetailModel {


    private AccountDetailModel responseBody;
    /**
     * responseBody :
     * {"APPLYDAY":16,"APPLYNO":"2016082320805211","BAILACCNO":"",
     * "BALANCE":"0.0"
     * ,"BEGINDATE":"2016/08/30","COMPDINTEBALANCE":"0.0","CREDITNO"
     * :"T2016082320802272"
     * ,"CURRENCY":"RMB","CURRENCYNAME":"人民币","CUSTNAME":"普洛斯测试01"
     * ,"CUSTNO":"2016082320802214"
     * ,"DEDUCTINTTYPE":"RPT05","DEDUCTINTTYPENAME":"利随本清"
     * ,"DEFAULTDUEDAY":"","ENDDATE"
     * :"2016/09/15","FEERATE":"1.0","FEETYPE":"A1",
     * "FEETYPENAME":"贷款手续费","FINCLASSNAME"
     * :"流动资金贷款","FINCLASSNO":"LN","FINEINTEBALANCE"
     * :"0.0","FIRSTBAILRATE":"0.0",
     * "FIRSTBAILRATEDISC":"0.0","FIRSTBAILRATIO":"0.0"
     * ,"FIRSTBAILUPFRONTAMT":"0.0"
     * ,"FLOATRATIO":"0.0","INTERESTRATE":"0.0","INTFLOATTYPE"
     * :"RAT002","INTFLOATTYPENAME"
     * :"贷款固定利率","ISENTRUSTPAYNAME":"否","LOANACCNO":"123456789"
     * ,"LOANOWNAMT":"0.0"
     * ,"LOANOWNRATIO":"0.0","MAXPUTOUTAMT":"645995.00","OVERDUEDAYS"
     * :0,"PAYEELIST"
     * :[],"PAYMENTFRETYPE":"一次","PERFORMRATE":"0.0","PERIOD":"1","PRDCODE"
     * :"FA0100100010"
     * ,"PRDNAME":"ETC保理","PUTOUTAMT":"25000.0","PUTOUTCCY":"RMB",
     * "RESULTCODE":"000000"
     * ,"RESULTMSG":"操作成功","SETTLEACCNO":"77777777","SUMCOUNT"
     * :"0","TOTALAMOUNT":"600.0","navi":"3","second":"3020"} responseType :
     * ENTITY
     */

    private String             responseType;

    public AccountDetailModel getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(AccountDetailModel responseBody) {
        this.responseBody = responseBody;
    }

    public String getResponseType() {
        return responseType;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }

    public static class AccountDetailModel {
        private int     APPLYDAY;
        private String  APPLYNO;
        private String  BAILACCNO;
        private String  BALANCE;
        private String  BEGINDATE;
        private String  COMPDINTEBALANCE;
        private String  CREDITNO;
        private String  CURRENCY;
        private String  CURRENCYNAME;
        private String  CUSTNAME;
        private String  CUSTNO;
        private String  DEDUCTINTTYPE;
        private String  DEDUCTINTTYPENAME;
        private String  DEFAULTDUEDAY;
        private String  ENDDATE;
        private String  FEERATE;
        private String  FEETYPE;
        private String  FEETYPENAME;
        private String  FINCLASSNAME;
        private String  FINCLASSNO;
        private String  FINEINTEBALANCE;
        private String  FIRSTBAILRATE;
        private String  FIRSTBAILRATEDISC;
        private String  FIRSTBAILRATIO;
        private String  FIRSTBAILUPFRONTAMT;
        private String  FLOATRATIO;
        private String  INTERESTRATE;
        private String  INTFLOATTYPE;
        private String  INTFLOATTYPENAME;
        private String  ISENTRUSTPAYNAME;
        private String  LOANACCNO;
        private String  LOANOWNAMT;
        private String  LOANOWNRATIO;
        private String  MAXPUTOUTAMT;
        private int     OVERDUEDAYS;
        private String  PAYMENTFRETYPE;
        private String  PERFORMRATE;
        private String  PERIOD;
        private String  PRDCODE;
        private String  PRDNAME;
        private String  PUTOUTAMT;
        private String  PUTOUTCCY;
        private String  RESULTCODE;
        private String  RESULTMSG;
        private String  SETTLEACCNO;
        private String  SUMCOUNT;
        private String  TOTALAMOUNT;
        private String  navi;
        private String  second;
        private List<?> PAYEELIST;

        public int getAPPLYDAY() {
            return APPLYDAY;
        }

        public void setAPPLYDAY(int APPLYDAY) {
            this.APPLYDAY = APPLYDAY;
        }

        public String getAPPLYNO() {
            return APPLYNO;
        }

        public void setAPPLYNO(String APPLYNO) {
            this.APPLYNO = APPLYNO;
        }

        public String getBAILACCNO() {
            return BAILACCNO;
        }

        public void setBAILACCNO(String BAILACCNO) {
            this.BAILACCNO = BAILACCNO;
        }

        public String getBALANCE() {
            return BALANCE;
        }

        public void setBALANCE(String BALANCE) {
            this.BALANCE = BALANCE;
        }

        public String getBEGINDATE() {
            return BEGINDATE;
        }

        public void setBEGINDATE(String BEGINDATE) {
            this.BEGINDATE = BEGINDATE;
        }

        public String getCOMPDINTEBALANCE() {
            return COMPDINTEBALANCE;
        }

        public void setCOMPDINTEBALANCE(String COMPDINTEBALANCE) {
            this.COMPDINTEBALANCE = COMPDINTEBALANCE;
        }

        public String getCREDITNO() {
            return CREDITNO;
        }

        public void setCREDITNO(String CREDITNO) {
            this.CREDITNO = CREDITNO;
        }

        public String getCURRENCY() {
            return CURRENCY;
        }

        public void setCURRENCY(String CURRENCY) {
            this.CURRENCY = CURRENCY;
        }

        public String getCURRENCYNAME() {
            return CURRENCYNAME;
        }

        public void setCURRENCYNAME(String CURRENCYNAME) {
            this.CURRENCYNAME = CURRENCYNAME;
        }

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

        public String getDEDUCTINTTYPE() {
            return DEDUCTINTTYPE;
        }

        public void setDEDUCTINTTYPE(String DEDUCTINTTYPE) {
            this.DEDUCTINTTYPE = DEDUCTINTTYPE;
        }

        public String getDEDUCTINTTYPENAME() {
            return DEDUCTINTTYPENAME;
        }

        public void setDEDUCTINTTYPENAME(String DEDUCTINTTYPENAME) {
            this.DEDUCTINTTYPENAME = DEDUCTINTTYPENAME;
        }

        public String getDEFAULTDUEDAY() {
            return DEFAULTDUEDAY;
        }

        public void setDEFAULTDUEDAY(String DEFAULTDUEDAY) {
            this.DEFAULTDUEDAY = DEFAULTDUEDAY;
        }

        public String getENDDATE() {
            return ENDDATE;
        }

        public void setENDDATE(String ENDDATE) {
            this.ENDDATE = ENDDATE;
        }

        public String getFEERATE() {
            return FEERATE;
        }

        public void setFEERATE(String FEERATE) {
            this.FEERATE = FEERATE;
        }

        public String getFEETYPE() {
            return FEETYPE;
        }

        public void setFEETYPE(String FEETYPE) {
            this.FEETYPE = FEETYPE;
        }

        public String getFEETYPENAME() {
            return FEETYPENAME;
        }

        public void setFEETYPENAME(String FEETYPENAME) {
            this.FEETYPENAME = FEETYPENAME;
        }

        public String getFINCLASSNAME() {
            return FINCLASSNAME;
        }

        public void setFINCLASSNAME(String FINCLASSNAME) {
            this.FINCLASSNAME = FINCLASSNAME;
        }

        public String getFINCLASSNO() {
            return FINCLASSNO;
        }

        public void setFINCLASSNO(String FINCLASSNO) {
            this.FINCLASSNO = FINCLASSNO;
        }

        public String getFINEINTEBALANCE() {
            return FINEINTEBALANCE;
        }

        public void setFINEINTEBALANCE(String FINEINTEBALANCE) {
            this.FINEINTEBALANCE = FINEINTEBALANCE;
        }

        public String getFIRSTBAILRATE() {
            return FIRSTBAILRATE;
        }

        public void setFIRSTBAILRATE(String FIRSTBAILRATE) {
            this.FIRSTBAILRATE = FIRSTBAILRATE;
        }

        public String getFIRSTBAILRATEDISC() {
            return FIRSTBAILRATEDISC;
        }

        public void setFIRSTBAILRATEDISC(String FIRSTBAILRATEDISC) {
            this.FIRSTBAILRATEDISC = FIRSTBAILRATEDISC;
        }

        public String getFIRSTBAILRATIO() {
            return FIRSTBAILRATIO;
        }

        public void setFIRSTBAILRATIO(String FIRSTBAILRATIO) {
            this.FIRSTBAILRATIO = FIRSTBAILRATIO;
        }

        public String getFIRSTBAILUPFRONTAMT() {
            return FIRSTBAILUPFRONTAMT;
        }

        public void setFIRSTBAILUPFRONTAMT(String FIRSTBAILUPFRONTAMT) {
            this.FIRSTBAILUPFRONTAMT = FIRSTBAILUPFRONTAMT;
        }

        public String getFLOATRATIO() {
            return FLOATRATIO;
        }

        public void setFLOATRATIO(String FLOATRATIO) {
            this.FLOATRATIO = FLOATRATIO;
        }

        public String getINTERESTRATE() {
            return INTERESTRATE;
        }

        public void setINTERESTRATE(String INTERESTRATE) {
            this.INTERESTRATE = INTERESTRATE;
        }

        public String getINTFLOATTYPE() {
            return INTFLOATTYPE;
        }

        public void setINTFLOATTYPE(String INTFLOATTYPE) {
            this.INTFLOATTYPE = INTFLOATTYPE;
        }

        public String getINTFLOATTYPENAME() {
            return INTFLOATTYPENAME;
        }

        public void setINTFLOATTYPENAME(String INTFLOATTYPENAME) {
            this.INTFLOATTYPENAME = INTFLOATTYPENAME;
        }

        public String getISENTRUSTPAYNAME() {
            return ISENTRUSTPAYNAME;
        }

        public void setISENTRUSTPAYNAME(String ISENTRUSTPAYNAME) {
            this.ISENTRUSTPAYNAME = ISENTRUSTPAYNAME;
        }

        public String getLOANACCNO() {
            return LOANACCNO;
        }

        public void setLOANACCNO(String LOANACCNO) {
            this.LOANACCNO = LOANACCNO;
        }

        public String getLOANOWNAMT() {
            return LOANOWNAMT;
        }

        public void setLOANOWNAMT(String LOANOWNAMT) {
            this.LOANOWNAMT = LOANOWNAMT;
        }

        public String getLOANOWNRATIO() {
            return LOANOWNRATIO;
        }

        public void setLOANOWNRATIO(String LOANOWNRATIO) {
            this.LOANOWNRATIO = LOANOWNRATIO;
        }

        public String getMAXPUTOUTAMT() {
            return MAXPUTOUTAMT;
        }

        public void setMAXPUTOUTAMT(String MAXPUTOUTAMT) {
            this.MAXPUTOUTAMT = MAXPUTOUTAMT;
        }

        public int getOVERDUEDAYS() {
            return OVERDUEDAYS;
        }

        public void setOVERDUEDAYS(int OVERDUEDAYS) {
            this.OVERDUEDAYS = OVERDUEDAYS;
        }

        public String getPAYMENTFRETYPE() {
            return PAYMENTFRETYPE;
        }

        public void setPAYMENTFRETYPE(String PAYMENTFRETYPE) {
            this.PAYMENTFRETYPE = PAYMENTFRETYPE;
        }

        public String getPERFORMRATE() {
            return PERFORMRATE;
        }

        public void setPERFORMRATE(String PERFORMRATE) {
            this.PERFORMRATE = PERFORMRATE;
        }

        public String getPERIOD() {
            return PERIOD;
        }

        public void setPERIOD(String PERIOD) {
            this.PERIOD = PERIOD;
        }

        public String getPRDCODE() {
            return PRDCODE;
        }

        public void setPRDCODE(String PRDCODE) {
            this.PRDCODE = PRDCODE;
        }

        public String getPRDNAME() {
            return PRDNAME;
        }

        public void setPRDNAME(String PRDNAME) {
            this.PRDNAME = PRDNAME;
        }

        public String getPUTOUTAMT() {
            return PUTOUTAMT;
        }

        public void setPUTOUTAMT(String PUTOUTAMT) {
            this.PUTOUTAMT = PUTOUTAMT;
        }

        public String getPUTOUTCCY() {
            return PUTOUTCCY;
        }

        public void setPUTOUTCCY(String PUTOUTCCY) {
            this.PUTOUTCCY = PUTOUTCCY;
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

        public String getSETTLEACCNO() {
            return SETTLEACCNO;
        }

        public void setSETTLEACCNO(String SETTLEACCNO) {
            this.SETTLEACCNO = SETTLEACCNO;
        }

        public String getSUMCOUNT() {
            return SUMCOUNT;
        }

        public void setSUMCOUNT(String SUMCOUNT) {
            this.SUMCOUNT = SUMCOUNT;
        }

        public String getTOTALAMOUNT() {
            return TOTALAMOUNT;
        }

        public void setTOTALAMOUNT(String TOTALAMOUNT) {
            this.TOTALAMOUNT = TOTALAMOUNT;
        }

        public String getNavi() {
            return navi;
        }

        public void setNavi(String navi) {
            this.navi = navi;
        }

        public String getSecond() {
            return second;
        }

        public void setSecond(String second) {
            this.second = second;
        }

        public List<?> getPAYEELIST() {
            return PAYEELIST;
        }

        public void setPAYEELIST(List<?> PAYEELIST) {
            this.PAYEELIST = PAYEELIST;
        }
    }
}
