package com.jiubo.erp.kqgl.vo;

//部门考勤
public class DepartKQ {

    private String departKQName;//部门名称
    private String laterTimes;//迟到次数
    private String leaveEarlyTimes;//早退次数
    private String minersTimes;//矿工次数
    private String onPA;//上班打卡异常
    private String downPA;//下班打卡异常
    private String restDays;//休息天数
    private String overTimesDays;//加班天数

    public DepartKQ() {
        // TODO Auto-generated constructor stub
    }

    public DepartKQ(String departKQName, String laterTimes, String leaveEarlyTimes, String minersTimes, String onPA,
                    String downPA, String restDays, String overTimesDays) {
        super();
        this.departKQName = departKQName;
        this.laterTimes = laterTimes;
        this.leaveEarlyTimes = leaveEarlyTimes;
        this.minersTimes = minersTimes;
        this.onPA = onPA;
        this.downPA = downPA;
        this.restDays = restDays;
        this.overTimesDays = overTimesDays;
    }


    public String getDepartKQName() {
        return departKQName;
    }

    public void setDepartKQName(String departKQName) {
        this.departKQName = departKQName;
    }

    public String getLaterTimes() {
        return laterTimes;
    }

    public void setLaterTimes(String laterTimes) {
        this.laterTimes = laterTimes;
    }

    public String getLeaveEarlyTimes() {
        return leaveEarlyTimes;
    }

    public void setLeaveEarlyTimes(String leaveEarlyTimes) {
        this.leaveEarlyTimes = leaveEarlyTimes;
    }

    public String getMinersTimes() {
        return minersTimes;
    }

    public void setMinersTimes(String minersTimes) {
        this.minersTimes = minersTimes;
    }

    public String getOnPA() {
        return onPA;
    }

    public void setOnPA(String onPA) {
        this.onPA = onPA;
    }

    public String getDownPA() {
        return downPA;
    }

    public void setDownPA(String downPA) {
        this.downPA = downPA;
    }

    public String getRestDays() {
        return restDays;
    }

    public void setRestDays(String restDays) {
        this.restDays = restDays;
    }

    public String getOverTimesDays() {
        return overTimesDays;
    }

    public void setOverTimesDays(String overTimesDays) {
        this.overTimesDays = overTimesDays;
    }


}
