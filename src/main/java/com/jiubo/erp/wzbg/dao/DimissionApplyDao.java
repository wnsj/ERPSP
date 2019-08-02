package com.jiubo.erp.wzbg.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jiubo.erp.wzbg.bean.DimissionApplyBean;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

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
    Page<DimissionApplyBean> queryDimissionApplyByPage(Page<DimissionApplyBean> page);

    //List<DimissionApplyBean> queryDimissionApplyByPage(Page<DimissionApplyBean> page);
}
