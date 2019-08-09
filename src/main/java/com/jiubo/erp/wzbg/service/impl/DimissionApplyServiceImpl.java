package com.jiubo.erp.wzbg.service.impl;

import com.jiubo.erp.wzbg.bean.DimissionApplyBean;
import com.jiubo.erp.wzbg.dao.DimissionApplyDao;
import com.jiubo.erp.wzbg.service.DimissionApplyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *   离职管理 服务实现类
 * </p>
 *
 * @author dx
 * @since 2019-08-02
 */
@Service
public class DimissionApplyServiceImpl extends ServiceImpl<DimissionApplyDao, DimissionApplyBean> implements DimissionApplyService {

    @Autowired
    private DimissionApplyDao dimissionApplyDao;

    @Override
    public List<DimissionApplyBean> queryDimissionApply(DimissionApplyBean dimissionApplyBean) {
        return dimissionApplyDao.queryDimissionApply(dimissionApplyBean);
    }

    @Override
    public void addDimissionApply(DimissionApplyBean dimissionApplyBean) {
        int count = dimissionApplyDao.insert(dimissionApplyBean);
    }
}
