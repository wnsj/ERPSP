package com.jiubo.erp.zpgl.controller;

import com.alibaba.fastjson.JSONObject;
import com.jiubo.erp.common.Constant;
import com.jiubo.erp.common.MapUtil;
import com.jiubo.erp.common.MessageException;
import com.jiubo.erp.zpgl.bean.RecruitChannelBean;
import com.jiubo.erp.zpgl.bean.RecruitDataBean;
import com.jiubo.erp.zpgl.bean.ZpPlanBean;
import com.jiubo.erp.zpgl.bean.ZpPublishBean;
import com.jiubo.erp.zpgl.service.ZpglService;
import com.quicksand.push.ToolClass;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@Scope("prototype")
@RequestMapping("/zpglController")
public class ZpglController {

    private final static Logger logger = LoggerFactory.getLogger(ZpglController.class);

    @Autowired
    private ZpglService zpglService;

    /**
     * @desc:查询招聘渠道
     * @param:
     * @return: JSONObject
     * @Create at: 2019-05-09
     * @author: dx
     * @version: 1.0
     */
    //http://127.0.0.1:8080/Erp/zpglController/queryRecruitChannel
    @ResponseBody
    @RequestMapping(value = "/queryRecruitChannel", method = {RequestMethod.POST})
    public JSONObject queryRecruitChannel(HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            result.put(Constant.Result.RETDATA, zpglService.queryRecruitChannel());
        } catch (MessageException e) {
            retCode = Constant.Result.ERROR;
            retMsg = e.getMessage();
        } catch (Exception e) {
            retCode = Constant.Result.ERROR;
            retMsg = Constant.Result.ERROR_MSG;
            logger.error(Constant.Result.RETMSG, e);
        } finally {
            result.put(Constant.Result.RETCODE, retCode);
            result.put(Constant.Result.RETMSG, retMsg);
            return result;
        }
    }

    /**
     * @desc:添加招聘渠道
     * @param:
     * @return: JSONObject
     * @Create at: 2019-05-13
     * @author: dx
     * @version: 1.0
     */
    //http://127.0.0.1:8080/Erp/zpglController/addRecruitChannel?recruitChannelName=Boss
    @ResponseBody
    @RequestMapping(value = "/addRecruitChannel", method = {RequestMethod.POST})
    public JSONObject addRecruitChannel(HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str)) throw new MessageException("参数接收失败！");
            RecruitChannelBean recruitChannelBean = MapUtil.transJsonStrToObjectIgnoreCase(str, RecruitChannelBean.class);
            zpglService.addRecruitChannel(recruitChannelBean);
        } catch (MessageException e) {
            retCode = Constant.Result.ERROR;
            retMsg = e.getMessage();
        } catch (Exception e) {
            retCode = Constant.Result.ERROR;
            retMsg = Constant.Result.ERROR_MSG;
            logger.error(Constant.Result.RETMSG, e);
        } finally {
            result.put(Constant.Result.RETCODE, retCode);
            result.put(Constant.Result.RETMSG, retMsg);
            return result;
        }
    }

    /**
     * @desc:删除招聘渠道
     * @param:
     * @return: JSONObject
     * @Create at: 2019-05-09
     * @author: dx
     * @version: 1.0
     */
    //http://127.0.0.1:8080/Erp/zpglController/deleteRecruitChannel?id=2
    @ResponseBody
    @RequestMapping(value = "/deleteRecruitChannel", method = {RequestMethod.POST})
    public JSONObject deleteRecruitChannel(@RequestBody Map<String, Object> requestMap, HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            String id = MapUtil.getStringIgnoreCase(requestMap, "id", MapUtil.NOT_NULL);
            zpglService.deleteRecruitChannel(id);
        } catch (MessageException e) {
            retCode = Constant.Result.ERROR;
            retMsg = e.getMessage();
        } catch (Exception e) {
            retCode = Constant.Result.ERROR;
            retMsg = Constant.Result.ERROR_MSG;
            logger.error(Constant.Result.RETMSG, e);
        } finally {
            result.put(Constant.Result.RETCODE, retCode);
            result.put(Constant.Result.RETMSG, retMsg);
            return result;
        }
    }

    /**
     * @desc:修改招聘渠道
     * @param:
     * @return: JSONObject
     * @Create at: 2019-05-13
     * @author: dx
     * @version: 1.0
     */
    @ResponseBody
    @RequestMapping(value = "/updateRecruitChannel", method = {RequestMethod.POST})
    public JSONObject updateRecruitChannel(HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str)) throw new MessageException("参数接收失败！");
            RecruitChannelBean recruitChannelBean = MapUtil.transJsonStrToObjectIgnoreCase(str, RecruitChannelBean.class);
            zpglService.updateRecruitChannel(recruitChannelBean);
        } catch (MessageException e) {
            retCode = Constant.Result.ERROR;
            retMsg = e.getMessage();
        } catch (Exception e) {
            retCode = Constant.Result.ERROR;
            retMsg = Constant.Result.ERROR_MSG;
            logger.error(Constant.Result.RETMSG, e);
        } finally {
            result.put(Constant.Result.RETCODE, retCode);
            result.put(Constant.Result.RETMSG, retMsg);
            return result;
        }
    }

    /**
     * @desc:查询面试信息
     * @param:
     * @return: JSONObject
     * @Create at: 2019-05-10
     * @author: dx / DingDong
     * @version: 1.0
     */
    //
    @ResponseBody
    @RequestMapping(value = "/queryRecruitData", method = {RequestMethod.POST})
    public JSONObject queryRecruitData(HttpServletRequest request) {
        JSONObject result = new JSONObject();
        String retCode = null;
        String retMsg = null;
        String retData = null;
        logger.info("----------请求接口:computerController/queryPreApplication----------");
        try {
            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str)) {
                throw new MessageException("参数接收失败！");
            }
            RecruitDataBean recruitDataBean = MapUtil.transJsonStrToObjectIgnoreCase(str, RecruitDataBean.class);
            List<RecruitDataBean> list = zpglService.queryRecruitData(recruitDataBean);
            retCode = Constant.Result.SUCCESS;
            retMsg = Constant.Result.SUCCESS_MSG;
            retData = Constant.Result.RETDATA;

            result.put(retData, list);
            logger.info("----------查询面试信息接口成功----------");
            return result;
        } catch (IOException e) {
            retCode = Constant.Result.ERROR;
            retMsg = Constant.Result.ERROR_MSG;
            logger.error(e.getMessage(), e);
            return result;
        } catch (MessageException e) {
            retCode = Constant.Result.ERROR;
            retMsg = Constant.Result.ERROR_MSG;
            logger.error(e.getMessage(), e);
            return result;
        } catch (Exception e) {
            retCode = Constant.Result.ERROR;
            retMsg = Constant.Result.ERROR_MSG;
            logger.error(e.getMessage(), e);
            return result;
        } finally {
            result.put(Constant.Result.RETCODE, retCode);
            result.put(Constant.Result.RETMSG, retMsg);
        }
    }

    /**
     * @desc:添加面试信息
     * @param:
     * @return: JSONObject
     * @Create at: 2019-05-10
     * @author: dx
     * @version: 1.0
     */
    //http://127.0.0.1:8080/Erp/zpglController/addRecruitData
    @ResponseBody
    @RequestMapping(value = "/addRecruitData", method = {RequestMethod.POST})
    public JSONObject addRecruitData(HttpServletRequest request) {
        JSONObject result = new JSONObject();
        String retCode = null;
        String retMsg = null;
        logger.info("----------请求接口:zpglController/addRecruitData----------");
        try {
            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str)) {
                throw new MessageException("参数接收失败！");
            }
            RecruitDataBean recruitDataBean = MapUtil.transJsonStrToObjectIgnoreCase(str, RecruitDataBean.class);
            zpglService.addRecruitData(recruitDataBean);
            retCode = Constant.Result.SUCCESS;
            retMsg = Constant.Result.SUCCESS_MSG;
            logger.info("----------添加面试信息接口请求成功----------");
            return result;
        } catch (IOException e) {
            retCode = Constant.Result.ERROR;
            retMsg = Constant.Result.ERROR_MSG;
            logger.error(e.getMessage(), e);
            return result;
        } catch (MessageException e) {
            retCode = Constant.Result.ERROR;
            retMsg = Constant.Result.ERROR_MSG;
            logger.error(e.getMessage(), e);
            return result;
        } catch (Exception e) {
            retCode = Constant.Result.ERROR;
            retMsg = Constant.Result.ERROR_MSG;
            logger.error(e.getMessage(), e);
            return result;
        } finally {
            result.put(Constant.Result.RETCODE, retCode);
            result.put(Constant.Result.RETMSG, retMsg);
        }
    }

    /**
     * @desc:修改面试信息
     * @param:
     * @return: JSONObject
     * @Create at: 2019-05-10
     * @author: dx
     * @version: 1.0
     */
    //http://127.0.0.1:8080/Erp/zpglController/updateRecruitData
    @ResponseBody
    @RequestMapping(value = "/updateRecruitData", method = {RequestMethod.POST})
    public JSONObject updateRecruitData(HttpServletRequest request) {
        JSONObject result = new JSONObject();
        String retCode = null;
        String retMsg = null;
        logger.info("----------请求接口:zpglController/updateRecruitData----------");
        try {
            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str)) {
                throw new MessageException("参数接收失败！");
            }
            RecruitDataBean recruitDataBean = MapUtil.transJsonStrToObjectIgnoreCase(str, RecruitDataBean.class);
            zpglService.updateRecruitData(recruitDataBean);
            retCode = Constant.Result.SUCCESS;
            retMsg = Constant.Result.SUCCESS_MSG;
            logger.info("----------修改面试信息成功----------");
            return result;
        } catch (IOException e) {
            retCode = Constant.Result.ERROR;
            retMsg = Constant.Result.ERROR_MSG;
            logger.error(e.getMessage(), e);
            return result;
        } catch (MessageException e) {
            retCode = Constant.Result.ERROR;
            retMsg = Constant.Result.ERROR_MSG;
            logger.error(e.getMessage(), e);
            return result;
        } catch (Exception e) {
            retCode = Constant.Result.ERROR;
            retMsg = Constant.Result.ERROR_MSG;
            logger.error(e.getMessage(), e);
            return result;
        }finally {
            result.put(Constant.Result.RETCODE, retCode);
            result.put(Constant.Result.RETMSG, retMsg);
        }
    }

    /**
     * @desc:删除面试信息（逻辑删除）
     * @param:
     * @return: JSONObject
     * @Create at: 2019-05-10
     * @author: dx
     * @version: 1.0
     */
    @ResponseBody
    @RequestMapping(value = "/updateRecruitDataById", method = {RequestMethod.POST})
    public JSONObject updateRecruitDataById(@RequestBody Map<String, Object> requestMap, HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            String id = MapUtil.getStringIgnoreCase(requestMap, "id", MapUtil.NOT_NULL);
            zpglService.updateRecruitData(id);
        } catch (MessageException e) {
            retCode = Constant.Result.ERROR;
            retMsg = e.getMessage();
        } catch (Exception e) {
            retCode = Constant.Result.ERROR;
            retMsg = Constant.Result.ERROR_MSG;
            logger.error(Constant.Result.RETMSG, e);
        } finally {
            result.put(Constant.Result.RETCODE, retCode);
            result.put(Constant.Result.RETMSG, retMsg);
            return result;
        }
    }

    /**
     * @desc:查询招聘计划
     * @param:
     * @return: JSONObject
     * @Create at: 2019-05-10
     * @author: dx
     * @version: 1.0
     */
    //http://127.0.0.1:8080/Erp/zpglController/queryZpPlan?begDate=2017-05&endDate=2017-06&department=1&position=24
    @ResponseBody
    @RequestMapping(value = "/queryZpPlan", method = {RequestMethod.GET, RequestMethod.POST})
    public JSONObject queryZpPlan(HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str)) throw new MessageException("参数接收失败！");
            ZpPlanBean zpPlanBean = MapUtil.transJsonStrToObjectIgnoreCase(str, ZpPlanBean.class);
            result.put(Constant.Result.RETDATA, zpglService.queryZpPlan(zpPlanBean));
        } catch (MessageException e) {
            retCode = Constant.Result.ERROR;
            retMsg = e.getMessage();
        } catch (Exception e) {
            retCode = Constant.Result.ERROR;
            retMsg = Constant.Result.ERROR_MSG;
            logger.error(Constant.Result.RETMSG, e);
        } finally {
            result.put(Constant.Result.RETCODE, retCode);
            result.put(Constant.Result.RETMSG, retMsg);
            return result;
        }
    }

    /**
     * @desc:添加招聘计划
     * @param:
     * @return: JSONObject
     * @Create at: 2019-05-10
     * @author: dx
     * @version: 1.0
     */
    //http://127.0.0.1:8080/Erp/zpglController/addZpPlan?department=&position=66&lackNum=1&planNum=2&phoneNum=3&planDate=2019-06-01
    @ResponseBody
    @RequestMapping(value = "/addZpPlan", method = {RequestMethod.GET, RequestMethod.POST})
    public JSONObject addZpPlan(HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str)) throw new MessageException("参数接收失败！");
            ZpPlanBean zpPlanBean = MapUtil.transJsonStrToObjectIgnoreCase(str, ZpPlanBean.class);
            zpglService.addZpPlan(zpPlanBean);
        } catch (MessageException e) {
            retCode = Constant.Result.ERROR;
            retMsg = e.getMessage();
        } catch (Exception e) {
            retCode = Constant.Result.ERROR;
            retMsg = Constant.Result.ERROR_MSG;
            logger.error(Constant.Result.RETMSG, e);
        } finally {
            result.put(Constant.Result.RETCODE, retCode);
            result.put(Constant.Result.RETMSG, retMsg);
            return result;
        }
    }

    /**
     * @desc:修改招聘计划
     * @param:
     * @return: JSONObject
     * @Create at: 2019-05-10
     * @author: dx
     * @version: 1.0
     */
    //http://127.0.0.1:8080/Erp/zpglController/updateZpPlan?department=9&position=9&lackNum=9&planNum=9&phoneNum=9&planDate=2019-06-09&planId=7
    @ResponseBody
    @RequestMapping(value = "/updateZpPlan", method = {RequestMethod.GET, RequestMethod.POST})
    public JSONObject updateZpPlan(HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str)) throw new MessageException("参数接收失败！");
            ZpPlanBean zpPlanBean = MapUtil.transJsonStrToObjectIgnoreCase(str, ZpPlanBean.class);
            zpglService.updateZpPlan(zpPlanBean);
        } catch (MessageException e) {
            retCode = Constant.Result.ERROR;
            retMsg = e.getMessage();
        } catch (Exception e) {
            retCode = Constant.Result.ERROR;
            retMsg = Constant.Result.ERROR_MSG;
            logger.error(Constant.Result.RETMSG, e);
        } finally {
            result.put(Constant.Result.RETCODE, retCode);
            result.put(Constant.Result.RETMSG, retMsg);
            return result;
        }
    }

    /**
     * @desc:删除招聘计划
     * @param:
     * @return: JSONObject
     * @Create at: 2019-05-10
     * @author: dx
     * @version: 1.0
     */
    //http://127.0.0.1:8080/Erp/zpglController/deleteZpPlan?id=7
    @ResponseBody
    @RequestMapping(value = "/deleteZpPlan", method = {RequestMethod.POST})
    public JSONObject deleteZpPlan(@RequestBody Map<String, Object> requestMap, HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            String id = MapUtil.getStringIgnoreCase(requestMap, "id", MapUtil.NOT_NULL);
            zpglService.deleteZpPlan(id);
        } catch (MessageException e) {
            retCode = Constant.Result.ERROR;
            retMsg = e.getMessage();
        } catch (Exception e) {
            retCode = Constant.Result.ERROR;
            retMsg = Constant.Result.ERROR_MSG;
            logger.error(Constant.Result.RETMSG, e);
        } finally {
            result.put(Constant.Result.RETCODE, retCode);
            result.put(Constant.Result.RETMSG, retMsg);
            return result;
        }
    }

    /**
     * @desc:查询招聘发布信息
     * @param:
     * @return: JSONObject
     * @Create at: 2019-05-11
     * @author: dx
     * @version: 1.0
     */
    //http://127.0.0.1:8080/Erp/zpglController/queryZpPublish?begDate=2019-05-01&endDate=2019-05-11&channel=3&position=23
    @ResponseBody
    @RequestMapping(value = "/queryZpPublish", method = {RequestMethod.GET, RequestMethod.POST})
    public JSONObject queryZpPublish(HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str)) throw new MessageException("参数接收失败！");
            ZpPublishBean zpPublishBean = MapUtil.transJsonStrToObjectIgnoreCase(str, ZpPublishBean.class);
            result.put(Constant.Result.RETDATA, zpglService.queryZpPublish(zpPublishBean));
        } catch (MessageException e) {
            retCode = Constant.Result.ERROR;
            retMsg = e.getMessage();
        } catch (Exception e) {
            retCode = Constant.Result.ERROR;
            retMsg = Constant.Result.ERROR_MSG;
            logger.error(Constant.Result.RETMSG, e);
        } finally {
            result.put(Constant.Result.RETCODE, retCode);
            result.put(Constant.Result.RETMSG, retMsg);
            return result;
        }
    }

    /**
     * @desc:添加招聘发布信息
     * @param:
     * @return: JSONObject
     * @Create at: 2019-05-11
     * @author: dx
     * @version: 1.0
     */
    //http://127.0.0.1:8080/Erp/zpglController/addZpPublish?publishDate=2019-05-12&channel=3&position=23&publishNum=2&phoneNum=0
    @ResponseBody
    @RequestMapping(value = "/addZpPublish", method = {RequestMethod.GET, RequestMethod.POST})
    public JSONObject addZpPublish(HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str)) throw new MessageException("参数接收失败！");
            ZpPublishBean zpPublishBean = MapUtil.transJsonStrToObjectIgnoreCase(str, ZpPublishBean.class);
            zpglService.addZpPublish(zpPublishBean);
        } catch (MessageException e) {
            retCode = Constant.Result.ERROR;
            retMsg = e.getMessage();
        } catch (Exception e) {
            retCode = Constant.Result.ERROR;
            retMsg = Constant.Result.ERROR_MSG;
            logger.error(Constant.Result.RETMSG, e);
        } finally {
            result.put(Constant.Result.RETCODE, retCode);
            result.put(Constant.Result.RETMSG, retMsg);
            return result;
        }
    }

    /**
     * @desc:删除招聘发布信息
     * @param:
     * @return: JSONObject
     * @Create at: 2019-05-11
     * @author: dx
     * @version: 1.0
     */
    //http://127.0.0.1:8080/Erp/zpglController/deleteZpPublish?id=3
    @ResponseBody
    @RequestMapping(value = "/deleteZpPublish", method = {RequestMethod.POST})
    public JSONObject deleteZpPublish(@RequestBody Map<String, Object> requestMap, HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            String id = MapUtil.getStringIgnoreCase(requestMap, "id", MapUtil.NOT_NULL);
            zpglService.deleteZpPublish(id);
        } catch (MessageException e) {
            retCode = Constant.Result.ERROR;
            retMsg = e.getMessage();
        } catch (Exception e) {
            retCode = Constant.Result.ERROR;
            retMsg = Constant.Result.ERROR_MSG;
            logger.error(Constant.Result.RETMSG, e);
        } finally {
            result.put(Constant.Result.RETCODE, retCode);
            result.put(Constant.Result.RETMSG, retMsg);
            return result;
        }
    }

    /**
     * @desc:修改招聘发布信息
     * @param:
     * @return: JSONObject
     * @Create at: 2019-05-11
     * @author: dx
     * @version: 1.0
     */
    //http://127.0.0.1:8080/Erp/zpglController/updateZpPublish?publishDate=2019-05-12&channel=3&position=23&publishNum=2&phoneNum=0&publishId=3
    @ResponseBody
    @RequestMapping(value = "/updateZpPublish", method = {RequestMethod.GET, RequestMethod.POST})
    public JSONObject updateZpPublish(HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str)) throw new MessageException("参数接收失败！");
            ZpPublishBean zpPublishBean = MapUtil.transJsonStrToObjectIgnoreCase(str, ZpPublishBean.class);
            zpglService.updateZpPublish(zpPublishBean);
        } catch (MessageException e) {
            retCode = Constant.Result.ERROR;
            retMsg = e.getMessage();
        } catch (Exception e) {
            retCode = Constant.Result.ERROR;
            retMsg = Constant.Result.ERROR_MSG;
            logger.error(Constant.Result.RETMSG, e);
        } finally {
            result.put(Constant.Result.RETCODE, retCode);
            result.put(Constant.Result.RETMSG, retMsg);
            return result;
        }
    }
}
