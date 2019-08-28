package com.jiubo.erp.rygl.vo;

public class QueryFamilyResult {
    private String ID;
    private String jobnum;//工号
    private String name;//员工名字
    private String appellation; //称谓
    private String chname;//成员名字
    private String birth;//生日
    private String workAddress;//工作单位
    private String position;//职务
    private String phone;//手机号
    private String wechat;//微信号
    private String famAddress;//家庭地址
    private String resignType;//离职类型
    private String resignReason;//离职原因
    private String uAccountId;//ERP账号id
    private String uAccountName;//ERP账号id
    private String type;//add，modify 添加或者修改

    private String recruitDataID;//面试入职人员家庭信息

    public QueryFamilyResult() {
		// TODO Auto-generated constructor stub
	}
    
    @Override
    public String toString() {
        return "QueryFamilyResult [ID=" + ID + ", jobnum=" + jobnum + ", name=" + name + ", appellation=" + appellation
                + ", chname=" + chname + ", birth=" + birth + ", workAddress=" + workAddress + ", position=" + position
                + ", phone=" + phone + ", wechat=" + wechat + ", famAddress=" + famAddress + ", resignType="
                + resignType + ", resignReason=" + resignReason + ", uAccountId=" + uAccountId + ", uAccountName="
                + uAccountName + ", type=" + type + "]";
    }

    public String getRecruitDataID() {
        return recruitDataID;
    }

    public void setRecruitDataID(String recruitDataID) {
        this.recruitDataID = recruitDataID;
    }

    public String getuAccountName() {
        return uAccountName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setuAccountName(String uAccountName) {
        this.uAccountName = uAccountName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public String getResignType() {
        return resignType;
    }

    public void setResignType(String resignType) {
        this.resignType = resignType;
    }

    public String getResignReason() {
        return resignReason;
    }

    public void setResignReason(String resignReason) {
        this.resignReason = resignReason;
    }

    public void setID(String iD) {
        ID = iD;
    }

    public String getJobnum() {
        return jobnum;
    }

    public void setJobnum(String jobnum) {
        this.jobnum = jobnum;
    }

    public String getAppellation() {
        return appellation;
    }

    public String getuAccountId() {
        return uAccountId;
    }

    public void setuAccountId(String uAccountId) {
        this.uAccountId = uAccountId;
    }

    public void setAppellation(String appellation) {
        this.appellation = appellation;
    }

    public String getChname() {
        return chname;
    }

    public void setChname(String chname) {
        this.chname = chname;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(String workAddress) {
        this.workAddress = workAddress;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getFamAddress() {
        return famAddress;
    }

    public void setFamAddress(String famAddress) {
        this.famAddress = famAddress;
    }


}
