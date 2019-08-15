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
     * @param id(部门id)
     * @return List<DeptWithEmp>
     * @Description: 查询部门下的员工姓名以及ERP账户信息
     * @author: DingDong
     * @date: 2019年7月1日
     * @version: V1.0
     */
    List<DeptWithEmp> queryEmpInfoByDept(String id) throws MessageException;

    /**
     * @param leavePrepareBean(请假报备实体)
     * @return
     * @Description: 添加请假报备
     * @author: DingDong
     * @date: 2019年06月29日
     * @version: V1.0
     */
    void addLeavePrepareBean(LeavePrepareBean leavePrepareBean) throws MessageException;

    /**
     * @param
     * @return
     * @Description: 查询报备审批权限账户信息
     * @author: DingDong
     * @date: 2019年07月2日
     * @version: V1.0
     */
    List<AccWithApprovalLeaveAuth> queryApprovalAuthAccount() throws MessageException;

    /**
     * @param leavePrepareBean(请假报备实体)
     * @return
     * @Description: 查询请假报备
     * @author: DingDong
     * @date: 2019年06月29日
     * @version: V1.0
     */
    List<LeavePrepareBean> queryLeavePrepareBean(LeavePrepareBean leavePrepareBean) throws MessageException;

    /**
     * @param deptWithEmp
     * @return List<DeptWithEmp>
     * @Description: 查询请假代理人列表
     * @author: DingDong
     * @date: 2019年7月9日
     * @version: V1.0
     */
    List<DeptWithEmp> queryAgentList(DeptWithEmp deptWithEmp) throws MessageException;

    /**
     * @param deptWithEmp
     * @return List<DeptWithEmp>
     * @Description: 查询所在部门以及子部门的员工信息
     * @author: DingDong
     * @date: 2019年7月10日
     * @version: V1.0
     */
    List<DeptWithEmp> queryEmpByDeptOrParentDept(DeptWithEmp deptWithEmp) throws MessageException;

    /**
     * @param leavePrepareBean
     * @return
     * @Description: 更新请假报备信息
     * @author: DingDong
     * @date: 2019年7月11日
     * @version: V1.0
     */
    void updateLeavePrepare(LeavePrepareBean leavePrepareBean) throws MessageException;

    /**
     * @param checkInfo
     * @return
     * @Description: 查询审查人信息
     * @author: DingDong
     * @date: 2019年7月24日
     * @version: V1.0
     */
    List<CheckInfo> queryCheckInfo(CheckInfo checkInfo) throws MessageException;

    /**
     * @param deptId
     * @Description: 查询父级部门ID
     * @return String
     * @author: DingDong
     * @date: 2019年7月24日
     * @version: V1.0
     */
    String queryParentDept(String deptId) throws MessageException;

    /**
     * @param
     * @return
     * @Description: 查询请假表的报备ID
     * @author: DingDong
     * @date: 2019年8月15日
     * @version: V1.0
     */
    List<String> queryIdsForLeave() throws MessageException;
}
