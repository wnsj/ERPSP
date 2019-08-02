package com.jiubo.erp.erpLogin.dao;

import java.util.List;

import com.jiubo.erp.erpLogin.bean.AccountDataBean;
import com.jiubo.erp.erpLogin.bean.AccountRuleData;
import com.jiubo.erp.erpLogin.bean.RuleDataBean;
import com.jiubo.erp.erpLogin.vo.LoginOutput;
import com.jiubo.erp.erpLogin.vo.PositionInfoOutPut;

public interface LoginDAO {

    //根据用户名查询账号信息
    AccountDataBean userLogin(AccountDataBean input);

    //根据用户id查询权限
    List<AccountRuleData> queryRuleData(String accountId);

}
/*
    List<PositionInfoOutPut> selectPositionInfoByAccoutname(AccountDataBean input);

    AccountDataBean selectByUserName(AccountDataBean input);

    Integer addAccountData(AccountDataBean input);

    Integer addRuleData(RuleDataBean input);

    Integer addAccountRuleData(AccountRuleData input);
*/
