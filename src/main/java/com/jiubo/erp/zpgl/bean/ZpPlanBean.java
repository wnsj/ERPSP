package com.jiubo.erp.zpgl.bean;

import java.io.Serializable;

//招聘计划
public class ZpPlanBean implements Serializable {
    private static final long serialVersionUID = -1554577884241697894L;
    private String planId;//计划id
    private String department;//部门
    private String position;//职位
    private String lackNum;//缺编人数
    private String planNum; //计划人数
    private String phoneNum;//邀约人数
    private String planDate;//计划月份

    private String departmentName;//部门名
    private String positionName;//职位名
    private String begDate;//查询时间
    private String endDate;//查询时间
    private String isYes;//是否完成
    private String isBack;//是否撤销

    public ZpPlanBean() {
        super();
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLackNum() {
        return lackNum;
    }

    public void setLackNum(String lackNum) {
        this.lackNum = lackNum;
    }

    public String getPlanNum() {
        return planNum;
    }

    public void setPlanNum(String planNum) {
        this.planNum = planNum;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPlanDate() {
        return planDate;
    }

    public void setPlanDate(String planDate) {
        this.planDate = planDate;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getBegDate() {
        return begDate;
    }

    public void setBegDate(String begDate) {
        this.begDate = begDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getIsYes() {
        return isYes;
    }

    public void setIsYes(String isYes) {
        this.isYes = isYes;
    }

    public String getIsBack() {
        return isBack;
    }

    public void setIsBack(String isBack) {
        this.isBack = isBack;
    }

    @Override
    public String toString() {
        return "ZpPlanBean [planId=" + planId + ", department=" + department + ", position=" + position + ", lackNum="
                + lackNum + ", planNum=" + planNum + ", phoneNum=" + phoneNum + ", planDate=" + planDate
                + ", departmentName=" + departmentName + ", positionName=" + positionName + ", begDate=" + begDate
                + ", endDate=" + endDate + ", isYes=" + isYes + ", isBack=" + isBack + "]";
    }


}
