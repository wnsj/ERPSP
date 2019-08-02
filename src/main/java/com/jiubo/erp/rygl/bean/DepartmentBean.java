package com.jiubo.erp.rygl.bean;

import java.io.Serializable;
import java.util.List;

import com.jiubo.erp.kqgl.bean.PositionDataBean;

public class DepartmentBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private String ID; //编号
    private String Name; //名称
    private String ParentID; //父级编号
    private String OrderNum; //顺序号
    private int level;//部门级别
    private String preFixName;//带前缀的名字
    private List<DepartmentBean> children;//子部门
    private List<EmployeeBasicBean> employeeList;//部门员工
    private List<PositionDataBean> positionDataList;
    private int jinSheng;//晋升
    private int jiangZhi;//降职
    private int change;//换岗
    private int diaoChu;//调出
    private int diaoRu;//调入
    private double count;//单个人数
    private double sumCount;//总人数
    private int resignation;//辞职
    private int dismiss;//辞退
    private int unKnow;//未知
    private int total;//合计
    private int begMonCount;//月初人数
    private int endMonCount;//月末人数
    private int entryCount;//入职人数
    private double avgCount;//平均人数
    private double quitMix;//离职率
    private double changeMix;//异动率

    public DepartmentBean() {
    }

    public List<DepartmentBean> getChildren() {
        return children;
    }

    public void setChildren(List<DepartmentBean> children) {
        this.children = children;
    }

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getParentID() {
        return ParentID;
    }

    public void setParentID(String parentID) {
        ParentID = parentID;
    }

    public String getOrderNum() {
        return OrderNum;
    }

    public void setOrderNum(String orderNum) {
        OrderNum = orderNum;
    }


    public List<EmployeeBasicBean> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<EmployeeBasicBean> employeeList) {
        this.employeeList = employeeList;
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
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


    public List<PositionDataBean> getPositionDataList() {
        return positionDataList;
    }

    public void setPositionDataList(List<PositionDataBean> positionDataList) {
        this.positionDataList = positionDataList;
    }

    public String getPreFixName() {
        return preFixName;
    }

    public void setPreFixName(String preFixName) {
        this.preFixName = preFixName;
    }

    @Override
    public String toString() {
        return "DepartmentBean{" +
                "ID='" + ID + '\'' +
                ", Name='" + Name + '\'' +
                ", ParentID='" + ParentID + '\'' +
                ", OrderNum='" + OrderNum + '\'' +
                ", level=" + level +
                ", preFixName='" + preFixName + '\'' +
                ", children=" + children +
                ", employeeList=" + employeeList +
                ", positionDataList=" + positionDataList +
                ", jinSheng=" + jinSheng +
                ", jiangZhi=" + jiangZhi +
                ", change=" + change +
                ", diaoChu=" + diaoChu +
                ", diaoRu=" + diaoRu +
                ", count=" + count +
                ", sumCount=" + sumCount +
                ", resignation=" + resignation +
                ", dismiss=" + dismiss +
                ", unKnow=" + unKnow +
                ", total=" + total +
                ", begMonCount=" + begMonCount +
                ", endMonCount=" + endMonCount +
                ", entryCount=" + entryCount +
                ", avgCount=" + avgCount +
                ", quitMix=" + quitMix +
                ", changeMix=" + changeMix +
                '}';
    }
}
