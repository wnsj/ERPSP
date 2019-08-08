package com.jiubo.erp.wzbg.dao;

import com.jiubo.erp.wzbg.bean.DimissionApplyBean;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author dx
 * @since 2019-08-02
 */
public interface DimissionApplyDao extends BaseMapper<DimissionApplyBean>{
    //离职管理查询
    List<DimissionApplyBean> queryDimissionApply(DimissionApplyBean dimissionApplyBean);
}
