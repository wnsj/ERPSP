package com.jiubo.erp.wzbg.dao;

import com.jiubo.erp.wzbg.bean.OfficeNameBean;
import com.jiubo.erp.wzbg.bean.OfficeSuppliesDataBean;
import com.jiubo.erp.wzbg.bean.OfficeUserDataBean;
import com.jiubo.erp.wzbg.bean.SpecificationBean;
import com.jiubo.erp.wzbg.bean.OfficeDataBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @desc:
 * @date: 2019-07-12 15:25
 * @author: dx
 * @version: 1.0
 */
public interface OfficeDao {
    //办公用品管理查询接口
    public List<OfficeSuppliesDataBean> queryOfficeSuppliesData(OfficeSuppliesDataBean officeSuppliesDataBean);

    //办公用品名
    public List<OfficeNameBean> queryOfficeName(OfficeNameBean officeNameBean);

    //办公用品规格
    public List<SpecificationBean> querySpecification(SpecificationBean specificationBean);

    //添加或修改办公用品信息
    public int addUpdateOfficeSupplies(@Param("officeList") List<OfficeSuppliesDataBean> officeList);

    //删除办公用品信息
    public void deleteOfficeSupplies(@Param("officeList") List<OfficeSuppliesDataBean> officeList);

    //查询办公用品信息
    public List<OfficeSuppliesDataBean> getOfficeSuppliesData(OfficeSuppliesDataBean officeSuppliesDataBean);

    //办公用品信息汇总
    public List<OfficeSuppliesDataBean> gatherOfficeSupplies(OfficeSuppliesDataBean officeSuppliesDataBean);

    //查询审核意见
    public List<Map<String, Object>> queryAdvance(OfficeSuppliesDataBean officeSuppliesDataBean);

    //获取意见给出人
    public List<Map<String, Object>> queryAdvancePeo(Map<String, Object> param);

    //提交，审核
    public void commitAndSheHe(@Param("officeList") List<OfficeSuppliesDataBean> officeList);

    //根据部门id查询部门所属的等级
    public int queryDeptLevel(@Param("count") int count, @Param("deptId") String deptId);

    //查询部门相关负责人(主管及组长)
    public List<Map<String, Object>> queryDeptConscientious(@Param("level") int level, @Param("deptId") String deptId);

    //查询本部门主管
    public List<Map<String, Object>> queryDeptResponsible(@Param("level") int level, @Param("deptId") String deptId);

    //扩大部门主管范围
    public List<Map<String, Object>> queryDeptExpandResponsible(@Param("level") int level, @Param("deptId") String deptId);

    //普岗，资深，主力，组长，主管
    public int isPuGang(@Param("postId")String postId,@Param("postName")String postName);

    //部长，总监
    public int isBuZhang(@Param("postId")String postId,@Param("postName")String postName);

    //副总
    public int isFuZong(@Param("postId")String postId,@Param("postName")String postName);

    //查询审查人（暂不使用）
    public List<Map<String, Object>> queryCensor(@Param("level") int level);

    //查询审查人
    public List<Map<String, Object>> queryCensors(@Param("postLevel") int postLevel,@Param("deptLevel")int deptLevel,@Param("deptId")String deptId);

    //查询电脑交接人
    public List<Map<String, Object>> queryComputerHandover();

    //查询办公用品交接人
    public List<Map<String, Object>> queryOfficeHandover();

    //查询人力负责人
    public List<Map<String, Object>> queryManpowerOfficer();

    //查询审批负责人
    public List<Map<String, Object>> queryApprovalOfficer(@Param("postLevel")int postLevel);

    //查询会议室申请信息
    public List<OfficeUserDataBean> queryOfficeUserData(OfficeUserDataBean officeUserDataBean);

    //会议室查询
    public List<OfficeDataBean> queryOfficeData();

    //申请会议室
    public void addOfficeUserData(OfficeUserDataBean officeUserDataBean);

    //修改会议室申请信息
    public void updateOfficeUserData(OfficeUserDataBean officeUserDataBean);

    public int updateOfficeUserDataState(OfficeUserDataBean officeUserDataBean);
}
