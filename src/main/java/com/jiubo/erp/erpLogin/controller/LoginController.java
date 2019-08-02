package com.jiubo.erp.erpLogin.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;
import com.jiubo.erp.common.Constant;
import com.jiubo.erp.common.MapUtil;
import com.jiubo.erp.common.MessageException;
import com.jiubo.erp.erpLogin.bean.AccountDataBean;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jiubo.erp.erpLogin.service.UserService;

@Controller
@RequestMapping("/ErpLogin")
public class LoginController {

    public static Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService Userservice;

    /* *
    * @desc:用户登录
    * @author: dx
    * @date: 2019-07-02 09:41:19
    * @param request :
    * @param response :
    * @return: com.alibaba.fastjson.JSONObject
    * @throws:
    * @version: 1.0
    **/
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public JSONObject login(HttpServletRequest request, HttpServletResponse response,@RequestBody String params) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            String accountName = null;
            String accountPwd = null;
            try {
                if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败！");
                Map<String, Object> requestMap = JSONObject.parseObject(params, Map.class);
                accountName = MapUtil.getString(requestMap, "accountName", MapUtil.NOT_NULL);
                accountPwd = MapUtil.getString(requestMap, "accountPwd", MapUtil.NOT_NULL);
            } catch (Exception e) {
                throw new MessageException("账号或密码为空!");
            }
            AccountDataBean account = new AccountDataBean();
            account.setAccount_Name(accountName);
            account.setAccount_Pwd(accountPwd);
            result.put(Constant.Result.RETDATA, Userservice.login(account));
        } catch (MessageException e) {
            retCode = Constant.Result.ERROR;
            retMsg = e.getMessage();
        } catch (Exception e) {
            retCode = Constant.Result.ERROR;
            retMsg = Constant.Result.ERROR_MSG;
            log.error(Constant.Result.RETMSG, e);
        } finally {
            result.put(Constant.Result.RETCODE, retCode);
            result.put(Constant.Result.RETMSG, retMsg);
            return result;
        }
    }
}

/*
     * Erp用户登录
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(LoginInput input, HttpSession session, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView();
        response.setContentType("text/html;charset=UTF-8"); //设置相应内容编码
        String error = "<script>alert('登录失败,请重试!');history.back();</script>";
        String pwError = "<script>alert('用户名或密码有误,请重新输入!');history.back();</script>";
        try {
            LoginOutput out = this.Userservice.Erplogin(input);
            if (out != null) {
                session.setAttribute("user", out);
                mv.setViewName("index");
                return mv;
            } else {
                response.getWriter().write(pwError);
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                response.getWriter().write(error);
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
        return null;
    }
      */

    /*
     * Erp用户退出

    @RequestMapping(value = "/exit", method = RequestMethod.GET)
    public String loginOut(HttpSession session, HttpServletResponse response, HttpServletRequest request) {
        response.setContentType("text/html;charset=UTF-8"); //设置相应内容编码
        String error = "<script>alert('操作失败,请重试!');history.back();</script>";
        String abpath = request.getContextPath();
        String success = "<script>window.location.href='" + abpath + "/page/login.jsp';</script>";
        try {
            session.invalidate();
            response.getWriter().write(success);
        } catch (Exception e) {
            e.printStackTrace();
            try {
                response.getWriter().write(error);
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
        return null;
    }
   */
