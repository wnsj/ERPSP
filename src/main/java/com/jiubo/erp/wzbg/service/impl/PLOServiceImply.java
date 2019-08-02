package com.jiubo.erp.wzbg.service.impl;


import com.alibaba.fastjson.JSONObject;
import com.jiubo.erp.common.Constant;
import com.jiubo.erp.common.MapUtil;
import com.jiubo.erp.common.MessageException;
import com.jiubo.erp.rygl.controller.EmpController;
import com.jiubo.erp.wzbg.bean.AskForLeaveBean;
import com.jiubo.erp.wzbg.bean.RestDownBean;
import com.jiubo.erp.wzbg.dao.PLODao;
import com.jiubo.erp.wzbg.service.PLOService;
import com.jiubo.erp.wzbg.vo.PLOParam;
import com.quicksand.push.ToolClass;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

@Service
public class PLOServiceImply implements PLOService {

	public static Logger log = LoggerFactory.getLogger(EmpController.class);
	
	@Autowired
    private PLODao dao;
	
	/**
	    * 请假-列表
	    * @param response
	    * @param request
	    * @return
	    * JSONObject
	    * @author 作者 : mwl
	    * @version 创建时间：2019年7月3日 下午2:35:25
	    */
	@SuppressWarnings("finally")
	@Override
	public JSONObject askOfLeaveList(HttpServletResponse response, HttpServletRequest request) {
		PLOParam plop = new PLOParam();
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str))
                throw new MessageException("参数接收失败！");
            plop = MapUtil.transJsonStrToObjectIgnoreCase(str, PLOParam.class);
            System.out.println("plop:"+plop.toString());
            result.put("resData", this.dao.selectAskForLeaveList(plop));
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
	 * 请假 -- 代理人员列表
	 * @param response
	 * @param request
	 * @return
	 * JSONObject
	 * @author 作者 : mwl
	 * @version 创建时间：2019年7月3日 下午2:37:15
	 */
	@SuppressWarnings("finally")
	@Override
	public JSONObject selectDepartOfEmpList(HttpServletResponse response, HttpServletRequest request) {
		PLOParam plop = new PLOParam();
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str))
                throw new MessageException("参数接收失败！");
            plop = MapUtil.transJsonStrToObjectIgnoreCase(str, PLOParam.class);
            System.out.println("getSearchContent：" + plop.getDepartId()+plop.toString());
            result.put("resData", this.dao.selectDepartOfEmpList(plop));
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
	 * 请假审查 -- 审查人列表 根据请假人的级别查看审查列表
	 * @param response
	 * @param request
	 * @return
	 * JSONObject
	 * @author 作者 : mwl
	 * @version 创建时间：2019年7月8日 上午10:20:08
	 */
	@SuppressWarnings("finally")
	public JSONObject checkOfEmpList(HttpServletResponse response, HttpServletRequest request) {
		Map<String, String> levelMap = new HashMap<>();
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            levelMap = ToolClass.mapShiftStr(request);
            result.put("resData", this.dao.checkOfEmpList(levelMap.get("level"),levelMap.get("positionId"),levelMap.get("departId"),levelMap.get("clickTimes")));
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
	 * 请假申请
	 * @param response
	 * @param request
	 * @return
	 * JSONObject
	 * @author 作者 : mwl
	 * @version 创建时间：2019年7月8日 上午9:43:42
	 */
	@SuppressWarnings("finally")
	public JSONObject insertLeaveApplication(HttpServletResponse response, HttpServletRequest request) {
		
		AskForLeaveBean aflb = new AskForLeaveBean();
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
        	String str = StreamUtils.copyToString(request.getInputStream(), Charset.forName("UTF-8"));
        	if (StringUtils.isBlank(str))
                throw new MessageException("参数接收失败！");
			JSONObject jsonData = JSONObject.parseObject(str);
            
            JSONObject aflbStr = jsonData.getJSONObject("lInfo");
            aflb= MapUtil.transJsonToObjectIgnoreCase(aflbStr, AskForLeaveBean.class);
            System.out.println("insertLeaveApplication：" + aflb.getLeaveAccount()+aflb.toString());
            result.put("resData", this.dao.insertLeaveApplication(aflb));
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
	 * 请假修改
	 * @param response
	 * @param request
	 * @return
	 * JSONObject
	 * @author 作者 : mwl
	 * @version 创建时间：2019年7月22日 上午9:37:42
	 */
@SuppressWarnings("finally")
public JSONObject updateLeaveApplication(HttpServletResponse response, HttpServletRequest request) {
		
		AskForLeaveBean aflb = new AskForLeaveBean();
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
        	String str = StreamUtils.copyToString(request.getInputStream(), Charset.forName("UTF-8"));
        	if (StringUtils.isBlank(str))
                throw new MessageException("参数接收失败！");
			JSONObject jsonData = JSONObject.parseObject(str);
            
            JSONObject aflbStr = jsonData.getJSONObject("lInfo");
            aflb= MapUtil.transJsonToObjectIgnoreCase(aflbStr, AskForLeaveBean.class);
            System.out.println("updateLeaveApplication：" + aflb.getLeaveAccount()+aflb.toString());
            result.put("resData", this.dao.updateLeaveApplication(aflb));
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
	 * 倒休列表
	 * @param response
	 * @param request
	 * @return
	 * JSONObject
	 * @author 作者 : mwl
	 * @version 创建时间：2019年7月22日 上午9:37:42
	 */
	@SuppressWarnings("finally")
	public JSONObject restDownList(HttpServletResponse response, HttpServletRequest request) {
        PLOParam plop = new PLOParam();
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str))
                throw new MessageException("参数接收失败！");
            plop = MapUtil.transJsonStrToObjectIgnoreCase(str, PLOParam.class);
            System.out.println("plop:"+plop.toString());
            result.put("resData", this.dao.selectRestDownList(plop));
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
	 * 倒休申请
	 * @param response
	 * @param request
	 * @return
	 * JSONObject
	 * @author 作者 : mwl
	 * @version 创建时间：2019年7月22日 上午9:37:42
	 */
	@SuppressWarnings("finally")
	public JSONObject restDownApply(HttpServletResponse response, HttpServletRequest request) {
		RestDownBean rdb = new RestDownBean();
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
        	String str = StreamUtils.copyToString(request.getInputStream(), Charset.forName("UTF-8"));
        	if (StringUtils.isBlank(str))
                throw new MessageException("参数接收失败！");
			JSONObject jsonData = JSONObject.parseObject(str);
            
            JSONObject aflbStr = jsonData.getJSONObject("rdInfo");
            rdb= MapUtil.transJsonToObjectIgnoreCase(aflbStr, RestDownBean.class);
            System.out.println("insertRestApplication：" + rdb.getLeaveAccount()+rdb.toString());
            result.put("resData", this.dao.insertRestDownApplication(rdb));
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
	 * 倒休修改
	 * @param response
	 * @param request
	 * @return
	 * JSONObject
	 * @author 作者 : mwl
	 * @version 创建时间：2019年7月22日 上午9:37:42
	 */
	@SuppressWarnings("finally")
	public JSONObject restDownModify(HttpServletResponse response, HttpServletRequest request) {
		RestDownBean rdb = new RestDownBean();
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
        	String str = StreamUtils.copyToString(request.getInputStream(), Charset.forName("UTF-8"));
        	if (StringUtils.isBlank(str))
                throw new MessageException("参数接收失败！");
			JSONObject jsonData = JSONObject.parseObject(str);
            
            JSONObject aflbStr = jsonData.getJSONObject("rdInfo");
            rdb= MapUtil.transJsonToObjectIgnoreCase(aflbStr, RestDownBean.class);
            System.out.println("insertLeaveApplication：" + rdb.getLeaveAccount()+rdb.toString());
            result.put("resData", this.dao.updateRestDownApplication(rdb));
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
