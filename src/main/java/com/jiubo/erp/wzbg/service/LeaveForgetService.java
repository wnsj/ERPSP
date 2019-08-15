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
     * @param leaveForgetBean
     * @return List<LeaveForgetBean>
     * @Description: 查询忘记打卡证明
     * @author: DingDong
     * @date: 2019年7月12日
     * @version: V1.0
     */
    List<LeaveForgetBean> queryLeaveForgetBean(LeaveForgetBean leaveForgetBean) throws MessageException;

    /**
     * @param leaveForgetBean
     * @return
     * @Description: 新增忘记打卡证明
     * @author: DingDong
     * @date: 2019年7月13日
     * @version: V1.0
     */
    void addLeaveForgetBean(LeaveForgetBean leaveForgetBean) throws MessageException;

    /**
     * @param deptWithEmp
     * @return DeptWithEmp
     * @Description: 通过账户ID查询某员工部门和职位
     * @author: DingDong
     * @date: 2019年7月16日
     * @version: V1.0
     */
    DeptWithEmp queryEmpInfoByAccount(DeptWithEmp deptWithEmp) throws MessageException;

    /**
     * @param leaveForgetBean
     * @return
     * @Description: 修改忘记打卡证明
     * @author: DingDong
     * @date: 2019年7月29日
     * @version: V1.0
     */
    void updateLeaveForget(LeaveForgetBean leaveForgetBean) throws MessageException;

}
