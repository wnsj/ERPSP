package com.jiubo.erp.wzbg.service;

import com.jiubo.erp.common.MessageException;
import com.jiubo.erp.wzbg.bean.LeavePrepareBean;
import com.jiubo.erp.wzbg.vo.AccWithApprovalLeaveAuth;
import com.jiubo.erp.wzbg.vo.CheckInfo;
import com.jiubo.erp.wzbg.vo.DeptWithEmp;

import java.util.List;

/**
 * @version: V1.0
 * @author: DingDong
 * @className: LeavePrepareService
 * @description: 请假报备管理业务层
 * @data: 2019-06-29
 **/
public interface LeavePrepareService {

	/**
	 * @Description: 查询部门下的员工姓名以及ERP账户信息
	 * @param  String id(部门id)
	 * @return List<DeptWithEmp>
	 * @author: DingDong
	 * @date: 2019年7月1日
	 * @version: V1.0
	 */
	public List<DeptWithEmp> queryEmpInfoByDept(String id) throws MessageException;

	/**
	 * @Description: 添加请假报备
	 * @param  leavePrepareBean(请假报备实体)
	 * @return
	 * @author: DingDong
	 * @date: 2019年06月29日
	 * @version: V1.0
	 */
	public void addLeavePrepareBean(LeavePrepareBean leavePrepareBean) throws MessageException;

	/**
	 * @Description: 查询报备审批权限账户信息
	 * @param
	 * @return
	 * @author: DingDong
	 * @date: 2019年07月2日
	 * @version: V1.0
	 */
	public List<AccWithApprovalLeaveAuth> queryApprovalAuthAccount() throws MessageException;

	/**
	 * @Description: 查询请假报备
	 * @param  leavePrepareBean(请假报备实体)
	 * @return
	 * @author: DingDong
	 * @date: 2019年06月29日
	 * @version: V1.0
	 */
	public List<LeavePrepareBean> queryLeavePrepareBean(LeavePrepareBean leavePrepareBean) throws MessageException;

	/**
	 * @Description: 查询请假代理人列表
	 * @param  deptWithEmp
	 * @return List<DeptWithEmp>
	 * @author: DingDong
	 * @date: 2019年7月9日
	 * @version: V1.0
	 */
	public List<DeptWithEmp> queryAgentList(DeptWithEmp deptWithEmp) throws MessageException;

	/**
	 * @Description: 查询所在部门以及子部门的员工信息
	 * @param  deptWithEmp
	 * @return List<DeptWithEmp>
	 * @author: DingDong
	 * @date: 2019年7月10日
	 * @version: V1.0
	 */
	public List<DeptWithEmp> queryEmpByDeptOrParentDept(DeptWithEmp deptWithEmp) throws MessageException;

	/**
	 * @Description: 更新请假报备信息
	 * @param  leavePrepareBean
	 * @return
	 * @author: DingDong
	 * @date: 2019年7月11日
	 * @version: V1.0
	 */
	public void updateLeavePrepare(LeavePrepareBean leavePrepareBean) throws MessageException;
	
	/**
	 * @Description: 查询审查人信息
	 * @param  queryCheckInfo
	 * @return
	 * @author: DingDong
	 * @date: 2019年7月24日
	 * @version: V1.0
	 */
    public List<CheckInfo> queryCheckInfo(CheckInfo checkInfo) throws MessageException;
    
    /**
	 * @Description: 查询父级部门ID
	 * @param  queryParentDept
	 * @return	String
	 * @author: DingDong
	 * @date: 2019年7月24日
	 * @version: V1.0
	 */
    public String queryParentDept(String deptId) throws MessageException;
}
