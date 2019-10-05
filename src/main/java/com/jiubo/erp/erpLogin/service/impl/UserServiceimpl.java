package com.jiubo.erp.erpLogin.service.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.jiubo.erp.common.Constant;
import com.jiubo.erp.common.CookieTools;
import com.jiubo.erp.common.MessageException;
import com.jiubo.erp.erpLogin.bean.AccountRuleData;
import com.jiubo.erp.erpLogin.bean.RuleDataBean;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.jiubo.erp.erpLogin.bean.AccountDataBean;
import com.jiubo.erp.erpLogin.dao.LoginDAO;
import com.jiubo.erp.erpLogin.service.UserService;
import com.jiubo.erp.erpLogin.util.Md5Util;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Service
@Transactional
public class UserServiceimpl implements UserService {

    public static Logger log = LoggerFactory.getLogger(UserServiceimpl.class);

    @Autowired
    private LoginDAO dao;

    @Value("${tokenLife}")
    private int tokenLife;

    @Value("${accountLife}")
    private int accountLife;

//    public String getTokenLife() {
//        return tokenLife;
//    }
//
//    public void setTokenLife(String tokenLife) {
//        this.tokenLife = tokenLife;
//    }
//
//    public String getAccountLife() {
//        return accountLife;
//    }
//
//    public void setAccountLife(String accountLife) {
//        this.accountLife = accountLife;
//    }

    @Override
    public JSONObject login(AccountDataBean bean) throws MessageException {
        JSONObject jsonObject = new JSONObject();
        JSONObject cookieJson = new JSONObject();
        String pwd = Md5Util.md5Encrypt32Lower(bean.getAccount_Pwd());
//        log.error("accountName:{},pwd:{}", bean.getAccount_Name(), pwd);
        bean.setAccount_Pwd(pwd);
        bean.setAccount_State("在用");
        AccountDataBean accountDataBean = dao.userLogin(bean);
        if (accountDataBean == null) throw new MessageException("账号、密码错误或该账号已被停用!");
        //if ("停用".equals(accountDataBean.getAccount_State())) throw new MessageException("该账号已被停用!");
        jsonObject.put("account", accountDataBean);
        cookieJson.put("account", accountDataBean);
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        //String token = (String) request.getSession(true).getAttribute("Access-Token");
        String token = Md5Util.md5Encrypt32Lower(accountDataBean.getAccount_Name() + accountDataBean.getAccount_Pwd());
        accountDataBean.setAccount_Pwd("");
        request.getSession().setAttribute(token, accountDataBean);
        List<AccountRuleData> ruleDataBeans = queryRuleData(accountDataBean.getAccount_ID());
        //cookie存储大小为4k左右，进行cookie瘦身
        List<String> ruleIdList = new ArrayList<String>();
        for (AccountRuleData accountRuleData : ruleDataBeans) {
            ruleIdList.add(accountRuleData.getRule_ID());
        }
        jsonObject.put("accessToken", token);
        jsonObject.put("permission", ruleDataBeans);
        cookieJson.put("accessToken", token);
        cookieJson.put("permission", ruleIdList);
        jsonObject.put("smallAccountData", cookieJson);
        CookieTools.addCookie(response, "accessToken", token, tokenLife);
        try {
            CookieTools.addCookie(response, "accountData", URLEncoder.encode(cookieJson.toJSONString(), Constant.Charset.UTF8), accountLife);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    @Override
    public List<AccountRuleData> queryRuleData(String accountId) throws MessageException {
        if (StringUtils.isBlank(accountId)) throw new MessageException("账户id不能为空!");
        return dao.queryRuleData(accountId);
    }
}

    /*
     * Erp用户注册
     * 默认测试账号:admin1
     * 密码:a123456
    public Result UserRegister(AccountDataBean input) throws Exception {
        Result result = new Result<>();
        if (dao.selectByUserName(input) == null) {
            this.dao.addAccountData(input);
            result.setMessage("注册成功");
            result.setStatus("1");
        } else {
            result.setMessage("用户名已存在");
            result.setStatus("0");
        }
        return result;
    }
       */

    /*
     * 名称:ERP系统登录
     * 参数::用户名username 密码password
     * 返回值:LoginOutput

    @Override
    @Transactional
    public LoginOutput Erplogin(LoginInput input) throws Exception {
        LoginOutput in = new LoginOutput();
        AccountDataBean account = new AccountDataBean();
        if (StringUtils.isEmpty(input.getUsername()) || StringUtils.isEmpty(input.getPassword())) {
            throw new Exception("must not be null");
        }
        account.setAccount_Name(input.getUsername());
        account.setAccount_Pwd(Md5Util.md5Encrypt32Lower(input.getPassword()));
        in = dao.userLogin(account);
        if (in != null) {
            //判断权限信息
            List<PositionInfoOutPut> posits = dao.selectPositionInfoByAccoutname(account);  //根据用户名查询其权限信息
            if (!posits.isEmpty()) {
                for (PositionInfoOutPut posit : posits) {
                    if (StringUtils.isNotEmpty(posit.getPosition_Name())) {
                        if (posit.getPosition_Name().equals(Position.SUPERADMIN) || posit.getPosition_Name().equals(Position.FUZONG) || posit.getPosition_Name().equals(Position.XINGZHENG)) {
                            in.setStatus("1");
                        }
                        if (posit.getPosition_Name().equals(Position.YHZZH) || posit.getPosition_Name().equals(Position.ZXZG) || posit.getPosition_Name().equals(Position.YYXMZG)) {
                            in.setStatus("0");
                        }
                    }
                }
            }
            in.setStatus("1");
            return in;
        } else {
            return null;
        }
    }
     */
