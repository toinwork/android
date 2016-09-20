package com.toin.glp.models.account;

/**
 * 设置消息为已读 Created by hb on 16/9/20.
 */
public class SetMessageModel {
    /**
     * MOBILE : 18605914471 RESULTCODE : 000000 RESULTMSG : 操作成功 STATUS : 02
     * datasetSize : 0
     */

    private ResponseBodyEntity responseBody;

    public ResponseBodyEntity getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(ResponseBodyEntity responseBody) {
        this.responseBody = responseBody;
    }

    public static class ResponseBodyEntity {
        private String MOBILE;
        private String RESULTCODE;
        private String RESULTMSG;
        private String STATUS;
        private int    datasetSize;

        public String getMOBILE() {
            return MOBILE;
        }

        public void setMOBILE(String MOBILE) {
            this.MOBILE = MOBILE;
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

        public String getSTATUS() {
            return STATUS;
        }

        public void setSTATUS(String STATUS) {
            this.STATUS = STATUS;
        }

        public int getDatasetSize() {
            return datasetSize;
        }

        public void setDatasetSize(int datasetSize) {
            this.datasetSize = datasetSize;
        }
    }
}
