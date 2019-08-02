package com.jiubo.erp.wzbg.controller;

import com.alibaba.fastjson.JSONObject;
import com.jiubo.erp.common.Constant;
import com.jiubo.erp.common.MapUtil;
import com.jiubo.erp.common.MessageException;
import com.jiubo.erp.wzbg.bean.ComputerBean;
import com.jiubo.erp.wzbg.service.ComputerService;
import com.jiubo.erp.wzbg.vo.PositionInfo;
import com.quicksand.push.ToolClass;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @version: V1.0
 * @author: DingDong
 * @className: ComputerController
 * @description: 电脑控制层
 * @data: 2019-07-30
 **/
@RestController
@Scope("prototype")
@RequestMapping("/computerController")
public class ComputerController {
	
	private final static Logger logger  = LoggerFactory.getLogger(ComputerController.class);
	
	@Autowired
	private ComputerService computerService;
	
	/**
	 * @Description: 查询电脑预申请接口
	 * @author: DingDong
	 * @date: 2019年07月30日
	 * @version: V1.0
	 */
	//http://127.0.0.1:8080/Erp/computerController/queryPreApplication
	@RequestMapping(value="/queryPreApplication", method= RequestMethod.POST)
	public JSONObject queryLeaveForget(HttpServletRequest request,HttpServletResponse response) {
		JSONObject result = new JSONObject();
		String retCode = null;
		String retMsg = null;
	    String retData = null;
	    logger.info("----------请求接口:computerController/queryPreApplication----------");
		try {
			String str = ToolClass.getStrFromInputStream(request);
			if(StringUtils.isBlank(str)) {
				throw new MessageException("参数接收失败！");
			}
			ComputerBean computerBean = MapUtil.transJsonStrToObjectIgnoreCase(str, ComputerBean.class);
			List<ComputerBean> list = computerService.queryPreApplication(computerBean);
			retCode = Constant.Result.SUCCESS;
			retMsg = Constant.Result.SUCCESS_MSG;
			retData = Constant.Result.RETDATA;
			
			result.put(retData, list);
			logger.info("----------查询电脑预申请接口成功----------");
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
	 * @Description: 添加电脑预申请接口
	 * @author: DingDong
	 * @date: 2019年07月31日
	 * @version: V1.0
	 */
	//http://127.0.0.1:8080/Erp/computerController/addPreApplication
	@RequestMapping(value="/addPreApplication", method= RequestMethod.POST)
	public JSONObject addPreApplication(HttpServletRequest request,HttpServletResponse response) {
		JSONObject result = new JSONObject();
		String retCode = null;
		String retMsg = null;
	    logger.info("----------请求接口:computerController/addPreApplication----------");
		try {
			String str = ToolClass.getStrFromInputStream(request);
			if(StringUtils.isBlank(str)) {
				throw new MessageException("参数接收失败！");
			}
			ComputerBean computerBean = MapUtil.transJsonStrToObjectIgnoreCase(str, ComputerBean.class);
			computerService.addPreApplication(computerBean);
			retCode = Constant.Result.SUCCESS;
			retMsg = Constant.Result.SUCCESS_MSG;
			logger.info("----------添加电脑预申请接口成功----------");
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
	 * @Description: 查询岗位信息接口
	 * @author: DingDong
	 * @date: 2019年07月31日
	 * @version: V1.0
	 */
	//http://127.0.0.1:8080/Erp/computerController/queryPositionInfo
	@RequestMapping(value="/queryPositionInfo", method= RequestMethod.GET)
	public JSONObject queryPositionInfo(HttpServletRequest request,HttpServletResponse response) {
		JSONObject result = new JSONObject();
		String retCode = null;
		String retMsg = null;
	    String retData = null;
	    logger.info("----------请求接口:computerController/queryPositionInfo----------");
		try {
			List<PositionInfo> list = computerService.queryPositionInfo();
			retCode = Constant.Result.SUCCESS;
			retMsg = Constant.Result.SUCCESS_MSG;
			retData = Constant.Result.RETDATA;
			
			result.put(retData, list);
			logger.info("----------查询电脑预申请接口成功----------");
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
	 * @Description: 查询所在部门主管信息接口
	 * @author: DingDong
	 * @date: 2019年8月1日
	 * @version: V1.0
	 */
	//http://127.0.0.1:8080/Erp/computerController/queryLeaderInfo/{deptId}
	@RequestMapping(value="/queryLeaderInfo", method= RequestMethod.GET)
	public JSONObject queryLeaderInfo(String deptId) {
		JSONObject result = new JSONObject();
		String retCode = null;
		String retMsg = null;
	    String retData = null;
	    logger.info("----------请求接口:computerController/queryLeaderInfo/{deptId}----------");
		try {
			retCode = Constant.Result.SUCCESS;
			retMsg = Constant.Result.SUCCESS_MSG;
			retData = Constant.Result.RETDATA;
			result.put(retData, computerService.queryLeaderInfo(deptId));
			logger.info("----------查询所在部门主管信息接口成功----------");
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
}
