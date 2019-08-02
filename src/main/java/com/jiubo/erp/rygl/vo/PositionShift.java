package com.jiubo.erp.rygl.vo;

public class PositionShift {
    private String accountId;
    private String oldDepartmentId;
    private String newDepartmentId;
    private String oldPositionId;
    private String newPositionId;
    private String upDateTime;
    private String Flag;

    public PositionShift() {
        // TODO Auto-generated constructor stub
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getOldDepartmentId() {
        return oldDepartmentId;
    }

    public void setOldDepartmentId(String oldDepartmentId) {
        this.oldDepartmentId = oldDepartmentId;
    }

    public String getNewDepartmentId() {
        return newDepartmentId;
    }

    public void setNewDepartmentId(String newDepartmentId) {
        this.newDepartmentId = newDepartmentId;
    }

    public String getOldPositionId() {
        return oldPositionId;
    }

    public void setOldPositionId(String oldPositionId) {
        this.oldPositionId = oldPositionId;
    }

    public String getNewPositionId() {
        return newPositionId;
    }

    public void setNewPositionId(String newPositionId) {
        this.newPositionId = newPositionId;
    }

    public String getUpDateTime() {
        return upDateTime;
    }

    public void setUpDateTime(String upDateTime) {
        this.upDateTime = upDateTime;
    }

    public String getFlag() {
        return Flag;
    }

    public void setFlag(String flag) {
        Flag = flag;
    }

}
