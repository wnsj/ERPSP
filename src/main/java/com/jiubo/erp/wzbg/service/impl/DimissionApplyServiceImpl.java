package com.jiubo.erp.wzbg.service.impl;

import com.jiubo.erp.common.MessageException;
import com.jiubo.erp.wzbg.bean.DimissionApplyBean;
import com.jiubo.erp.wzbg.dao.DimissionApplyDao;
import com.jiubo.erp.wzbg.service.DimissionApplyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
@Transactional
public class DimissionApplyServiceImpl extends ServiceImpl<DimissionApplyDao, DimissionApplyBean> implements DimissionApplyService {

    @Autowired
    private DimissionApplyDao dimissionApplyDao;

    @Override
    public List<DimissionApplyBean> queryDimissionApply(DimissionApplyBean dimissionApplyBean)throws MessageException {
        return dimissionApplyDao.queryDimissionApply(dimissionApplyBean);
    }

    @Override
    public void addDimissionApply(DimissionApplyBean dimissionApplyBean)throws MessageException {
        int count = dimissionApplyDao.insert(dimissionApplyBean);
    }

    @Override
    public void updateDimissionApply(DimissionApplyBean dimissionApplyBean) throws MessageException {
        if(dimissionApplyDao.updateById(dimissionApplyBean) <= 0)throw new MessageException("修改失败!");
    }

    @Override
    public void examineApprove(DimissionApplyBean dimissionApplyBean) throws MessageException {
        if(StringUtils.isBlank(dimissionApplyBean.getId()))throw new MessageException("id不能为空!");
        DimissionApplyBean applyBean = new DimissionApplyBean();
        applyBean.setId(dimissionApplyBean.getId());
        List<DimissionApplyBean> dimissionApplyBeans = dimissionApplyDao.queryDimissionApply(applyBean);
        if(dimissionApplyBeans.size() <= 0)throw new MessageException("数据异常!");
        applyBean = dimissionApplyBeans.get(0);
        if ("已完成".equals(applyBean.getDaIsCollect()))throw new MessageException("离职手续已完成不可操作!");
        if (StringUtils.isNotBlank(dimissionApplyBean.getDaChargeAdvice())){
            //主管审核
            if (!"未审核".equals(applyBean.getDaChargeAdvice())) throw new MessageException("不可重复审核!");
        } else if(StringUtils.isNotBlank(dimissionApplyBean.getDaMinisterAdvice())){
            //审查人审核
            if(!"同意".equals(applyBean.getDaChargeAdvice()))throw new MessageException("主管未同意前不可审核!");
            if (!"未审核".equals(applyBean.getDaMinisterAdvice())) throw new MessageException("不可重复审核!");
        }else if (StringUtils.isNotBlank(dimissionApplyBean.getDaConnectAdvice())){
            //电脑交接人审核
            if (!"同意".equals(applyBean.getDaMinisterAdvice()))throw new MessageException("审查人未同意前不可审核!");
            if(!"未审核".equals(applyBean.getDaConnectAdvice())) throw new MessageException("不可重复审核!");
        }else if(StringUtils.isNotBlank(dimissionApplyBean.getDaPersonnelOfficeAdvice())){
            //生活用品交接人审核
            if (!"同意".equals(applyBean.getDaConnectAdvice()))throw new MessageException("电脑交接人未同意前不可审核!");
            if(!"未审核".equals(applyBean.getDaPersonnelOfficeAdvice())) throw new MessageException("不可重复审核!");
        }else if(StringUtils.isNotBlank(dimissionApplyBean.getDaAuditorAdvice())){
            //人力负责人审核
            if (!"同意".equals(applyBean.getDaPersonnelOfficeAdvice()))throw new MessageException("生活用品交接人未同意前不可审核!");
            if(!"未审核".equals(applyBean.getDaAuditorAdvice())) throw new MessageException("不可重复审核!");
        }else if(StringUtils.isNotBlank(dimissionApplyBean.getDaApproverAdvice())){
            //审批负责人审核
            if (!"同意".equals(applyBean.getDaAuditorAdvice()))throw new MessageException("人力负责人未同意前不可审核!");
            if(!"未审核".equals(applyBean.getDaApproverAdvice())) throw new MessageException("不可重复审核!");
        }else if(StringUtils.isNotBlank(dimissionApplyBean.getDaIsCollect())){
            //点击完成
            if (!"同意".equals(applyBean.getDaApproverAdvice()))throw new MessageException("审批负责人未同意前不可审核!");
            if(!"点击完成".equals(applyBean.getDaIsCollect()))throw new MessageException("已完成，不可重复操作!");
        }
        if (dimissionApplyDao.examineApprove(dimissionApplyBean) <= 0)throw new MessageException("操作失败!");
    }
}
