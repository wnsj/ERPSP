package com.jiubo.erp.wzbg.dao;

import com.jiubo.erp.wzbg.bean.ApprovalBaoBeiBean;
import com.jiubo.erp.wzbg.bean.LeavePrepareBean;
import com.jiubo.erp.wzbg.vo.AccWithApprovalLeaveAuth;
import com.jiubo.erp.wzbg.vo.CheckInfo;
import com.jiubo.erp.wzbg.vo.DeptWithEmp;

import java.util.List;

/**
 * @version: V1.0
 * @author: DingDong
 * @className: LeavePrepareDao
 * @description: 请假报备数据访问层
 * @data: 2019-06-29
 **/
public interface LeavePrepareDao {

    // 查询某个部门下的员工姓名和员工ERP账户
    public List<DeptWithEmp> queryEmpInfoByDept(String id);

    // 添加请假报备信息
    public void addLeavePrepare(LeavePrepareBean leavePrepare);

    // 查询请假报备信息
    public List<LeavePrepareBean> queryLeavePrepare(LeavePrepareBean leavePrepareBean);

    // 查询报备审批权限表
    public ApprovalBaoBeiBean queryApprovalAuth();

    // 通过职位id查询报备审批权限账户信息
    public List<AccWithApprovalLeaveAuth> queryAuthAccount(String id);

    // 查询请假代理人列表
    public List<DeptWithEmp> queryAgentList(DeptWithEmp deptWithEmp);

    // 查询所在部门以及子部门的员工信息
    public List<DeptWithEmp> queryEmpByDeptOrParentDept(DeptWithEmp deptWithEmp);

    //	更新请假报备信息
    public void updateLeavePrepare(LeavePrepareBean leavePrepareBean);
    
    // 	查询审查人信息
    public List<CheckInfo> queryCheckInfo(CheckInfo checkInfo);
    
    // 查询父级部门ID
    public String queryParentDept(String deptId);

}
