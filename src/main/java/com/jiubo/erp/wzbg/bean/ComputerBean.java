package com.jiubo.erp.wzbg.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @version: V1.0
 * @author: DingDong
 * @className: ComputerBean
 * @description: 电脑POJO
 * @data: 2019-07-30
 **/
@Data
public class ComputerBean implements Serializable {

    private static final long serialVersionUID = -5597291336415363760L;

    private String id; // (主键)单号
    // 部门
    private String deptId; // 部门ID
    private String deptName; // 部门名
    // 岗位
    private String positionId; // 岗位ID
    private String positionName; // 岗位名
    // 时间
    private String submitTime; // 提交时间
    private String useTime;    // 使用时间
    private String finishTime; // 交接时间
    private String flowEndTime;// 流程结束时间
    // 查询时间类型
    private String timeType;// 1.提交时间 2.使用时间 3.完成时间
    // 查询起止时间
    private String beginTime; // 提交时间
    private String endTime; // 提交时间
    // 申请人
    private String applyId; //申请人ID
    private String applyName; // 申请人姓名
    private String applyIsSee; // 是否查看
    // 使用人
    private String userId; // 预计使用人ID
    private String userName; // 预计使用人姓名
    private String userIsSee; // 是否查看
    // 主管
    private String leaderId; // 主管ID
    private String leaderName; // 主管姓名
    private String leaderAudit; // 审核状态: 0.未审核 1.同意 2.不同意
    private String leaderIsSee; // 是否查看
    // 交接人
    private String handId; // 交接人ID
    private String handName; // 交接人姓名
    private String handIsSee; // 交接人是否查看
    private String peiJieName;// 配接单姓名
    private String peiJieIsSee;// 配接单是否查看
    // 负责人
    private String principalId; // 负责人ID
    private String principalName; // 负责人姓名
    private String principalAudit; // 审核状态: 0.未审核 1.同意 2.不同意
    private String principalIsSee; // 负责人是否查看
    // 配置人
    private String configId; // 配置电脑人ID
    private String configName; // 配置电脑人姓名
    private String configIsSee; // 是否查看
    private String isConfig; // 是否分配了配置电脑人
    // 申请类型
    private String isReserve; // 是否为预申请: 0.否(普通申请) 2.是(预申请)
    private String typeId; // 类型: 0.领用电脑 1.更换配件 2.添加配件
    private String typeName; // 名称
    private String status; // 申请状态: null:未完成(页面显示点击完成)  1.进行中 2.已完成

    private String remark; // 说明
    // 登陆人
    private String accountId; // 登陆人ID
    private String accountName; // 登陆人姓名
}
