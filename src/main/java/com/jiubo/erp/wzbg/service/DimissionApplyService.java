package com.jiubo.erp.wzbg.service;

import com.jiubo.erp.wzbg.bean.DimissionApplyBean;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author dx
 * @since 2019-08-02
 */
public interface DimissionApplyService extends IService<DimissionApplyBean> {

    List<DimissionApplyBean> queryDimissionApplyByPage(DimissionApplyBean dimissionApplyBean);
}
