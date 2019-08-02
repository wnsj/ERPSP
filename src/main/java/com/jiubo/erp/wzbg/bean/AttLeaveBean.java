package com.jiubo.erp.wzbg.bean;

import java.io.Serializable;

//请假信息
public class AttLeaveBean implements Serializable {

    private static final long serialVersionUID = -1632154974077532588L;
    private String id;
    private String accountId;//用户ID
	private String jobNum;//工号
    private String leaveTypeId;//请假类别
    private String startTime;//开始时间
    private String endTime;//结束时间
    private String totleTime;//总计时间
    private String totleDate;//总计天数
    private String reason;//请假事由
    private String appliCant;//申请人
    private String appliDate;//申请时间
    private String verifier;//审核人
    private String verifyDate;//审核时间
    private String status;//审核状态
    private String isDelete;//是否有效
    private String createDate;//创建时间
    private String creator;//创建者

    /*非数据库字段*/
    private String empName;//员工姓名
    private String leaveName;//假期名
    private String begDate;
    private String endDate;
    private String deptName;//部门名
    private String creatorName;//创建人姓名
    private String creatorDeptName;//创建人部门


    public AttLeaveBean() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}


    public String getJobNum() {
        return jobNum;
    }

    public void setJobNum(String jobNum) {
        this.jobNum = jobNum;
    }

    public String getLeaveTypeId() {
        return leaveTypeId;
    }

    public void setLeaveTypeId(String leaveTypeId) {
        this.leaveTypeId = leaveTypeId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getTotleTime() {
        return totleTime;
    }

    public void setTotleTime(String totleTime) {
        this.totleTime = totleTime;
    }

    public String getTotleDate() {
        return totleDate;
    }

    public void setTotleDate(String totleDate) {
        this.totleDate = totleDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getAppliCant() {
        return appliCant;
    }

    public void setAppliCant(String appliCant) {
        this.appliCant = appliCant;
    }

    public String getAppliDate() {
        return appliDate;
    }

    public void setAppliDate(String appliDate) {
        this.appliDate = appliDate;
    }

    public String getVerifier() {
        return verifier;
    }

    public void setVerifier(String verifier) {
        this.verifier = verifier;
    }

    public String getVerifyDate() {
        return verifyDate;
    }

    public void setVerifyDate(String verifyDate) {
        this.verifyDate = verifyDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getLeaveName() {
        return leaveName;
    }

    public void setLeaveName(String leaveName) {
        this.leaveName = leaveName;
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

    public static long getSerialversionuid() {
        return serialVersionUID;
    }


    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getCreatorDeptName() {
        return creatorDeptName;
    }

    public void setCreatorDeptName(String creatorDeptName) {
        this.creatorDeptName = creatorDeptName;
    }

    @Override
    public String toString() {
        return "AttLeaveBean{" +
                "id='" + id + '\'' +
                ", accountId='" + accountId + '\'' +
                ", jobNum='" + jobNum + '\'' +
                ", leaveTypeId='" + leaveTypeId + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", totleTime='" + totleTime + '\'' +
                ", totleDate='" + totleDate + '\'' +
                ", reason='" + reason + '\'' +
                ", appliCant='" + appliCant + '\'' +
                ", appliDate='" + appliDate + '\'' +
                ", verifier='" + verifier + '\'' +
                ", verifyDate='" + verifyDate + '\'' +
                ", status='" + status + '\'' +
                ", isDelete='" + isDelete + '\'' +
                ", createDate='" + createDate + '\'' +
                ", creator='" + creator + '\'' +
                ", empName='" + empName + '\'' +
                ", leaveName='" + leaveName + '\'' +
                ", begDate='" + begDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", deptName='" + deptName + '\'' +
                ", creatorName='" + creatorName + '\'' +
                ", creatorDeptName='" + creatorDeptName + '\'' +
                '}';
    }
}
