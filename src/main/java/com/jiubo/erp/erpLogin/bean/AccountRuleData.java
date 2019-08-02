package com.jiubo.erp.erpLogin.bean;

import java.io.Serializable;

//账号权限表
public class AccountRuleData implements Serializable{

    private static final long serialVersionUID = -5450845031317993393L;

    private String A_R_ID; //编号
    private String Account_ID;//账号主键
    private String Rule_ID; //角色主键
    private RuleDataBean ruleDataBean;//权限

    public String getA_R_ID() {
        return A_R_ID;
    }

    public void setA_R_ID(String a_R_ID) {
        A_R_ID = a_R_ID;
    }

    public String getAccount_ID() {
        return Account_ID;
    }

    public void setAccount_ID(String account_ID) {
        Account_ID = account_ID;
    }

    public String getRule_ID() {
        return Rule_ID;
    }

    public void setRule_ID(String rule_ID) {
        Rule_ID = rule_ID;
    }

    public RuleDataBean getRuleDataBean() {
        return ruleDataBean;
    }

    public void setRuleDataBean(RuleDataBean ruleDataBean) {
        this.ruleDataBean = ruleDataBean;
    }

    @Override
    public String toString() {
        return "AccountRuleData{" +
                "A_R_ID='" + A_R_ID + '\'' +
                ", Account_ID='" + Account_ID + '\'' +
                ", Rule_ID='" + Rule_ID + '\'' +
                ", ruleDataBean=" + ruleDataBean +
                '}';
    }
}
