package com.jiubo.erp.kqgl.vo;

//人员考勤
public class KqInfoResult {

    private String uId;//姓名id
    private String name;//姓名
    private String accountId;//账号ID
    private String accountName;//账号
    private String projectId;
    private String jobNum;//工号
    private String departname;//部门
    private String departId;//部门id
    private String positionName;//职位
    private String entryDate;//入职日期
    private String resignDate;//离职日期
    private String punchTime;//班次
    private String classTimeName;//出勤班次名称
    private String classTimeType;//出勤班次类型 所有休息2 上班1
    private String shiftDate;//出勤班次日期
    private String attTime;//打卡时间
    private String startDate;//开始日期
    private String endDate;//结束日期
    private String startTime;//上班时间
    private String endTime;//下班时间
    private String firstTimeState;//上班
    private String lastTimeState;//下班
    private String firstTime;//上班第一次打开时间
    private String lastTime;//下班最后一次打开时间
    private String status;//状态，暂时没有使用这个参数
    private String YYYYMMDD;//给查询对象添加时间参数


    public KqInfoResult() {
        // TODO Auto-generated constructor stub
    }


    public String getEntryDate() {
        return entryDate;
    }


    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }


    public String getResignDate() {
        return resignDate;
    }


    public void setResignDate(String resignDate) {
        this.resignDate = resignDate;
    }


    public String getProjectId() {
        return projectId;
    }


    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getYYYYMMDD() {
        return YYYYMMDD;
    }

    public void setYYYYMMDD(String yYYYMMDD) {
        YYYYMMDD = yYYYMMDD;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getClassTimeType() {
        return classTimeType;
    }

    public void setClassTimeType(String classTimeType) {
        this.classTimeType = classTimeType;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getFirstTimeState() {
        return firstTimeState;
    }

    public void setFirstTimeState(String firstTimeState) {
        this.firstTimeState = firstTimeState;
    }

    public String getLastTimeState() {
        return lastTimeState;
    }

    public void setLastTimeState(String lastTimeState) {
        this.lastTimeState = lastTimeState;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getDepartId() {
        return departId;
    }

    public void setDepartId(String departId) {
        this.departId = departId;
    }

    public String getFirstTime() {
        return firstTime;
    }

    public void setFirstTime(String firstTime) {
        this.firstTime = firstTime;
    }

    public String getLastTime() {
        return lastTime;
    }

    public void setLastTime(String lastTime) {
        this.lastTime = lastTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobNum() {
        return jobNum;
    }

    public void setJobNum(String jobNum) {
        this.jobNum = jobNum;
    }

    public String getDepartname() {
        return departname;
    }

    public void setDepartname(String departname) {
        this.departname = departname;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getPunchTime() {
        return punchTime;
    }

    public void setPunchTime(String punchTime) {
        this.punchTime = punchTime;
    }

    public String getClassTimeName() {
        return classTimeName;
    }

    public void setClassTimeName(String classTimeName) {
        this.classTimeName = classTimeName;
    }

    public String getShiftDate() {
        return shiftDate;
    }

    public void setShiftDate(String shiftDate) {
        this.shiftDate = shiftDate;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAttTime() {
        return attTime;
    }

    public void setAttTime(String attTime) {
        this.attTime = attTime;
    }


}
