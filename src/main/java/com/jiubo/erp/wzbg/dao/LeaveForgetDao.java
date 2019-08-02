package com.jiubo.erp.wzbg.dao;

import com.jiubo.erp.wzbg.bean.LeaveForgetBean;
import com.jiubo.erp.wzbg.vo.DeptWithEmp;

import java.util.List;

/**
 * @version: V1.0
 * @author: DingDong
 * @className: LeaveForgetDao
 * @description: 忘记打卡证明数据访问层
 * @data: 2019-07-12
 **/
public interface LeaveForgetDao {
	
	// 查询忘记打卡证明
	public List<LeaveForgetBean> queryLeaveForget(LeaveForgetBean leaveForgetBean);
	
	// 添加忘记打卡证明
	public void addLeaveForget(LeaveForgetBean leaveForgetBean);
	
	// 通过账户ID查询某员工部门和职位
	public DeptWithEmp queryEmpInfoByAccount(DeptWithEmp deptWithEmp);
	
	// 修改忘记打卡证明
	public void updateLeaveForget(LeaveForgetBean leaveForgetBean);
}
