package com.jiubo.erp.rygl.vo;

//检索参数
public class QueryParam {
    private String departName;
    private String departId;
    private String state;
    private String projectId;

    //高级查询
    private String searchType; // 检索类别 0.全部 1.入职日期 2.转正日期 3.离职日期
    private String startDate; // 入职日期
    private String endDate; // 入职日期
    private String birth; // 生日月份
    private String resignType;//离职类型
    private String resignReasonId;//离职原因id
    private String enterStartDate;//入职开始时间
    private String enterEndDate;//入职结束时间
    private String leaveStartDate;//离职开始时间
    private String leaveEndDate;//离职结束时间
    private String zzStartDate;//转正开始时间
    private String zzEndDate;//转正结束时间


    //搜索内容  工号、姓名、职位、项目组
    private String searchContent;


    // DB:家庭成员检索
    private String chName;
    private String empName;
    private String shBirth;

    // 分页信息
    private int currentPage = 1;

    private int records = 30;


    /**
     * 构造方法
     */
    public QueryParam() {
        // TODO Auto-generated constructor stub
    }


    @Override
    public String toString() {
        return "QueryParam [departName=" + departName + ", departId=" + departId + ", state=" + state + ", projectId="
                + projectId + ", searchType=" + searchType + ", startDate=" + startDate + ", endDate=" + endDate
                + ", birth=" + birth + ", resignType=" + resignType + ", resignReasonId=" + resignReasonId
                + ", enterStartDate=" + enterStartDate + ", enterEndDate=" + enterEndDate + ", leaveStartDate="
                + leaveStartDate + ", leaveEndDate=" + leaveEndDate + ", zzStartDate=" + zzStartDate + ", zzEndDate="
                + zzEndDate + ", searchContent=" + searchContent + ", chName=" + chName + ", empName=" + empName
                + ", shBirth=" + shBirth + ", currentPage=" + currentPage + ", records=" + records + "]";
    }


    public String getEnterStartDate() {
        return enterStartDate;
    }

    public void setEnterStartDate(String enterStartDate) {
        this.enterStartDate = enterStartDate;
    }

    public String getEnterEndDate() {
        return enterEndDate;
    }

    public void setEnterEndDate(String enterEndDate) {
        this.enterEndDate = enterEndDate;
    }

    public String getLeaveStartDate() {
        return leaveStartDate;
    }

    public void setLeaveStartDate(String leaveStartDate) {
        this.leaveStartDate = leaveStartDate;
    }

    public String getLeaveEndDate() {
        return leaveEndDate;
    }

    public void setLeaveEndDate(String leaveEndDate) {
        this.leaveEndDate = leaveEndDate;
    }

    public String getZzStartDate() {
        return zzStartDate;
    }

    public void setZzStartDate(String zzStartDate) {
        this.zzStartDate = zzStartDate;
    }

    public String getZzEndDate() {
        return zzEndDate;
    }

    public void setZzEndDate(String zzEndDate) {
        this.zzEndDate = zzEndDate;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public String getResignType() {
        return resignType;
    }

    public void setResignType(String resignType) {
        this.resignType = resignType;
    }

    public String getResignReasonId() {
        return resignReasonId;
    }

    public void setResignReasonId(String resignReasonId) {
        this.resignReasonId = resignReasonId;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getRecords() {
        return records;
    }

    public void setRecords(int records) {
        this.records = records;
    }

    public String getChName() {
        return chName;
    }

    public void setChName(String chName) {
        this.chName = chName;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getShBirth() {
        return shBirth;
    }

    public void setShBirth(String shBirth) {
        this.shBirth = shBirth;
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

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getSearchContent() {
        return searchContent;
    }

    public void setSearchContent(String searchContent) {
        this.searchContent = searchContent;
    }

}
