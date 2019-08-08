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
    /* *
     * @desc:离职管理查询
     * @author: dx
     * @date: 2019-08-03 17:27:51
     * @param dimissionApplyBean :
     * @return: java.util.List<com.jiubo.erp.wzbg.bean.DimissionApplyBean>
     * @throws:
     * @version: 1.0
     **/
    List<DimissionApplyBean> queryDimissionApply(DimissionApplyBean dimissionApplyBean);
}
