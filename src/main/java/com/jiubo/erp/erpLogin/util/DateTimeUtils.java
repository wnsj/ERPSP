package com.jiubo.erp.erpLogin.util;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateTimeUtils {
    public static final String DEFAULT_START_DATE = "1900-1-1";

    public static final String YMD = "yyyy-MM-dd";

    public static final String _YMD = "yyyy-M-d";

    public static final String YM = "yyyy-MM";

    public static final String YMDHM = "yyyy-MM-dd HH:mm";

    public static final String YMDHMS = "yyyy-MM-dd HH:mm:ss";

    public static final String YMDHMSS = "yyyy-MM-dd HH:mm:ss:SS";

    public static final String HMS = "HH:mm:ss";

    public static final String YMDHMS_STR = "yyyyMMddHHmmss";

    public static final String TIME_STEMP = "yyMMddHHmmssssss";

    public static final String TIME_STEMPS = "yyMMdd";

    public static final String Y = "yyyy";

    public static final String M = "MM";

    public static final String D = "dd";

    public static final String MD = "M-dd";

    public static final String MD_ZH = "MM月dd日";

    /**
     * @Title: str2Date @Description: TODO(将string
     * 按指定格式转化为java.util.Date) @param: @param str @param: @param
     * format @param: @return @param: @throws ParseException @return:
     * Date @throws
     */
    public static Date str2Date(String str, String format) throws ParseException {
        if (str == null || "".equals(str)) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.parse(str);
    }

    /**
     * @Title: date2str @Description: TODO(将java.util.Date
     * 按指定格式转化为String) @param: @param date @param: @param
     * format @param: @return @return: String @throws
     */
    public static String date2str(Date date, String format) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    // 产生时间戳新文件名
    public static final String getDateFileName() {
        long currentTime = System.currentTimeMillis();
        SimpleDateFormat formatter = new SimpleDateFormat(YMDHMS_STR);
        Date date = new Date(currentTime);
        return formatter.format(date);
    }

    public static Date getCurrentDate() {
        return new Date();
    }

    public static Long getCurrentDateStamp() {
        return new Date().getTime();
    }
}
