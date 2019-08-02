package com.jiubo.erp.ryxxl.controller;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.jiubo.erp.common.Constant;
import com.jiubo.erp.common.MessageException;
import com.jiubo.erp.ryxxl.bean.DepartmentAttendanceBean;
import com.jiubo.erp.ryxxl.service.RyxxlService;

//人员信息管理类模块接口
@Controller
@Scope("prototype")
@RequestMapping("/ryxxlController")
public class RyxxlController {

    public static Logger log = LoggerFactory.getLogger(RyxxlController.class);

    @Autowired
    private RyxxlService ryxxlService;

    /**
     * @desc:在职人员分析报表
     * @param:
     * @return: JSONObject
     * @Create at: 2019-05-14
     * @author: dx
     * @version: 1.0
     */
    //http://127.0.0.1:8080/Erp/ryxxlController/queryZzryReport?date=2019-01-01&flag=1&deptId=6&incude=0
    @ResponseBody
    @RequestMapping(value = "/queryZzryReport", method = {RequestMethod.POST})
    public JSONObject queryZzryReport(@RequestBody String params) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败！");
            Map<String, Object> requestMap = JSONObject.parseObject(params, Map.class);
            result.put(Constant.Result.RETDATA, ryxxlService.queryZzryReport(requestMap));
        } catch (MessageException e) {
            retCode = Constant.Result.ERROR;
            retMsg = e.getMessage();
        } catch (Exception e) {
            retCode = Constant.Result.ERROR;
            retMsg = Constant.Result.ERROR_MSG;
            log.error(Constant.Result.RETMSG, e);
        } finally {
            result.put(Constant.Result.RETCODE, retCode);
            result.put(Constant.Result.RETMSG, retMsg);
            return result;
        }
    }

    /**
     * @desc:离职人员分析报表
     * @param:
     * @return: JSONObject
     * @Create at: 2019-05-24
     * @author: dx
     * @version: 1.0
     */
    //http://127.0.0.1:8080/Erp/ryxxlController/queryLzryReport?begDate=2018-01-01&endDate=2019-01-15&deptId=&posId=
    @ResponseBody
    @RequestMapping(value = "/queryLzryReport", method = {RequestMethod.POST})
    public JSONObject queryLzryReport(@RequestBody String params) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败！");
            Map<String, Object> requestMap = JSONObject.parseObject(params, Map.class);
            //result.put(Constant.Result.RETDATA, ryxxlService.queryLzryReport(requestMap));
            result.put(Constant.Result.RETDATA, ryxxlService.getLzryReport(requestMap));
        } catch (MessageException e) {
            retCode = Constant.Result.ERROR;
            retMsg = e.getMessage();
        } catch (Exception e) {
            retCode = Constant.Result.ERROR;
            retMsg = Constant.Result.ERROR_MSG;
            log.error(Constant.Result.RETMSG, e);
        } finally {
            result.put(Constant.Result.RETCODE, retCode);
            result.put(Constant.Result.RETMSG, retMsg);
            return result;
        }
    }

    /**
     * @desc:人力资源异动分析报表
     * @param:
     * @return: JSONObject
     * @Create at: 2019-05-23
     * @author: dx
     * @version: 1.0
     */
    //http://127.0.0.1:8080/Erp/ryxxlController/queryChanges?begDate=2019-01&level=1&deptId=0
    @ResponseBody
    @RequestMapping(value = "/queryChanges", method = {RequestMethod.POST})
    public JSONObject queryChanges(@RequestBody String params) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败！");
            Map<String, Object> requestMap = JSONObject.parseObject(params, Map.class);
            //result.put(Constant.Result.RETDATA, ryxxlService.queryChanges(requestMap));
            result.put(Constant.Result.RETDATA, ryxxlService.getChanges(requestMap));
        } catch (MessageException e) {
            retCode = Constant.Result.ERROR;
            retMsg = e.getMessage();
        } catch (Exception e) {
            retCode = Constant.Result.ERROR;
            retMsg = Constant.Result.ERROR_MSG;
            log.error(Constant.Result.RETMSG, e);
        } finally {
            result.put(Constant.Result.RETCODE, retCode);
            result.put(Constant.Result.RETMSG, retMsg);
            return result;
        }
    }

    /**
     * @desc:招聘效果分析表
     * @param:
     * @return: JSONObject
     * @Create at: 2019-05-24
     * @author: dx
     * @version: 1.0
     */
    //http://127.0.0.1:8080/Erp/ryxxlController/queryRecruit?begDate=2019-01&endDate=2019-04&deptId=&posId=
    @ResponseBody
    @RequestMapping(value = "/queryRecruit", method = {RequestMethod.POST})
    public JSONObject queryRecruit(@RequestBody String params) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败！");
            Map<String, Object> requestMap = JSONObject.parseObject(params, Map.class);
            //result.put(Constant.Result.RETDATA, ryxxlService.queryRecruit(requestMap));
            result.put(Constant.Result.RETDATA, ryxxlService.getRecruit(requestMap));
        } catch (MessageException e) {
            retCode = Constant.Result.ERROR;
            retMsg = e.getMessage();
        } catch (Exception e) {
            retCode = Constant.Result.ERROR;
            retMsg = Constant.Result.ERROR_MSG;
            log.error(Constant.Result.RETMSG, e);
        } finally {
            result.put(Constant.Result.RETCODE, retCode);
            result.put(Constant.Result.RETMSG, retMsg);
            return result;
        }
    }

    /**
     * @desc:人力资源利用率报表
     * @param:
     * @return: JSONObject
     * @Create at: 2019-05-28
     * @author: dx
     * @version: 1.0
     */
    //http://127.0.0.1:8080/Erp/ryxxlController/queryRlzylyReport?deptId=40&begDate=2019-01&isEntry=0&isQuit=0
    @ResponseBody
    @RequestMapping(value = "/queryRlzylyReport", method = {RequestMethod.POST})
    public JSONObject queryRlzylyReport(@RequestBody String params) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败！");
            Map<String, Object> requestMap = JSONObject.parseObject(params, Map.class);
            //result.put(Constant.Result.RETDATA, ryxxlService.queryRlzylyReport(requestMap));
            result.put(Constant.Result.RETDATA, ryxxlService.getRlzylyReport(requestMap));
        } catch (MessageException e) {
            retCode = Constant.Result.ERROR;
            retMsg = e.getMessage();
        } catch (Exception e) {
            retCode = Constant.Result.ERROR;
            retMsg = Constant.Result.ERROR_MSG;
            log.error(Constant.Result.RETMSG, e);
        } finally {
            result.put(Constant.Result.RETCODE, retCode);
            result.put(Constant.Result.RETMSG, retMsg);
            return result;
        }
    }

    /**
     * @desc:修改或添加部门未打卡信息
     * @param:
     * @return: JSONObject
     * @Create at: 2019-05-28
     * @author: dx
     * @version: 1.0
     */
    //http://127.0.0.1:8080/Erp/ryxxlController/updateAddDeptAttendance?id=0&num=88&departmentId=86&dataMonth=2019-05-01
    @ResponseBody
    @RequestMapping(value = "/updateAddDeptAttendance", method = {RequestMethod.POST})
    public JSONObject updateAddDeptAttendance(@RequestBody String params) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败！");
            DepartmentAttendanceBean departmentAttendanceBean = JSONObject.parseObject(params, DepartmentAttendanceBean.class);
            ryxxlService.updateAddDeptAttendance(departmentAttendanceBean);
        } catch (MessageException e) {
            retCode = Constant.Result.ERROR;
            retMsg = e.getMessage();
        } catch (Exception e) {
            retCode = Constant.Result.ERROR;
            retMsg = Constant.Result.ERROR_MSG;
            log.error(Constant.Result.RETMSG, e);
        } finally {
            result.put(Constant.Result.RETCODE, retCode);
            result.put(Constant.Result.RETMSG, retMsg);
            return result;
        }
    }
}
/*
  //分页插件的用法
 //	PageHelper.offsetPage(0,10);
 PageHelper.startPage(0,10);
 List<RecruitChannelBean> recruitChannelBeans = zpglDao.queryRecruitChannel();
 PageInfo page = new PageInfo(recruitChannelBeans);
 //获取总条数
 System.out.println("Total:"+page.getTotal());
 */
