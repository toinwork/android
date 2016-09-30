package com.toin.glp.models.account;

import java.util.List;

/**
 * Created by hb on 16/9/19.
 */
public class AccountsModel{

    private ResponseBodyEntity responseBody;
    /**
     * responseBody : {"CUSTNO":"2016082320802214","RESULTCODE":"000000","RESULTMSG":"操作成功","data":[{"BALANCE":"0.0","BUSINESSSUM":"60000.0","COMPDINTEBALANCE":"0.0","CURRENCY":"RMB","FINEINTEBALANCE":"0.0","LOANSTATUS":"4","LOANSTATUSDESC":"逾期结清","MATURITYDATE":"2016/09/15","NORMALBALANCE":"0.0","OVERDUEBALANCE":"0.0","OVERDUEDAYS":0,"PRDNAME":"ETC保理","PUTOUTDATE":"2016/09/01","PUTOUTNO":"2016082320805211"},{"BALANCE":"0.0","BUSINESSSUM":"84000.0","COMPDINTEBALANCE":"0.0","CURRENCY":"RMB","FINEINTEBALANCE":"0.0","LOANSTATUS":"3","LOANSTATUSDESC":"提前结清","MATURITYDATE":"2016/10/15","NORMALBALANCE":"0.0","OVERDUEBALANCE":"0.0","OVERDUEDAYS":0,"PRDNAME":"ETC保理","PUTOUTDATE":"2016/10/01","PUTOUTNO":"2016082320805712"},{"BALANCE":"0.0","BUSINESSSUM":"197003.0","COMPDINTEBALANCE":"0.0","CURRENCY":"RMB","FINEINTEBALANCE":"0.0","LOANSTATUS":"4","LOANSTATUSDESC":"逾期结清","MATURITYDATE":"2016/12/15","NORMALBALANCE":"0.0","OVERDUEBALANCE":"0.0","OVERDUEDAYS":0,"PRDNAME":"ETC保理","PUTOUTDATE":"2016/12/02","PUTOUTNO":"2016083020870415"},{"BALANCE":"0.0","BUSINESSSUM":"125002.0","COMPDINTEBALANCE":"0.0","CURRENCY":"RMB","FINEINTEBALANCE":"0.0","LOANSTATUS":"2","LOANSTATUSDESC":"正常结清","MATURITYDATE":"2017/02/15","NORMALBALANCE":"0.0","OVERDUEBALANCE":"0.0","OVERDUEDAYS":0,"PRDNAME":"ETC保理","PUTOUTDATE":"2017/02/01","PUTOUTNO":"2016090120887353"}],"datasetSize":"4"}
     * responseType : ENTITY
     */

    private String responseType;

    public ResponseBodyEntity getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(ResponseBodyEntity responseBody) {
        this.responseBody = responseBody;
    }

    public String getResponseType() {
        return responseType;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }

    public static class ResponseBodyEntity {
        private String CUSTNO;
        private String RESULTCODE;
        private String RESULTMSG;
        private String datasetSize;
        private String is_valid_token;
        /**
         * BALANCE : 0.0
         * BUSINESSSUM : 60000.0
         * COMPDINTEBALANCE : 0.0
         * CURRENCY : RMB
         * FINEINTEBALANCE : 0.0
         * LOANSTATUS : 4
         * LOANSTATUSDESC : 逾期结清
         * MATURITYDATE : 2016/09/15
         * NORMALBALANCE : 0.0
         * OVERDUEBALANCE : 0.0
         * OVERDUEDAYS : 0
         * PRDNAME : ETC保理
         * PUTOUTDATE : 2016/09/01
         * PUTOUTNO : 2016082320805211
         */

        private List<AccountModel> data;

        public String getCUSTNO() {
            return CUSTNO;
        }

        public void setCUSTNO(String CUSTNO) {
            this.CUSTNO = CUSTNO;
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

        public String getDatasetSize() {
            return datasetSize;
        }

        public void setDatasetSize(String datasetSize) {
            this.datasetSize = datasetSize;
        }

        public List<AccountModel> getData() {
            return data;
        }

        public void setData(List<AccountModel> data) {
            this.data = data;
        }

        public String getIs_valid_token() {
            return is_valid_token;
        }

        public void setIs_valid_token(String is_valid_token) {
            this.is_valid_token = is_valid_token;
        }

        public static class AccountModel {
            private String BALANCE;
            private String BUSINESSSUM;
            private String COMPDINTEBALANCE;
            private String CURRENCY;
            private String FINEINTEBALANCE;
            private String LOANSTATUS;
            private String LOANSTATUSDESC;
            private String MATURITYDATE;
            private String NORMALBALANCE;
            private String OVERDUEBALANCE;
            private int OVERDUEDAYS;
            private String PRDNAME;
            private String PUTOUTDATE;
            private String PUTOUTNO;

            public String getBALANCE() {
                return BALANCE;
            }

            public void setBALANCE(String BALANCE) {
                this.BALANCE = BALANCE;
            }

            public String getBUSINESSSUM() {
                return BUSINESSSUM;
            }

            public void setBUSINESSSUM(String BUSINESSSUM) {
                this.BUSINESSSUM = BUSINESSSUM;
            }

            public String getCOMPDINTEBALANCE() {
                return COMPDINTEBALANCE;
            }

            public void setCOMPDINTEBALANCE(String COMPDINTEBALANCE) {
                this.COMPDINTEBALANCE = COMPDINTEBALANCE;
            }

            public String getCURRENCY() {
                return CURRENCY;
            }

            public void setCURRENCY(String CURRENCY) {
                this.CURRENCY = CURRENCY;
            }

            public String getFINEINTEBALANCE() {
                return FINEINTEBALANCE;
            }

            public void setFINEINTEBALANCE(String FINEINTEBALANCE) {
                this.FINEINTEBALANCE = FINEINTEBALANCE;
            }

            public String getLOANSTATUS() {
                return LOANSTATUS;
            }

            public void setLOANSTATUS(String LOANSTATUS) {
                this.LOANSTATUS = LOANSTATUS;
            }

            public String getLOANSTATUSDESC() {
                return LOANSTATUSDESC;
            }

            public void setLOANSTATUSDESC(String LOANSTATUSDESC) {
                this.LOANSTATUSDESC = LOANSTATUSDESC;
            }

            public String getMATURITYDATE() {
                return MATURITYDATE;
            }

            public void setMATURITYDATE(String MATURITYDATE) {
                this.MATURITYDATE = MATURITYDATE;
            }

            public String getNORMALBALANCE() {
                return NORMALBALANCE;
            }

            public void setNORMALBALANCE(String NORMALBALANCE) {
                this.NORMALBALANCE = NORMALBALANCE;
            }

            public String getOVERDUEBALANCE() {
                return OVERDUEBALANCE;
            }

            public void setOVERDUEBALANCE(String OVERDUEBALANCE) {
                this.OVERDUEBALANCE = OVERDUEBALANCE;
            }

            public int getOVERDUEDAYS() {
                return OVERDUEDAYS;
            }

            public void setOVERDUEDAYS(int OVERDUEDAYS) {
                this.OVERDUEDAYS = OVERDUEDAYS;
            }

            public String getPRDNAME() {
                return PRDNAME;
            }

            public void setPRDNAME(String PRDNAME) {
                this.PRDNAME = PRDNAME;
            }

            public String getPUTOUTDATE() {
                return PUTOUTDATE;
            }

            public void setPUTOUTDATE(String PUTOUTDATE) {
                this.PUTOUTDATE = PUTOUTDATE;
            }

            public String getPUTOUTNO() {
                return PUTOUTNO;
            }

            public void setPUTOUTNO(String PUTOUTNO) {
                this.PUTOUTNO = PUTOUTNO;
            }
        }
    }
}
