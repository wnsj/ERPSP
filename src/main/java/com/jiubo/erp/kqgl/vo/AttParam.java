/**
 * @author 作者 mwl
 * @version 创建时间 2019年6月20日 @{time}
 */
/**
 *
 */
package com.jiubo.erp.kqgl.vo;

/**
 * 考勤查询所有模块参数
 * @author mwl
 *
 */
public class AttParam {


    private String name;//姓名
    private String projectId;
    private String jobNum;//工号
    private String departName;//部门
    private String departId;//部门id
    private String positionName;//职位
    private String beginDate;//职位
    private String endDate;//职位
    private String accountName;//账号的名字

    /**
     *
     */
    public AttParam() {
        // TODO Auto-generated constructor stub
    }


    @Override
    public String toString() {
        return "AttParam [name=" + name + ", projectId=" + projectId + ", jobNum=" + jobNum + ", departName="
                + departName + ", departId=" + departId + ", positionName=" + positionName + ", beginDate=" + beginDate
                + ", endDate=" + endDate + ", accountName=" + accountName + "]";
    }


    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getJobNum() {
        return jobNum;
    }

    public void setJobNum(String jobNum) {
        this.jobNum = jobNum;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    public String getDepartId() {
        return departId;
    }

    public void setDepartId(String departId) {
        this.departId = departId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }


}
