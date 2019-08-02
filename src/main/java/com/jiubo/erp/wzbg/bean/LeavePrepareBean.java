package com.jiubo.erp.wzbg.bean;

import lombok.Data;

import java.io.Serializable;


/**
 * @version: V1.0
 * @author: DingDong
 * @className: LeavePrepare
 * @description: 请假报备POJO
 * @data: 2019-06-29
 **/
@Data
public class LeavePrepareBean implements Serializable {

	private static final long serialVersionUID = -6959115797576537005L;

	private String id; // 请假报备id
	private String type; // 请假类型
	private String fillAccount; // 填表人账户
	private String fillTime; // 填表时间
	private String leaveAccount; // 请假人账户
	private String startTime; // 起始时间
	private String endTime; // 结束时间
	private String leaveRemark; // 请假说明
	private String checkAccount; // 审批人账户
	private String checkTime; // 审批时间
	private String checkResult; // 审批结果
	private String checkRemark; // 审批意见
	private String updateTime; // 数据更新时间
	private String isSee; // 是否查看
	private String state; // 状态
	
	// 非数据库字段
	private String accountId; // 登陆人账户
	private String leaveEmpName;
	private String leaveDeptId;
	private String leaveDepartmentName; // 请假人部门名
	private String leavePositionId;
	private String leavePositionName;// 请假人职位名
	
	private String fillEmpName;
	private String fillDepartmentName;  // 填表人部门名
	private String fillPositionId;
	private String fillPositionName;// 填表人职位名
	private String checkEmpName;
	private String checkPositionName;// 审批人职位名
	private String typeId;	// 请假人职务级别
	private String fillTypeId;	// 填表人职务级别
	
}
