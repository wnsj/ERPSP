package com.jiubo.erp.kqgl.bean;

//出勤规则表
public class AttRuleTypeBean {
    private String id;//编号
    private String name;//名称
    private String earlyMinutes;//早退时间
    private String lateMinutes;//迟到时间
    private String isDelete;//是否有效
    private String createDate;//创建时间
    private String creator;//创建者

    public AttRuleTypeBean() {
        super();
        // TODO Auto-generated constructor stub
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

    public String getEarlyMinutes() {
        return earlyMinutes;
    }

    public void setEarlyMinutes(String earlyMinutes) {
        this.earlyMinutes = earlyMinutes;
    }

    public String getLateMinutes() {
        return lateMinutes;
    }

    public void setLateMinutes(String lateMinutes) {
        this.lateMinutes = lateMinutes;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

}
