package com.jiubo.erp.wzbg.controller;

import com.alibaba.fastjson.JSONObject;
import com.jiubo.erp.common.Constant;
import com.jiubo.erp.common.MessageException;
import com.jiubo.erp.wzbg.bean.OfficeSuppliesDataBean;
import com.jiubo.erp.wzbg.bean.OfficeUserDataBean;
import com.jiubo.erp.wzbg.service.OfficeService;
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
import java.util.Map;

/**
 * @desc:
 * @date: 2019-07-12 16:25
 * @author: dx
 * @version: 1.0
 */
@Controller
@Scope("prototype")
@RequestMapping("/officeAction")
public class OfficeAction {

    private final static Logger logger = LoggerFactory.getLogger(OfficeAction.class);

    @Autowired
    private OfficeService wzbgService;

    /* *
    * @desc:办公用品管理查询
    * @author: dx
    * @date: 2019-07-09 09:13:56
    * @param request :
    * @param response :
    * @param params :
    * @return: com.alibaba.fastjson.JSONObject
    * @throws:
    * @version: 1.0
    **/
    //http://127.0.0.1:8080/Erp/officeAction/queryOfficeSuppliesData?month=2019-08&accountId1=&departmentId=&name=
    @ResponseBody
    @RequestMapping(value = "/queryOfficeSuppliesData", method = RequestMethod.POST)
    public JSONObject queryOfficeSuppliesData(HttpServletRequest request, HttpServletResponse response, @RequestBody String params) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败！");
            OfficeSuppliesDataBean officeSuppliesDataBean = JSONObject.parseObject(params, OfficeSuppliesDataBean.class);
            result.put(Constant.Result.RETDATA, wzbgService.queryOfficeSuppliesData(officeSuppliesDataBean));
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

    /* *
     * @desc:查询办公用品名及规格
     * @author: dx
     * @date: 2019-07-10 13:40:15
     * @param request :
     * @param response :
     * @return: com.alibaba.fastjson.JSONObject
     * @throws:
     * @version: 1.0
     **/
    //http://127.0.0.1:8080/Erp/officeAction/queryOfficeNames
    @ResponseBody
    @RequestMapping(value = "/queryOfficeNames", method = RequestMethod.POST)
    public JSONObject queryOfficeNames(HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            result.put(Constant.Result.RETDATA, wzbgService.queryOfficeNames());
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

    /* *
     * @desc:修改或添加办公用品申请信息
     * @author: dx
     * @date: 2019-07-12 11:13:23
     * @param request :
     * @param response :
     * @param params :
     * @return: com.alibaba.fastjson.JSONObject
     * @throws:
     * @version: 1.0
     **/
    //http://127.0.0.1:8080/Erp/officeAction/addUpdateOfficeSupplies?{"officeInfo":[{"id":"478","departmentId":"55","month":"2019-08-01","name":"小本","num":"2","specification":"本","remark":"2","accountId1":"239","accountId2":"239","advice2":3,"accountId3":null,"advice3":null,"state":0,"isTiJiao":null,"renShiId":null,"renShidAvice":null,"renShiSee":null,"fuZongId":null,"fuZongAdvice":null,"fuZongSee":null,"caiWuId":null,"caiWuAdvice":null,"caiWuSee":null,"zhuSee":null,"renSee":null,"shenSee":null,"isWanCheng":null,"renOtherSee":null,"departmentName":"开发组","account1Name":"王杰林","account2Name":"王杰林","officeId":"1","specId":"1","specificationList":[{"id":"1","specification":"本","nameId":"1"}]}],"delOffice":[]}
    @ResponseBody
    @RequestMapping(value = "/addUpdateOfficeSupplies", method = RequestMethod.POST)
    public JSONObject addUpdateOfficeSupplies(HttpServletRequest request, HttpServletResponse response, @RequestBody String params) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败!");
            Map<String, Object> requestMap = JSONObject.parseObject(params, Map.class);
            wzbgService.addUpdateOfficeSupplies(requestMap);
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

    /* *
     * @desc:当月是否汇总查询（已经汇总返回9999，没有返回0000）
     * @author: dx
     * @date: 2019-07-16 10:04:52
     * @param request :
     * @param response :
     * @param params :
     * @return: com.alibaba.fastjson.JSONObject
     * @throws:
     * @version: 1.0
     **/
    //http://127.0.0.1:8080/Erp/officeAction/isHuiZong?month=
    @ResponseBody
    @RequestMapping(value = "/isHuiZong", method = RequestMethod.POST)
    public JSONObject isHuiZong(HttpServletRequest request, HttpServletResponse response, @RequestBody String params) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败!");
            Map<String, Object> requestMap = JSONObject.parseObject(params, Map.class);
            result.put(Constant.Result.RETDATA, wzbgService.isHuiZong(requestMap));
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

    /* *
     * @desc:主管组长数据审核
     * @author: dx
     * @date: 2019-07-16 09:21:36
     * @param request :
     * @param response :
     * @param params :
     * @return: com.alibaba.fastjson.JSONObject
     * @throws:
     * @version: 1.0
     **/
    @ResponseBody
    @RequestMapping(value = "/shenHeOffice", method = RequestMethod.POST)
    public JSONObject shenHeOffice(HttpServletRequest request, HttpServletResponse response, @RequestBody String params) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败!");
            Map<String, Object> requestMap = JSONObject.parseObject(params, Map.class);
            wzbgService.shenHeOfficeSupplies(requestMap);
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

    /* *
     * @desc:办公用品汇总查询
     * @author: dx
     * @date: 2019-07-17 09:48:12
     * @param request :
     * @param response :
     * @param params :
     * @return: com.alibaba.fastjson.JSONObject
     * @throws:
     * @version: 1.0
     **/
    //http://127.0.0.1:8080/Erp/officeAction/gatherOfficeSupplies?month=2019-08
    @ResponseBody
    @RequestMapping(value = "/gatherOfficeSupplies", method = RequestMethod.POST)
    public JSONObject gatherOfficeSupplies(HttpServletRequest request, HttpServletResponse response, @RequestBody String params) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败!");
            Map<String, Object> requestMap = JSONObject.parseObject(params, Map.class);
            result.put(Constant.Result.RETDATA, wzbgService.gatherOfficeSupplies(requestMap));
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

    /* *
     * @desc:获取意见给出人
     * @author: dx
     * @date: 2019-07-17 10:21:19
     * @param request :
     * @param response :
     * @param params :
     * 参数最外层为一个json对象，里面为一个json数组（均为固定key）
     * 例：{params:[{deptName:"总经办",postName:"副总经理",key:"自定义返回key"}]}
     * @return: com.alibaba.fastjson.JSONObject
     * @throws:
     * @version: 1.0
     **/
    //http://127.0.0.1:8080/Erp/officeAction/queryAdvancePeo?{params:[{deptName:"总经办",postName:"副总经理",key:"自定义返回key"}]}
    @ResponseBody
    @RequestMapping(value = "/queryAdvancePeo", method = RequestMethod.POST)
    public JSONObject queryAdvancePeo(HttpServletRequest request, HttpServletResponse response, @RequestBody String params) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败!");
            Map<String, Object> requestMap = JSONObject.parseObject(params, Map.class);
            result.put(Constant.Result.RETDATA, wzbgService.queryAdvancePeo(requestMap));
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

    /* *
      * @desc:查询审核意见
      * @author: dx
      * @date: 2019-07-17 13:59:55
      * @param request :
      * @param response :
      * @param params :
      * @return: com.alibaba.fastjson.JSONObject
      * @throws:
      * @version: 1.0
      **/
    //http://127.0.0.1:8080/Erp/officeAction/queryAdvance?month=2019-08
    @ResponseBody
    @RequestMapping(value = "/queryAdvance", method = RequestMethod.POST)
    public JSONObject queryAdvance(HttpServletRequest request, HttpServletResponse response, @RequestBody String params) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败!");
            Map<String, Object> requestMap = JSONObject.parseObject(params, Map.class);
            result.put(Constant.Result.RETDATA, wzbgService.queryAdvance(requestMap));
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

    /* *
     * @desc:提交，审核
     * @author: dx
     * @date: 2019-07-17 16:34:08
     * @param request :
     * @param response :
     * @param params :
     * @return: com.alibaba.fastjson.JSONObject
     * @throws:
     * @version: 1.0
     **/
    //http://127.0.0.1:8080/Erp/officeAction/commitAndSheHe?{"officeInfo":[{"month":"2019-08","accountId3":"239","isTiJiao":1,"state":1}]}
    @ResponseBody
    @RequestMapping(value = "/commitAndSheHe", method = RequestMethod.POST)
    public JSONObject commitAndSheHe(HttpServletRequest request, HttpServletResponse response, @RequestBody String params) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败!");
            Map<String, Object> requestMap = JSONObject.parseObject(params, Map.class);
            wzbgService.commitAndSheHe(requestMap);
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

    /* *
     * @desc:查询部门相关负责人(主管及组长)
     * @author: dx
     * @date: 2019-07-18 10:00:10
     * @param request :
     * @param response :
     * @param params :
     * @return: com.alibaba.fastjson.JSONObject
     * @throws:
     * @version: 1.0
     **/
    //http://127.0.0.1:8080/Erp/officeAction/queryDeptConscientious?deptId=&level=
    @ResponseBody
    @RequestMapping(value = "/queryDeptConscientious", method = RequestMethod.POST)
    public JSONObject queryDeptConscientious(HttpServletRequest request, HttpServletResponse response, @RequestBody String params) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败!");
            Map<String, Object> requestMap = JSONObject.parseObject(params, Map.class);
            result.put(Constant.Result.RETDATA, wzbgService.queryDeptConscientious(requestMap));
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

    /* *
     * @desc:查询本部门主管
     * @author: dx
     * @date: 2019-08-06 10:15:47
     * @param request :
     * @param response :
     * @param params :
     * @return: com.alibaba.fastjson.JSONObject
     * @throws:
     * @version: 1.0
     **/
    //http://127.0.0.1:8080/Erp/officeAction/queryDeptResponsible?deptId=&level=
    @ResponseBody
    @RequestMapping(value = "/queryDeptResponsible", method = RequestMethod.POST)
    public JSONObject queryDeptResponsible(HttpServletRequest request, HttpServletResponse response, @RequestBody String params) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败!");
            Map<String, Object> requestMap = JSONObject.parseObject(params, Map.class);
            result.put(Constant.Result.RETDATA, wzbgService.queryDeptResponsible(requestMap));
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

    /* *
     * @desc:扩大主管范围
     * @author: dx
     * @date: 2019-08-06 10:34:34
     * @param request :
     * @param response :
     * @param params :
     * @return: com.alibaba.fastjson.JSONObject
     * @throws:
     * @version: 1.0
     **/
    //http://127.0.0.1:8080/Erp/officeAction/queryDeptExpandResponsible?deptId=&level=
    @ResponseBody
    @RequestMapping(value = "/queryDeptExpandResponsible", method = RequestMethod.POST)
    public JSONObject queryDeptExpandResponsible(HttpServletRequest request, HttpServletResponse response, @RequestBody String params) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败!");
            Map<String, Object> requestMap = JSONObject.parseObject(params, Map.class);
            result.put(Constant.Result.RETDATA, wzbgService.queryDeptExpandResponsible(requestMap));
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

    /* *
     * @desc:查询审查人
     * @author: dx
     * @date: 2019-08-06 13:34:49
     * @param request :
     * @param response :
     * @param params :
     * @return: com.alibaba.fastjson.JSONObject
     * @throws:
     * @version: 1.0
     **/
    //http://127.0.0.1:8080/Erp/officeAction/queryCensor?postId=&postName=
    @ResponseBody
    @RequestMapping(value = "/queryCensor", method = RequestMethod.POST)
    public JSONObject queryCensor(HttpServletRequest request, HttpServletResponse response, @RequestBody String params) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败!");
            Map<String, Object> requestMap = JSONObject.parseObject(params, Map.class);
            result.put(Constant.Result.RETDATA, wzbgService.queryCensor(requestMap));
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

    /* *
     * @desc:查询电脑交接人
     * @author: dx
     * @date: 2019-08-06 15:45:14
     * @param request :
     * @param response :
     * @param params :
     * @return: com.alibaba.fastjson.JSONObject
     * @throws:
     * @version: 1.0
     **/
    //http://127.0.0.1:8080/Erp/officeAction/queryComputerHandover
     @ResponseBody
     @RequestMapping(value = "/queryComputerHandover", method = RequestMethod.POST)
     public JSONObject queryComputerHandover(HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            result.put(Constant.Result.RETDATA, wzbgService.queryComputerHandover(null));
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

    /* *
     * @desc:查询办公用品交接人
     * @author: dx
     * @date: 2019-08-06 15:54:39
     * @param request :
     * @param response :
     * @return: com.alibaba.fastjson.JSONObject
     * @throws:
     * @version: 1.0
     **/
    //http://127.0.0.1:8080/Erp/officeAction/queryOfficeHandover
    @ResponseBody
    @RequestMapping(value = "/queryOfficeHandover", method = RequestMethod.POST)
    public JSONObject queryOfficeHandover(HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            result.put(Constant.Result.RETDATA, wzbgService.queryOfficeHandover(null));
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

    /* *
     * @desc:会议室申请信息查询
     * @author: dx
     * @date: 2019-07-23 09:26:25
     * @param request :
     * @param response :
     * @param params :
     * @return: com.alibaba.fastjson.JSONObject
     * @throws:
     * @version: 1.0
     **/
    //http://127.0.0.1:8080/Erp/officeAction/queryOfficeUserData?startTime=&endTime&officeId=
    @ResponseBody
    @RequestMapping(value = "/queryOfficeUserData", method = RequestMethod.POST)
    public JSONObject queryOfficeUserData(HttpServletRequest request, HttpServletResponse response, @RequestBody String params) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败!");
            OfficeUserDataBean officeUserDataBean = JSONObject.parseObject(params, OfficeUserDataBean.class);
            result.put(Constant.Result.RETDATA, wzbgService.queryOfficeUserData(officeUserDataBean));
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

    /* *
     * @desc:会议室查询
     * @author: dx
     * @date: 2019-07-23 09:38:17
     * @param request :
     * @param response :
     * @param params :
     * @return: com.alibaba.fastjson.JSONObject
     * @throws:
     * @version: 1.0
     **/
    //http://127.0.0.1:8080/Erp/officeAction/queryOfficeData
    @ResponseBody
    @RequestMapping(value = "/queryOfficeData", method = RequestMethod.POST)
    public JSONObject queryOfficeData(HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            result.put(Constant.Result.RETDATA, wzbgService.queryOfficeData());
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

    /* *
     * @desc:会议预约信息添加及修改
     * @author: dx
     * @date: 2019-07-25 15:13:59
     * @param request :
     * @param response :
     * @param params :
     * @return: com.alibaba.fastjson.JSONObject
     * @throws:
     * @version: 1.0
     **/
    //http://127.0.0.1:8080/Erp/officeAction/addUpdateOfficeUserData
    @ResponseBody
    @RequestMapping(value = "/addUpdateOfficeUserData", method = RequestMethod.POST)
    public JSONObject addUpdateOfficeUserData(HttpServletRequest request, HttpServletResponse response, @RequestBody String params) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败!");
            OfficeUserDataBean officeUserDataBean = JSONObject.parseObject(params, OfficeUserDataBean.class);
            wzbgService.addUpdateOfficeUserData(officeUserDataBean);
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

    /* *
     * @desc:修改会议室预约信息状态
     * @author: dx
     * @date: 2019-07-30 09:13:35
     * @param request :
     * @param response :
     * @param params :
     * @return: com.alibaba.fastjson.JSONObject
     * @throws:
     * @version: 1.0
     **/
    //http://127.0.0.1:8080/Erp/officeAction/updateOfficeUserDataState?{id:'570',state:'1'}
    @ResponseBody
    @RequestMapping(value = "/updateOfficeUserDataState", method = RequestMethod.POST)
    public JSONObject updateOfficeUserDataState(HttpServletRequest request, HttpServletResponse response, @RequestBody String params) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败!");
            OfficeUserDataBean officeUserDataBean = JSONObject.parseObject(params, OfficeUserDataBean.class);
            wzbgService.updateOfficeUserDataState(officeUserDataBean);
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
