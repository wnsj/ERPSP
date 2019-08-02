package com.jiubo.erp.ryxxl.bean;

import java.io.Serializable;

//岗位离职人数统计
public class OutEmpBean implements Serializable {
    private static final long serialVersionUID = 8260440155970564377L;
    private String positionId;//职位id
    private String positionName;//职位名
    private String resignType;//离职类型或异动类型
    private int resignation;//辞职
    private int dismiss;//辞退
    private int unKnow;//未知
    private double count;//单个人数
    private double sumCount;//总人数
    private String departmentId;//部门id
    private String departmentName;//部门名
    private String newDepartmentId; //新部门id
    private int jinSheng;//晋升
    private int jiangZhi;//降职
    private int change;//换岗
    private int diaoChu;//调出
    private int diaoRu;//调入
    private int begMonCount;//月初人数
    private int endMonCount;//月末人数
    private int entryCount;//入职人数
    private double avgCount;//平均人数
    private double quitMix;//离职率
    private double changeMix;//异动率

    public OutEmpBean() {
        super();
    }


    public String getPositionId() {
        return positionId;
    }


    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }


    public String getPositionName() {
        return positionName;
    }


    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }


    public String getResignType() {
        return resignType;
    }


    public void setResignType(String resignType) {
        this.resignType = resignType;
    }


    public double getCount() {
        return count;
    }


    public void setCount(double count) {
        this.count = count;
    }


    public double getSumCount() {
        return sumCount;
    }


    public void setSumCount(double sumCount) {
        this.sumCount = sumCount;
    }

    public int getResignation() {
        return resignation;
    }


    public void setResignation(int resignation) {
        this.resignation = resignation;
    }


    public int getDismiss() {
        return dismiss;
    }


    public void setDismiss(int dismiss) {
        this.dismiss = dismiss;
    }


    public int getUnKnow() {
        return unKnow;
    }


    public void setUnKnow(int unKnow) {
        this.unKnow = unKnow;
    }


    public String getDepartmentId() {
        return departmentId;
    }


    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }


    public String getDepartmentName() {
        return departmentName;
    }


    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }


    public String getNewDepartmentId() {
        return newDepartmentId;
    }


    public void setNewDepartmentId(String newDepartmentId) {
        this.newDepartmentId = newDepartmentId;
    }


    public int getJinSheng() {
        return jinSheng;
    }


    public void setJinSheng(int jinSheng) {
        this.jinSheng = jinSheng;
    }


    public int getJiangZhi() {
        return jiangZhi;
    }


    public void setJiangZhi(int jiangZhi) {
        this.jiangZhi = jiangZhi;
    }


    public int getChange() {
        return change;
    }


    public void setChange(int change) {
        this.change = change;
    }


    public int getDiaoChu() {
        return diaoChu;
    }


    public void setDiaoChu(int diaoChu) {
        this.diaoChu = diaoChu;
    }


    public int getDiaoRu() {
        return diaoRu;
    }


    public void setDiaoRu(int diaoRu) {
        this.diaoRu = diaoRu;
    }


    public int getBegMonCount() {
        return begMonCount;
    }


    public void setBegMonCount(int begMonCount) {
        this.begMonCount = begMonCount;
    }


    public int getEndMonCount() {
        return endMonCount;
    }


    public void setEndMonCount(int endMonCount) {
        this.endMonCount = endMonCount;
    }


    public int getEntryCount() {
        return entryCount;
    }


    public void setEntryCount(int entryCount) {
        this.entryCount = entryCount;
    }


    public double getAvgCount() {
        return avgCount;
    }


    public void setAvgCount(double avgCount) {
        this.avgCount = avgCount;
    }


    public double getQuitMix() {
        return quitMix;
    }


    public void setQuitMix(double quitMix) {
        this.quitMix = quitMix;
    }


    public double getChangeMix() {
        return changeMix;
    }


    public void setChangeMix(double changeMix) {
        this.changeMix = changeMix;
    }


    @Override
    public String toString() {
        return "OutEmpBean [positionId=" + positionId + ", positionName=" + positionName + ", resignType=" + resignType
                + ", resignation=" + resignation + ", dismiss=" + dismiss + ", unKnow=" + unKnow + ", count=" + count
                + ", sumCount=" + sumCount + ", departmentId=" + departmentId + ", departmentName=" + departmentName
                + ", newDepartmentId=" + newDepartmentId + ", jinSheng=" + jinSheng + ", jiangZhi=" + jiangZhi
                + ", change=" + change + ", diaoChu=" + diaoChu + ", diaoRu=" + diaoRu + ", begMonCount=" + begMonCount
                + ", endMonCount=" + endMonCount + ", entryCount=" + entryCount + ", avgCount=" + avgCount
                + ", quitMix=" + quitMix + ", changeMix=" + changeMix + "]";
    }
}
