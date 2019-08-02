package com.jiubo.erp.kqgl.vo;

//班次  班次表中使用的userId是accountId
public class ClassTime {
    private String accountId;
    private String ctName;//班次名称
    private String ctShiftDate;
    private String ctStartTime;
    private String ctEndTime;


    private String ctStartDate;
    private String ctEndDate;

    public ClassTime() {
        // TODO Auto-generated constructor stub
    }

    public String getCtStartDate() {
        return ctStartDate;
    }

    public void setCtStartDate(String ctStartDate) {
        this.ctStartDate = ctStartDate;
    }

    public String getCtEndDate() {
        return ctEndDate;
    }

    public void setCtEndDate(String ctEndDate) {
        this.ctEndDate = ctEndDate;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getCtName() {
        return ctName;
    }

    public void setCtName(String ctName) {
        this.ctName = ctName;
    }

    public String getCtShiftDate() {
        return ctShiftDate;
    }

    public void setCtShiftDate(String ctShiftDate) {
        this.ctShiftDate = ctShiftDate;
    }

    public String getCtStartTime() {
        return ctStartTime;
    }

    public void setCtStartTime(String ctStartTime) {
        this.ctStartTime = ctStartTime;
    }

    public String getCtEndTime() {
        return ctEndTime;
    }

    public void setCtEndTime(String ctEndTime) {
        this.ctEndTime = ctEndTime;
    }

}
