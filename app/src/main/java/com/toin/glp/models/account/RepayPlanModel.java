package com.toin.glp.models.account;

import java.util.List;

/**
 * Created by hb on 16/9/19.
 */
public class RepayPlanModel {

    /**
     * PAYMENTLIST : [{"ACTUALPAYCOMPDINTEAMT":"0.0","ACTUALPAYFINEAMT":"0.0","ACTUALPAYINTEAMT":"0.0","ACTUALPAYPRINCIPALAMT":"84000.0","ACTUALRECIEVEAMOUNT":"840.0","PAYCOMPDINTEAMT":"0.0","PAYDATE":"2016/10/05","PAYFINEAMT":"0.0","PAYINTEAMT":"0.0","PAYPRINCIPALAMT":"84000.0","SEQID":"0","TOTALAMOUNT":"840.0"}]
     * RESULTCODE : 000000
     * RESULTMSG : 操作成功
     * SUMCOUNT : 1
     * SUMPAGENUM : 1
     */

    private ResponseBodyEntity responseBody;
    /**
     * responseBody : {"PAYMENTLIST":[{"ACTUALPAYCOMPDINTEAMT":"0.0","ACTUALPAYFINEAMT":"0.0","ACTUALPAYINTEAMT":"0.0","ACTUALPAYPRINCIPALAMT":"84000.0","ACTUALRECIEVEAMOUNT":"840.0","PAYCOMPDINTEAMT":"0.0","PAYDATE":"2016/10/05","PAYFINEAMT":"0.0","PAYINTEAMT":"0.0","PAYPRINCIPALAMT":"84000.0","SEQID":"0","TOTALAMOUNT":"840.0"}],"RESULTCODE":"000000","RESULTMSG":"操作成功","SUMCOUNT":1,"SUMPAGENUM":1}
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
        private String RESULTCODE;
        private String RESULTMSG;
        private int SUMCOUNT;
        private int SUMPAGENUM;
        /**
         * ACTUALPAYCOMPDINTEAMT : 0.0
         * ACTUALPAYFINEAMT : 0.0
         * ACTUALPAYINTEAMT : 0.0
         * ACTUALPAYPRINCIPALAMT : 84000.0
         * ACTUALRECIEVEAMOUNT : 840.0
         * PAYCOMPDINTEAMT : 0.0
         * PAYDATE : 2016/10/05
         * PAYFINEAMT : 0.0
         * PAYINTEAMT : 0.0
         * PAYPRINCIPALAMT : 84000.0
         * SEQID : 0
         * TOTALAMOUNT : 840.0
         */

        private List<PlanModel> PAYMENTLIST;

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

        public int getSUMCOUNT() {
            return SUMCOUNT;
        }

        public void setSUMCOUNT(int SUMCOUNT) {
            this.SUMCOUNT = SUMCOUNT;
        }

        public int getSUMPAGENUM() {
            return SUMPAGENUM;
        }

        public void setSUMPAGENUM(int SUMPAGENUM) {
            this.SUMPAGENUM = SUMPAGENUM;
        }

        public List<PlanModel> getPAYMENTLIST() {
            return PAYMENTLIST;
        }

        public void setPAYMENTLIST(List<PlanModel> PAYMENTLIST) {
            this.PAYMENTLIST = PAYMENTLIST;
        }

        public static class PlanModel {
            private String ACTUALPAYCOMPDINTEAMT;
            private String ACTUALPAYFINEAMT;
            private String ACTUALPAYINTEAMT;
            private String ACTUALPAYPRINCIPALAMT;
            private String ACTUALRECIEVEAMOUNT;
            private String PAYCOMPDINTEAMT;
            private String PAYDATE;
            private String PAYFINEAMT;
            private String PAYINTEAMT;
            private String PAYPRINCIPALAMT;
            private String SEQID;
            private String TOTALAMOUNT;

            public String getACTUALPAYCOMPDINTEAMT() {
                return ACTUALPAYCOMPDINTEAMT;
            }

            public void setACTUALPAYCOMPDINTEAMT(String ACTUALPAYCOMPDINTEAMT) {
                this.ACTUALPAYCOMPDINTEAMT = ACTUALPAYCOMPDINTEAMT;
            }

            public String getACTUALPAYFINEAMT() {
                return ACTUALPAYFINEAMT;
            }

            public void setACTUALPAYFINEAMT(String ACTUALPAYFINEAMT) {
                this.ACTUALPAYFINEAMT = ACTUALPAYFINEAMT;
            }

            public String getACTUALPAYINTEAMT() {
                return ACTUALPAYINTEAMT;
            }

            public void setACTUALPAYINTEAMT(String ACTUALPAYINTEAMT) {
                this.ACTUALPAYINTEAMT = ACTUALPAYINTEAMT;
            }

            public String getACTUALPAYPRINCIPALAMT() {
                return ACTUALPAYPRINCIPALAMT;
            }

            public void setACTUALPAYPRINCIPALAMT(String ACTUALPAYPRINCIPALAMT) {
                this.ACTUALPAYPRINCIPALAMT = ACTUALPAYPRINCIPALAMT;
            }

            public String getACTUALRECIEVEAMOUNT() {
                return ACTUALRECIEVEAMOUNT;
            }

            public void setACTUALRECIEVEAMOUNT(String ACTUALRECIEVEAMOUNT) {
                this.ACTUALRECIEVEAMOUNT = ACTUALRECIEVEAMOUNT;
            }

            public String getPAYCOMPDINTEAMT() {
                return PAYCOMPDINTEAMT;
            }

            public void setPAYCOMPDINTEAMT(String PAYCOMPDINTEAMT) {
                this.PAYCOMPDINTEAMT = PAYCOMPDINTEAMT;
            }

            public String getPAYDATE() {
                return PAYDATE;
            }

            public void setPAYDATE(String PAYDATE) {
                this.PAYDATE = PAYDATE;
            }

            public String getPAYFINEAMT() {
                return PAYFINEAMT;
            }

            public void setPAYFINEAMT(String PAYFINEAMT) {
                this.PAYFINEAMT = PAYFINEAMT;
            }

            public String getPAYINTEAMT() {
                return PAYINTEAMT;
            }

            public void setPAYINTEAMT(String PAYINTEAMT) {
                this.PAYINTEAMT = PAYINTEAMT;
            }

            public String getPAYPRINCIPALAMT() {
                return PAYPRINCIPALAMT;
            }

            public void setPAYPRINCIPALAMT(String PAYPRINCIPALAMT) {
                this.PAYPRINCIPALAMT = PAYPRINCIPALAMT;
            }

            public String getSEQID() {
                return SEQID;
            }

            public void setSEQID(String SEQID) {
                this.SEQID = SEQID;
            }

            public String getTOTALAMOUNT() {
                return TOTALAMOUNT;
            }

            public void setTOTALAMOUNT(String TOTALAMOUNT) {
                this.TOTALAMOUNT = TOTALAMOUNT;
            }
        }
    }
}
