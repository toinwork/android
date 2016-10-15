package com.toin.glp;

public class Config {
    public static final boolean MDEBUG        = Boolean.parseBoolean("true");
    /** 环境——动态配置项 */
    public static ProgramMode   mode          = ProgramMode.PROGRAM_TEST_MODE;
    /** 是否调试 */
    public static final boolean DEBUG         = !(mode == ProgramMode.PRGRAM_PRODUCT_MODE);

    /** 接口信息 */
    /** 域名 */
    public static String        API_WEIJIN    = "";
    public static String        API_FINANCING = "";
    public static String        VERSION       = "1.0";

    static {
        switch (mode) {
            case PRGRAM_PRODUCT_MODE:
                API_FINANCING = "https://credit.glp168.com/scf/appdata/service.do";
                API_WEIJIN = "https://acco.glp168.com/appserver/gateway/member.do";
                break;
            case PRGRAM_PREPRODUCT_MODE:
                API_FINANCING = "http://203.114.247.185:8888/scf/appdata/service.do";
                API_WEIJIN = "http://func109.vfinance.cn/appserver/gateway/member.do";
                break;
            case PROGRAM_TEST_MODE:
                API_FINANCING = "http://203.114.247.185:8888/scf/appdata/service.do";
                API_WEIJIN = "http://func109.vfinance.cn/appserver/gateway/";
                break;
            case PROGRAM_DEV_MODE:
                API_FINANCING = "http://203.114.247.185:8888/scf/appdata/service.do";
                API_WEIJIN = "http://func109.vfinance.cn/appserver/gateway/member.do";
                break;
        }
    }

    public static String        phone         = "0571-56921002";

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
