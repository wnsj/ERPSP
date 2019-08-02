package com.quicksand.push;

import com.jiubo.erp.common.TimeUtil;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.StreamUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class ToolClass {

    /**
     * 接口数据转化成map
     *
     * @param
     * @return
     */
    public static Map<String, String> mapShiftStr(HttpServletRequest request) {
        String s;
        try {
            s = StreamUtils.copyToString(request.getInputStream(), Charset.forName("UTF-8"));
            System.out.println("--------字符串-------" + s);
            JSONObject jsonObject = JSONObject.fromObject(s);
            System.out.println("--------字符串-------" + s);
            Map<String, String> mapList = (Map<String, String>) jsonObject;
            return mapList;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    public static String getStrFromInputStream(HttpServletRequest request) throws IOException {
        return StreamUtils.copyToString(request.getInputStream(), Charset.forName("UTF-8"));
    }

    //比较两个时间字符串的大小
    public static int compare_date(String DATE1, String DATE2) {
        try {
            Date dt1 = TimeUtil.parseAnyDate(DATE1);
            Date dt2 = TimeUtil.parseAnyDate(DATE2);
            if (dt1.getTime() > dt2.getTime()) {
	                System.out.println("1"+dt1+"--"+dt2);
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
	                System.out.println("2"+dt1+"--"+dt2);
                return -1;
            } else {
                System.out.println("3" + dt1 + "--" + dt2);
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }
   
    public static String judgeStr(String string) {
        if (StringUtils.isBlank(string) || "0".equals(string)) {
            return "";
        }
        return string;
    }

    /**
     * 时间字符串格式化
     *
     * @param
     * @return
     */
    public static String strDateTimeStr(Date date) {

        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.000"); //加上时间
//        SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd"); //加上时间
        String sDate = sDateFormat.format(date);
        System.out.println("-------时间转换--------------------------" + sDate);
        return sDate;

    }

    /**
     * 时间字符串格式化
     *
     * @param
     * @return
     */
    public static String strDateTimeShiftStr(String str, Integer timeIndex) {
        str = str + "00";
        SimpleDateFormat sDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.000"); //加上时间
        SimpleDateFormat sDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.000"); //加上时间
        Date strDate;
        try {
            strDate = sDateFormat1.parse(str);
            Date dateStr = new Date(strDate.getTime() + timeIndex * 60 * 1000);
            String sDate = sDateFormat2.format(dateStr);
//			System.out.println("-------时间转换--------------------------"+dateStr);
            return sDate;
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return str;
        }
    }


    /**
     * 时间转化，将带有时分秒的年月日字符串时间格式化成年月日
     *
     * @param
     * @return
     */
    public static Date dateTimeDate(Date date) {

        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:000"); //加上时间

        try {
            String sDate = sDateFormat.format(date);
            Date newDate = sDateFormat.parse(sDate);
            System.out.println(date);
            return newDate;
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将不带时分秒的字符串时间转化成年月日
     *
     * @param dateStr
     * @return
     */
    public Date dateStr(String dateStr) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //必须捕获异常
        try {
            Date date = simpleDateFormat.parse(dateStr);
            return date;
        } catch (ParseException px) {
            px.printStackTrace();
        }
        return null;
    }

    /**
     * 判断一个时间是否在一个时间段之内
     *
     * @param nowTime
     * @param startTime
     * @param endTime
     * @return
     */
    public static boolean isEffectiveDate(Date nowTime, Date startTime, Date endTime) {
        if (nowTime.getTime() == startTime.getTime()
                || nowTime.getTime() == endTime.getTime()) {
            return true;
        }

        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(startTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        if (date.after(begin) && date.before(end)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取当前的时间
     *
     * @return
     */
    public static String inquirNowDateTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:000");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
        String newDate = df.format(new Date());
        return newDate;
    }

    /**
     * 获取当前的时间
     *
     * @return
     */
    public static String inquirNowDate() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
        String newDate = df.format(new Date());
        return newDate;
    }

    /**
     * 通过HttpServletRequest返回IP地址
     *
     * @param request HttpServletRequest
     * @return ip String
     * @throws Exception
     */
    public String getIpAddr(HttpServletRequest request) throws Exception {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * 通过IP地址获取MAC地址
     *
     * @param ip String,127.0.0.1格式
     * @return mac String
     * @throws Exception
     */
    public String getMACAddress(String ip) throws Exception {
        String line = "";
        String macAddress = "";
        final String MAC_ADDRESS_PREFIX = "MAC Address = ";
        final String LOOPBACK_ADDRESS = "127.0.0.1";
        //如果为127.0.0.1,则获取本地MAC地址。
        if (LOOPBACK_ADDRESS.equals(ip)) {
            InetAddress inetAddress = InetAddress.getLocalHost();
            //貌似此方法需要JDK1.6。
            byte[] mac = NetworkInterface.getByInetAddress(inetAddress).getHardwareAddress();
            //下面代码是把mac地址拼装成String
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mac.length; i++) {
                if (i != 0) {
                    sb.append("-");
                }
                //mac[i] & 0xFF 是为了把byte转化为正整数
                String s = Integer.toHexString(mac[i] & 0xFF);
                sb.append(s.length() == 1 ? 0 + s : s);
            }
            //把字符串所有小写字母改为大写成为正规的mac地址并返回
            macAddress = sb.toString().trim().toUpperCase();
            return macAddress;
        }
        //获取非本地IP的MAC地址
        try {
            Process p = Runtime.getRuntime().exec("nbtstat -A " + ip);
            InputStreamReader isr = new InputStreamReader(p.getInputStream());
            BufferedReader br = new BufferedReader(isr);
            while ((line = br.readLine()) != null) {
                if (line != null) {
                    int index = line.indexOf(MAC_ADDRESS_PREFIX);
                    if (index != -1) {
                        macAddress = line.substring(index + MAC_ADDRESS_PREFIX.length()).trim().toUpperCase();
                    }
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
        return macAddress;
    }
}
