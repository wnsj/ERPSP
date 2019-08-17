package com.jiubo.erp.zpgl.bean;

import lombok.Data;

import java.io.Serializable;

//招聘计划
@Data
public class ZpPlanBean implements Serializable {

    private static final long serialVersionUID = -1554577884241697894L;

    private String planId;//计划id
    private String department;//部门
    private String position;//职位
    private String lackNum;//缺编人数
    private String planNum; //计划人数
    private String phoneNum;//邀约人数
    private String planDate;//计划月份
    private String departmentName;//部门名
    private String positionName;//职位名
    private String begDate;//查询时间
    private String endDate;//查询时间
    private String isYes;//是否完成
    private String isBack;//是否撤销
}
