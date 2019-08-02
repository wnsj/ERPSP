package com.jiubo.erp.wzbg.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @version: V1.0
 * @author: DingDong
 * @className: LeaveForgetBean
 * @description: 忘记打卡证明POJO
 * @data: 2019-07-12
 **/
@Data
public class LeaveForgetBean implements Serializable {

	private static final long serialVersionUID = -2002753809895501231L;
	
	private String id;	// 忘记打卡证明ID
	private String reason; // 原因
	private String leaveAccount; // 申请人
	private String addTime; // 申请时间
	private String startTime; // 未打卡时间
	private String leaveRemark; // 未打卡说明
	private String accountR; // 证明人ID
	private String timeR; // 证明时间
	private String resultR; // 证明结果
	private String remarkR; // 证明说明
	private String account1; // 审查人ID
	private String time1; // 审查时间
	private String result1; // 审查结果
	private String remark1; // 审查说明
	private String account2; // 审核人ID
	private String time2; // 审核时间
	private String result2; // 审核结果
	private String remark2; // 审核说明
	private String account3; // 批准人ID
	private String time3; // 批准时间
	private String result3; // 批准结果
	private String remark3; // 批准说明
	private String account4; // 报备人ID
	private String time4; // 报备时间
	private String result4; // 报备结果
	private String remark4; // 报备说明
	private String updateTime; // 数据更新时间
	private String isSee; // 是否查看
	private String step; //步骤
	
	// 非数据库字段
	private String accountId; // 登陆人账户
	// leaveAccount
	private String leaveAccountName; // 申请人账户名
	private String leaveDeptId;	// 申请人部门ID
	private String leaveDeptName; // 申请人部门名
	private String leavePositionId; // 申请人职位ID
	private String leavePositionName;// 申请人职位名
	// accountR
	private String witnessAccountName; // 证明人账户名
	private String witnessDeptId;	// 证明人部门ID
	private String witnessDeptName; // 证明人部门名
	private String witnessPositionId; // 证明人职位ID
	private String witnessPositionName;// 证明人职位名
	// account1
	private String examineAccountName; // 审查人账户名
	private String examineDeptId;	// 审查人部门ID
	private String examineDeptName; // 审查人部门名
	private String examinePositionId; // 审查人职位ID
	private String examinePositionName;// 审查人职位名
	// account2
	private String checkAccountName; // 审核人账户名
	private String checkDeptId;	// 审核人部门ID
	private String checkDeptName; // 审核人部门名
	private String checkPositionId; // 审核人职位ID
	private String checkPositionName;// 审核人职位名
	// account3
	private String approveAccountName; // 批准人账户名
	private String approveDeptId;	// 批准人部门ID
	private String approveDeptName; // 批准人部门名
	private String approvePositionId; // 批准人职位ID
	private String approvePositionName;// 批准人职位名
	// account4
	private String reportAccountName; // 报备人账户名
	private String reportDeptId;	// 报备人部门ID
	private String reportDeptName; // 报备人部门名
	private String reportPositionId; // 报备人职位ID
	private String reportPositionName;// 报备人职位名
	// 查询时间
	private String beginDate;
	private String endDate;
	private String state;	// 状态
	
	
}
