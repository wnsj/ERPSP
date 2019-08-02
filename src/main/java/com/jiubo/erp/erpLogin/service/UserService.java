package com.jiubo.erp.erpLogin.service;

import com.alibaba.fastjson.JSONObject;
import com.jiubo.erp.common.MessageException;
import com.jiubo.erp.common.Result;
import com.jiubo.erp.erpLogin.bean.AccountDataBean;
import com.jiubo.erp.erpLogin.bean.AccountRuleData;
import com.jiubo.erp.erpLogin.bean.RuleDataBean;
import com.jiubo.erp.erpLogin.vo.LoginInput;
import com.jiubo.erp.erpLogin.vo.LoginOutput;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface UserService {
    //erp登录
    //LoginOutput Erplogin(LoginInput input) throws Exception;

    //Result UserRegister(AccountDataBean input) throws Exception;

    public JSONObject login(AccountDataBean bean) throws MessageException;

    List<AccountRuleData> queryRuleData(String accountId) throws MessageException;
}
