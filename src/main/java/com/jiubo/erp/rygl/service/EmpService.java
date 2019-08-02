package com.jiubo.erp.rygl.service;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.jiubo.erp.common.Position;
import com.jiubo.erp.rygl.bean.DepartmentBean;
import com.jiubo.erp.rygl.bean.EmployeeBasicBean;
import com.jiubo.erp.rygl.bean.ProjectDataBean;
import com.jiubo.erp.rygl.vo.Account;
import com.jiubo.erp.rygl.vo.LeaveResign;
import com.jiubo.erp.rygl.vo.Nation;
import com.jiubo.erp.rygl.vo.PositionShift;
import com.jiubo.erp.rygl.vo.QueryFamilyResult;
import com.jiubo.erp.rygl.vo.QueryParam;
import com.jiubo.erp.rygl.vo.QueryResult;
import com.jiubo.erp.rygl.vo.UserInfo;

public interface EmpService {
	
	//初始化人员列表
	List<QueryResult> initEmpList(QueryParam param, HttpServletRequest request) throws Exception;
	
	//家庭成员列表初始化
	List<QueryFamilyResult> initFamilList(QueryFamilyResult param)throws Exception;
	
	//初始化部门列表
	List<DepartmentBean> initDepartList(DepartmentBean dbp);
	
	//初始化项目列表
	List<ProjectDataBean> initProjectList(HttpServletRequest request);
	
	//初始化职位列表
	public List<Position> initPositionList();
	
	//初始化民族列比
	public List<Nation>	initNationList();
	
	//初始化离职原因列表
	public List<LeaveResign> initLeaveList(LeaveResign lr);
	
	//根据部门名称查询部门
	public List<DepartmentBean> selectUserDepId(DepartmentBean depName);
	
	//模糊查询家庭列表
	public List<QueryFamilyResult> familyfuzzyQuery(QueryFamilyResult param) throws Exception;
	
	//查询账户信息
	public List<Account> selectAccountList(Account account);
	
	//插入员工的账户信息
	public Integer insertAccountInfo(Account account);
	
	//修改 员工的账户密码
	Integer updataAccountPwd(Account accountPwd);
	
	//单个员工基础信息
	public List<UserInfo> searchUBInfo(UserInfo userInfo);
	//单个员工详细信息
	public List<UserInfo> searchUDInfo(UserInfo userInfo);
	//查询个人家庭成员列表
	public List<QueryFamilyResult>singleFamilyList(QueryFamilyResult qfr);
	
	
	//插入员工信息
	public Integer insertUserInfo(UserInfo userInfo);
	
	//更新基础用户信息
	public Integer updataBaseInfo(UserInfo userInfo);
	
	
	//插入用户的详细信息
	public Integer insertUserDetailInfo(UserInfo userInfo);
	
	//更新用户的详细信息
	Integer updataDetialInfo(UserInfo userInfo);
	
	// 人员   转正日期
	Integer shiftPosition(UserInfo userInfo);
	
	// 人员   离职日期
	Integer employeeResgin(UserInfo userInfo);
	
	// 人员   删除状态
	Integer deleteEmployee(UserInfo userInfo);
	
	//插入家庭信息
	public Integer insertUserFmInfo(QueryFamilyResult qfr);
	
	//更新家庭信息
	public Integer updatafamilyInfo(QueryFamilyResult qfr);
	
	
	//查询调动信息
	public List<PositionShift> selectShiftInfo(PositionShift pShift);
	
	//更新离职原因
	Integer updateLeaveReason(LeaveResign lResign);
	
	//删除离职原因
	Integer deleteLeaveReason(LeaveResign lResign);
	
	//添加离职原因
	Integer addLeaveReason(LeaveResign lResign);

}
