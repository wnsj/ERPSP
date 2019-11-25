package com.jiubo.erp.wzbg.dao;

import com.jiubo.erp.wzbg.bean.GoOutRegisterBean;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author dx
 * @since 2019-08-11
 */
public interface GoOutRegisterDao extends BaseMapper<GoOutRegisterBean> {

    //外出登记查询
    List<GoOutRegisterBean> queryGoOutRegister(GoOutRegisterBean goOutRegisterBean);

    //修改外出登记
   int updateGoOutRegister(GoOutRegisterBean goOutRegisterBean);

   //新增外出登记
   int addGoOutRegister(@Param("registerBeanList") List<GoOutRegisterBean> registerBeanList);

   //查询部门下的员工
    List<Map<String, Object>> getOutData(@Param("params") Map<String, Object> params);

    //根据部门id查询相关负责人
    List<Map<String, Object>> selectDeptLeaderById(@Param("map") Map<String, Object> map);

    //根据部门id查询部门信息
    Map<String, Object> selectDeptById(String deptid);

    //根据部门id查询部门上级id集合
    List<Object> expandDeptLeaderById(String deptid);

    //根据id修改是否取消状态
    void updateGoOutDeleteById(String id);

    //更新通知人或报备人意见
    int updateAdvice(Map<String, String> map);

    //根据parentId查询同级部门id集合
    List<Object> selectDeptLeaderByParentId(String parentID);
}
