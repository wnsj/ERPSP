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
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
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
    @RequestMapping(value = "/queryRecruitChannel", method = {RequestMethod.POST})
    public JSONObject queryRecruitChannel() {
        JSONObject result = new JSONObject();
        String retCode = null;
        String retMsg = null;
        String retData;
        logger.info("----------请求接口:zpglController/queryRecruitChannel----------");
        try {
            retCode = Constant.Result.SUCCESS;
            retMsg = Constant.Result.SUCCESS_MSG;
            retData = Constant.Result.RETDATA;
            result.put(retData, zpglService.queryRecruitChannel());
            logger.info("----------查询招聘渠道接口请求成功----------");
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
     * @desc:添加招聘渠道
     * @param:
     * @return: JSONObject
     * @Create at: 2019-05-13
     * @author: dx
     * @version: 1.0
     */
    //http://127.0.0.1:8080/Erp/zpglController/addRecruitChannel?recruitChannelName=Boss
    @RequestMapping(value = "/addRecruitChannel", method = {RequestMethod.POST})
    public JSONObject addRecruitChannel(HttpServletRequest request) {
        JSONObject result = new JSONObject();
        String retCode = null;
        String retMsg = null;
        logger.info("----------请求接口:zpglController/addRecruitChannel----------");
        try {
            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str)) {
                throw new MessageException("参数接收失败！");
            }
            RecruitChannelBean recruitChannelBean = MapUtil.transJsonStrToObjectIgnoreCase(str, RecruitChannelBean.class);
            zpglService.addRecruitChannel(recruitChannelBean);
            retCode = Constant.Result.SUCCESS;
            retMsg = Constant.Result.SUCCESS_MSG;
            logger.info("----------添加招聘渠道接口请求成功----------");
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
     * @desc:修改招聘渠道
     * @param:
     * @return: JSONObject
     * @Create at: 2019-05-13
     * @author: dx
     * @version: 1.0
     */

    @RequestMapping(value = "/updateRecruitChannel", method = {RequestMethod.POST})
    public JSONObject updateRecruitChannel(HttpServletRequest request) {
        JSONObject result = new JSONObject();
        String retCode = null;
        String retMsg = null;
        try {
            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str)) {
                throw new MessageException("参数接收失败！");
            }
            RecruitChannelBean recruitChannelBean = MapUtil.transJsonStrToObjectIgnoreCase(str, RecruitChannelBean.class);
            zpglService.updateRecruitChannel(recruitChannelBean);
            retCode = Constant.Result.SUCCESS;
            retMsg = Constant.Result.SUCCESS_MSG;
            logger.info("----------修改招聘渠道接口请求成功----------");
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
     * @desc:删除招聘渠道
     * @param:
     * @return: JSONObject
     * @Create at: 2019-05-09
     * @author: dx
     * @version: 1.0
     */
    //http://127.0.0.1:8080/Erp/zpglController/deleteRecruitChannel?id=2
    @RequestMapping(value = "/deleteRecruitChannel", method = {RequestMethod.POST})
    public JSONObject deleteRecruitChannel(@RequestBody Map<String, Object> requestMap, HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        String retCode = null;
        String retMsg = null;
        try {
            String id = MapUtil.getStringIgnoreCase(requestMap, "id", MapUtil.NOT_NULL);
            zpglService.deleteRecruitChannel(id);
            retCode = Constant.Result.SUCCESS;
            retMsg = Constant.Result.SUCCESS_MSG;
            logger.info("----------删除招聘渠道接口请求成功----------");
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
     * @desc:查询面试信息
     * @param:
     * @return: JSONObject
     * @Create at: 2019-05-10
     * @author: dx / DingDong
     * @version: 1.0
     */

    @RequestMapping(value = "/queryRecruitData", method = {RequestMethod.POST})
    public JSONObject queryRecruitData(HttpServletRequest request) {
        JSONObject result = new JSONObject();
        String retCode = null;
        String retMsg = null;
        String retData;
        logger.info("----------请求接口:zpglController/queryRecruitData----------");
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
        } finally {
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

    @RequestMapping(value = "/updateRecruitDataById", method = {RequestMethod.POST})
    public JSONObject updateRecruitDataById(@RequestBody Map<String, Object> requestMap) {
        JSONObject result = new JSONObject();
        String retCode = null;
        String retMsg = null;
        logger.info("----------请求接口:zpglController/updateRecruitDataById----------");
        try {
            String id = MapUtil.getStringIgnoreCase(requestMap, "id", MapUtil.NOT_NULL);
            zpglService.updateRecruitData(id);
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
        } finally {
            result.put(Constant.Result.RETCODE, retCode);
            result.put(Constant.Result.RETMSG, retMsg);
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
    @RequestMapping(value = "/queryZpPlan", method = {RequestMethod.GET, RequestMethod.POST})
    public JSONObject queryZpPlan(HttpServletRequest request) {
        JSONObject result = new JSONObject();
        String retCode = null;
        String retMsg = null;
        String retData;
        logger.info("----------请求接口:zpglController/queryZpPlan----------");
        try {
            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str)) {
                throw new MessageException("参数接收失败！");
            }
            ZpPlanBean zpPlanBean = MapUtil.transJsonStrToObjectIgnoreCase(str, ZpPlanBean.class);
            List<ZpPlanBean> list = zpglService.queryZpPlan(zpPlanBean);
            retCode = Constant.Result.SUCCESS;
            retMsg = Constant.Result.SUCCESS_MSG;
            retData = Constant.Result.RETDATA;
            result.put(retData, list);
            logger.info("----------查询招聘计划接口请求成功----------");
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
     * @desc:添加招聘计划
     * @param:
     * @return: JSONObject
     * @Create at: 2019-05-10
     * @author: dx
     * @version: 1.0
     */
    //http://127.0.0.1:8080/Erp/zpglController/addZpPlan?department=&position=66&lackNum=1&planNum=2&phoneNum=3&planDate=2019-06-01
    @RequestMapping(value = "/addZpPlan", method = {RequestMethod.GET, RequestMethod.POST})
    public JSONObject addZpPlan(HttpServletRequest request) {
        JSONObject result = new JSONObject();
        String retCode = null;
        String retMsg = null;
        logger.info("----------请求接口:zpglController/addZpPlan----------");
        try {
            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str)) {
                throw new MessageException("参数接收失败！");
            }
            ZpPlanBean zpPlanBean = MapUtil.transJsonStrToObjectIgnoreCase(str, ZpPlanBean.class);
            zpglService.addZpPlan(zpPlanBean);
            retCode = Constant.Result.SUCCESS;
            retMsg = Constant.Result.SUCCESS_MSG;
            logger.info("----------添加招聘计划接口请求成功----------");
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
     * @desc:修改招聘计划
     * @param:
     * @return: JSONObject
     * @Create at: 2019-05-10
     * @author: dx
     * @version: 1.0
     */
    //http://127.0.0.1:8080/Erp/zpglController/updateZpPlan?department=9&position=9&lackNum=9&planNum=9&phoneNum=9&planDate=2019-06-09&planId=7
    @RequestMapping(value = "/updateZpPlan", method = {RequestMethod.GET, RequestMethod.POST})
    public JSONObject updateZpPlan(HttpServletRequest request) {
        JSONObject result = new JSONObject();
        String retCode = null;
        String retMsg = null;
        logger.info("----------请求接口:zpglController/updateZpPlan----------");
        try {
            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str)) {
                throw new MessageException("参数接收失败！");
            }
            ZpPlanBean zpPlanBean = MapUtil.transJsonStrToObjectIgnoreCase(str, ZpPlanBean.class);
            zpglService.updateZpPlan(zpPlanBean);
            retCode = Constant.Result.SUCCESS;
            retMsg = Constant.Result.SUCCESS_MSG;
            logger.info("----------修改招聘计划接口请求成功----------");
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
     * @desc:删除招聘计划
     * @param:
     * @return: JSONObject
     * @Create at: 2019-05-10
     * @author: dx
     * @version: 1.0
     */
    //http://127.0.0.1:8080/Erp/zpglController/deleteZpPlan?id=7
    @RequestMapping(value = "/deleteZpPlan", method = {RequestMethod.POST})
    public JSONObject deleteZpPlan(@RequestBody Map<String, Object> requestMap) {
        JSONObject result = new JSONObject();
        String retCode = null;
        String retMsg = null;
        logger.info("----------请求接口:zpglController/deleteZpPlan----------");
        try {
            String id = MapUtil.getStringIgnoreCase(requestMap, "id", MapUtil.NOT_NULL);
            zpglService.deleteZpPlan(id);
            retCode = Constant.Result.SUCCESS;
            retMsg = Constant.Result.SUCCESS_MSG;
            logger.info("----------删除招聘计划接口请求成功----------");
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
     * @desc:查询招聘发布信息
     * @param:
     * @return: JSONObject
     * @Create at: 2019-05-11
     * @author: dx
     * @version: 1.0
     */
    //http://127.0.0.1:8080/Erp/zpglController/queryZpPublish?begDate=2019-05-01&endDate=2019-05-11&channel=3&position=23
    @RequestMapping(value = "/queryZpPublish", method = {RequestMethod.GET, RequestMethod.POST})
    public JSONObject queryZpPublish(HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        String retCode = null;
        String retMsg = null;
        String retData;
        logger.info("----------请求接口:zpglController/queryZpPublish----------");
        try {
            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str)) {
                throw new MessageException("参数接收失败！");
            }
            ZpPublishBean zpPublishBean = MapUtil.transJsonStrToObjectIgnoreCase(str, ZpPublishBean.class);
            List<ZpPublishBean> list = zpglService.queryZpPublish(zpPublishBean);
            retCode = Constant.Result.SUCCESS;
            retMsg = Constant.Result.SUCCESS_MSG;
            retData = Constant.Result.RETDATA;
            result.put(retData, list);
            logger.info("----------查询招聘发布信息接口请求成功----------");
            return result;
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
    @RequestMapping(value = "/addZpPublish", method = {RequestMethod.GET, RequestMethod.POST})
    public JSONObject addZpPublish(HttpServletRequest request) {
        JSONObject result = new JSONObject();
        String retCode = null;
        String retMsg = null;
        logger.info("----------请求接口:zpglController/addZpPublish----------");
        try {
            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str)) {
                throw new MessageException("参数接收失败！");
            }
            ZpPublishBean zpPublishBean = MapUtil.transJsonStrToObjectIgnoreCase(str, ZpPublishBean.class);
            zpglService.addZpPublish(zpPublishBean);
            retCode = Constant.Result.SUCCESS;
            retMsg = Constant.Result.SUCCESS_MSG;
            logger.info("----------添加招聘发布信息接口请求成功----------");
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
     * @desc:修改招聘发布信息
     * @param:
     * @return: JSONObject
     * @Create at: 2019-05-11
     * @author: dx
     * @version: 1.0
     */
    //http://127.0.0.1:8080/Erp/zpglController/updateZpPublish?publishDate=2019-05-12&channel=3&position=23&publishNum=2&phoneNum=0&publishId=3
    @RequestMapping(value = "/updateZpPublish", method = {RequestMethod.GET, RequestMethod.POST})
    public JSONObject updateZpPublish(HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        String retCode = null;
        String retMsg = null;
        logger.info("----------请求接口:zpglController/updateZpPublish----------");
        try {
            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str)) {
                throw new MessageException("参数接收失败！");
            }
            ZpPublishBean zpPublishBean = MapUtil.transJsonStrToObjectIgnoreCase(str, ZpPublishBean.class);
            zpglService.updateZpPublish(zpPublishBean);
            retCode = Constant.Result.SUCCESS;
            retMsg = Constant.Result.SUCCESS_MSG;
            logger.info("----------修改招聘发布信息接口请求成功----------");
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
     * @desc:删除招聘发布信息
     * @param:
     * @return: JSONObject
     * @Create at: 2019-05-11
     * @author: dx
     * @version: 1.0
     */
    //http://127.0.0.1:8080/Erp/zpglController/deleteZpPublish?id=3
    @RequestMapping(value = "/deleteZpPublish", method = {RequestMethod.POST})
    public JSONObject deleteZpPublish(@RequestBody Map<String, Object> requestMap, HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        String retCode = null;
        String retMsg = null;
        logger.info("----------请求接口:zpglController/deleteZpPublish----------");
        try {
            String id = MapUtil.getStringIgnoreCase(requestMap, "id", MapUtil.NOT_NULL);
            zpglService.deleteZpPublish(id);
            retCode = Constant.Result.SUCCESS;
            retMsg = Constant.Result.SUCCESS_MSG;
            logger.info("----------删除招聘发布信息接口请求成功----------");
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
     * @Description: 入职员工关联面试信息
     * @author: DingDong
     * @date: 2019年08月26日
     * @version: V1.0
     */
    //http://127.0.0.1:8080/Erp/zpglController/relateRecruitData
    @RequestMapping(value = "/relateRecruitData", method = RequestMethod.POST)
    public JSONObject relateRecruitData(HttpServletRequest request) {
        JSONObject result = new JSONObject();
        String retCode = null;
        String retMsg = null;
        logger.info("----------请求接口:zpglController/relateRecruitData----------");
        try {
            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str)) {
                throw new MessageException("参数接收失败！");
            }
            RecruitDataBean recruitDataBean = MapUtil.transJsonStrToObjectIgnoreCase(str, RecruitDataBean.class);
            zpglService.relateRecruitData(recruitDataBean);
            retCode = Constant.Result.SUCCESS;
            retMsg = Constant.Result.SUCCESS_MSG;
            logger.info("----------入职员工关联面试信息接口请求成功----------");
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
}
