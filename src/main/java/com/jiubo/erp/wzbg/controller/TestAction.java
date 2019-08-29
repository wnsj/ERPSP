package com.jiubo.erp.wzbg.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jiubo.erp.common.Constant;
import com.jiubo.erp.common.MessageException;
import com.jiubo.erp.wzbg.bean.DimissionApplyBean;
import com.jiubo.erp.wzbg.dao.DimissionApplyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

/**
 * @desc:
 * @date: 2019-07-31 15:12
 * @author: dx
 * @version: 1.0
 */

@RestController
@Scope("prototype")
@RequestMapping("/testAction")
public class TestAction {

    @Autowired
    private DimissionApplyDao dimissionApplyDao;

    @GetMapping("/test")
    public JSONObject test() throws Exception {
        Page<DimissionApplyBean> page = new Page<DimissionApplyBean>();
        page.setCurrent(1);
        page.setSize(2);
        JSONObject result = new JSONObject();
        result.put(Constant.Result.RETCODE,Constant.Result.SUCCESS);
        //System.out.println(dimissionApplyDao.queryDimissionApplyByPage(page));
        //result.put(Constant.Result.RETDATA,dimissionApplyDao.queryVacation(null));
        //int i = 1 / 0;
        //if(true)throw new MessageException("自定义异常!");

        return result;
    }


}
