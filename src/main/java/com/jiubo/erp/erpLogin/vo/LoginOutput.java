package com.jiubo.erp.erpLogin.vo;

public class LoginOutput {

    private String Acount_ID;
    private String Rule_ID;
    private String ar_id;
    private String Rule_name;
    private String account_name;
    private String account_pwd;
    private String account_state;
    private String status; //权限值


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAcount_ID() {
        return Acount_ID;
    }

    public void setAcount_ID(String acount_ID) {
        Acount_ID = acount_ID;
    }

    public String getRule_ID() {
        return Rule_ID;
    }

    public void setRule_ID(String rule_ID) {
        Rule_ID = rule_ID;
    }

    public String getAr_id() {
        return ar_id;
    }

    public void setAr_id(String ar_id) {
        this.ar_id = ar_id;
    }

    public String getRule_name() {
        return Rule_name;
    }

    public void setRule_name(String rule_name) {
        Rule_name = rule_name;
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public String getAccount_pwd() {
        return account_pwd;
    }

    public void setAccount_pwd(String account_pwd) {
        this.account_pwd = account_pwd;
    }

    public String getAccount_state() {
        return account_state;
    }

    public void setAccount_state(String account_state) {
        this.account_state = account_state;
    }

}
