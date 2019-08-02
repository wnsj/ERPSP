package com.jiubo.erp.zpgl.bean;

import java.io.Serializable;

//面试信息
public class RecruitDataBean implements Serializable {

    private static final long serialVersionUID = -7097531221123039163L;

    private String id;//id
    private String name;//姓名
    private String sex;//性别
    private String birth;//生日
    private String idNum; //身份证
    private String phone;//手机
    private String mail; //邮箱
    private String qq;//qq
    private String address; //现在地址
    private String homeAddress;//家庭地址
    private String homeTown;//籍贯
    private String accountProp;//户口性质
    private String ploitical;//政治面貌（political）
    private String marital;//婚姻
    private String nationality;//民族
    private String height;//身高
    private String weight;//体重
    private String bloodType;//血型
    private String education;//学历
    private String school;//毕业院校
    private String graduation;//毕业时间
    private String profession;//专业
    private String atSchool;//是否在校
    private String workCompany;//工作单位
    private String workexp;//相关经验
    private String certificate;//技能证书
    private String channel;//应聘渠道
    private String position;//职位
    private String department;//部门
    private String wages;//期望薪资
    private String interviewer;//面试官
    private String recruitDate;//面试时间
    private String invitationDate;//邀约时间
    private String score;//成绩
    private String isQualified;//是否合格
    private String isPay;//报销路费
    private String remark;//备注
    private String isEntry;//是否入职（0：未入职 1：在职 2：离职）
    private String isDelete;//是否有效（ 0：有效，1：失效）
    private String updateDate;//更新时间
    private String updateAccount;

    private String dateFlag;//面试管理时间查询（标记字段）
    private String begDate;//面试管理时间查询（开始时间）
    private String endDate;//结束时间

    private String channelName;
    private String departmentName;
    private String positionName;


    public String getDepartmentName() {
        return departmentName;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
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


    public RecruitDataBean() {
        super();
    }


    public String getDateFlag() {
        return dateFlag;
    }


    public void setDateFlag(String dateFlag) {
        this.dateFlag = dateFlag;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public String getAccountProp() {
        return accountProp;
    }

    public void setAccountProp(String accountProp) {
        this.accountProp = accountProp;
    }

    public String getPloitical() {
        return ploitical;
    }

    public void setPloitical(String ploitical) {
        this.ploitical = ploitical;
    }

    public String getMarital() {
        return marital;
    }

    public void setMarital(String marital) {
        this.marital = marital;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getGraduation() {
        return graduation;
    }

    public void setGraduation(String graduation) {
        this.graduation = graduation;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getAtSchool() {
        return atSchool;
    }

    public void setAtSchool(String atSchool) {
        this.atSchool = atSchool;
    }

    public String getWorkCompany() {
        return workCompany;
    }

    public void setWorkCompany(String workCompany) {
        this.workCompany = workCompany;
    }

    public String getWorkexp() {
        return workexp;
    }

    public void setWorkexp(String workexp) {
        this.workexp = workexp;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getWages() {
        return wages;
    }

    public void setWages(String wages) {
        this.wages = wages;
    }

    public String getInterviewer() {
        return interviewer;
    }

    public void setInterviewer(String interviewer) {
        this.interviewer = interviewer;
    }

    public String getRecruitDate() {
        return recruitDate;
    }

    public void setRecruitDate(String recruitDate) {
        this.recruitDate = recruitDate;
    }

    public String getInvitationDate() {
        return invitationDate;
    }

    public void setInvitationDate(String invitationDate) {
        this.invitationDate = invitationDate;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getIsQualified() {
        return isQualified;
    }

    public void setIsQualified(String isQualified) {
        this.isQualified = isQualified;
    }

    public String getIsPay() {
        return isPay;
    }

    public void setIsPay(String isPay) {
        this.isPay = isPay;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getIsEntry() {
        return isEntry;
    }

    public void setIsEntry(String isEntry) {
        this.isEntry = isEntry;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateAccount() {
        return updateAccount;
    }

    public void setUpdateAccount(String updateAccount) {
        this.updateAccount = updateAccount;
    }


    @Override
    public String toString() {
        return "RecruitDataBean [id=" + id + ", name=" + name + ", sex=" + sex + ", birth=" + birth + ", idNum=" + idNum
                + ", phone=" + phone + ", mail=" + mail + ", qq=" + qq + ", address=" + address + ", homeAddress="
                + homeAddress + ", homeTown=" + homeTown + ", accountProp=" + accountProp + ", ploitical=" + ploitical
                + ", marital=" + marital + ", nationality=" + nationality + ", height=" + height + ", weight=" + weight
                + ", bloodType=" + bloodType + ", education=" + education + ", school=" + school + ", graduation="
                + graduation + ", profession=" + profession + ", atSchool=" + atSchool + ", workCompany=" + workCompany
                + ", workexp=" + workexp + ", certificate=" + certificate + ", channel=" + channel + ", position="
                + position + ", department=" + department + ", wages=" + wages + ", interviewer=" + interviewer
                + ", recruitDate=" + recruitDate + ", invitationDate=" + invitationDate + ", score=" + score
                + ", isQualified=" + isQualified + ", isPay=" + isPay + ", remark=" + remark + ", isEntry=" + isEntry
                + ", isDelete=" + isDelete + ", updateDate=" + updateDate + ", updateAccount=" + updateAccount
                + ", dateFlag=" + dateFlag + ", begDate=" + begDate + ", endDate=" + endDate + "]";
    }

}
