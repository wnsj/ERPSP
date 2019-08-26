/**
 * @desc:招聘发布信息 Create at : 2019-05-11
 * @author: dx
 * @version: 1.0
 */
package com.jiubo.erp.zpgl.bean;

import lombok.Data;

import java.io.Serializable;

@Data
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
}
