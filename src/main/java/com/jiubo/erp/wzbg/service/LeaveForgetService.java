package com.jiubo.erp.wzbg.service;

import com.jiubo.erp.common.MessageException;
import com.jiubo.erp.wzbg.bean.LeaveForgetBean;
import com.jiubo.erp.wzbg.vo.DeptWithEmp;

import java.util.List;

/**
 * @version: V1.0
 * @author: DingDong
 * @className: LeaveForgetService
 * @description: 忘记打卡证明业务层
 * @data: 2019-07-12
 **/
public interface LeaveForgetService {
	
	/**
	 * @Description: 查询忘记打卡证明
	 * @param  leaveForgetBean
	 * @return List<LeaveForgetBean>
	 * @author: DingDong
	 * @date: 2019年7月12日
	 * @version: V1.0
	 */
	public List<LeaveForgetBean> queryLeaveForgetBean(LeaveForgetBean leaveForgetBean) throws MessageException;
	
	/**
	 * @Description: 新增忘记打卡证明
	 * @param  leaveForgetBean
	 * @return 
	 * @author: DingDong
	 * @date: 2019年7月13日
	 * @version: V1.0
	 */
	public void addLeaveForgetBean(LeaveForgetBean leaveForgetBean) throws MessageException;
	
	/**
	 * @Description: 通过账户ID查询某员工部门和职位
	 * @param  deptWithEmp
	 * @return DeptWithEmp
	 * @author: DingDong
	 * @date: 2019年7月16日
	 * @version: V1.0
	 */
	public DeptWithEmp queryEmpInfoByAccount(DeptWithEmp deptWithEmp) throws MessageException;
	
	/**
	 * @Description: 修改忘记打卡证明
	 * @param  leaveForgetBean
	 * @return 
	 * @author: DingDong
	 * @date: 2019年7月29日
	 * @version: V1.0
	 */
	public void updateLeaveForget(LeaveForgetBean leaveForgetBean) throws MessageException;
}
