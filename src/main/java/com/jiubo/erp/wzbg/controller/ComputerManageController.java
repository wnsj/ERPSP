package com.jiubo.erp.wzbg.controller;


import com.alibaba.fastjson.JSONObject;
import com.jiubo.erp.common.Constant;
import com.jiubo.erp.common.MessageException;
import com.jiubo.erp.common.TimeUtil;
import com.jiubo.erp.wzbg.bean.ComputerManageBean;
import com.jiubo.erp.wzbg.service.ComputerManageService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.util.Date;

/**
 * <p>
 * 电脑用品管理
 * </p>
 *
 * @author dx
 * @since 2019-08-31
 */

@RestController
@Scope("prototype")
@RequestMapping("/computerManageController")
public class ComputerManageController {

    @Autowired
    private ComputerManageService computerManageService;

    /* *
     * @desc:电脑用品查询
     * @author: dx
     * @date: 2019-09-02 11:13:37
     * @param params :
     * @return: com.alibaba.fastjson.JSONObject
     * @throws:
     * @version: 1.0
     **/
    //http://127.0.0.1:8080/computerManageController/queryComputer
    @PostMapping("/queryComputer")
    public JSONObject queryComputer(@RequestBody String params) throws Exception {
        if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败!");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.Result.RETCODE, Constant.Result.SUCCESS);
        jsonObject.put(Constant.Result.RETMSG, Constant.Result.SUCCESS_MSG);
        ComputerManageBean computerManageBean = JSONObject.parseObject(params, ComputerManageBean.class);
        if (StringUtils.isNotBlank(computerManageBean.getEndDate()))
            computerManageBean.setEndDate(TimeUtil.getDateYYYY_MM_DD(TimeUtil.dateAdd(TimeUtil.parseAnyDate(computerManageBean.getEndDate()), TimeUtil.UNIT_DAY, 1)));
        jsonObject.put(Constant.Result.RETDATA, computerManageService.queryComputer(computerManageBean));
        return jsonObject;
    }

    /* *
     * @desc:新增电脑用品申请
     * @author: dx
     * @date: 2019-09-02 14:46:11
     * @param params :
     * @return: com.alibaba.fastjson.JSONObject
     * @throws:
     * @version: 1.0
     **/
    //http://127.0.0.1:8080/computerManageController/addComputer
    @PostMapping("/addComputer")
    public JSONObject addComputer(@RequestBody String params) throws Exception {
        if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败!");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.Result.RETCODE, Constant.Result.SUCCESS);
        jsonObject.put(Constant.Result.RETMSG, Constant.Result.SUCCESS_MSG);
        ComputerManageBean computerManageBean = JSONObject.parseObject(params, ComputerManageBean.class);
        computerManageBean.setStartTime(TimeUtil.getDateYYYY_MM_DD_HH_MM_SS(new Date()));
        computerManageService.addComputer(computerManageBean);
        return jsonObject;
    }

    /* *
     * @desc:修改电脑用品申请
     * @author: dx
     * @date: 2019-09-02 14:50:03
     * @param params :
     * @return: com.alibaba.fastjson.JSONObject
     * @throws:
     * @version: 1.0
     **/
    //http://127.0.0.1:8080/computerManageController/updateComputer
    @PostMapping("/updateComputer")
    public JSONObject updateComputer(@RequestBody String params) throws Exception {
        if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败!");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.Result.RETCODE, Constant.Result.SUCCESS);
        jsonObject.put(Constant.Result.RETMSG, Constant.Result.SUCCESS_MSG);
        ComputerManageBean computerManageBean = JSONObject.parseObject(params, ComputerManageBean.class);
        computerManageService.updateComputer(computerManageBean);
        return jsonObject;
    }

    /* *
     * @desc:主管，负责人审核
     * @author: dx
     * @date: 2019-09-05 10:25:59
     * @param params :
     * @return: com.alibaba.fastjson.JSONObject
     * @throws:
     * @version: 1.0
     **/
    @PostMapping("/shenHe")
    public JSONObject shenHe(@RequestBody String params) throws Exception {
        if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败!");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.Result.RETCODE, Constant.Result.SUCCESS);
        jsonObject.put(Constant.Result.RETMSG, Constant.Result.SUCCESS_MSG);
        ComputerManageBean computerManageBean = JSONObject.parseObject(params, ComputerManageBean.class);
        if("2".equals(computerManageBean.getIsIng()))computerManageBean.setEndTime(TimeUtil.getDateYYYY_MM_DD_HH_MM_SS(new Date()));
        computerManageService.shenHe(computerManageBean);
        return jsonObject;
    }
}
