package com.quicksand.push;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CorsFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;

//        String origin = request.getHeader("Origin");
//        response.setHeader("Access-Control-Allow-Origin", origin);
//        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
//        response.setHeader("Access-Control-Max-Age", "3600");
//        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,Authorization");
//        response.setHeader("Access-Control-Allow-Credentials", "true");
//        String method = request.getMethod();
//        if(method.equalsIgnoreCase("OPTIONS")){
//            servletResponse.getOutputStream().write("Success".getBytes("utf-8"));
//        }else{
//            filterChain.doFilter(servletRequest, servletResponse);
//        }


        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type,Access-Token");
        response.setHeader("Access-Control-Expose-Headers", "*");
//        response.setHeader("token", "xxx"); //设置响应头
        String method = request.getMethod();
        if (method.equalsIgnoreCase("OPTIONS")) {
        	System.out.println("请求走-----1");
            servletResponse.getOutputStream().write("Success".getBytes("utf-8"));
        } else {
        	System.out.println("请求走-----2");
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }

}
