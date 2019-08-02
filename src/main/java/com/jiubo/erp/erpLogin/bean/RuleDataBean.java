package com.jiubo.erp.erpLogin.bean;

//权限表
public class RuleDataBean {

    private String Rule_ID; // 权限编号
    private String Rule_Name;// 权限名称
    private String Rule_Group_ID;// 分组ID

    public String getRule_ID() {
        return Rule_ID;
    }

    public void setRule_ID(String rule_ID) {
        Rule_ID = rule_ID;
    }

    public String getRule_Name() {
        return Rule_Name;
    }

    public void setRule_Name(String rule_Name) {
        Rule_Name = rule_Name;
    }

    public String getRule_Group_ID() {
        return Rule_Group_ID;
    }

    public void setRule_Group_ID(String rule_Group_ID) {
        Rule_Group_ID = rule_Group_ID;
    }

}
