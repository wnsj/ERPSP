package com.jiubo.erp.ryxxl.bean;

import java.io.Serializable;

//部门未打卡天数
public class DepartmentAttendanceBean implements Serializable {

    private static final long serialVersionUID = 4068476933168968837L;
    private String id;
    private String departmentId;
    private int num;
    private String dataMonth;

    public DepartmentAttendanceBean() {
        super();
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

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getDataMonth() {
        return dataMonth;
    }

    public void setDataMonth(String dataMonth) {
        this.dataMonth = dataMonth;
    }

    @Override
    public String toString() {
        return "DepartmentAttendanceBean [id=" + id + ", departmentId=" + departmentId + ", num=" + num + ", dataMonth="
                + dataMonth + "]";
    }

}
