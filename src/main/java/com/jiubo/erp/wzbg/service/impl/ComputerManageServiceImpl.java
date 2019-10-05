package com.jiubo.erp.wzbg.service.impl;


import com.jiubo.erp.common.MessageException;
import com.jiubo.erp.wzbg.bean.ComputerManageBean;
import com.jiubo.erp.wzbg.dao.ComputerManageDao;
import com.jiubo.erp.wzbg.service.ComputerManageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 电脑用品管理服务实现类
 * </p>
 *
 * @author dx
 * @since 2019-08-31
 */
@Service
public class ComputerManageServiceImpl extends ServiceImpl<ComputerManageDao, ComputerManageBean> implements ComputerManageService {

    @Autowired
    private ComputerManageDao computerManageDao;

    @Override
    public List<ComputerManageBean> queryComputer(ComputerManageBean computerManageBean) {
        return computerManageDao.queryComputer(computerManageBean);
    }

    @Override
    public void addComputer(ComputerManageBean computerManageBean) {
        computerManageDao.insert(computerManageBean);
    }

    @Override
    public void updateComputer(ComputerManageBean computerManageBean) {
        computerManageDao.updateById(computerManageBean);
    }

    @Override
    public void shenHe(ComputerManageBean computerManageBean) throws MessageException {
        if (computerManageDao.shenHe(computerManageBean) <= 0) throw new MessageException("操作失败!");
    }

    @Override
    public List<ComputerManageBean> queryComputerNotice(int flag) throws MessageException {
        return computerManageDao.queryComputerNotice(flag);
    }
}
