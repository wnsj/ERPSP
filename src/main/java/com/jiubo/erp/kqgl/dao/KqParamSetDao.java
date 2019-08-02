package com.jiubo.erp.kqgl.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.jiubo.erp.common.MessageException;
import com.jiubo.erp.kqgl.bean.AttRuleTypeBean;
import com.jiubo.erp.kqgl.bean.AttShiftBean;
import com.jiubo.erp.kqgl.bean.AttShiftGroupBean;
import com.jiubo.erp.kqgl.bean.AttShiftScheduleBean;
import com.jiubo.erp.kqgl.bean.PositionDataBean;
import com.jiubo.erp.kqgl.bean.PositionTypeBean;
import com.jiubo.erp.kqgl.vo.Vacation;
import com.jiubo.erp.rygl.bean.DepartmentBean;
import com.jiubo.erp.rygl.bean.EmployeeBasicBean;

public interface KqParamSetDao {

    //查询假期种类
    public List<Vacation> queryVacation();

    //修改假期种类
    public int updateVacation(@Param("vacation") Vacation vacation);

    //删除假期种类
    public int deleteVacation(int id);

    //添加假期种类
    public int addVacation(@Param("vacation") Vacation vacation);

    //查询考勤规则
    public List<AttRuleTypeBean> queryAttRuleType();

    //添加考勤规则
    public int addAttRuleType(@Param("attRuleType") AttRuleTypeBean attRuleType);

    //删除考勤规则
    public void deleteAttRuleType(int id);

    //修改考勤规则
    public void updateAttRuleType(@Param("attRuleType") AttRuleTypeBean attRuleType);

    //查询班次
    public List<AttShiftScheduleBean> queryAttShiftSchedule();

    //添加班次
    public void addAttShiftSchedule(@Param("attShiftSchedule") AttShiftScheduleBean attShiftSchedule);

    //删除班次
    public void deleteAttShiftSchedule(int id);

    //修改班次
    public void updateAttShiftSchedule(@Param("attShiftSchedule") AttShiftScheduleBean attShiftSchedule);

    //查询班组
    public List<AttShiftGroupBean> queryAttShiftGroup();

    //添加班组
    public void addAttShiftGroup(@Param("attShiftGroupBean") AttShiftGroupBean attShiftGroupBean);

    //删除班组
    public void deleteAttShiftGroup(int id);

    //修改班组
    public void updateAttShiftGroup(@Param("attShiftGroupBean") AttShiftGroupBean attShiftGroupBean);

    //查询部门信息
    public List<Map<String, Object>> queryDepartment();

    //增加部门信息
    public void addDepartment(DepartmentBean departmentBean);

    //删除部门信息
    public void deleteDepartment(int id);

    //修改部门信息
    public void updateDepartment(DepartmentBean departmentBean);

    //查询职位
    public List<Map<String, Object>> queryPositionData();

    //增加职位
    public void addPositionData(PositionDataBean positionDataBean);

    //修改职位
    public void updatePositionData(PositionDataBean positionDataBean);

    //查询岗位类型
    public List<PositionTypeBean> queryPositionType();

    //添加岗位类型
    public void addPositionType(PositionTypeBean positionTypeBean);

    //删除岗位类型
    public void deletePositionType(int id);

    //修改岗位类型
    public void updatePositionType(PositionTypeBean positionTypeBean);

    //根据ParentID查询部门信息
    public List<DepartmentBean> queryDepartmentByPId(String pId);

    //查询所属部门员工
    public List<EmployeeBasicBean> queryEmployeeBasic(@Param("departmentId") String departmentId, @Param("state") String state);

    //查询具体员工的排班计划
    public List<AttShiftBean> queryAttShift(@Param("userId") String userId, @Param("userName") String userName, @Param("startTime") String startTime, @Param("endTime") String endTime);

    //查询全部员工的排班计划
    public List<Map<String, Object>> queryAllEmpAttShift(@Param("begDate") String begDate, @Param("endDate") String endDate);

    //删除排班计划关系
    //public void deleteAttPeopleShift(String id);

    //删除员工的排班计划(逻辑删除)
    public void updateAttShift(@Param("begDate") String begDate, @Param("endDate") String endDate);

    //查询部门下的岗位
    public List<PositionDataBean> queryPositionDataByDeptId(@Param("deptId") String deptId, @Param("postId") String postId, @Param("isPoint") String isPoint);

    //查询部门树
    public List<DepartmentBean> queryDeptTree();
}
