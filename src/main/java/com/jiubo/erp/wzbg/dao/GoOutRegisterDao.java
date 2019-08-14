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
}
