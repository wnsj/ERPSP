package com.jiubo.erp.kqgl.service;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jiubo.erp.common.MessageException;
import com.jiubo.erp.kqgl.bean.AttRuleTypeBean;
import com.jiubo.erp.kqgl.bean.AttShiftGroupBean;
import com.jiubo.erp.kqgl.bean.AttShiftScheduleBean;
import com.jiubo.erp.kqgl.bean.PositionDataBean;
import com.jiubo.erp.kqgl.bean.PositionTypeBean;
import com.jiubo.erp.kqgl.vo.Vacation;
import com.jiubo.erp.rygl.bean.DepartmentBean;

public interface KqParamSetService {
    /**
     * @desc:查询假期种类
     * @param:
     * @return: List<Vacation>
     * @Create at: 2019-04-30
     * @author: dx
     * @version: 1.0
     */
    public List<Vacation> queryVacation() throws MessageException;

    /**
     * @throws Exception
     * @desc:修改假期种类
     * @param:
     * @return: void
     * @Create at: 2019-04-30
     * @author: dx
     * @version: 1.0
     */
    public void updateVacation(Vacation vacation) throws MessageException;

    /**
     * @desc:添加假期种类
     * @param:
     * @return: void
     * @Create at: 2019-04-30
     * @author: dx
     * @version: 1.0
     */
    public void addVacation(Vacation vacation);

    /**
     * @throws Exception
     * @desc:删除假期种类
     * @param:
     * @return: void
     * @Create at: 2019-04-30
     * @author: dx
     * @version: 1.0
     */
    public void deleteVacation(int id) throws MessageException;

    /**
     * @desc:查询考勤规则
     * @param:
     * @return: List<AttRuleType>
     * @Create at: 2019-04-30
     * @author: dx
     * @version: 1.0
     */
    public List<AttRuleTypeBean> queryAttRuleType() throws MessageException;

    /**
     * @desc:添加考勤规则
     * @param:
     * @return: void
     * @Create at: 2019-04-30
     * @author: dx
     * @version: 1.0
     */
    public void addAttRuleType(AttRuleTypeBean attRuleType) throws MessageException;

    /**
     * @desc:删除考勤规则
     * @param:
     * @return: void
     * @Create at: 2019-04-30
     * @author: dx
     * @version: 1.0
     */
    public void deleteAttRuleType(int id) throws MessageException;

    /**
     * @desc:修改考勤规则
     * @param:
     * @return: void
     * @Create at: 2019-04-30
     * @author: dx
     * @version: 1.0
     */
    public void updateAttRuleType(AttRuleTypeBean attRuleType) throws MessageException;

    /**
     * @desc:查询班次
     * @param:
     * @return: List<AttShiftSchedule>
     * @Create at: 2019-05-01
     * @author: dx
     * @version: 1.0
     */
    public List<AttShiftScheduleBean> queryAttShiftSchedule() throws MessageException;

    /**
     * @desc:添加班次
     * @param:
     * @return: void
     * @Create at: 2019-05-01
     * @author: dx
     * @version: 1.0
     */
    public void addAttShiftSchedule(AttShiftScheduleBean attShiftSchedule) throws MessageException;

    /**
     * @desc:删除班次
     * @param:
     * @return: void
     * @Create at: 2019-05-01
     * @author: dx
     * @version: 1.0
     */
    public void deleteAttShiftSchedule(int id) throws MessageException;

    /**
     * @desc:修改班次
     * @param:
     * @return: void
     * @Create at: 2019-05-01
     * @author: dx
     * @version: 1.0
     */
    public void updateAttShiftSchedule(AttShiftScheduleBean attShiftSchedule) throws MessageException;

    /**
     * @desc:查询班组
     * @param:
     * @return: List<AttShiftGroupBean>
     * @Create at: 2019-05-01
     * @author: dx
     * @version: 1.0
     */
    public List<AttShiftGroupBean> queryAttShiftGroup() throws MessageException;

    /**
     * @desc:添加班组
     * @param:
     * @return: void
     * @Create at: 2019-05-01
     * @author: dx
     * @version: 1.0
     */
    public void addAttShiftGroup(AttShiftGroupBean attShiftGroupBean) throws MessageException;

    /**
     * @desc:删除班组
     * @param:
     * @return: void
     * @Create at: 2019-05-01
     * @author: dx
     * @version: 1.0
     */
    public void deleteAttShiftGroup(int id) throws MessageException;

    /**
     * @desc:修改班组
     * @param:
     * @return: void
     * @Create at: 2019-05-01
     * @author: dx
     * @version: 1.0
     */
    public void updateAttShiftGroup(AttShiftGroupBean attShiftGroupBean) throws MessageException;

    /**
     * @desc:查询部门信息
     * @param:
     * @return: List<Map < String , Object>>
     * @Create at: 2019-05-02
     * @author: dx
     * @version: 1.0
     */
    public List<Map<String, Object>> queryDepartment() throws MessageException;

    /**
     * @desc:增加部门信息
     * @param:
     * @return: void
     * @Create at: 2019-05-02
     * @author: dx
     * @version: 1.0
     */
    public void addDepartment(DepartmentBean departmentBean) throws MessageException;

    /**
     * @desc:删除部门信息
     * @param:
     * @return: void
     * @Create at: 2019-05-02
     * @author: dx
     * @version: 1.0
     */
    public void deleteDepartment(int id) throws MessageException;

    /**
     * @desc:修改部门信息
     * @param:
     * @return: void
     * @Create at: 2019-05-02
     * @author: dx
     * @version: 1.0
     */
    public void updateDepartment(DepartmentBean departmentBean) throws MessageException;

    /**
     * @desc:查询职位
     * @param:
     * @return: List<PositionDataBean>
     * @Create at: 2019-05-04
     * @author: dx
     * @version: 1.0
     */
    public List<Map<String, Object>> queryPositionData() throws MessageException;

    /**
     * @desc:添加职位
     * @param:
     * @return: void
     * @Create at: 2019-05-04
     * @author: dx
     * @version: 1.0
     */
    public void addPositionData(PositionDataBean positionDataBean) throws MessageException;

    /**
     * @desc:修改职位
     * @param:
     * @return: void
     * @Create at: 2019-05-04
     * @author: dx
     * @version: 1.0
     */
    public void updatePositionData(PositionDataBean positionDataBean) throws MessageException;

    /**
     * @desc:岗位类型
     * @param:
     * @return: List<PositionTypeBean>
     * @Create at: 2019-05-03
     * @author: dx
     * @version: 1.0
     */
    public List<PositionTypeBean> queryPositionType() throws MessageException;

    /**
     * @desc:添加岗位类型
     * @param:
     * @return: void
     * @Create at: 2019-05-03
     * @author: dx
     * @version: 1.0
     */
    public void addPositionType(PositionTypeBean positionTypeBean) throws MessageException;

    /**
     * @desc:删除岗位类型
     * @param:
     * @return: void
     * @Create at: 2019-05-03
     * @author: dx
     * @version: 1.0
     */
    public void deletePositionType(int id) throws MessageException;

    /**
     * @desc:修改岗位类型
     * @param:
     * @return: void
     * @Create at: 2019-05-03
     * @author: dx
     * @version: 1.0
     */
    public void updatePositionType(PositionTypeBean positionTypeBean) throws MessageException;

    /**
     * @desc:查询部门及部门下的员工
     * @param:flag,是否加载员工
     * @param:flag2,是否加载部门下的岗位
     * @return: Map<String , Object>
     * @Create at: 2019-05-04
     * @author: dx
     * @version: 1.0
     */
    public List<DepartmentBean> queryDepartmentEmployee(boolean flag, boolean flag2) throws MessageException;

    /**
     * @desc:查询具体员工的排班计划
     * @param:
     * @return: JSONObject
     * @Create at: 2019-05-07
     * @author: dx
     * @version: 1.0
     */
    public JSONObject queryEmpAttShift(String userId, String userName, String startTime, String endTime, String flag) throws MessageException;

    /**
     * @desc:查询全部员工的排班计划
     * @param:
     * @return: List<Map < String , Object>>
     * @Create at: 2019-05-07
     * @author: dx
     * @version: 1.0
     */
    //public List<Map<String, Object>> queryAllEmpAttShift(Page page,String begDate, String endDate) throws MessageException;
    Page queryAllEmpAttShift(Page page,String begDate, String endDate) throws MessageException;

    /**
     * @desc:删除员工的排班计划
     * @param:
     * @return: void
     * @Create at: 2019-05-07
     * @author: dx
     * @version: 1.0
     */
    public void updateEmpAttShift(Map<String, Object> paraMap) throws MessageException;

    /**
     * @desc:根据部门等级查询部门
     * @param:
     * @return: List<DepartmentBean>
     * @Create at: 2019-05-17
     * @author: dx
     * @version: 1.0
     */
    //public List<DepartmentBean> queryDepartmentByLevel(int level)throws MessageException;

    /**
     * @desc:查询部门下的岗位
     * @param:
     * @return: List<PositionDataBean>
     * @Create at: 2019-05-24
     * @author: dx
     * @version: 1.0
     */
    public List<PositionDataBean> queryPositionDataByDeptId(String deptId, boolean flag) throws MessageException;

    /* *
     * @desc:查询部门树
     * @author: dx
     * @date: 2019-06-18 12:00:09
     * @param :
     * @return:
     * @throws:
     * @version: 1.0
     **/
    public List<DepartmentBean> queryDeptTree(Map<String, Object> param) throws MessageException;

    /* *
     * @desc:查询部门与职位关系
     * @author: dx
     * @date: 2019-06-19 17:24:58
     * @param deptId : 部门id
     * @param postId : 职位id
     * @param isPoint : 是否是重点职位（传空表示不是重点职位，其他均表示重点职位）
     * @return: java.util.List<com.jiubo.erp.kqgl.bean.PositionDataBean>
     * @throws:
     * @version: 1.0
     **/
    public List<PositionDataBean> queryDeptPost(String deptId, String postId, String isPoint);

    /* *
     * @desc:获取部门
     * @author: dx
     * @date: 2019-06-21 13:16:04
     * @return: java.util.List<com.jiubo.erp.rygl.bean.DepartmentBean>
     * @throws:
     * @version: 1.0
     **/
    public List<DepartmentBean> getDept() throws MessageException;

    /* *
     * @desc:将子部门与父级部门组合
     * @author: dx
     * @date: 2019-06-22 13:55:40
     * @param deptList :所有部门
     * @return: java.util.List<com.jiubo.erp.rygl.bean.DepartmentBean>
     * @throws:
     * @version: 1.0
     **/
    public List<DepartmentBean> composeDept(List<DepartmentBean> deptList) throws MessageException;

    /* *
     * @desc:为DepartmentBeanList中的Bean添加前缀
     * @author: dx
     * @date: 2019-06-24 13:34:23
     * @param sourceList :原数据List
     * @param targetList :新数据List
     * @return: void
     * @throws:
     * @version: 1.0
     **/
    public void addDeptPreFix(List<DepartmentBean> sourceList, List<DepartmentBean> targetList) throws MessageException;
}
//班次类别
//public List<AttShift> queryAttShift();
//添加班次类别
//public void addAttShift();