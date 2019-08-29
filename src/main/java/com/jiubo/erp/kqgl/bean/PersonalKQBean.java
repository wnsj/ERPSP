package com.jiubo.erp.kqgl.bean;

import java.util.List;
import java.util.Map;

import javax.print.DocFlavor.STRING;

public class PersonalKQBean {

    private String ryKQId;//人员考勤ID
    private String accountId;//账号ID
    private String ryKQName;//人员考勤名称
    private String ryJobNum;//工号
    private String ryDepartKQName;//部门名称
    private String ryDepartKQId;//部门id
    private String ryPositionKQName;//职位名称
    private String beginDate;//开始日期
    private String endDate;//结束日期
    private String ryLaterTimes;//迟到次数
    private String ryLeaveEarlyTimes;//早退次数
    private String ryMinersTimes;//矿工次数
    private String ryOnPA;//上班打卡异常
    private String ryDownPA;//下班打卡异常
    private String ryOnNomalPA;//上班打卡正常
    private String ryDownNomalPA;//下班打卡正常
    private String ryNotPA;//未打卡
    private String ryRestDays;//休息天数
    private String ryOverTimesDays;//加班天数
    private String ryNoScheduleTimes;//未排班次数
    private String ryEnteryTime;//入职时间
    private String ryLeaveTime;//离职时间
    private String notEntry;//入职
    private String leavedPosition;//离职
    private List<Map<String, String>> punchTime;//个人的班次和打卡时间的
    private String kqTableCount;//考勤情况综合统计


    public String getRyEnteryTime() {
        return ryEnteryTime;
    }


    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getNotEntry() {
        return notEntry;
    }
    public String getRyNotPA() {
        return ryNotPA;
    }

    public void setRyNotPA(String ryNotPA) {
        this.ryNotPA = ryNotPA;
    }
    public void setNotEntry(String notEntry) {
        this.notEntry = notEntry;
    }

    public String getLeavedPosition() {
        return leavedPosition;
    }

    public void setLeavedPosition(String leavedPosition) {
        this.leavedPosition = leavedPosition;
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


    public void setRyEnteryTime(String ryEnteryTime) {
        this.ryEnteryTime = ryEnteryTime;
    }


    public String getRyLeaveTime() {
        return ryLeaveTime;
    }


    public void setRyLeaveTime(String ryLeaveTime) {
        this.ryLeaveTime = ryLeaveTime;
    }

    public PersonalKQBean() {
        // TODO Auto-generated constructor stub
    }


    public String getRyNoScheduleTimes() {
        return ryNoScheduleTimes;
    }


    public void setRyNoScheduleTimes(String ryNoScheduleTimes) {
        this.ryNoScheduleTimes = ryNoScheduleTimes;
    }

    public String getRyKQId() {
        return ryKQId;
    }

    public void setRyKQId(String ryKQId) {
        this.ryKQId = ryKQId;
    }

    public List<Map<String, String>> getPunchTime() {
        return punchTime;
    }


    public String getKqTableCount() {
        return kqTableCount;
    }


    public void setKqTableCount(String kqTableCount) {
        this.kqTableCount = kqTableCount;
    }


    public void setPunchTime(List<Map<String, String>> punchTime) {
        this.punchTime = punchTime;
    }


    public String getRyKQName() {
        return ryKQName;
    }

    public void setRyKQName(String ryKQName) {
        this.ryKQName = ryKQName;
    }

    public String getRyJobNum() {
        return ryJobNum;
    }

    public void setRyJobNum(String ryJobNum) {
        this.ryJobNum = ryJobNum;
    }

    public String getRyDepartKQName() {
        return ryDepartKQName;
    }

    public void setRyDepartKQName(String ryDepartKQName) {
        this.ryDepartKQName = ryDepartKQName;
    }

    public String getRyDepartKQId() {
        return ryDepartKQId;
    }


    public void setRyDepartKQId(String ryDepartKQId) {
        this.ryDepartKQId = ryDepartKQId;
    }


    public String getRyPositionKQName() {
        return ryPositionKQName;
    }

    public void setRyPositionKQName(String ryPositionKQName) {
        this.ryPositionKQName = ryPositionKQName;
    }

    public String getRyLaterTimes() {
        return ryLaterTimes;
    }

    public void setRyLaterTimes(String ryLaterTimes) {
        this.ryLaterTimes = ryLaterTimes;
    }

    public String getRyLeaveEarlyTimes() {
        return ryLeaveEarlyTimes;
    }

    public void setRyLeaveEarlyTimes(String ryLeaveEarlyTimes) {
        this.ryLeaveEarlyTimes = ryLeaveEarlyTimes;
    }

    public String getRyMinersTimes() {
        return ryMinersTimes;
    }

    public void setRyMinersTimes(String ryMinersTimes) {
        this.ryMinersTimes = ryMinersTimes;
    }

    public String getRyOnPA() {
        return ryOnPA;
    }

    public void setRyOnPA(String ryOnPA) {
        this.ryOnPA = ryOnPA;
    }

    public String getRyDownPA() {
        return ryDownPA;
    }

    public void setRyDownPA(String ryDownPA) {
        this.ryDownPA = ryDownPA;
    }

    public String getRyOnNomalPA() {
        return ryOnNomalPA;
    }

    public void setRyOnNomalPA(String ryOnNomalPA) {
        this.ryOnNomalPA = ryOnNomalPA;
    }

    public String getRyDownNomalPA() {
        return ryDownNomalPA;
    }

    public void setRyDownNomalPA(String ryDownNomalPA) {
        this.ryDownNomalPA = ryDownNomalPA;
    }

    public String getRyRestDays() {
        return ryRestDays;
    }


    public void setRyRestDays(String ryRestDays) {
        this.ryRestDays = ryRestDays;
    }


    public String getRyOverTimesDays() {
        return ryOverTimesDays;
    }


    public void setRyOverTimesDays(String ryOverTimesDays) {
        this.ryOverTimesDays = ryOverTimesDays;
    }
}
