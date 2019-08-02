package com.jiubo.erp.rygl.vo;

import java.util.Date;

public class User {
    private Integer userId;
    private String userName;
    private String password;
    private String userTrueName;
    private String userState;
    private Integer creator;
    private Date createDate;
    private Integer updater;
    private Date updateDate;

    public User() {
        // TODO Auto-generated constructor stub
    }

    public User(Integer userId) {
        super();
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserTrueName() {
        return userTrueName;
    }

    public void setUserTrueName(String userTrueName) {
        this.userTrueName = userTrueName;
    }

    public String getUserState() {
        return userState;
    }

    public void setUserState(String userState) {
        this.userState = userState;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getUpdater() {
        return updater;
    }

    public void setUpdater(Integer updater) {
        this.updater = updater;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", userName=" + userName
                + ", password=" + password + ", userTrueName=" + userTrueName
                + ", userState=" + userState + ", creator=" + creator
                + ", createDate=" + createDate + ", updater=" + updater
                + ", updateDate=" + updateDate + "]";
    }

}
