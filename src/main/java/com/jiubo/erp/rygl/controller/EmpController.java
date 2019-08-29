package com.jiubo.erp.rygl.controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONArray;
import com.jiubo.erp.common.Constant;
import com.jiubo.erp.common.MD5Util;
import com.jiubo.erp.common.MapUtil;
import com.jiubo.erp.common.MessageException;
import com.jiubo.erp.common.Position;
import com.jiubo.erp.common.TimeUtil;
import com.jiubo.erp.erpLogin.util.ResponseMessageUtils;

import com.jiubo.erp.rygl.bean.DepartmentBean;
import com.jiubo.erp.rygl.bean.ProjectDataBean;
import com.jiubo.erp.rygl.service.EmpService;
import com.jiubo.erp.rygl.vo.Account;
import com.jiubo.erp.rygl.vo.LeaveResign;
import com.jiubo.erp.rygl.vo.Nation;
import com.jiubo.erp.rygl.vo.PositionShift;
import com.jiubo.erp.rygl.vo.QueryFamilyResult;
import com.jiubo.erp.rygl.vo.QueryParam;
import com.jiubo.erp.rygl.vo.QueryResult;
import com.jiubo.erp.rygl.vo.UserFamily;
import com.jiubo.erp.rygl.vo.UserInfo;
import com.quicksand.push.ToolClass;

@Controller
@RequestMapping("/search")
public class EmpController {
	
    public static Logger log = LoggerFactory.getLogger(EmpController.class);

    @Autowired
    private EmpService service;

    /**
     * 全员搜索
     *
     * @param response
     * @param request
     * @return
     */
    @SuppressWarnings("finally")
    @ResponseBody
    @RequestMapping(value = "/allList")
    public JSONObject allList(HttpServletResponse response, HttpServletRequest request) {
        QueryParam qp = new QueryParam();
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str))
                throw new MessageException("参数接收失败！");
            qp = MapUtil.transJsonStrToObjectIgnoreCase(str, QueryParam.class);
//            System.out.println("getSearchContent：" + qp.getSearchContent()+qp.toString()+this.service.initEmpList(qp, request).get(0).getResignDate());
            result.put("resData", this.service.initEmpList(qp, request));
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
     * 高级查询,入职、离职、转正
     *
     * @param request
     * @return
     * @throws Exception
     */
    @SuppressWarnings("finally")
    @ResponseBody
    @RequestMapping(value = "/advanceAllList")
    public JSONObject advanceQuery(HttpServletResponse response, HttpServletRequest request) throws Exception {
        QueryParam qp = new QueryParam();
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str))
                throw new MessageException("参数接收失败！");
            qp = MapUtil.transJsonStrToObjectIgnoreCase(str, QueryParam.class);

            result.put("resData", this.service.initEmpList(qp, request));
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
     * 生日查询
     *
     * @param response
     * @param request
     * @return 返回值类型  JSONObject
     * @throws Exception
     * @author 作者 mwl
     * @date 时间 2019年5月10日上午9:25:48
     */
    @SuppressWarnings("finally")
    @ResponseBody
    @RequestMapping(value = "/advanceBirthQuery")
    public JSONObject advanceBirthQuery(HttpServletResponse response, HttpServletRequest request) throws Exception {
        QueryParam qp = new QueryParam();

        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str))
                throw new MessageException("参数接收失败！");
            qp = MapUtil.transJsonStrToObjectIgnoreCase(str, QueryParam.class);
            System.out.println("QueryParam:categry:" + qp.getSearchType());


            result.put("resData", this.service.initEmpList(qp, request));
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
     * 首页模糊查询
     *
     * @param param
     * @param request
     * @return
     * @throws Exception
     */
    public List<QueryResult> fuzzyQuery(QueryParam param, HttpServletRequest request) throws Exception {
        List<QueryResult> emplist = this.service.initEmpList(param, request);

        // 首页的模糊搜索
        if (param.getSearchContent() != null & emplist.size() > 0) {
            List<QueryResult> qrListCource = new ArrayList<>();
            List<QueryResult> qrListRes = new ArrayList<>();
            String searchStr = param.getSearchContent();
            qrListCource = this.service.initEmpList(param, request);
            for (QueryResult qrListCour : qrListCource) {
                if (qrListCour.getJobNum().contains(searchStr) || qrListCour.getName().contains(searchStr)
                        || qrListCour.getDepartName().contains(searchStr)
                        || qrListCour.getPositionName().contains(searchStr)) {
                    qrListRes.add(qrListCour);
                }
            }
            // System.out.println("-------模糊查询fuzzyQuery-----"+qrListRes.size());

            return qrListRes;
        }
        return emplist;
    }

    /**
     * 赛选家庭人员列表
     *
     * @param response
     * @param request
     * @return
     * @throws Exception
     */
    @SuppressWarnings("finally")
    @ResponseBody
    @RequestMapping(value = "/fmList")
    public JSONObject fmList(HttpServletResponse response, HttpServletRequest request) throws Exception {

        QueryFamilyResult qfr = new QueryFamilyResult();

        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            List<QueryFamilyResult> fmList = new ArrayList<>();
            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str))
                throw new MessageException("参数接收失败！");
            qfr = MapUtil.transJsonStrToObjectIgnoreCase(str, QueryFamilyResult.class);
            fmList = this.service.familyfuzzyQuery(qfr);
            result.put("resData", fmList);
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
     * 查看所有人员列表
     *
     * @param param    所有人
     * @param response
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/ryAllList")
    public List<QueryResult> ryAllList(QueryParam param, HttpServletResponse response, HttpServletRequest request) {
        List<QueryResult> qrList = new ArrayList<>();
        try {
            qrList = this.service.initEmpList(param, request);
            // System.out.println("查询到了---------" + qrList.size());
            return qrList;
        } catch (Exception e) {
            e.printStackTrace();
            ResponseMessageUtils.responseMessage(response, "查询失败!");
            return null;
        }
    }

    /**
     * 项目列表
     *
     * @param response
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/projectList")
    public List<ProjectDataBean> projectList(HttpServletResponse response, HttpServletRequest request) {
        List<ProjectDataBean> qrList = new ArrayList<>();
        try {
            qrList = this.service.initProjectList(request);
            System.out.println("项目列表" + qrList.size());
            return qrList;
        } catch (Exception e) {
            e.printStackTrace();
            ResponseMessageUtils.responseMessage(response, "查询失败!");
            return null;
        }
    }

    /**
     * 部门列表
     *
     * @param response
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/departList")
    public List<DepartmentBean> departList(HttpServletResponse response, HttpServletRequest request) {

        DepartmentBean dbp = new DepartmentBean();
        try {
            List<DepartmentBean> sorceList = this.service.initDepartList(dbp);
            return sorceList;
        } catch (Exception e) {
            e.printStackTrace();
            ResponseMessageUtils.responseMessage(response, "查询失败!");
            return null;
        }
    }

    /**
     * 民族列表
     *
     * @param response
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/nationList")
    public List<Nation> positionList(HttpServletResponse response, HttpServletRequest request) {
        List<Nation> nList = new ArrayList<>();
        try {
            nList = this.service.initNationList();
            System.out.println("项目列表" + nList.size());
            return nList;
        } catch (Exception e) {
            e.printStackTrace();
            ResponseMessageUtils.responseMessage(response, "查询失败!");
            return null;
        }
    }

    /**
     * 职位列表
     *
     * @param response
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/positionList")
    public List<Position> nationList(HttpServletResponse response, HttpServletRequest request) {
        List<Position> pList = new ArrayList<>();
        try {
            pList = this.service.initPositionList();
            return pList;
        } catch (Exception e) {
            e.printStackTrace();
            ResponseMessageUtils.responseMessage(response, "查询失败!");
            return null;
        }
    }

    /**
     * 离职原因列表
     *
     * @param response
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/leaveReasonList")
    public List<LeaveResign> leaveReasonList(HttpServletResponse response, HttpServletRequest request) {
        List<LeaveResign> lrList = new ArrayList<>();
        try {
            lrList = this.service.initLeaveList(null);
            System.out.println("lrList" + lrList.size());
            return lrList;
        } catch (Exception e) {
            e.printStackTrace();
            ResponseMessageUtils.responseMessage(response, "查询失败!");
            return null;
        }
    }

    /**
     * 查询部门名称
     *
     * @param dpList 部门列表 dpId部门id
     * @return
     */
    public String departName(List<DepartmentBean> dpList, String dpId) {
        String dpName = new String();
        // System.out.println("-------部门列表和部门id----------"+dpList.size());
        for (DepartmentBean departmentBean : dpList) {
            DepartmentBean dp = departmentBean;
            if (dp.getID().equals(dpId)) {
                dpName = dp.getName();
                return dpName;
            }
        }
        return "";
    }

    /**
     * 家庭成员列表
     *
     * @param param
     * @param response
     * @param request
     * @return
     */
//	@ResponseBody
//	@RequestMapping(value = "/familyList")
//	public List<QueryFamilyResult> familyList(HttpServletResponse response, HttpServletRequest request) {
//		List<QueryFamilyResult> qfrList = new ArrayList<>();
//		QueryParam qParam = new QueryParam();
//		Map<String, String> mapList = ToolClass.mapShiftStr(request);
//		qParam.setChName(mapList.get("chName"));
//		qParam.setChName(mapList.get("empName"));
//		qParam.setChName(mapList.get("shBirth"));
//		try {
//			qfrList = this.service.initFamilList(qParam, request);
//			System.out.println("家庭人员列表" + qfrList.size());
//			return qfrList;
//		} catch (Exception e) {
//			e.printStackTrace();
//			ResponseMessageUtils.responseMessage(response, "查询失败!");
//			return null;
//		}
//	}


	/**
	 * ------------------------------------------------------------------个人信息----------------------------------------------------------------------
	 * 获取单个用户基础信息
	 * 
	 * @param response
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/singleUBInfo")
	public UserInfo requireUserBaseInfo(HttpServletResponse response, HttpServletRequest request) {
		List<UserInfo> uList = new ArrayList<>();
		UserInfo userInfo = new UserInfo();
		Map<String, String> mapList = ToolClass.mapShiftStr(request);

		userInfo.setId(Integer.valueOf(mapList.get("userId")));
		uList = this.service.searchUBInfo(userInfo);

		// 通过账号Id找账号的名字和职位的名字
		if (uList.size() > 0) {
			System.out.println("requireUserBaseInfo---" + uList.size());
			userInfo = uList.get(0);
			return userInfo;
		} else {
			ResponseMessageUtils.responseMessage(response, "查询失败!");
			return null;
		}

	}

	/**
	 * 通过账户查找职位名称和ID
	 *
	 * @return
	 */
	public Account requireDepartName(Account accountId) {
		List<Account> aList = this.service.selectAccountList(accountId);
		Account account = aList.get(0);
		return account;
	}

	/**
	 * 获取单个用户详细信息
	 * 
	 * @param response
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/singleUDInfo")
	public List<UserInfo> requireUserDetailInfo(HttpServletResponse response, HttpServletRequest request) {
		List<UserInfo> uList = new ArrayList<>();
		UserInfo userInfo = new UserInfo();
		Map<String, String> mapList = ToolClass.mapShiftStr(request);

		userInfo.setuEmployeeBasicID(Integer.valueOf(mapList.get("userId")));
		System.out.println("---requireUserDetailInfo----" + userInfo.getuEmployeeBasicID());
		uList = this.service.searchUDInfo(userInfo);

		return uList;
	}
    /**
     * emp  详细信息
     *
     * @param response
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/detailInfo")
    public JSONObject detailInfo(HttpServletResponse response, HttpServletRequest request) {
        UserInfo uf = new UserInfo();
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str))
                throw new MessageException("参数接收失败！");
            uf = MapUtil.transJsonStrToObjectIgnoreCase(str, UserInfo.class);

            result.put("resData", this.service.searchUDInfo(uf)) ;
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
	 * 初始化当前账号密码
	 * @return
	 * @return 返回值类型  Integer
	 * @author 作者 mwl
	 * @date   时间 2019年6月17日下午4:04:28
	 */
	@SuppressWarnings("finally")
	@ResponseBody
	@RequestMapping(value = "/updataAccountPwd")
	public JSONObject updataAccountPwd(HttpServletResponse response, HttpServletRequest request) {
		
		Account pwd = new Account();
		JSONObject result = new JSONObject();
		String retCode = Constant.Result.SUCCESS;
		String retMsg = Constant.Result.SUCCESS_MSG;
		try {
			String str = ToolClass.getStrFromInputStream(request);
			if (StringUtils.isBlank(str))
				throw new MessageException("参数接收失败！");
			pwd = MapUtil.transJsonStrToObjectIgnoreCase(str, Account.class);
			pwd.setAccountPwd(MD5Util.MD5EncodeUtf8("123456"));
			
			result.put("resData", this.service.updataAccountPwd(pwd)) ;
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
	 * 转正日期
	 * @param response
	 * @param request
	 * @return
	 * @return 返回值类型  JSONObject
	 * @author 作者 mwl
	 * @date   时间 2019年6月18日下午1:30:10
	 */
	@SuppressWarnings("finally")
	@ResponseBody
	@RequestMapping(value = "/shiftPositiveDate")
	public JSONObject shiftPositiveDate(HttpServletResponse response, HttpServletRequest request) {
		
		UserInfo user = new UserInfo();
		JSONObject result = new JSONObject();
		String retCode = Constant.Result.SUCCESS;
		String retMsg = Constant.Result.SUCCESS_MSG;
		try {
			String str = ToolClass.getStrFromInputStream(request);
			if (StringUtils.isBlank(str))
				throw new MessageException("参数接收失败！");
			user = MapUtil.transJsonStrToObjectIgnoreCase(str, UserInfo.class);
			user.setPositiveDate(TimeUtil.YYYYMMDD_SHIFT_YYYYMMDDHHMMSSSSS(user.getPositiveDate()));
			
			result.put("resData", this.service.shiftPosition(user)) ;
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
	 * 辞职日期
	 * @param response
	 * @param request
	 * @return
	 * @return 返回值类型  JSONObject
	 * @author 作者 mwl
	 * @date   时间 2019年6月18日下午1:30:42
	 */
	@SuppressWarnings("finally")
	@ResponseBody
	@RequestMapping(value = "/employeeResginDate")
	public JSONObject employeeResginDate(HttpServletResponse response, HttpServletRequest request) {
		
		UserInfo user = new UserInfo();
		JSONObject result = new JSONObject();
		String retCode = Constant.Result.SUCCESS;
		String retMsg = Constant.Result.SUCCESS_MSG;
		try {
			String str = ToolClass.getStrFromInputStream(request);
			if (StringUtils.isBlank(str))
				throw new MessageException("参数接收失败！");
			user = MapUtil.transJsonStrToObjectIgnoreCase(str, UserInfo.class);
			user.setResignDate(TimeUtil.YYYYMMDD_SHIFT_YYYYMMDDHHMMSSSSS(user.getResignDate()));
			
			result.put("resData", this.service.employeeResgin(user)) ;
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
     * 删除员工
     * @param response
     * @param request
     * @return
     */
	@SuppressWarnings("finally")
	@ResponseBody
	@RequestMapping(value = "/deleteEmployee")
	public JSONObject deleteEmployee(HttpServletResponse response, HttpServletRequest request) {
		
		UserInfo user = new UserInfo();
		JSONObject result = new JSONObject();
		String retCode = Constant.Result.SUCCESS;
		String retMsg = Constant.Result.SUCCESS_MSG;
		try {
			String str = ToolClass.getStrFromInputStream(request);
			if (StringUtils.isBlank(str))
				throw new MessageException("参数接收失败！");
			user = MapUtil.transJsonStrToObjectIgnoreCase(str, UserInfo.class);
			
			
			result.put("resData", this.service.deleteEmployee(user));
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
	 * 个人的家庭成员信息
	 *
	 * @param response
	 * @param request
	 * @return
	 */
	@SuppressWarnings("finally")
	@ResponseBody
	@RequestMapping(value = "/singlefamilyList")
	public JSONObject singlefamilyList(HttpServletResponse response, HttpServletRequest request) {
		QueryFamilyResult qf = new QueryFamilyResult();
		
		JSONObject result = new JSONObject();
		String retCode = Constant.Result.SUCCESS;
		String retMsg = Constant.Result.SUCCESS_MSG;
		try {
			List<QueryFamilyResult> qfrList = new ArrayList<>();
			String str = ToolClass.getStrFromInputStream(request);
			if (StringUtils.isBlank(str))
				throw new MessageException("参数接收失败！");
			qf = MapUtil.transJsonStrToObjectIgnoreCase(str, QueryFamilyResult.class);

			result.put("resData", this.service.singleFamilyList(qf)) ;
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
     * 删除家庭信息
     * @param response
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deletFamilyInfo")
    public JSONObject deletFamilyInfo(HttpServletResponse response, HttpServletRequest request) {
        QueryFamilyResult qf = new QueryFamilyResult();

        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            List<QueryFamilyResult> qfrList = new ArrayList<>();
            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str))
                throw new MessageException("参数接收失败！");
            qf = MapUtil.transJsonStrToObjectIgnoreCase(str, QueryFamilyResult.class);

            result.put("resData", this.service.deletFamilyInfo(qf)) ;
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
	 * 更新用户基础信息+详细信息+家庭信息
	 *
	 * @param response
	 * @param request
	 * @return
	 */
	@SuppressWarnings("finally")
	@ResponseBody
	@RequestMapping(value = "/updateUserInfo")
	public JSONObject updateUserInfo(HttpServletResponse response, HttpServletRequest request) {
		
		UserInfo ui = new UserInfo();
		QueryFamilyResult qfr = new QueryFamilyResult();
		Map<String, String> resultMap = new HashMap<>(); 
		
		JSONObject result = new JSONObject();
		String retCode = Constant.Result.SUCCESS;
		String retMsg = Constant.Result.SUCCESS_MSG;
		resultMap.put("message", "更新成功");
		try {
			String string = StreamUtils.copyToString(request.getInputStream(), Charset.forName("UTF-8"));

			JSONObject jsonData = JSONObject.parseObject(string);
			JSONObject userBase,userDetail;
			JSONArray userFamily;
			
			
			
			System.out.println("updateUserInfo:"+jsonData);
			if (jsonData.containsKey("userBase")) {
				
				userBase = jsonData.getJSONObject("userBase");
				ui= MapUtil.transJsonToObjectIgnoreCase(userBase, UserInfo.class);
				Integer baseInfoInt = this.service.updataBaseInfo(ui);
				if (baseInfoInt==1) {
					resultMap.put("userBase", "1");
				}else {
					resultMap.put("message", "基础信息更新失败");
				}
				resultMap.put("userBase", String.valueOf(baseInfoInt));
			}
			if (jsonData.containsKey("userDetail")) {
				userDetail = jsonData.getJSONObject("userDetail");
				if (!userDetail.isEmpty()) {
					ui= MapUtil.transJsonToObjectIgnoreCase(userDetail, UserInfo.class);

					Integer detailInfoInt = this.service.updataDetialInfo(ui);
					if (detailInfoInt==1) {
                        resultMap.put("userDetail", "1");
                    }else if (detailInfoInt==0) {
                        this.service.insertUserDetailInfo(ui);
					    resultMap.put("userDetail", "1");
					}else {
						resultMap.put("message", "详细信息更新失败");
					}
				}
			}	
			

			if (jsonData.containsKey("userFamily")) {
				userFamily = jsonData.getJSONArray("userFamily");
				resultMap.put("add", "1");
				resultMap.put("modify", "1");
				for (int i = 0; i < userFamily.size(); i++) {
					JSONObject jsonObject = userFamily.getJSONObject(i);
					qfr= MapUtil.transJsonToObjectIgnoreCase(jsonObject, QueryFamilyResult.class);
					if (!StringUtils.isEmpty(qfr.getType()) && "add".equals(qfr.getType())) {
						Integer add = this.service.insertUserFmInfo(qfr);
						if (add==0) {
							resultMap.put("add", "0");
							resultMap.put("message", "家庭成员添加失败");
						}
					}
					if (!StringUtils.isEmpty(qfr.getType()) && "modify".equals(qfr.getType())) {
						Integer modify = this.service.updatafamilyInfo(qfr);
						if (modify==0) {
							resultMap.put("modify", "0");
							resultMap.put("message", "家庭成员修改失败");
						}
					}
				}
			}
			result.put("resData", resultMap);
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
	 *  插入用户信息
	 * @param response
	 * @param request
	 * @return
	 * @return 返回值类型  JSONObject
	 * @author 作者 mwl
	 * @date   时间 2019年6月7日上午9:00:04
	 */
	@SuppressWarnings("finally")
	@ResponseBody
	@RequestMapping(value = "/insertUserInfo")
	public JSONObject insertUserInfo(HttpServletResponse response, HttpServletRequest request) {
		
		UserInfo ui = new UserInfo();
		Integer uId = 0;
		Account account = new Account();
		String accountId = "0";
		QueryFamilyResult qfr = new QueryFamilyResult();
		Map<String, String> resultMap = new HashMap<>(); 
		
		JSONObject result = new JSONObject();
		String retCode = Constant.Result.SUCCESS;
		String retMsg = Constant.Result.SUCCESS_MSG;
		resultMap.put("message", "添加成功");
		try {
			String string = StreamUtils.copyToString(request.getInputStream(), Charset.forName("UTF-8"));

			JSONObject jsonData = JSONObject.parseObject(string);
			JSONObject userBase,userDetail;
			JSONArray userFamily;
			
			System.out.println("updateUserInfo:"+jsonData);
			if (!jsonData.isEmpty()) {
				if (jsonData.containsKey("userBase")) {
					userBase = jsonData.getJSONObject("userBase");
					if (!userBase.isEmpty()) {
						ui= MapUtil.transJsonToObjectIgnoreCase(userBase, UserInfo.class);
						
						
						UserInfo userInfo = new UserInfo();
						userInfo.setJobNum(ui.getName());
						List<UserInfo> uList = this.service.searchUBInfo(ui);
						if (uList.size() > 0) {
							resultMap.put("message", "姓名已存在");
							result.put("resData", resultMap);
							return result;
						}
						
						userInfo = new UserInfo();
						userInfo.setJobNum(ui.getJobNum());
						List<UserInfo> jList = this.service.searchUBInfo(userInfo);
						if (jList.size() > 0) {
							resultMap.put("message", "工号已存在");
							result.put("resData", resultMap);
							return result;
						}
						
						
						account.setAccountName(ui.getErpaaccount());
						List<Account> aList = this.service.selectAccountList(account);
						if (aList.size() > 0) {
							resultMap.put("message", "ERP账号已存在");
							result.put("resData", resultMap);
							return result;
						} else {
							account.setAccountName(ui.getErpaaccount());
							account.setAccountPwd("123456");
							account.setAccountState("在用");
							account.setPositionId(ui.getPositionId());
							Integer isSucess = this.service.insertAccountInfo(account);
							resultMap.put("account", String.valueOf(isSucess));
							if (isSucess == 1) {
								aList = this.service.selectAccountList(account);
								account = aList.get(0);
								ui.setAccountId(account.getAccountId());
								accountId = account.getAccountId();
							}
						}
						String newDate = ToolClass.strDateTimeStr(new Date());
						if (!StringUtils.isBlank(ui.getEntryDate())) {
							System.out.println("setEntryDte"+ui.getEntryDate());
							ui.setEntryDate(TimeUtil.YYYYMMDD_SHIFT_YYYYMMDDHHMMSSSSS(ui.getEntryDate()));
							System.out.println("setEntryDte"+ui.getEntryDate());
						}
						if (!StringUtils.isBlank(ui.getPositiveDate())) {
							ui.setPositiveDate(TimeUtil.YYYYMMDD_SHIFT_YYYYMMDDHHMMSSSSS(ui.getPositiveDate()));
						}
						if (!StringUtils.isBlank(ui.getResignDate())) {
							ui.setResignDate(TimeUtil.YYYYMMDD_SHIFT_YYYYMMDDHHMMSSSSS(ui.getResignDate()));
						}
						
						ui.setCreateDate(newDate);
						ui.setUpdateDate(newDate);
						ui.setuAtSchool("0");
						
						
						// 插入用户基本信息，在进行查询人员ID，在进行插入详细信息
						Integer baseInt = this.service.insertUserInfo(ui);
						if (baseInt==1) {
							resultMap.put("userDetail", String.valueOf(baseInt));
						}else {
							resultMap.put("message", "基础信息插入失败");
						}
						List<UserInfo> userlist = this.service.searchUBInfo(ui);
						uId = userlist.get(0).getId();
						
					}
				}
				
				if (jsonData.containsKey("userDetail")) {
					userDetail = jsonData.getJSONObject("userDetail");
					
					if (!userDetail.isEmpty()) {
						ui= MapUtil.transJsonToObjectIgnoreCase(userDetail, UserInfo.class);
						ui.setuEmployeeBasicID(uId);
						System.out.println("userDetail+uId:"+ui.getuEmployeeBasicID());
						if (uId != 0) {
							Integer detailInfoInt = this.service.insertUserDetailInfo(ui);
							if (detailInfoInt==1) {
								resultMap.put("userDetail", String.valueOf(detailInfoInt));
							}else {
								resultMap.put("message", "详细信息插入失败");
							}
							
						}
					}
				}	
				

				if (jsonData.containsKey("userFamily")) {
					System.out.println("userFamily-1:");
					userFamily = jsonData.getJSONArray("userFamily");
					resultMap.put("add", "1");
					resultMap.put("modify", "1");
					if (!accountId.equals("0")) {
						System.out.println("userFamily-2:");
						for (int i = 0; i < userFamily.size(); i++) {
							JSONObject jsonObject = userFamily.getJSONObject(i);
							qfr= MapUtil.transJsonToObjectIgnoreCase(jsonObject, QueryFamilyResult.class);
							qfr.setuAccountId(accountId);
							System.out.println("userFamily-3:");
							System.out.println("userFamily:"+qfr.toString());
							if (qfr.getType().equals("add")) {
								Integer add = this.service.insertUserFmInfo(qfr);
								if (add==0) {
									resultMap.put("add", "0");
									resultMap.put("message", "家庭信息添加失败");
								}
							}
							if (qfr.getType().equals("modify")) {
								Integer modify = this.service.updatafamilyInfo(qfr);
								if (modify==0) {
									resultMap.put("modify", "0");
								}
							}
						}
					}
				}
			}
			result.put("resData", resultMap);
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
	 * 插入用户基础信息
	 *
	 * @param response
	 * @param request
	 * @return
	 * 
	 * 		注：员工入职的姓名、性别、工号、ERP账号、部门是必填的 1、工号和ERP账号没有规则，只要不和数据库冲突就可以使用
	 *         2、通过ERP账号自动生成账号的相关信息，包括初始密码、id、状态
	 */
	@ResponseBody
	@RequestMapping(value = "/uBaseInfo")
	public Map<String, String> userBaseInfo(HttpServletResponse response, HttpServletRequest request) {

		UserInfo userInfo = new UserInfo();
		Account account = new Account();
		Map<String, String> resultM = new HashMap<>();

		String string;
		try {
			string = StreamUtils.copyToString(request.getInputStream(), Charset.forName("UTF-8"));

			JSONObject jsonData = JSONObject.parseObject(string);

			System.out.println("jsonData" + jsonData);

			userInfo.setName(jsonData.getString("Name"));
			List<UserInfo> uList = this.service.searchUBInfo(userInfo);

			if (uList.size() > 0) {
				resultM.put("0", "姓名已存在");
				return resultM;
			}

			userInfo = new UserInfo();
			userInfo.setJobNum(jsonData.getString("JobNum"));
			List<UserInfo> jList = this.service.searchUBInfo(userInfo);
			if (jList.size() > 0) {
				resultM.put("0", "工号已存在");
				return resultM;
			}

			account.setAccountName(jsonData.getString("Account_Name"));
			List<Account> aList = this.service.selectAccountList(account);
			if (aList.size() > 0) {
				resultM.put("0", "ERP账号已存在");
				return resultM;
			} else {
				account.setPositionId(jsonData.getString("PositionId"));
				Integer isSucess = this.service.insertAccountInfo(account);
				if (isSucess == 1) {
					aList = this.service.selectAccountList(account);
					account = aList.get(0);
					userInfo.setAccountId(account.getAccountId());
				}
			}

			

			// 提交家庭信息
			if (jsonData.containsKey("newFamilyNumList")) {
				JSONArray jArr = jsonData.getJSONArray("newFamilyNumList");
				for (int i = 0; i < jArr.size(); i++) {
					QueryFamilyResult qfr = new QueryFamilyResult();
					qfr.setuAccountId(userInfo.getAccountId());
					qfr.setAppellation(jArr.getJSONObject(i).getString("appellation"));
					qfr.setChname(jArr.getJSONObject(i).getString("chname"));
					qfr.setBirth(jArr.getJSONObject(i).getString("birth"));
					qfr.setWorkAddress(jArr.getJSONObject(i).getString("workadress"));
					qfr.setPosition(jArr.getJSONObject(i).getString("position"));
					qfr.setPhone(jArr.getJSONObject(i).getString("phone"));
					qfr.setWechat(jArr.getJSONObject(i).getString("wechat"));
					qfr.setFamAddress(jArr.getJSONObject(i).getString("famAddress"));
				}
			}

			String newDate = ToolClass.strDateTimeStr(new Date());
			userInfo.setCreateDate(newDate);
			userInfo.setUpdateDate(newDate);
			userInfo.setuAtSchool("0");

			// 插入用户基本信息，在进行查询人员ID，在进行插入详细信息
			this.service.insertUserInfo(userInfo);
			List<UserInfo> userlist = this.service.searchUBInfo(userInfo);
			Integer userId = userlist.get(0).getId();
			String uid = String.valueOf(userId);
			 System.out.println("---------人员ID-----------"+uid);

			// 设置上传时间、上传的人
			userInfo.setuEmployeeBasicID(Integer.valueOf(uid));

			this.service.insertUserDetailInfo(userInfo);
			resultM.put("0", "成员插入成功");
			return resultM;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultM.put("0", "数据插入失败");
			return resultM;
		}

	}

	/**
	 * 插入和更新家庭信息
	 *
	 * @param response
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/ufInfo")
	public String userFamilyDetailInfo(HttpServletResponse response, HttpServletRequest request) {
		boolean isBool;
		UserFamily ufInfo = new UserFamily();
		Map<String, String> mapList = ToolClass.mapShiftStr(request);

		// ufInfo.setAccountId(mapList.get("accountId"));
		// ufInfo.setAddress(mapList.get("address"));
		// ufInfo.setAppellation(mapList.get("appellation"));
		// ufInfo.setBirthtay(mapList.get("birthtay"));
		// ufInfo.setName(mapList.get("name"));
		// ufInfo.setPhone(mapList.get("phone"));
		// ufInfo.setPosition(mapList.get("position"));
		// ufInfo.setWechat(mapList.get("wechat"));
		// ufInfo.setWorkAddress(mapList.get("workAddress"));
		try {
			// isBool = this.service.insertUserFmInfo(ufInfo);
			// System.out.println("家庭人员列表" + isBool);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			ResponseMessageUtils.responseMessage(response, "插入失败!");
			return null;
		}
	}

	/**
	 * 查询用户的职位的调动信息
	 * 
	 * @param response
	 * @param request
	 * @return
	 */
	@SuppressWarnings("finally")
	@ResponseBody
	@RequestMapping(value = "/positionShifts")
	public JSONObject positionShifts(HttpServletResponse response, HttpServletRequest request) {
		PositionShift pShift = new PositionShift();
		
		JSONObject result = new JSONObject();
		String retCode = Constant.Result.SUCCESS;
		String retMsg = Constant.Result.SUCCESS_MSG;
		try {
			List<PositionShift> psList = this.service.selectShiftInfo(pShift);
			String str = ToolClass.getStrFromInputStream(request);
			if (StringUtils.isBlank(str))
				throw new MessageException("参数接收失败！");
			pShift = MapUtil.transJsonStrToObjectIgnoreCase(str, PositionShift.class);

			result.put("resData", this.service.selectShiftInfo(pShift)) ;
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
     * 调动信息 插入
     *
     * @param response
     * @param request
     * @return
     */
    @SuppressWarnings("finally")
    @ResponseBody
    @RequestMapping(value = "/insertShiftInfo")
    public JSONObject insertShiftInfo(HttpServletResponse response, HttpServletRequest request) {
        PositionShift pShift = new PositionShift();

        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str))
                throw new MessageException("参数接收失败！");
            pShift = MapUtil.transJsonStrToObjectIgnoreCase(str, PositionShift.class);

            result.put("resData", this.service.insertShiftInfo(pShift));
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
	 * 添加离职原因
	 * 
	 * @param response
	 * @param request
	 * @return
	 * @return 返回值类型 JSONObject
	 * @author 作者 mwl
	 * @date 时间 2019年5月9日上午11:57:39
	 */
	@SuppressWarnings("finally")
	@ResponseBody
	@RequestMapping(value = "/addLeaveReason")
	public JSONObject addLeaveReason(HttpServletResponse response, HttpServletRequest request) {
		LeaveResign lr = new LeaveResign();

		JSONObject result = new JSONObject();
		String retCode = Constant.Result.SUCCESS;
		String retMsg = Constant.Result.SUCCESS_MSG;
		try {
			String str = ToolClass.getStrFromInputStream(request);
			if (StringUtils.isBlank(str))
				throw new MessageException("参数接收失败！");
			lr = MapUtil.transJsonStrToObjectIgnoreCase(str, LeaveResign.class);
			if (StringUtils.isBlank(lr.getReasonName()))
				throw new MessageException("离职ID为空或离职原因为空！");
			List<LeaveResign> lrList = this.service.initLeaveList(lr);
			if (lrList.size() > 0) {
				retMsg = "离职原因已存在";
			} else {
				this.service.addLeaveReason(lr);
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

	/**
	 * 修改离职原因
	 * 
	 * @param response
	 * @param request
	 * @return
	 * @return 返回值类型 List<LeaveResign>
	 * @author 作者 mwl
	 * @date 时间 2019年5月9日上午8:05:31
	 */
	@SuppressWarnings("finally")
	@ResponseBody
	@RequestMapping(value = "/updateLeaveReason")
	public JSONObject updateLeaveReason(HttpServletResponse response, HttpServletRequest request) {
		LeaveResign lr = new LeaveResign();

		JSONObject result = new JSONObject();
		String retCode = Constant.Result.SUCCESS;
		String retMsg = Constant.Result.SUCCESS_MSG;
		try {
			String str = ToolClass.getStrFromInputStream(request);
			if (StringUtils.isBlank(str))
				throw new MessageException("参数接收失败！");
			lr = MapUtil.transJsonStrToObjectIgnoreCase(str, LeaveResign.class);
			if (StringUtils.isBlank(lr.getReasonId()) || StringUtils.isBlank(lr.getReasonName()))
				throw new MessageException("离职ID为空或离职原因为空！");
			this.service.updateLeaveReason(lr);
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
	 * 删除离职原因
	 * 
	 * @param response
	 * @param request
	 * @return
	 * @return 返回值类型 JSONObject
	 * @author 作者 mwl
	 * @date 时间 2019年5月9日上午10:47:39
	 */
	@SuppressWarnings("finally")
	@ResponseBody
	@RequestMapping(value = "/deleteLeaveReason")
	public JSONObject deleteLeaveReason(HttpServletResponse response, HttpServletRequest request) {
		LeaveResign lr = new LeaveResign();

		JSONObject result = new JSONObject();
		String retCode = Constant.Result.SUCCESS;
		String retMsg = Constant.Result.SUCCESS_MSG;
		try {
			String str = ToolClass.getStrFromInputStream(request);
			if (StringUtils.isBlank(str))
				throw new MessageException("参数接收失败！");
			lr = MapUtil.transJsonStrToObjectIgnoreCase(str, LeaveResign.class);
			if (StringUtils.isBlank(lr.getReasonId()))
				throw new MessageException("离职ID为空");
			this.service.deleteLeaveReason(lr);
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
	 * 测试
	 *
	 * @return
	 */
	@RequestMapping(value = "/export")
	@ResponseBody
	public void exportExcel(String index, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("您来了" + index);
		// 设置响应正文的MIME类型，该类型表示Excel
		request.setCharacterEncoding("gbk");
		response.setContentType("application/vnd.ms-excel");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String sex = request.getParameter("sex");
		System.out.println(sex);
		String age = request.getParameter("age");
		String email = request.getParameter("email");

		ServletOutputStream out = response.getOutputStream(); // 响应输出流对象
		HSSFWorkbook wb = new HSSFWorkbook(); // 创建Excel表格
		HSSFSheet sheet = wb.createSheet("用户注册信息"); // 创建工作薄
		sheet.setColumnWidth(4, 5000); // 设置列宽

		HSSFRow titleRow = sheet.createRow(0); // 创建Excel中的标题栏,第1行

		HSSFCell titleCell1 = titleRow.createCell(0); // 在行中创建第1个单元格
		titleCell1.setCellValue("用户姓名"); // 设置第1个单元格的值
		HSSFCell titleCell2 = titleRow.createCell(1); // 在行中创建第2个单元格
		titleCell2.setCellValue("密码"); // 设置第2个单元格的值
		HSSFCell titleCell3 = titleRow.createCell(2); // 在行中创建第3个单元格
		titleCell3.setCellValue("性别"); // 设置第3个单元格的值
		HSSFCell titleCell4 = titleRow.createCell(3); // 在行中创建第4个单元格
		titleCell4.setCellValue("年龄"); // 设置第4个单元格的值
		HSSFCell titleCell5 = titleRow.createCell(4); // 在行中创建第5个单元格
		titleCell5.setCellValue("Email"); // 设置第5个单元格的值

		HSSFRow valueRow = sheet.createRow(1); // 创建第2行

		HSSFCell nameCell = valueRow.createCell(0); // 在第2行中创建单元格
		nameCell.setCellValue(name);
		HSSFCell pwdCell = valueRow.createCell(1);
		pwdCell.setCellValue(pwd);
		HSSFCell sexCell = valueRow.createCell(2);
		sexCell.setCellValue(sex);
		HSSFCell ageCell = valueRow.createCell(3);
		ageCell.setCellValue(age);
		HSSFCell emailCell = valueRow.createCell(4);
		emailCell.setCellValue(email);

		HSSFCellStyle cellStyle = wb.createCellStyle();
		wb.write(out); // 将响应流输入到Excel表格中
		out.flush();
	}
}

