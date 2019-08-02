package com.jiubo.erp.common;

/**
 * 公共常量类
 */
public class Constant {
    /*
     * 页面应答返回值
     * */
    public static interface Result {
        final public String RETCODE = "retCode";
        final public String RETMSG = "retMsg";
        final public String SUCCESS = "0000";
        final public String ERROR = "9999";
        final public String REPEAT = "1111";
        final public String SUCCESS_MSG = "成功！";
        final public String ERROR_MSG = "系统异常！";
        public static final String RETDATA = "retData";
        public static final String RETCOUNT = "count";
        public static final String CODE = "code";
    }

    public interface Charset {
        final public static String UTF8 = "UTF-8";
        final public static String GBK = "GBK";
    }
}
