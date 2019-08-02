package com.jiubo.erp.wzbg.vo;

import lombok.Data;

/**
 * @version: V1.0
 * @author: DingDong
 * @className: DeptWithEmp
 * @description: 员工部门职位信息
 * @data: 2019-07-05
 **/
@Data
public class DeptWithEmp {
	private String account;// 账户id
	private String name;// 账户名
	private String departmentId; // 部门ID
	private String deptParentId;// 父级ID
	private String deptName;// 部门名
	private String deptParentName;// 父级部门名
	private String positionId; // 职位ID
	private String positionName;// 职位名
	private String typeId;// 职位级别
}
