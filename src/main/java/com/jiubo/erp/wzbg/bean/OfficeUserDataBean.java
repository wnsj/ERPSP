package com.jiubo.erp.wzbg.bean;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @desc:
 * @date: 2019-07-22 13:06
 * @author: dx
 * @version: 1.0
 */
public class OfficeUserDataBean implements Serializable{
    private static final long serialVersionUID = 7623225524970147429L;
    private String id;
    private String officeId;//会议室id
    private String startTime;
    private String endTime;
    private String accountId;//申请人id
    private String accountZt;//会议主题
    private String remark;//备注
    private String state;//会议状态(0:未完成 ,1:已完成 ,2:未完成,3:已取消)
    private String num;//参会人数
    private String userName;//主持人
    private String type;//会议类型(1:其他会议,2:例会)
    private String yuYueTime;//预约时间

    private String accountName;//申请人
    private String name;//会议室名
    private String conference;//会议类型中文
    private String[] officeIdArr;//会议室id数组
    private String[] stateArr;//状态数据
    private String week;//星期

    public OfficeUserDataBean() {
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String[] getOfficeIdArr() {
        return officeIdArr;
    }

    public void setOfficeIdArr(String[] officeIdArr) {
        this.officeIdArr = officeIdArr;
    }

    public String[] getStateArr() {
        return stateArr;
    }

    public void setStateArr(String[] stateArr) {
        this.stateArr = stateArr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountZt() {
        return accountZt;
    }

    public void setAccountZt(String accountZt) {
        this.accountZt = accountZt;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOfficeId() {
        return officeId;
    }

    public void setOfficeId(String officeId) {
        this.officeId = officeId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getYuYueTime() {
        return yuYueTime;
    }

    public void setYuYueTime(String yuYueTime) {
        this.yuYueTime = yuYueTime;
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

    public String getConference() {
        return conference;
    }

    public void setConference(String conference) {
        this.conference = conference;
    }

    @Override
    public String toString() {
        return "OfficeUserDataBean{" +
                "id='" + id + '\'' +
                ", officeId='" + officeId + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", accountId='" + accountId + '\'' +
                ", accountZt='" + accountZt + '\'' +
                ", remark='" + remark + '\'' +
                ", state='" + state + '\'' +
                ", num='" + num + '\'' +
                ", userName='" + userName + '\'' +
                ", type='" + type + '\'' +
                ", yuYueTime='" + yuYueTime + '\'' +
                ", accountName='" + accountName + '\'' +
                ", name='" + name + '\'' +
                ", conference='" + conference + '\'' +
                ", officeIdArr=" + Arrays.toString(officeIdArr) +
                ", stateArr=" + Arrays.toString(stateArr) +
                ", week='" + week + '\'' +
                '}';
    }
}
