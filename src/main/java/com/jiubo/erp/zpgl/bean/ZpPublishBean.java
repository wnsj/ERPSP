/**
 * @desc:招聘发布信息 Create at : 2019-05-11
 * @author: dx
 * @version: 1.0
 */
package com.jiubo.erp.zpgl.bean;

import java.io.Serializable;

public class ZpPublishBean implements Serializable {

    private static final long serialVersionUID = -7721494066080945658L;

    private String publishId;//id
    private String channel;//渠道
    private String position;//职位
    private String publishNum;//发布人数
    private String phoneNum;//邀约人数
    private String publishDate;//发布日期

    private String channelName;//渠道名
    private String positionName;//职位名
    private String begDate;//查询时间
    private String endDate;//查询时间

    public ZpPublishBean() {
        super();
    }

    public String getPublishId() {
        return publishId;
    }

    public void setPublishId(String publishId) {
        this.publishId = publishId;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPublishNum() {
        return publishNum;
    }

    public void setPublishNum(String publishNum) {
        this.publishNum = publishNum;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }


    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getBegDate() {
        return begDate;
    }

    public void setBegDate(String begDate) {
        this.begDate = begDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "ZpPublishBean [publishId=" + publishId + ", channel=" + channel + ", position=" + position
                + ", publishNum=" + publishNum + ", phoneNum=" + phoneNum + ", publishDate=" + publishDate
                + ", channelName=" + channelName + ", positionName=" + positionName + ", begDate=" + begDate
                + ", endDate=" + endDate + "]";
    }

}
