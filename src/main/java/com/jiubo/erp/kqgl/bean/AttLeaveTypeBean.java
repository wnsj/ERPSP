package com.jiubo.erp.kqgl.bean;

//假期种类类型
public class AttLeaveTypeBean {
    private String ID;//编号
    private String Name;  //名称
    private String IsDelete; //是否有效
    private String CreateDate; //创建时间
    private String Creator; //创建者


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

    public String getIsDelete() {
        return IsDelete;
    }

    public void setIsDelete(String isDelete) {
        IsDelete = isDelete;
    }

    public String getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(String createDate) {
        CreateDate = createDate;
    }

    public String getCreator() {
        return Creator;
    }

    public void setCreator(String creator) {
        Creator = creator;
    }


}
