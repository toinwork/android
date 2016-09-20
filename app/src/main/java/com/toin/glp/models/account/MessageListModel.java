package com.toin.glp.models.account;

import java.util.List;

/**
 * 消息列表 Created by hb on 16/9/19.
 */
public class MessageListModel {

    /**
     * RESULTCODE : 000000 RESULTMSG : 操作成功 SUMPAGENUM : 4 data :
     * [{"CUSTNAME":"普洛斯测试01","CUSTNO":"2016082320802214","DETAIL":
     * "您的贷款[借据号：2016082320805211],于[实际放款日期：null],成功放款[贷款金额：25000.0]元！"
     * ,"ID":"2016082320805302"
     * ,"INPUTDATE":"2016/08/30","PARAMINFO":"LoanSuccess@2016082320805211"
     * ,"SOURCE"
     * :"","STATUS":"01","TYPE":"LoanSuccess","USERID":"ywjb"},{"CUSTNAME"
     * :"普洛斯测试01","CUSTNO":"2016082320802214","DETAIL":
     * "您的贷款[借据号：2016082320805211],于[实际放款日期：null],成功放款[贷款金额：20000.0]元！"
     * ,"ID":"2016082320805515"
     * ,"INPUTDATE":"2016/08/31","PARAMINFO":"LoanSuccess@2016082320805409"
     * ,"SOURCE"
     * :"","STATUS":"01","TYPE":"LoanSuccess","USERID":"ywjb"},{"CUSTNAME"
     * :"普洛斯测试01","CUSTNO":"2016082320802214","DETAIL":
     * "您的贷款[借据号：2016082320805712],于[实际放款日期：null],成功放款[贷款金额：20000.0]元！"
     * ,"ID":"2016082320806308"
     * ,"INPUTDATE":"2016/09/02","PARAMINFO":"LoanSuccess@2016082320805712"
     * ,"SOURCE"
     * :"","STATUS":"01","TYPE":"LoanSuccess","USERID":"ywjb"},{"CUSTNAME"
     * :"普洛斯测试01","CUSTNO":"2016082320802214","DETAIL":
     * "您的贷款[借据号：2016082320805211],需在[还款日：2016/09/15],还款[还款金额：50600.0]元！还剩[到期天数：3天]到期,为维护您良好的信用记录，请及时还款！"
     * ,"ID":"2016082320810269","INPUTDATE":"2016/09/12","SOURCE":"","STATUS":
     * "01","TYPE":"repayDue","USERID":"ywjb"},{"CUSTNAME":"普洛斯测试01","CUSTNO":
     * "2016082320802214","DETAIL":
     * "您的贷款[借据号：2016082320805211],需在[还款日：2016/09/15],还款[还款金额：50600.0]元！今日到期,为维护您良好的信用记录，请及时还款！"
     * ,"ID":"2016082320810313","INPUTDATE":"2016/09/15","SOURCE":"","STATUS":
     * "01","TYPE":"repayDue","USERID":"ywjb"},{"CUSTNAME":"普洛斯测试01","CUSTNO":
     * "2016082320802214"
     * ,"DETAIL":"您的还款申请 2016082320810314 已成功！ ","ID":"2016082420812234"
     * ,"INPUTDATE"
     * :"2016/08/24","SOURCE":"","STATUS":"01","TYPE":"Repayment","USERID"
     * :"ywjb"},{"CUSTNAME":"普洛斯测试01","CUSTNO":"2016082320802214","DETAIL":
     * "您的贷款[借据号：2016082320805712],于[实际放款日期：null],成功放款[贷款金额：4000.0]元！"
     * ,"ID":"2016082420822377"
     * ,"INPUTDATE":"2016/10/01","PARAMINFO":"LoanSuccess@2016082420822304"
     * ,"SOURCE"
     * :"","STATUS":"01","TYPE":"LoanSuccess","USERID":"ywjb"},{"CUSTNAME"
     * :"普洛斯测试01","CUSTNO":"2016082320802214","DETAIL":
     * "您的贷款[借据号：2016082420822441],于[实际放款日期：null],成功放款[贷款金额：4000.0]元！"
     * ,"ID":"2016082420822607"
     * ,"INPUTDATE":"2016/10/03","PARAMINFO":"LoanSuccess@2016082420822441"
     * ,"SOURCE"
     * :"","STATUS":"01","TYPE":"LoanSuccess","USERID":"ywjb"},{"CUSTNAME"
     * :"普洛斯测试01","CUSTNO":"2016082320802214","DETAIL":
     * "您的贷款[借据号：2016082420822441],于[实际放款日期：null],成功放款[贷款金额：5000.0]元！"
     * ,"ID":"2016082520835405"
     * ,"INPUTDATE":"2016/10/07","PARAMINFO":"LoanSuccess@2016082520827482"
     * ,"SOURCE"
     * :"","STATUS":"01","TYPE":"LoanSuccess","USERID":"ywjb"},{"CUSTNAME"
     * :"普洛斯测试01","CUSTNO":"2016082320802214","DETAIL":
     * "您的贷款[借据号：2016082420822441],于[实际放款日期：null],成功放款[贷款金额：63001.0]元！"
     * ,"ID":"2016082920865844"
     * ,"INPUTDATE":"2016/11/02","PARAMINFO":"LoanSuccess@2016082920865588"
     * ,"SOURCE":"","STATUS":"01","TYPE":"LoanSuccess","USERID":"ywjb"}]
     * datasetSize : 36
     */

    private ResponseBodyEntity responseBody;
    /**
     * responseBody :
     * {"RESULTCODE":"000000","RESULTMSG":"操作成功","SUMPAGENUM":"4",
     * "data":[{"CUSTNAME":"普洛斯测试01","CUSTNO":"2016082320802214","DETAIL":
     * "您的贷款[借据号：2016082320805211],于[实际放款日期：null],成功放款[贷款金额：25000.0]元！"
     * ,"ID":"2016082320805302"
     * ,"INPUTDATE":"2016/08/30","PARAMINFO":"LoanSuccess@2016082320805211"
     * ,"SOURCE"
     * :"","STATUS":"01","TYPE":"LoanSuccess","USERID":"ywjb"},{"CUSTNAME"
     * :"普洛斯测试01","CUSTNO":"2016082320802214","DETAIL":
     * "您的贷款[借据号：2016082320805211],于[实际放款日期：null],成功放款[贷款金额：20000.0]元！"
     * ,"ID":"2016082320805515"
     * ,"INPUTDATE":"2016/08/31","PARAMINFO":"LoanSuccess@2016082320805409"
     * ,"SOURCE"
     * :"","STATUS":"01","TYPE":"LoanSuccess","USERID":"ywjb"},{"CUSTNAME"
     * :"普洛斯测试01","CUSTNO":"2016082320802214","DETAIL":
     * "您的贷款[借据号：2016082320805712],于[实际放款日期：null],成功放款[贷款金额：20000.0]元！"
     * ,"ID":"2016082320806308"
     * ,"INPUTDATE":"2016/09/02","PARAMINFO":"LoanSuccess@2016082320805712"
     * ,"SOURCE"
     * :"","STATUS":"01","TYPE":"LoanSuccess","USERID":"ywjb"},{"CUSTNAME"
     * :"普洛斯测试01","CUSTNO":"2016082320802214","DETAIL":
     * "您的贷款[借据号：2016082320805211],需在[还款日：2016/09/15],还款[还款金额：50600.0]元！还剩[到期天数：3天]到期,为维护您良好的信用记录，请及时还款！"
     * ,"ID":"2016082320810269","INPUTDATE":"2016/09/12","SOURCE":"","STATUS":
     * "01","TYPE":"repayDue","USERID":"ywjb"},{"CUSTNAME":"普洛斯测试01","CUSTNO":
     * "2016082320802214","DETAIL":
     * "您的贷款[借据号：2016082320805211],需在[还款日：2016/09/15],还款[还款金额：50600.0]元！今日到期,为维护您良好的信用记录，请及时还款！"
     * ,"ID":"2016082320810313","INPUTDATE":"2016/09/15","SOURCE":"","STATUS":
     * "01","TYPE":"repayDue","USERID":"ywjb"},{"CUSTNAME":"普洛斯测试01","CUSTNO":
     * "2016082320802214"
     * ,"DETAIL":"您的还款申请 2016082320810314 已成功！ ","ID":"2016082420812234"
     * ,"INPUTDATE"
     * :"2016/08/24","SOURCE":"","STATUS":"01","TYPE":"Repayment","USERID"
     * :"ywjb"},{"CUSTNAME":"普洛斯测试01","CUSTNO":"2016082320802214","DETAIL":
     * "您的贷款[借据号：2016082320805712],于[实际放款日期：null],成功放款[贷款金额：4000.0]元！"
     * ,"ID":"2016082420822377"
     * ,"INPUTDATE":"2016/10/01","PARAMINFO":"LoanSuccess@2016082420822304"
     * ,"SOURCE"
     * :"","STATUS":"01","TYPE":"LoanSuccess","USERID":"ywjb"},{"CUSTNAME"
     * :"普洛斯测试01","CUSTNO":"2016082320802214","DETAIL":
     * "您的贷款[借据号：2016082420822441],于[实际放款日期：null],成功放款[贷款金额：4000.0]元！"
     * ,"ID":"2016082420822607"
     * ,"INPUTDATE":"2016/10/03","PARAMINFO":"LoanSuccess@2016082420822441"
     * ,"SOURCE"
     * :"","STATUS":"01","TYPE":"LoanSuccess","USERID":"ywjb"},{"CUSTNAME"
     * :"普洛斯测试01","CUSTNO":"2016082320802214","DETAIL":
     * "您的贷款[借据号：2016082420822441],于[实际放款日期：null],成功放款[贷款金额：5000.0]元！"
     * ,"ID":"2016082520835405"
     * ,"INPUTDATE":"2016/10/07","PARAMINFO":"LoanSuccess@2016082520827482"
     * ,"SOURCE"
     * :"","STATUS":"01","TYPE":"LoanSuccess","USERID":"ywjb"},{"CUSTNAME"
     * :"普洛斯测试01","CUSTNO":"2016082320802214","DETAIL":
     * "您的贷款[借据号：2016082420822441],于[实际放款日期：null],成功放款[贷款金额：63001.0]元！"
     * ,"ID":"2016082920865844"
     * ,"INPUTDATE":"2016/11/02","PARAMINFO":"LoanSuccess@2016082920865588"
     * ,"SOURCE"
     * :"","STATUS":"01","TYPE":"LoanSuccess","USERID":"ywjb"}],"datasetSize"
     * :"36"} responseType : ENTITY
     */

    private String             responseType;

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
        private String             RESULTCODE;
        private String             RESULTMSG;
        private String             SUMPAGENUM;
        private String             datasetSize;
        /**
         * CUSTNAME : 普洛斯测试01 CUSTNO : 2016082320802214 DETAIL :
         * 您的贷款[借据号：2016082320805211],于[实际放款日期：null],成功放款[贷款金额：25000.0]元！ ID :
         * 2016082320805302 INPUTDATE : 2016/08/30 PARAMINFO : LoanSuccess@2016082320805211
         * SOURCE : STATUS : 01 TYPE : LoanSuccess USERID : ywjb
         */

        private List<MessageModel> data;

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

        public String getSUMPAGENUM() {
            return SUMPAGENUM;
        }

        public void setSUMPAGENUM(String SUMPAGENUM) {
            this.SUMPAGENUM = SUMPAGENUM;
        }

        public String getDatasetSize() {
            return datasetSize;
        }

        public void setDatasetSize(String datasetSize) {
            this.datasetSize = datasetSize;
        }

        public List<MessageModel> getData() {
            return data;
        }

        public void setData(List<MessageModel> data) {
            this.data = data;
        }
    }
}
