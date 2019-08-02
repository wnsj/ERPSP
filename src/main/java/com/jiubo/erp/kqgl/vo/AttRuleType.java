package com.jiubo.erp.kqgl.vo;

public class AttRuleType {
    private String id;
    private String name;
    private String earlyMinutes;
    private String lateMinutes;
    private String isDelete;
    private String createDate;
    private String creator;

    public AttRuleType() {
        super();
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
