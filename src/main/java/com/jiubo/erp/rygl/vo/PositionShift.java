package com.jiubo.erp.rygl.vo;

public class PositionShift {
    private String accountId;
    private String oldDepartmentId;
    private String oldDepartmentName;
    private String newDepartmentId;
    private String newDepartmentName;
    private String oldPositionId;
    private String oldPositionName;
    private String newPositionId;
    private String newPositionName;
    private String upDateTime;
    private String Flag;

    public String getAccountId() {
        return accountId;
    }

    @Override
    public String toString() {
        return "PositionShift{" +
                "accountId='" + accountId + '\'' +
                ", oldDepartmentId='" + oldDepartmentId + '\'' +
                ", oldDepartmentName='" + oldDepartmentName + '\'' +
                ", newDepartmentId='" + newDepartmentId + '\'' +
                ", newDepartmentName='" + newDepartmentName + '\'' +
                ", oldPositionId='" + oldPositionId + '\'' +
                ", oldPositionName='" + oldPositionName + '\'' +
                ", newPositionId='" + newPositionId + '\'' +
                ", newPositionName='" + newPositionName + '\'' +
                ", upDateTime='" + upDateTime + '\'' +
                ", Flag='" + Flag + '\'' +
                '}';
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

    public String getOldDepartmentName() {
        return oldDepartmentName;
    }

    public void setOldDepartmentName(String oldDepartmentName) {
        this.oldDepartmentName = oldDepartmentName;
    }

    public String getNewDepartmentId() {
        return newDepartmentId;
    }

    public void setNewDepartmentId(String newDepartmentId) {
        this.newDepartmentId = newDepartmentId;
    }

    public String getNewDepartmentName() {
        return newDepartmentName;
    }

    public void setNewDepartmentName(String newDepartmentName) {
        this.newDepartmentName = newDepartmentName;
    }

    public String getOldPositionId() {
        return oldPositionId;
    }

    public void setOldPositionId(String oldPositionId) {
        this.oldPositionId = oldPositionId;
    }

    public String getOldPositionName() {
        return oldPositionName;
    }

    public void setOldPositionName(String oldPositionName) {
        this.oldPositionName = oldPositionName;
    }

    public String getNewPositionId() {
        return newPositionId;
    }

    public void setNewPositionId(String newPositionId) {
        this.newPositionId = newPositionId;
    }

    public String getNewPositionName() {
        return newPositionName;
    }

    public void setNewPositionName(String newPositionName) {
        this.newPositionName = newPositionName;
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
