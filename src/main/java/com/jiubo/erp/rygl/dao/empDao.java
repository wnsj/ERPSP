package com.jiubo.erp.rygl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

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

public interface empDao {
	
	List<Account> selectAccountList(Account account);
	
	Integer updataAccountPwd(Account accountPwd);
	
	List<QueryResult> searchEmplist(QueryParam param);
	
	List<LeaveResign> selectLeaveList(LeaveResign lr);
	
	List<QueryFamilyResult> searchFamilyList(QueryFamilyResult param);

	List<ProjectDataBean> selectProjectList();
	
	List<Position> selectPositionList();
	
	List<Nation> selectNationList();
	
	List<DepartmentBean> selectDepartList(DepartmentBean dbp);//查询用户部门ID
	
	List<UserInfo> searchUBInfo(UserInfo userInfo);
	
	List<QueryFamilyResult> singleFamilyList(QueryFamilyResult qfr);
	
	List<UserInfo> searchUDInfo(UserInfo userInfo);
	
	Integer insertBaseInfo(UserInfo userInfo);
	
	Integer insertAccountInfo(Account account);
	
	Integer updataBaseInfo(UserInfo userInfo);
	
	Integer shiftPosition(UserInfo userInfo);
	Integer employeeResgin(UserInfo userInfo);
	Integer deleteEmployee(UserInfo userInfo);
	
	
	Integer insertDetailInfo(UserInfo userInfo);
	
	Integer updataDetialInfo(UserInfo userInfo);
	
	Integer insertfamilyInfo(QueryFamilyResult qfr);
	
	Integer updatafamilyInfo(QueryFamilyResult qfr);
	
	List<PositionShift> selectShiftInfo(PositionShift pShift);

	
	Integer updateLeaveReason(LeaveResign lResign);
	
	Integer deleteLeaveReason(LeaveResign lResign);
	
	Integer addLeaveReason(LeaveResign lResign);

}
