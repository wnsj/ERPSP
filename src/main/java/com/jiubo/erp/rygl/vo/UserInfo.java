package com.jiubo.erp.rygl.vo;

import java.util.List;

public class UserInfo {

    //基础信息
    private Integer id;
    private String name;
    private String sex;
    private String jobNum;
    private String departId;
    private String positionId;
    private String birth;
    private String entryDate;
    private String positiveDate;
    private String resignDate;
    private String photo;
    private String isDelete;
    private String state;
    private String erpaaccount;
    private String accountId;
    private String parentId;
    private String resignType;
    private String resignReason;

    //详细信息
    private Integer uEmployeeBasicID;
    private String uIdNum;
    private String uPloitical;
    private String uContact;
    private String uHomeTown;
    private String uNationality;
    private String uMarital;
    private String uHomeAddress;
    private String uCurrentAddress;
    private String uSchools;
    private String uEducation;
    private String uProfession;
    private String uGraduation;
    private String uEmergencyContact;
    private String uEmergencyphone;
    private String uHeight;
    private String uWeight;
    private String uBloodType;
    private String uLicenseType;
    private String uDrivingExpe;
    private String uDomicile;
    private String uAccountProp;
    private String uAtSchool;

    //相同参数
    private String createDate;
    private String updateDate;
    private String createUser;
    private String remark;

    private String recruitDataID;


    public UserInfo() {
    }

    public String getRecruitDataID() {
        return recruitDataID;
    }

    public void setRecruitDataID(String recruitDataID) {
        this.recruitDataID = recruitDataID;
    }

    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
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


    public String getJobNum() {
        return jobNum;
    }


    public void setJobNum(String jobNum) {
        this.jobNum = jobNum;
    }


    public String getDepartId() {
        return departId;
    }


    public void setDepartId(String departId) {
        this.departId = departId;
    }


    public String getPositionId() {
        return positionId;
    }


    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }


    public String getBirth() {
        return birth;
    }


    public void setBirth(String birth) {
        this.birth = birth;
    }


    public String getEntryDate() {
        return entryDate;
    }


    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }


    public String getPositiveDate() {
        return positiveDate;
    }


    public void setPositiveDate(String positiveDate) {
        this.positiveDate = positiveDate;
    }


    public String getResignDate() {
        return resignDate;
    }


    public void setResignDate(String resignDate) {
        this.resignDate = resignDate;
    }


    public String getPhoto() {
        return photo;
    }


    public void setPhoto(String photo) {
        this.photo = photo;
    }


    public String getIsDelete() {
        return isDelete;
    }


    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }


    public String getState() {
        return state;
    }


    public void setState(String state) {
        this.state = state;
    }


    public String getErpaaccount() {
        return erpaaccount;
    }


    public void setErpaaccount(String erpaaccount) {
        this.erpaaccount = erpaaccount;
    }


    public String getAccountId() {
        return accountId;
    }


    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }


    public String getParentId() {
        return parentId;
    }


    public void setParentId(String parentId) {
        this.parentId = parentId;
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


    public Integer getuEmployeeBasicID() {
        return uEmployeeBasicID;
    }


    public void setuEmployeeBasicID(Integer uEmployeeBasicID) {
        this.uEmployeeBasicID = uEmployeeBasicID;
    }


    public String getuIdNum() {
        return uIdNum;
    }


    public void setuIdNum(String uIdNum) {
        this.uIdNum = uIdNum;
    }


    public String getuPloitical() {
        return uPloitical;
    }


    public void setuPloitical(String uPloitical) {
        this.uPloitical = uPloitical;
    }


    public String getuContact() {
        return uContact;
    }


    public void setuContact(String uContact) {
        this.uContact = uContact;
    }


    public String getuHomeTown() {
        return uHomeTown;
    }


    public void setuHomeTown(String uHomeTown) {
        this.uHomeTown = uHomeTown;
    }


    public String getuNationality() {
        return uNationality;
    }


    public void setuNationality(String uNationality) {
        this.uNationality = uNationality;
    }


    public String getuMarital() {
        return uMarital;
    }


    public void setuMarital(String uMarital) {
        this.uMarital = uMarital;
    }


    public String getuHomeAddress() {
        return uHomeAddress;
    }


    public void setuHomeAddress(String uHomeAddress) {
        this.uHomeAddress = uHomeAddress;
    }


    public String getuCurrentAddress() {
        return uCurrentAddress;
    }


    public void setuCurrentAddress(String uCurrentAddress) {
        this.uCurrentAddress = uCurrentAddress;
    }


    public String getuSchools() {
        return uSchools;
    }


    public void setuSchools(String uSchools) {
        this.uSchools = uSchools;
    }


    public String getuEducation() {
        return uEducation;
    }


    public void setuEducation(String uEducation) {
        this.uEducation = uEducation;
    }


    public String getuProfession() {
        return uProfession;
    }


    public void setuProfession(String uProfession) {
        this.uProfession = uProfession;
    }


    public String getuGraduation() {
        return uGraduation;
    }


    public void setuGraduation(String uGraduation) {
        this.uGraduation = uGraduation;
    }


    public String getuEmergencyContact() {
        return uEmergencyContact;
    }


    public void setuEmergencyContact(String uEmergencyContact) {
        this.uEmergencyContact = uEmergencyContact;
    }


    public String getuEmergencyphone() {
        return uEmergencyphone;
    }


    public void setuEmergencyphone(String uEmergencyphone) {
        this.uEmergencyphone = uEmergencyphone;
    }


    public String getuHeight() {
        return uHeight;
    }


    public void setuHeight(String uHeight) {
        this.uHeight = uHeight;
    }


    public String getuWeight() {
        return uWeight;
    }


    public void setuWeight(String uWeight) {
        this.uWeight = uWeight;
    }


    public String getuBloodType() {
        return uBloodType;
    }


    public void setuBloodType(String uBloodType) {
        this.uBloodType = uBloodType;
    }


    public String getuLicenseType() {
        return uLicenseType;
    }


    public void setuLicenseType(String uLicenseType) {
        this.uLicenseType = uLicenseType;
    }


    public String getuDrivingExpe() {
        return uDrivingExpe;
    }


    public void setuDrivingExpe(String uDrivingExpe) {
        this.uDrivingExpe = uDrivingExpe;
    }


    public String getuDomicile() {
        return uDomicile;
    }


    public void setuDomicile(String uDomicile) {
        this.uDomicile = uDomicile;
    }


    public String getuAccountProp() {
        return uAccountProp;
    }


    public void setuAccountProp(String uAccountProp) {
        this.uAccountProp = uAccountProp;
    }


    public String getuAtSchool() {
        return uAtSchool;
    }


    public void setuAtSchool(String uAtSchool) {
        this.uAtSchool = uAtSchool;
    }


    public String getCreateDate() {
        return createDate;
    }


    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }


    public String getUpdateDate() {
        return updateDate;
    }


    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }


    public String getCreateUser() {
        return createUser;
    }


    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }


    public String getRemark() {
        return remark;
    }


    public void setRemark(String remark) {
        this.remark = remark;
    }




}
