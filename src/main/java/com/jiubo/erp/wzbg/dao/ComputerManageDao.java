package com.jiubo.erp.wzbg.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jiubo.erp.wzbg.bean.ComputerManageBean;
import org.apache.ibatis.annotations.Param;

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

    //主管，负责人审核
    int shenHe(ComputerManageBean computerManageBean);

    //电脑用品通知
    public List<ComputerManageBean> queryComputerNotice(@Param("flag") int flag);

}
