package com.jiubo.erp.wzbg.service.impl;


import com.alibaba.fastjson.JSONObject;
import com.jiubo.erp.common.Constant;
import com.jiubo.erp.common.MapUtil;
import com.jiubo.erp.common.MessageException;
import com.jiubo.erp.rygl.controller.EmpController;
import com.jiubo.erp.wzbg.bean.AskForLeaveBean;
import com.jiubo.erp.wzbg.bean.EmpRequireBean;
import com.jiubo.erp.wzbg.bean.EmployeeOfCheck;
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
import java.util.List;
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
            result.put("resData", this.dao.checkOfEmpList(plop));
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
     * @return
     * JSONObject
     * @author 作者 : mwl
     * @version 创建时间：2019年7月8日 上午10:20:08
     */
    @SuppressWarnings("finally")
    public List<EmployeeOfCheck> verifyOfEmpList(PLOParam ploParam){
	    return this.dao.verifyOfEmpList(ploParam);
	}

    /**
     * 请假审查 -- 审查人列表 根据请假人的级别查看审查列表
     * @return
     * JSONObject
     * @author 作者 : mwl
     * @version 创建时间：2019年7月8日 上午10:20:08
     */
    @SuppressWarnings("finally")
    public List<EmployeeOfCheck>approveOfEmpList(PLOParam ploParam){

        return this.dao.approveOfEmpList(ploParam);
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

    /**
     * 人员需求列表
     * 方法说明
     * @param response
     * @param request
     * @return
     * JSONObject
     * @author 作者 : mwl
     * @version 创建时间：2019年8月1日 下午1:42:27
     */
    @SuppressWarnings("finally")
    public JSONObject selectEmpRequireLsit(HttpServletResponse response, HttpServletRequest request) {
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
     * 人员需求申请
     * 方法说明
     * @param response
     * @param request
     * @return
     * JSONObject
     * @author 作者 : mwl
     * @version 创建时间：2019年8月1日 下午1:43:01
     */
    public JSONObject insertEmpRequireApply(HttpServletResponse response, HttpServletRequest request){
        EmpRequireBean erb = new EmpRequireBean();
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            String str = StreamUtils.copyToString(request.getInputStream(), Charset.forName("UTF-8"));
            if (StringUtils.isBlank(str))
                throw new MessageException("参数接收失败！");
            JSONObject jsonData = JSONObject.parseObject(str);
            erb= MapUtil.transJsonToObjectIgnoreCase(jsonData, EmpRequireBean.class);
            System.out.println("insertEmpRequireApply：" + erb.getDepartmentName()+erb.toString());
            result.put("resData", this.dao.insertEmpRequireApply(erb));
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
     * 修改人员需求
     * 方法说明
     * @param response
     * @param request
     * @return
     * JSONObject
     * @author 作者 : mwl
     * @version 创建时间：2019年8月1日 下午1:43:01
     */
    public JSONObject updateRYRequire(HttpServletResponse response, HttpServletRequest request) {
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

    /**
     * 工作年限
     * 方法说明
     * @param response
     * @param request
     * @return
     * JSONObject
     * @author 作者 : mwl
     * @version 创建时间：2019年8月1日 下午1:43:30
     */
    public JSONObject selectWorkAge(HttpServletResponse response, HttpServletRequest request) {

        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {

            result.put("resData", this.dao.selectWorkAge());
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
     * 专业
     * 方法说明
     * @param response
     * @param request
     * @return
     * JSONObject
     * @author 作者 : mwl
     * @version 创建时间：2019年8月1日 下午1:43:54
     */
    public JSONObject selectMajor(HttpServletResponse response, HttpServletRequest request) {
        // TODO Auto-generated method stub
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {

            result.put("resData", this.dao.selectMajor());
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
     * 跳槽频率
     * 方法说明
     * @param response
     * @param request
     * @return
     * JSONObject
     * @author 作者 : mwl
     * @version 创建时间：2019年8月1日 下午1:43:54
     */
    public JSONObject selectJobHopFrequency(HttpServletResponse response, HttpServletRequest request) {
        // TODO Auto-generated method stub
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {

            result.put("resData", this.dao.selectJobHopFrequency());
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
     * 行业背景
     * 方法说明
     * @param response
     * @param request
     * @return
     * JSONObject
     * @author 作者 : mwl
     * @version 创建时间：2019年8月1日 下午1:43:54
     */
    public JSONObject selectIndustryBackground(HttpServletResponse response, HttpServletRequest request) {
        // TODO Auto-generated method stub
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {

            result.put("resData", this.dao.selectIndustryBackground());
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
     * 不同年龄段列表
     * 方法说明
     * @param response
     * @param request
     * @return
     * JSONObject
     * @author 作者 : mwl
     * @version 创建时间：2019年8月1日 下午1:43:54
     */
    public JSONObject selectAgeLsit(HttpServletResponse response, HttpServletRequest request) {
        // TODO Auto-generated method stub
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {

            result.put("resData", this.dao.selectAgeLsit());
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
     * 人员需求 审查人
     * @param response
     * @param request
     * @return
     */
    public JSONObject empRequireCheckList(HttpServletResponse response, HttpServletRequest request) {

        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            String str = StreamUtils.copyToString(request.getInputStream(), Charset.forName("UTF-8"));
            if (StringUtils.isBlank(str))
                throw new MessageException("参数接收失败！");
            JSONObject jsonData = JSONObject.parseObject(str);
            int pType = this.dao.selectPositionType(jsonData.getString("positionId"));
            System.out.println("empRequireCheckList："+str +"pType:"+pType+ jsonData.getString("btnTime")+jsonData.getString("departId"));
            result.put("resData", this.dao.selectCheckList(jsonData.getString("departId"),jsonData.getString("btnTime"),pType));
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
     * 人员需求审核人
     * @param response
     * @param request
     * @return
     */
    public JSONObject empRequireApprolList(HttpServletResponse response, HttpServletRequest request) {

        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            String str = StreamUtils.copyToString(request.getInputStream(), Charset.forName("UTF-8"));
            if (StringUtils.isBlank(str))
                throw new MessageException("参数接收失败！");
            JSONObject jsonData = JSONObject.parseObject(str);

            System.out.println("empRequireApprolList：" + jsonData.getString("positionId"));
            result.put("resData", this.dao.selectApprolList(jsonData.getString("positionId")));
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
