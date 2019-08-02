package com.jiubo.erp.ryxxl.service;

import java.util.List;
import java.util.Map;

import com.jiubo.erp.common.MessageException;
import com.jiubo.erp.rygl.bean.DepartmentBean;
import com.jiubo.erp.ryxxl.bean.DepartmentAttendanceBean;

//人员管理类Service
public interface RyxxlService {
    /**
     * @throws Exception
     * @desc:在职人员分析表
     * @param:
     * @return: Map<String   ,   Object>
     * @Create at: 2019-05-14
     * @author: dx
     * @version: 1.0
     */
    public Map<String, Object> queryZzryReport(Map<String, Object> paraMap) throws Exception;

    /**
     * @desc:离职人员分析表(废弃,不再使用)
     * @param:
     * @return: Map<String   ,   Object>
     * @Create at: 2019-05-16
     * @author: dx
     * @version: 1.0
     */
    @Deprecated
    public Map<String, Object> queryLzryReport(Map<String, Object> paraMap) throws Exception;

    public Map<String, Object> getLzryReport(Map<String, Object> paraMap) throws Exception;

    /**
     * @desc:人力资源异动分析报表(废弃,不再使用)
     * @param:
     * @return: Map<String   ,   Object>
     * @Create at: 2019-05-23
     * @author: dx
     * @version: 1.0
     */
    @Deprecated
    public Map<String, Object> queryChanges(Map<String, Object> paraMap) throws MessageException;

    public Map<String, Object> getChanges(Map<String, Object> paraMap) throws MessageException;

    /**
     * @desc:招聘效果分析表(废弃，不再使用)
     * @param:
     * @return: Map<String   ,   Object>
     * @Create at: 2019-05-24
     * @author: dx
     * @version: 1.0
     */
    @Deprecated
    public Map<String, Object> queryRecruit(Map<String, Object> paraMap) throws MessageException;

    public Map<String, Object> getRecruit(Map<String, Object> paraMap) throws MessageException;

    /**
     * @desc:人力资源利用率报表
     * @param:
     * @return: Map<String   ,   Object>
     * @Create at: 2019-05-27
     * @author: dx
     * @version: 1.0
     */
    @Deprecated
    public Map<String, Object> queryRlzylyReport(Map<String, Object> paraMap) throws MessageException;

    public List<DepartmentBean> getRlzylyReport(Map<String, Object> paraMap) throws MessageException;

    /**
     * @desc:修改或添加部门未打卡信息
     * @param:
     * @return: void
     * @Create at: 2019-05-28
     * @author: dx
     * @version: 1.0
     */
    public void updateAddDeptAttendance(DepartmentAttendanceBean departmentAttendanceBean) throws MessageException;
}
