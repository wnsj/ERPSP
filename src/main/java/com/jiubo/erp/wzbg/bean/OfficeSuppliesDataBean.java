package com.jiubo.erp.wzbg.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @desc:办公用品管理bean
 * @date: 2019-07-09 08:35
 * @author: dx
 * @version: 1.0
 */
public class OfficeSuppliesDataBean implements Serializable{
    private static final long serialVersionUID = -9131377697924256844L;
    private String id;
    private String departmentId;//部门id
    private String month;//时间
    private String name;//办公用品名
    private String num;//数量
    private String specification;//规格
    private String remark;//备注
    private String accountId1;//申请人
    private String accountId2;//一级审核人
    private String advice2;//意见（1：同意,2:不同意,3:未审核）
    private String accountId3;
    private String advice3;
    private String state;//状态（0：等待，1：通过，2：没通过）
    private String isTiJiao;//是否提交
    private String renShiId;//人事id
    private String renShidAvice;//人事意见
    private String renShiSee;
    private String fuZongId;//副总id
    private String fuZongAdvice;//副总意见
    private String fuZongSee;
    private String caiWuId;//财务id
    private String caiWuAdvice;//财务意见
    private String caiWuSee;
    private String zhuSee;
    private String renSee;
    private String shenSee;
    private String isWanCheng;//是否完成
    private String renOtherSee;

    private String departmentName;//部门名
    private String account1Name;
    private String account2Name;
    private String officeId;//办公用品名id
    private String specId;//办公用品规格id
    private List<SpecificationBean> specificationList;//办公用品所有的规格

    public OfficeSuppliesDataBean() {
    }

    public List<SpecificationBean> getSpecificationList() {
        return specificationList;
    }

    public void setSpecificationList(List<SpecificationBean> specificationList) {
        this.specificationList = specificationList;
    }

    public String getOfficeId() {
        return officeId;
    }

    public void setOfficeId(String officeId) {
        this.officeId = officeId;
    }

    public String getSpecId() {
        return specId;
    }

    public void setSpecId(String specId) {
        this.specId = specId;
    }

    public String getAccount2Name() {
        return account2Name;
    }

    public void setAccount2Name(String account2Name) {
        this.account2Name = account2Name;
    }

    public String getAccount1Name() {
        return account1Name;
    }

    public void setAccount1Name(String account1Name) {
        this.account1Name = account1Name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAccountId1() {
        return accountId1;
    }

    public void setAccountId1(String accountId1) {
        this.accountId1 = accountId1;
    }

    public String getAccountId2() {
        return accountId2;
    }

    public void setAccountId2(String accountId2) {
        this.accountId2 = accountId2;
    }

    public String getAdvice2() {
        return advice2;
    }

    public void setAdvice2(String advice2) {
        this.advice2 = advice2;
    }

    public String getAccountId3() {
        return accountId3;
    }

    public void setAccountId3(String accountId3) {
        this.accountId3 = accountId3;
    }

    public String getAdvice3() {
        return advice3;
    }

    public void setAdvice3(String advice3) {
        this.advice3 = advice3;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getIsTiJiao() {
        return isTiJiao;
    }

    public void setIsTiJiao(String isTiJiao) {
        this.isTiJiao = isTiJiao;
    }

    public String getRenShiId() {
        return renShiId;
    }

    public void setRenShiId(String renShiId) {
        this.renShiId = renShiId;
    }

    public String getRenShidAvice() {
        return renShidAvice;
    }

    public void setRenShidAvice(String renShidAvice) {
        this.renShidAvice = renShidAvice;
    }

    public String getRenShiSee() {
        return renShiSee;
    }

    public void setRenShiSee(String renShiSee) {
        this.renShiSee = renShiSee;
    }

    public String getFuZongId() {
        return fuZongId;
    }

    public void setFuZongId(String fuZongId) {
        this.fuZongId = fuZongId;
    }

    public String getFuZongAdvice() {
        return fuZongAdvice;
    }

    public void setFuZongAdvice(String fuZongAdvice) {
        this.fuZongAdvice = fuZongAdvice;
    }

    public String getFuZongSee() {
        return fuZongSee;
    }

    public void setFuZongSee(String fuZongSee) {
        this.fuZongSee = fuZongSee;
    }

    public String getCaiWuId() {
        return caiWuId;
    }

    public void setCaiWuId(String caiWuId) {
        this.caiWuId = caiWuId;
    }

    public String getCaiWuAdvice() {
        return caiWuAdvice;
    }

    public void setCaiWuAdvice(String caiWuAdvice) {
        this.caiWuAdvice = caiWuAdvice;
    }

    public String getCaiWuSee() {
        return caiWuSee;
    }

    public void setCaiWuSee(String caiWuSee) {
        this.caiWuSee = caiWuSee;
    }

    public String getZhuSee() {
        return zhuSee;
    }

    public void setZhuSee(String zhuSee) {
        this.zhuSee = zhuSee;
    }

    public String getRenSee() {
        return renSee;
    }

    public void setRenSee(String renSee) {
        this.renSee = renSee;
    }

    public String getShenSee() {
        return shenSee;
    }

    public void setShenSee(String shenSee) {
        this.shenSee = shenSee;
    }

    public String getIsWanCheng() {
        return isWanCheng;
    }

    public void setIsWanCheng(String isWanCheng) {
        this.isWanCheng = isWanCheng;
    }

    public String getRenOtherSee() {
        return renOtherSee;
    }

    public void setRenOtherSee(String renOtherSee) {
        this.renOtherSee = renOtherSee;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "OfficeSuppliesDataBean{" +
                "id='" + id + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", month='" + month + '\'' +
                ", name='" + name + '\'' +
                ", num='" + num + '\'' +
                ", specification='" + specification + '\'' +
                ", remark='" + remark + '\'' +
                ", accountId1='" + accountId1 + '\'' +
                ", accountId2='" + accountId2 + '\'' +
                ", advice2='" + advice2 + '\'' +
                ", accountId3='" + accountId3 + '\'' +
                ", advice3='" + advice3 + '\'' +
                ", state='" + state + '\'' +
                ", isTiJiao='" + isTiJiao + '\'' +
                ", renShiId='" + renShiId + '\'' +
                ", renShidAvice='" + renShidAvice + '\'' +
                ", renShiSee='" + renShiSee + '\'' +
                ", fuZongId='" + fuZongId + '\'' +
                ", fuZongAdvice='" + fuZongAdvice + '\'' +
                ", fuZongSee='" + fuZongSee + '\'' +
                ", caiWuId='" + caiWuId + '\'' +
                ", caiWuAdvice='" + caiWuAdvice + '\'' +
                ", caiWuSee='" + caiWuSee + '\'' +
                ", zhuSee='" + zhuSee + '\'' +
                ", renSee='" + renSee + '\'' +
                ", shenSee='" + shenSee + '\'' +
                ", isWanCheng='" + isWanCheng + '\'' +
                ", renOtherSee='" + renOtherSee + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", account1Name='" + account1Name + '\'' +
                ", account2Name='" + account2Name + '\'' +
                ", officeId='" + officeId + '\'' +
                ", specId='" + specId + '\'' +
                ", specificationList=" + specificationList +
                '}';
    }
}
