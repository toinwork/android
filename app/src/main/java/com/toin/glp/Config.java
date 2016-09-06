package com.toin.glp;

public class Config {
    public static final boolean MDEBUG        = Boolean.parseBoolean("true");
    /** 环境——动态配置项 */
    public static ProgramMode   mode          = ProgramMode.PROGRAM_TEST_MODE;
    /** 是否调试 */
    public static final boolean DEBUG         = !(mode == ProgramMode.PRGRAM_PRODUCT_MODE);

    /** 接口信息 */
    /** 域名 */
    public static String        API_AGENT     = "";
    public static String        API_AGENT_TWO = "";
    public static String        apiVersion    = "api/v1/";
    public static String        VERSION       = "1.0.0";

    public static String        appSecurity   = "";

    static {
        switch (mode) {
            case PRGRAM_PRODUCT_MODE:
                API_AGENT = "http://tiw.upadd.cn/";
                break;
            case PRGRAM_PREPRODUCT_MODE:
                API_AGENT = "http://tiw.upadd.cn/";
                break;
            case PROGRAM_TEST_MODE:
                //                API_AGENT = "http://120.26.86.129/";
                API_AGENT = "http://tiw.upadd.cn/";
                break;
            case PROGRAM_DEV_MODE:
                API_AGENT = "http://tiw.upadd.cn/";
                break;
        }
    }

    /** 社会化组件 */
    public static String        WXAppID       = "wxc145914447d24b65";                        //微信key
    public static String        WXAppSecret   = "b455e198da81676bb68f8e3894a47a99";
    public static String        QQAppID       = "1105253653";                                //qqkey
    public static String        QQAppSecret   = "hQeQ62I3FjbTjYuq";
    public static String        SINAAppID     = "3819933553";
    public static String        SINAAppSecret = "aeef7db53666b433e31a3fdc1ea5f40d";

    public static String        phone         = "0571-56921002";

    public static final String  STORE_DETAIL  = "http://html.isspu.com/detail.html?room_id=";

    public static final String  SHARE_URL     = "http://html.isspu.com/share.html?room_id=";

    /**
     * 系统运行环境参数
     */
    public enum ProgramMode {
        /** 线上参数 */
        PRGRAM_PRODUCT_MODE,
        /** 预发参数 */
        PRGRAM_PREPRODUCT_MODE,
        /** 测试参数 */
        PROGRAM_TEST_MODE,
        /** 开发参数 */
        PROGRAM_DEV_MODE
    }

}
