package com.jiubo.erp.erpLogin.util;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

public class ResponseMessageUtils {

    public static void responseMessage(HttpServletResponse response, String word) {
        response.setContentType("text/html;charset=UTF-8"); //设置相应内容编码
        String error = "<script>alert('" + word + "');history.back();</script>";
        if (StringUtils.isNotEmpty(word)) {
            try {
                response.getWriter().write(error);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
