package com.jiubo.erp.wzbg.controller;

import com.alibaba.fastjson.JSONObject;
import com.jiubo.erp.common.Constant;
import com.jiubo.erp.common.MapUtil;
import com.jiubo.erp.common.MessageException;
import com.jiubo.erp.wzbg.bean.LeavePrepareBean;
import com.jiubo.erp.wzbg.service.LeavePrepareService;
import com.jiubo.erp.wzbg.vo.AccWithApprovalLeaveAuth;
import com.jiubo.erp.wzbg.vo.CheckInfo;
import com.jiubo.erp.wzbg.vo.DeptWithEmp;
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

/**
 * @version: V1.0
 * @author: DingDong
 * @className: LeavePrepareController
 * @description: 请假报备管理控制层
 * @data: 2019-06-29
 **/
@Controller
@Scope("prototype")
@RequestMapping("/leavePrepareController")
public class LeavePrepareController {

    private final static Logger logger = LoggerFactory.getLogger(LeavePrepareController.class);

    @Autowired
    private LeavePrepareService leavePrepareService;

    /**
     * @param
     * @return JSONObject
     * @Description: 查询某个部门的员工账户信息
     * @author: DingDong
     * @date: 2019年7月1日
     * @version: V1.0
     */
    //http://127.0.0.1:8080/Erp/leavePrepareController/queryEmpInfoByDept
    @ResponseBody
    @RequestMapping(value = "/queryEmpInfoByDept", method = RequestMethod.POST)
    public JSONObject queryEmpInfoByDept(@RequestBody Map<String, Object> params, HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        String retCode = null;
        String retMsg = null;
        String retData = null;
        try {
            String id = MapUtil.getString(params, "departmentId", MapUtil.ALLOW_NULL);
            List<DeptWithEmp> list = leavePrepareService.queryEmpInfoByDept(id);

            retCode = Constant.Result.SUCCESS;
            retMsg = Constant.Result.SUCCESS_MSG;
            retData = Constant.Result.RETDATA;

            result.put(retData, list);
            logger.info("--------------查询部门下的员工姓名以及ERP账户信息成功 返回json数据-------------------");
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
     * @param
     * @return
     * @Description: 查询审批人账户信息
     * @author: DingDong
     * @date: 2019年07月02日
     * @version: V1.0
     */
    //http://127.0.0.1:8080/Erp/leavePrepareController/queryApprovalLeaveAccount
    @ResponseBody
    @RequestMapping(value = "/queryApprovalLeaveAccount", method = RequestMethod.POST)
    public JSONObject queryApprovalLeaveAccount(HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        // 异常处理
        try {
            List<AccWithApprovalLeaveAuth> list = leavePrepareService.queryApprovalAuthAccount();
            result.put(Constant.Result.RETDATA, list);
            logger.info("------------查询成功----------");
        } catch (Exception e) {
            retCode = Constant.Result.ERROR;
            retMsg = Constant.Result.ERROR_MSG;
            // 日志记录
            logger.error(Constant.Result.RETMSG, e);
        } finally {
            result.put(Constant.Result.RETCODE, retCode);
            result.put(Constant.Result.RETMSG, retMsg);
        }
        return result;
    }

    /**
     * @param
     * @return
     * @Description: 查询请假报备
     * @author: DingDong
     * @date: 2019年06月29日
     * @version: V1.0
     */
    //http://127.0.0.1:8080/Erp/leavePrepareController/queryLeavePrepare
    @ResponseBody
    @RequestMapping(value = "/queryLeavePrepare", method = RequestMethod.POST)
    public JSONObject queryLeavePrepare(HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        String retCode = null;
        String retMsg = null;
        String retData = null;
        try {
            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str)) {
                throw new MessageException("参数接收失败！");
            }
            LeavePrepareBean leavePrepareBean = MapUtil.transJsonStrToObjectIgnoreCase(str, LeavePrepareBean.class);
            List<LeavePrepareBean> list = leavePrepareService.queryLeavePrepareBean(leavePrepareBean);

            retCode = Constant.Result.SUCCESS;
            retMsg = Constant.Result.SUCCESS_MSG;
            retData = Constant.Result.RETDATA;

            result.put(retData, list);
            logger.info("--------------查询请假报备成功 返回json数据-------------------");
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
     * @param
     * @return
     * @Description: 申请请假报备
     * @author: DingDong
     * @date: 2019年06月29日
     * @version: V1.0
     */
    //http://127.0.0.1:8080/Erp/leavePrepareController/addLeavePrepare
    @ResponseBody
    @RequestMapping(value = "/addLeavePrepare", method = RequestMethod.POST)
    public JSONObject addLeavePrepare(HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        String retCode = null;
        String retMsg = null;
        try {
            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str)) {
                throw new MessageException("参数接收失败！");
            }
            LeavePrepareBean leavePrepareBean = MapUtil.transJsonStrToObjectIgnoreCase(str, LeavePrepareBean.class);
            leavePrepareService.addLeavePrepareBean(leavePrepareBean);

            retCode = Constant.Result.SUCCESS;
            retMsg = Constant.Result.SUCCESS_MSG;
            logger.info("--------------添加请假报备成功-------------------");
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
     * @param
     * @return JSONObject
     * @Description: 查询代理人账户信息
     * @author: DingDong
     * @date: 2019年07月09日
     * @version: V1.0
     */
    //http://127.0.0.1:8080/Erp/leavePrepareController/queryAgentList
    @ResponseBody
    @RequestMapping(value = "/queryAgentList", method = RequestMethod.POST)
    public JSONObject queryAgentList(HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        String retCode = null;
        String retMsg = null;
        String retData = null;
        try {
            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str)) {
                throw new MessageException("参数接收失败！");
            }
            DeptWithEmp deptWithEmp = MapUtil.transJsonStrToObjectIgnoreCase(str, DeptWithEmp.class);
            List<DeptWithEmp> list = leavePrepareService.queryAgentList(deptWithEmp);

            retCode = Constant.Result.SUCCESS;
            retMsg = Constant.Result.SUCCESS_MSG;
            retData = Constant.Result.RETDATA;

            result.put(retData, list);
            logger.info("--------------查询请假代理人列表成功 返回json数据-------------------");
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
     * @param
     * @return JSONObject
     * @Description: 查询部门及子部门的员工信息
     * @author: DingDong
     * @date: 2019年07月10日
     * @version: V1.0
     */
    //http://127.0.0.1:8080/Erp/leavePrepareController/queryEmpByDeptOrParentDept
    @ResponseBody
    @RequestMapping(value = "/queryEmpByDeptOrParentDept", method = RequestMethod.POST)
    public JSONObject queryEmpByDeptOrParentDept(HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        String retCode = null;
        String retMsg = null;
        String retData = null;
        try {
            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str)) {
                throw new MessageException("参数接收失败！");
            }
            DeptWithEmp deptWithEmp = MapUtil.transJsonStrToObjectIgnoreCase(str, DeptWithEmp.class);
            List<DeptWithEmp> list = leavePrepareService.queryEmpByDeptOrParentDept(deptWithEmp);

            retCode = Constant.Result.SUCCESS;
            retMsg = Constant.Result.SUCCESS_MSG;
            retData = Constant.Result.RETDATA;

            result.put(retData, list);
            logger.info("--------------查询所在部门以及子部门的员工信息成功 返回json数据-------------------");
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
     * @param
     * @return JSONObject
     * @Description: 更新请假报备
     * @author: DingDong
     * @date: 2019年07月11日
     * @version: V1.0
     */
    //http://127.0.0.1:8080/Erp/leavePrepareController/updateLeavePrepare
    @ResponseBody
    @RequestMapping(value = "/updateLeavePrepare", method = RequestMethod.POST)
    public JSONObject updateLeavePrepare(HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        String retCode = null;
        String retMsg = null;
        try {
            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str)) {
                throw new MessageException("参数接收失败！");
            }
            LeavePrepareBean leavePrepareBean = MapUtil.transJsonStrToObjectIgnoreCase(str, LeavePrepareBean.class);
            leavePrepareService.updateLeavePrepare(leavePrepareBean);

            retCode = Constant.Result.SUCCESS;
            retMsg = Constant.Result.SUCCESS_MSG;
            logger.info("--------------更新请假报备信息信息成功 返回json数据-------------------");
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
     * @param
     * @return JSONObject
     * @Description: 查询审查人信息
     * @author: DingDong
     * @date: 2019年07月10日
     * @version: V1.0
     */
    //http://127.0.0.1:8080/Erp/leavePrepareController/queryCheckInfo
    @ResponseBody
    @RequestMapping(value = "/queryCheckInfo", method = RequestMethod.POST)
    public JSONObject queryCheckInfo(HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        String retCode = null;
        String retMsg = null;
        String retData = null;
        try {
            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str)) {
                throw new MessageException("参数接收失败！");
            }
            CheckInfo checkInfo = JSONObject.parseObject(str, CheckInfo.class);
            List<CheckInfo> list = leavePrepareService.queryCheckInfo(checkInfo);

            retCode = Constant.Result.SUCCESS;
            retMsg = Constant.Result.SUCCESS_MSG;
            retData = Constant.Result.RETDATA;

            result.put(retData, list);
            logger.info("--------------查询审查人信息成功 返回json数据-------------------");
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
     * @param
     * @return JSONObject
     * @Description: 查询父级部门ID
     * @author: DingDong
     * @date: 2019年07月10日
     * @version: V1.0
     */
    //http://127.0.0.1:8080/Erp/leavePrepareController/queryParentDept
    @ResponseBody
    @RequestMapping(value = "/queryParentDept", method = RequestMethod.POST)
    public JSONObject queryParentDept(@RequestBody Map<String, Object> params, HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        String retCode = null;
        String retMsg = null;
        String retData = null;
        try {
            String id = MapUtil.getString(params, "deptId", MapUtil.ALLOW_NULL);
            String parentId = leavePrepareService.queryParentDept(id);
            retCode = Constant.Result.SUCCESS;
            retMsg = Constant.Result.SUCCESS_MSG;
            retData = Constant.Result.RETDATA;

            result.put(retData, parentId);
            logger.info("--------------查询父级部门ID成功 返回json数据-------------------");
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
     * @param
     * @return JSONObject
     * @Description: // 查询请假表的报备ID
     * @author: DingDong
     * @date: 2019年08月15日
     * @version: V1.0
     */
    //http://127.0.0.1:8080/Erp/leavePrepareController/queryIdsForLeave
    @ResponseBody
    @RequestMapping(value = "/queryIdsForLeave", method = RequestMethod.GET)
    public JSONObject queryIdsForLeave() {
        JSONObject result = new JSONObject();
        String retCode = null;
        String retMsg = null;
        String retData = null;
        try {
            retCode = Constant.Result.SUCCESS;
            retMsg = Constant.Result.SUCCESS_MSG;
            retData = Constant.Result.RETDATA;
            result.put(retData, leavePrepareService.queryIdsForLeave());
            logger.info("--------------查询请假表里请假报备ID成功-------------------");
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
