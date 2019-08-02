package com.jiubo.erp.kqgl.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.jiubo.erp.common.Constant;
import com.jiubo.erp.common.MapUtil;
import com.jiubo.erp.common.MessageException;
import com.jiubo.erp.erpLogin.util.ResponseMessageUtils;
import com.jiubo.erp.kqgl.bean.AttRuleTypeBean;
import com.jiubo.erp.kqgl.bean.AttShiftGroupBean;
import com.jiubo.erp.kqgl.bean.AttShiftScheduleBean;
import com.jiubo.erp.kqgl.bean.PositionDataBean;
import com.jiubo.erp.kqgl.bean.PositionTypeBean;
import com.jiubo.erp.kqgl.service.KqParamSetService;
import com.jiubo.erp.kqgl.vo.Vacation;
import com.jiubo.erp.rygl.bean.DepartmentBean;
import com.quicksand.push.ToolClass;

@Controller
@Scope("prototype")
@RequestMapping("/kqParamSetContr")
public class KqParamSetController {

    public static Logger log = LoggerFactory.getLogger(KqParamSetController.class);

    @Autowired
    private KqParamSetService KqParamSetService;

    /**
     * @desc:查询假期种类
     * @param:
     * @return: List<Vacation>
     * @Create at: 2019-04-30
     * @author: dx
     * @version: 1.0
     */
    //http://127.0.0.1:8080/Erp/kqParamSetContr/queryVacation
    @ResponseBody
    @RequestMapping(value = "/queryVacation", method = {RequestMethod.GET, RequestMethod.POST})
    public JSONObject queryVacation(HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;

        try {
            result.put(Constant.Result.RETDATA, KqParamSetService.queryVacation());
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
     * @desc:修改假期种类
     * @param:
     * @return: void
     * @Create at: 2019-04-30
     * @author: dx
     * @version: 1.0
     */
    //http://127.0.0.1:8080/Erp1.1/kqParamSetContr/updateVacation?name=777&id=22
    @ResponseBody
    @RequestMapping(value = "/updateVacation", method = {RequestMethod.POST})
    public JSONObject updateVacation(HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str)) throw new MessageException("参数接收失败！");
            Vacation vacation = MapUtil.transJsonStrToObjectIgnoreCase(str, Vacation.class);
            if (StringUtils.isBlank(vacation.getId()) || StringUtils.isBlank(vacation.getName()))
                throw new MessageException("假期种类ID为空或假期种类名为空！");
            KqParamSetService.updateVacation(vacation);
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
     * @desc:删除假期种类
     * @param:
     * @return: void
     * @Create at: 2019-04-30
     * @author: dx
     * @version: 1.0
     */
    //http://127.0.0.1:8080/Erp1.1/kqParamSetContr/deleteVacation?id=22
    @ResponseBody
    @RequestMapping(value = "/deleteVacation", method = {RequestMethod.POST})
    public JSONObject deleteVacation(@RequestBody Map<String, Object> requestMap, HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            int id = MapUtil.getIntIgnoreCase(requestMap, "id", MapUtil.NOT_NULL);
            KqParamSetService.deleteVacation(id);
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
     * @desc:添加假期种类
     * @param:
     * @return: void
     * @Create at: 2019-04-30
     * @author: dx
     * @version: 1.0
     */
    //http://127.0.0.1:8080/Erp1.1/kqParamSetContr/addVacation?name=666
    @ResponseBody
    @RequestMapping(value = "/addVacation", method = {RequestMethod.POST})
    public JSONObject addVacation(HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str)) throw new MessageException("参数接收失败！");
            Vacation vacation = MapUtil.transJsonStrToObjectIgnoreCase(str, Vacation.class);
            if (StringUtils.isBlank(vacation.getName())) throw new MessageException("假期种类名不能为空！");
            vacation.setIsDelete("0");
            vacation.setCreateDate(ToolClass.inquirNowDateTime());
            KqParamSetService.addVacation(vacation);
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
     * @desc:查询考勤规则
     * @param:
     * @return: List<AttRuleType>
     * @Create at: 2019-04-30
     * @author: dx
     * @version: 1.0
     */
    //http://127.0.0.1:8080/Erp1.1/kqParamSetContr/queryAttRuleType
    @ResponseBody
    @RequestMapping(value = "/queryAttRuleType", method = {RequestMethod.POST})
    public JSONObject queryAttRuleType(HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            result.put(Constant.Result.RETDATA, KqParamSetService.queryAttRuleType());
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
     * @desc:添加考勤规则
     * @param:
     * @return: void
     * @Create at: 2019-04-30
     * @author: dx
     * @version: 1.0
     */
    //http://127.0.0.1:8080/Erp1.1/kqParamSetContr/addAttRuleType?name=88&earlyMinutes=10&lateMinutes=20
    @ResponseBody
    @RequestMapping(value = "/addAttRuleType", method = {RequestMethod.POST})
    public JSONObject addAttRuleType(HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str)) throw new MessageException("参数接收失败！");
            AttRuleTypeBean attRuleType = MapUtil.transJsonStrToObjectIgnoreCase(str, AttRuleTypeBean.class);
            if (StringUtils.isBlank(attRuleType.getName()) || StringUtils.isBlank(attRuleType.getEarlyMinutes()) || StringUtils.isBlank(attRuleType.getLateMinutes()))
                throw new MessageException("考勤规则名为空、最早时间为空或最晚时间为空！");
            attRuleType.setIsDelete("0");
            attRuleType.setCreateDate(ToolClass.inquirNowDateTime());
            KqParamSetService.addAttRuleType(attRuleType);
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
     * @desc:删除考勤规则
     * @param:
     * @return: void
     * @Create at: 2019-04-30
     * @author: dx
     * @version: 1.0
     */
    //http://127.0.0.1:8080/Erp1.1/kqParamSetContr/deleteAttRuleType?id=5
    @ResponseBody
    @RequestMapping(value = "/deleteAttRuleType", method = {RequestMethod.POST})
    public JSONObject deleteAttRuleType(@RequestBody Map<String, Object> requestMap, HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            int id = MapUtil.getIntIgnoreCase(requestMap, "id", MapUtil.NOT_NULL);
            KqParamSetService.deleteAttRuleType(id);
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
     * @desc:修改考勤规则
     * @param:
     * @return: void
     * @Create at: 2019-04-30
     * @author: dx
     * @version: 1.0
     */
    //http://127.0.0.1:8080/Erp1.1/kqParamSetContr/updateAttRuleType?name=99&earlyMinutes=20&lateMinutes=30&id=5
    @ResponseBody
    @RequestMapping(value = "/updateAttRuleType", method = {RequestMethod.POST})
    public JSONObject updateAttRuleType(HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str)) throw new MessageException("参数接收失败！");
            AttRuleTypeBean attRuleType = MapUtil.transJsonStrToObjectIgnoreCase(str, AttRuleTypeBean.class);
            if (StringUtils.isBlank(attRuleType.getName()) || StringUtils.isBlank(attRuleType.getEarlyMinutes())
                    || StringUtils.isBlank(attRuleType.getLateMinutes()) || StringUtils.isBlank(attRuleType.getId()))
                throw new MessageException("考勤规则名为空、最早时间为空、最晚时间为空或考勤规则id为空！");
            KqParamSetService.updateAttRuleType(attRuleType);
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
     * @desc:查询班次
     * @param:
     * @return: List<AttShiftSchedule>
     * @Create at: 2019-05-01
     * @author: dx
     * @version: 1.0
     */
    //http://127.0.0.1:8080/Erp1.1/kqParamSetContr/queryAttShiftSchedule
    @ResponseBody
    @RequestMapping(value = "/queryAttShiftSchedule", method = {RequestMethod.POST})
    public JSONObject queryAttShiftSchedule(HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            result.put(Constant.Result.RETDATA, KqParamSetService.queryAttShiftSchedule());
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
     * @desc:添加班次
     * @param:
     * @return: void
     * @Create at: 2019-05-01
     * @author: dx
     * @version: 1.0
     */
    //http://127.0.0.1:8080/Erp1.1/kqParamSetContr/addAttShiftSchedule?name=test&shortName=test&startTime=6:00&endTime=8:00&type=2
    @ResponseBody
    @RequestMapping(value = "/addAttShiftSchedule", method = {RequestMethod.POST})
    public JSONObject addAttShiftSchedule(HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str)) throw new MessageException("参数接收失败！");
            AttShiftScheduleBean attShiftSchedule = MapUtil.transJsonStrToObjectIgnoreCase(str, AttShiftScheduleBean.class);
            // StringUtils.isBlank(attShiftSchedule.getStartTime()) || StringUtils.isBlank(attShiftSchedule.getEndTime()) ||
            if (StringUtils.isBlank(attShiftSchedule.getName()) || StringUtils.isBlank(attShiftSchedule.getShortName()) ||
                    StringUtils.isBlank(attShiftSchedule.getType())) throw new MessageException("班次名、简称或类型为空！");
            KqParamSetService.addAttShiftSchedule(attShiftSchedule);
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
     * @desc:删除班次
     * @param:
     * @return: void
     * @Create at: 2019-05-01
     * @author: dx
     * @version: 1.0
     */
    //http://127.0.0.1:8080/Erp1.1/kqParamSetContr/deleteAttShiftSchedule?id=36
    @ResponseBody
    @RequestMapping(value = "/deleteAttShiftSchedule", method = {RequestMethod.POST})
    public JSONObject deleteAttShiftSchedule(@RequestBody Map<String, Object> requestMap, HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            int id = MapUtil.getIntIgnoreCase(requestMap, "id", MapUtil.NOT_NULL);
            KqParamSetService.deleteAttShiftSchedule(id);
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
     * @desc:修改班次
     * @param:
     * @return: void
     * @Create at: 2019-05-01
     * @author: dx
     * @version: 1.0
     */
    //http://127.0.0.1:8080/Erp1.1/kqParamSetContr/updateAttShiftSchedule?name=test1&shortName=test1&startTime=16:00&endTime=18:00&type=1&remarks=test&id=36
    @ResponseBody
    @RequestMapping(value = "/updateAttShiftSchedule", method = {RequestMethod.POST})
    public JSONObject updateAttShiftSchedule(HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str)) throw new MessageException("参数接收失败！");
            AttShiftScheduleBean attShiftSchedule = MapUtil.transJsonStrToObjectIgnoreCase(str, AttShiftScheduleBean.class);
            //StringUtils.isBlank(attShiftSchedule.getStartTime()) || StringUtils.isBlank(attShiftSchedule.getEndTime()) ||
            if (StringUtils.isBlank(attShiftSchedule.getName()) || StringUtils.isBlank(attShiftSchedule.getShortName()) ||
                    StringUtils.isBlank(attShiftSchedule.getType()) || StringUtils.isBlank(attShiftSchedule.getId()))
                throw new MessageException("班次名、简称、类型或班次id为空！");
            KqParamSetService.updateAttShiftSchedule(attShiftSchedule);
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
     * @desc:查询班组
     * @param:
     * @return: List<AttShiftGroupBean>
     * @Create at: 2019-05-01
     * @author: dx
     * @version: 1.0
     */
    //http://127.0.0.1:8080/Erp1.1/kqParamSetContr/queryAttShiftGroup
    @ResponseBody
    @RequestMapping(value = "/queryAttShiftGroup", method = {RequestMethod.POST})
    public JSONObject queryAttShiftGroup(HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            result.put(Constant.Result.RETDATA, KqParamSetService.queryAttShiftGroup());
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

    ;

    /**
     * @desc:添加班组
     * @param:
     * @return: void
     * @Create at: 2019-05-01
     * @author: dx
     * @version: 1.0
     */
    //http://127.0.0.1:8080/Erp1.1/kqParamSetContr/addAttShiftGroup?name=test1&remark=test1
    @ResponseBody
    @RequestMapping(value = "/addAttShiftGroup", method = {RequestMethod.POST})
    public JSONObject addAttShiftGroup(HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str)) throw new MessageException("参数接收失败！");
            AttShiftGroupBean attShiftGroupBean = MapUtil.transJsonStrToObjectIgnoreCase(str, AttShiftGroupBean.class);
            if (StringUtils.isBlank(attShiftGroupBean.getName())) throw new MessageException("班组名不能为空！");
            attShiftGroupBean.setCreateDate(ToolClass.inquirNowDateTime());
            attShiftGroupBean.setIsDelete("0");
            if (StringUtils.isBlank(attShiftGroupBean.getCreator())) attShiftGroupBean.setCreator("0");
            KqParamSetService.addAttShiftGroup(attShiftGroupBean);
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

    ;

    /**
     * @desc:删除班组
     * @param:
     * @return: void
     * @Create at: 2019-05-01
     * @author: dx
     * @version: 1.0
     */
    //http://127.0.0.1:8080/Erp1.1/kqParamSetContr/deleteAttShiftGroup?id=3
    @ResponseBody
    @RequestMapping(value = "/deleteAttShiftGroup", method = {RequestMethod.POST})
    public JSONObject deleteAttShiftGroup(@RequestBody Map<String, Object> requestMap) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            int id = MapUtil.getIntIgnoreCase(requestMap, "id", MapUtil.NOT_NULL);
            KqParamSetService.deleteAttShiftGroup(id);
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

    ;

    /**
     * @desc:修改班组
     * @param:
     * @return: void
     * @Create at: 2019-05-01
     * @author: dx
     * @version: 1.0
     */
    //http://127.0.0.1:8080/Erp1.1/kqParamSetContr/updateAttShiftGroup?name=test2&remark=test2&id=4
    @ResponseBody
    @RequestMapping(value = "/updateAttShiftGroup", method = {RequestMethod.POST})
    public JSONObject updateAttShiftGroup(HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str)) throw new MessageException("参数接收失败！");
            AttShiftGroupBean attShiftGroupBean = MapUtil.transJsonStrToObjectIgnoreCase(str, AttShiftGroupBean.class);
            //JSONObject.toJSONString(attShiftGroupBean, MapUtil.JSON_NULL_VALUE_FILTER, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
            if (StringUtils.isBlank(attShiftGroupBean.getName()) || StringUtils.isBlank(attShiftGroupBean.getId()))
                throw new MessageException("班组名或班组id为空！");
            KqParamSetService.updateAttShiftGroup(attShiftGroupBean);
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

    ;

    /**
     * @desc:查询部门信息
     * @param:
     * @return: JSONObject
     * @Create at: 2019-05-02
     * @author: dx
     * @version: 1.0
     */
    //http://127.0.0.1:8080/Erp/kqParamSetContr/queryDepartment
    @ResponseBody
    @RequestMapping(value = "/queryDepartment", method = {RequestMethod.POST})
    public JSONObject queryDepartment(HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            result.put(Constant.Result.RETDATA, JSONObject.parse(JSONObject.toJSONString(KqParamSetService.queryDepartment(), MapUtil.JSON_NULL_VALUE_FILTER, SerializerFeature.WriteMapNullValue)));
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

    ;

    /**
     * @desc:增加部门信息
     * @param:
     * @return: JSONObject
     * @Create at: 2019-05-02
     * @author: dx
     * @version: 1.0
     */
    //http://127.0.0.1:8080/Erp/kqParamSetContr/addDepartment?Name=test99&ParentID=0&OrderNum=10
    @ResponseBody
    @RequestMapping(value = "/addDepartment", method = {RequestMethod.POST})
    public JSONObject addDepartment(HttpServletRequest request) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str)) throw new MessageException("参数接收失败！");
            DepartmentBean departmentBean = MapUtil.transJsonStrToObjectIgnoreCase(str, DepartmentBean.class);
            if (StringUtils.isBlank(departmentBean.getName())) throw new MessageException("部门名不能为空！");
            if (StringUtils.isBlank(departmentBean.getOrderNum())) departmentBean.setOrderNum("0");
            KqParamSetService.addDepartment(departmentBean);
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

    ;

    /**
     * @desc:删除部门信息
     * @param:
     * @return: JSONObject
     * @Create at: 2019-05-02
     * @author: dx
     * @version: 1.0
     */
    //http://127.0.0.1:8080/Erp/kqParamSetContr/deleteDepartment?id=87
    @ResponseBody
    @RequestMapping(value = "/deleteDepartment", method = {RequestMethod.POST})
    public JSONObject deleteDepartment(@RequestBody Map<String, Object> requestMap) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            int id = MapUtil.getIntIgnoreCase(requestMap, "id", MapUtil.NOT_NULL);
            KqParamSetService.deleteDepartment(id);
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

    ;

    /**
     * @desc:修改部门信息
     * @param:
     * @return: JSONObject
     * @Create at: 2019-05-02
     * @author: dx
     * @version: 1.0
     */
    //http://127.0.0.1:8080/Erp/kqParamSetContr/updateDepartment?Name=test88&ParentID=10&OrderNum=20&ID=87
    @ResponseBody
    @RequestMapping(value = "/updateDepartment", method = {RequestMethod.POST})
    public JSONObject updateDepartment(HttpServletRequest request) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str)) throw new MessageException("参数接收失败！");
            DepartmentBean departmentBean = MapUtil.transJsonStrToObjectIgnoreCase(str, DepartmentBean.class);
            if (StringUtils.isBlank(departmentBean.getName()) || StringUtils.isBlank(departmentBean.getID()))
                throw new MessageException("部门名或部门id为空！");
            KqParamSetService.updateDepartment(departmentBean);
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

    ;

    /**
     * 查询岗位类型
     *
     * @desc:
     * @param:
     * @return: JSONObject
     * @Create at: 2019-05-03
     * @author: dx
     * @version: 1.0
     */
    //http://127.0.0.1:8080/Erp/kqParamSetContr/queryPositionType
    @ResponseBody
    @RequestMapping(value = "/queryPositionType", method = {RequestMethod.POST})
    public JSONObject queryPositionType() {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            result.put(Constant.Result.RETDATA, KqParamSetService.queryPositionType());
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

    ;

    /**
     * @desc:添加岗位类型
     * @param:
     * @return: JSONObject
     * @Create at: 2019-05-03
     * @author: dx
     * @version: 1.0
     */
    //http://127.0.0.1:8080/Erp/kqParamSetContr/addPositionType?positionTypeName=999
    @ResponseBody
    @RequestMapping(value = "/addPositionType", method = {RequestMethod.POST})
    public JSONObject addPositionType(HttpServletRequest request) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str)) throw new MessageException("参数接收失败！");
            JSONObject jsObj = JSONObject.parseObject(str);
            if (!jsObj.containsKey("positionTypeName") || jsObj.get("positionTypeName") == null)
                throw new MessageException("岗位类型名字不能为空！");
            PositionTypeBean positionTypeBean = new PositionTypeBean();
            positionTypeBean.setPositionType_Name(jsObj.getString("positionTypeName"));
            KqParamSetService.addPositionType(positionTypeBean);
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

    ;

    /**
     * @desc:删除岗位类型
     * @param:
     * @return: JSONObject
     * @Create at: 2019-05-03
     * @author: dx
     * @version: 1.0
     */
    //http://127.0.0.1:8080/Erp/kqParamSetContr/deletePositionType?id=8
    @ResponseBody
    @RequestMapping(value = "/deletePositionType", method = {RequestMethod.POST})
    public JSONObject deletePositionType(@RequestBody Map<String, Object> requestMap) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            int id = MapUtil.getIntIgnoreCase(requestMap, "id", MapUtil.NOT_NULL);
            KqParamSetService.deletePositionType(id);
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

    ;

    /**
     * @desc:修改岗位类型
     * @param:
     * @return: JSONObject
     * @Create at: 2019-05-03
     * @author: dx
     * @version: 1.0
     */
    //http://127.0.0.1:8080/Erp/kqParamSetContr/updatePositionType?positionTypeName=999&positionTypeId=8
    @ResponseBody
    @RequestMapping(value = "/updatePositionType", method = {RequestMethod.POST})
    public JSONObject updatePositionType(HttpServletRequest request) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str)) throw new MessageException("参数接收失败！");
            JSONObject jsObj = JSONObject.parseObject(str);
            if (!jsObj.containsKey("positionTypeName") || jsObj.get("positionTypeName") == null
                    || !jsObj.containsKey("positionTypeId") || jsObj.get("positionTypeId") == null
            ) throw new MessageException("岗位类型名字或岗位类型id为空！");
            PositionTypeBean positionTypeBean = new PositionTypeBean();
            positionTypeBean.setPositionType_ID(jsObj.getString("positionTypeId"));
            positionTypeBean.setPositionType_Name(jsObj.getString("positionTypeName"));
            KqParamSetService.updatePositionType(positionTypeBean);
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

    ;

    /**
     * @desc:查询职位信息
     * @param:
     * @return: JSONObject
     * @Create at: 2019-05-04
     * @author: dx
     * @version: 1.0
     */
    //http://127.0.0.1:8080/Erp/kqParamSetContr/queryPositionData
    @ResponseBody
    @RequestMapping(value = "/queryPositionData", method = {RequestMethod.POST})
    public JSONObject queryPositionData() {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            result.put(Constant.Result.RETDATA, KqParamSetService.queryPositionData());
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

    ;

    /**
     * @desc:添加职位信息
     * @param:
     * @return: JSONObject
     * @Create at: 2019-05-04
     * @author: dx
     * @version: 1.0
     */
    //http://127.0.0.1:8080/Erp/kqParamSetContr/addPositionData?positionName=test88&isPoint=1&positionTypeId=2
    @ResponseBody
    @RequestMapping(value = "/addPositionData", method = {RequestMethod.POST})
    public JSONObject addPositionData(HttpServletRequest request) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str)) throw new MessageException("参数接收失败！");
            JSONObject jsObj = JSONObject.parseObject(str);
            if (jsObj.get("positionName") == null) throw new MessageException("职位名不能为空！");
            PositionDataBean positionDataBean = new PositionDataBean();
            positionDataBean.setPosition_Name(jsObj.getString("positionName"));
            positionDataBean.setIsPoint(jsObj.get("isPoint") == null ? "0" : jsObj.getString("isPoint"));
            positionDataBean.setPositionType_ID(jsObj.get("positionTypeId") == null ? "0" : jsObj.getString("positionTypeId"));
            KqParamSetService.addPositionData(positionDataBean);
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

    ;

    /**
     * @desc:修改职位信息
     * @param:
     * @return: JSONObject
     * @Create at: 2019-05-04
     * @author: dx
     * @version: 1.0
     */
    //http://127.0.0.1:8080/Erp/kqParamSetContr/updatePositionData?positionName=test88&isPoint=1&positionTypeId=2&positionId=103
    @ResponseBody
    @RequestMapping(value = "/updatePositionData", method = {RequestMethod.POST})
    public JSONObject updatePositionData(HttpServletRequest request) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str)) throw new MessageException("参数接收失败！");
            JSONObject jsObj = JSONObject.parseObject(str);
            if (jsObj.get("positionName") == null || jsObj.get("positionId") == null)
                throw new MessageException("职位名或职位id为空！");
            PositionDataBean positionDataBean = new PositionDataBean();
            positionDataBean.setPosition_ID(jsObj.getString("positionId"));
            positionDataBean.setPosition_Name(jsObj.getString("positionName"));
            positionDataBean.setIsPoint(jsObj.get("isPoint") == null ? "0" : jsObj.getString("isPoint"));
            positionDataBean.setPositionType_ID(jsObj.get("positionTypeId") == null ? "0" : jsObj.getString("positionTypeId"));
            KqParamSetService.updatePositionData(positionDataBean);
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

    ;

    /**
     * @desc:查询部门及部门下的员工
     * @param:
     * @return: JSONObject
     * @Create at: 2019-05-06
     * @author: dx
     * @version: 1.0
     */
    //http://127.0.0.1:8080/Erp/kqParamSetContr/queryDepartmentEmployee
    @ResponseBody
    @RequestMapping(value = "/queryDepartmentEmployee", method = {RequestMethod.GET, RequestMethod.POST})
    public JSONObject queryDepartmentEmployee(HttpServletRequest request) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            result.put(Constant.Result.RETDATA, KqParamSetService.queryDepartmentEmployee(true, false));
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

    ;

    /**
     * @desc:查询具体员工的排班计划
     * @param:
     * @return: JSONObject
     * @Create at: 2019-05-07
     * @author: dx
     * @version: 1.0
     */
    @ResponseBody
    @RequestMapping(value = "/queryEmpAttShift", method = {RequestMethod.POST})
    public JSONObject queryEmpAttShift(HttpServletRequest request) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str)) throw new MessageException("参数接收失败！");
            JSONObject jsObj = JSONObject.parseObject(str);
            String userId = jsObj.get("userId") == null ? null : jsObj.getString("userId");
            String userName = jsObj.get("userName") == null ? null : jsObj.getString("userName");
            if (jsObj.get("startTime") == null || jsObj.get("endTime") == null)
                throw new MessageException("startTime或endTime为空！");
            result = KqParamSetService.queryEmpAttShift(userId, userName, jsObj.getString("startTime"), jsObj.getString("endTime"), jsObj.getString("flag"));
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

    ;

    /**
     * @desc:查询全部员工的排班计划
     * @param:
     * @return: JSONObject
     * @Create at: 2019-05-07
     * @author: dx
     * @version: 1.0
     */
    //http://127.0.0.1:8080/Erp/kqParamSetContr/queryAllEmpAttShift?begDate=2017-02-01&endDate=2017-02-01
    @ResponseBody
    @RequestMapping(value = "/queryAllEmpAttShift", method = {RequestMethod.POST})
    public JSONObject queryAllEmpAttShift(HttpServletRequest request) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str)) throw new MessageException("参数接收失败！");
            JSONObject jsObj = JSONObject.parseObject(str);
            if (jsObj.get("begDate") == null || jsObj.get("endDate") == null)
                throw new MessageException("begDate或endDate为空！");
            List<Map<String, Object>> dataList = KqParamSetService.queryAllEmpAttShift(jsObj.getString("begDate"), jsObj.getString("endDate"));
            result.put(Constant.Result.RETDATA, dataList);
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

    ;

    /**
     * @desc:删除员工排班计划（逻辑删除）
     * @param:
     * @return: JSONObject
     * @Create at: 2019-05-08
     * @author: dx
     * @version: 1.0
     */
    //http://127.0.0.1:8080/Erp/kqParamSetContr/updateEmpAttShift?begDate=2019-01-01&endDate=2018-01-01
    @ResponseBody
    @RequestMapping(value = "/updateEmpAttShift", method = {RequestMethod.POST})
    public JSONObject updateEmpAttShift(@RequestBody String params) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败！");
            Map<String, Object> requestMap = JSONObject.parseObject(params, Map.class);
            KqParamSetService.updateEmpAttShift(requestMap);
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
     * @desc:查询部门下的职位
     * @param:
     * @return: JSONObject
     * @Create at: 2019-05-24
     * @author: dx
     * @version: 1.0
     */
    @ResponseBody
    @RequestMapping(value = "/queryDepartmentPosition", method = {RequestMethod.POST})
    public JSONObject queryDepartmentPosition(HttpServletRequest request) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            String params = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(params)) {
                result.put(Constant.Result.RETDATA, KqParamSetService.queryDepartmentEmployee(false, true));
            } else {
                Map<String, Object> requestMap = JSONObject.parseObject(params, Map.class);
                result.put(Constant.Result.RETDATA, KqParamSetService.queryPositionDataByDeptId(MapUtil.getString(requestMap, "deptId", MapUtil.NOT_NULL), true));
            }
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

    /* *
     * @desc:查询部门树
     * @author: dx
     * @date: 2019-06-18 11:30:11
     * @param params :
     * @return: com.alibaba.fastjson.JSONObject
     * @throws:
     * @version: 1.0
     **/
    @ResponseBody
    @RequestMapping(value = "/queryDeptTree", method = {RequestMethod.POST})
    public JSONObject queryDeptTree() {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            /*if (StringUtils.isNotBlank(params)){
                Map<String, Object> requestMap = JSONObject.parseObject(params, Map.class);
            }*/
            result.put(Constant.Result.RETDATA, KqParamSetService.queryDeptTree(null));
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
