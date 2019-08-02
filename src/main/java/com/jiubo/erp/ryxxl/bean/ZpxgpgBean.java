package com.jiubo.erp.ryxxl.bean;

import java.io.Serializable;

//招聘效果评估分析表
public class ZpxgpgBean implements Serializable {

    private static final long serialVersionUID = -5387135179124931257L;
    private String department;//部门
    private String position;//岗位
    private String lackNum;//缺编人数
    private String planNum;//计划人数
    private int faceCount;//到面人数
    private int begMonCount;//月初人数
    private int qualifiedCount;//合格人数
    private int entryCount;//入职人数
    private int endMonCount;//月末人数
    private String effectiveMix;//有效率
    private String reachMix;//达成率
    private String channel;//渠道
    private int candidates;//应聘人数
    private String feedbackMix;//反馈率
    private int publishNum;//发布人数

    public ZpxgpgBean() {
        super();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLackNum() {
        return lackNum;
    }

    public void setLackNum(String lackNum) {
        this.lackNum = lackNum;
    }

    public String getPlanNum() {
        return planNum;
    }

    public void setPlanNum(String planNum) {
        this.planNum = planNum;
    }

    public int getBegMonCount() {
        return begMonCount;
    }

    public void setBegMonCount(int begMonCount) {
        this.begMonCount = begMonCount;
    }

    public int getQualifiedCount() {
        return qualifiedCount;
    }

    public void setQualifiedCount(int qualifiedCount) {
        this.qualifiedCount = qualifiedCount;
    }

    public int getEntryCount() {
        return entryCount;
    }

    public void setEntryCount(int entryCount) {
        this.entryCount = entryCount;
    }

    public int getEndMonCount() {
        return endMonCount;
    }

    public void setEndMonCount(int endMonCount) {
        this.endMonCount = endMonCount;
    }

    public String getEffectiveMix() {
        return effectiveMix;
    }

    public void setEffectiveMix(String effectiveMix) {
        this.effectiveMix = effectiveMix;
    }

    public String getReachMix() {
        return reachMix;
    }

    public void setReachMix(String reachMix) {
        this.reachMix = reachMix;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public int getCandidates() {
        return candidates;
    }

    public void setCandidates(int candidates) {
        this.candidates = candidates;
    }

    public String getFeedbackMix() {
        return feedbackMix;
    }

    public void setFeedbackMix(String feedbackMix) {
        this.feedbackMix = feedbackMix;
    }


    public int getFaceCount() {
        return faceCount;
    }

    public void setFaceCount(int faceCount) {
        this.faceCount = faceCount;
    }

    public int getPublishNum() {
        return publishNum;
    }

    public void setPublishNum(int publishNum) {
        this.publishNum = publishNum;
    }

    @Override
    public String toString() {
        return "ZpxgpgBean [department=" + department + ", position=" + position + ", lackNum=" + lackNum + ", planNum="
                + planNum + ", faceCount=" + faceCount + ", begMonCount=" + begMonCount + ", qualifiedCount="
                + qualifiedCount + ", entryCount=" + entryCount + ", endMonCount=" + endMonCount + ", effectiveMix="
                + effectiveMix + ", reachMix=" + reachMix + ", channel=" + channel + ", candidates=" + candidates
                + ", feedbackMix=" + feedbackMix + ", publishNum=" + publishNum + "]";
    }

}
