package com.jiubo.erp.wzbg.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.jiubo.erp.common.MessageException;
import com.jiubo.erp.wzbg.bean.ComputerManageBean;

import java.util.List;

/**
 * <p>
 *  电脑用品管理服务类
 * </p>
 *
 * @author dx
 * @since 2019-08-31
 */
public interface ComputerManageService extends IService<ComputerManageBean> {

    //查询电脑用品
    public List<ComputerManageBean> queryComputer(ComputerManageBean computerManageBean);

    //新增电脑用品申请
    public void addComputer(ComputerManageBean computerManageBean);

    //修改电脑用品申请
    public void updateComputer(ComputerManageBean computerManageBean);

    //主管，负责人审核
    public void shenHe(ComputerManageBean computerManageBean) throws MessageException;

    //电脑用品通知
    public List<ComputerManageBean> queryComputerNotice(int flag)throws MessageException;
}
