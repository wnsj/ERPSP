package com.jiubo.erp.wzbg.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jiubo.erp.wzbg.bean.ComputerManageBean;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author dx
 * @since 2019-08-31
 */
public interface ComputerManageDao extends BaseMapper<ComputerManageBean> {

    //查询电脑用品
    List<ComputerManageBean> queryComputer(ComputerManageBean computerManageBean);

    //新增电脑用品
    //int addComputer(ComputerManageBean computerManageBean);
}
