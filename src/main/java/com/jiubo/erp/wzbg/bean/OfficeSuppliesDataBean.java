package com.jiubo.erp.wzbg.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @desc:办公用品管理bean
 * @date: 2019-07-09 08:35
 * @author: dx
 * @version: 1.0
 */
@Data
public class OfficeSuppliesDataBean implements Serializable{
    private static final long serialVersionUID = -9131377697924256844L;
    private String id;
    private String departmentId;//部门id
    private String month;//时间
    private String name;//办公用品名
    private String num;//数量
    private String specification;//规格
    private String remark;//备注
    private String accountId1;//申请人
    private String accountId2;//一级审核人
    private String advice2;//意见（1：同意,2:不同意,3:未审核）
    private String accountId3;
    private String advice3;
    private String state;//状态（0：等待，1：通过，2：没通过）
    private String isTiJiao;//是否提交
    private String renShiId;//人事id
    private String renShidAvice;//人事意见
    private String renShiSee;
    private String fuZongId;//副总id
    private String fuZongAdvice;//副总意见
    private String fuZongSee;
    private String caiWuId;//财务id
    private String caiWuAdvice;//财务意见
    private String caiWuSee;
    private String zhuSee;
    private String renSee;
    private String shenSee;
    private String isWanCheng;//是否完成
    private String renOtherSee;

    private String departmentName;//部门名
    private String account1Name;
    private String account2Name;
    private String account3Name;
    private String officeId;//办公用品名id
    private String specId;//办公用品规格id
    private List<SpecificationBean> specificationList;//办公用品所有的规格
}
