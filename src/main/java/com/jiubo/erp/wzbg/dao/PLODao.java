package com.jiubo.erp.wzbg.dao;

import com.jiubo.erp.wzbg.bean.AskForLeaveBean;
import com.jiubo.erp.wzbg.bean.EmployeeOfCheck;
import com.jiubo.erp.wzbg.bean.EmployeeOfDepartBean;
import com.jiubo.erp.wzbg.bean.RestDownBean;
import com.jiubo.erp.wzbg.vo.PLOParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PLODao {

	//请假列表
	public List<AskForLeaveBean> selectAskForLeaveList(PLOParam ploParam);
	
	//请假--当前部门下的人员列表
	public List<EmployeeOfDepartBean> selectDepartOfEmpList(PLOParam ploParam);
	
	//申请请假
	public int insertLeaveApplication(AskForLeaveBean afl);
	
	//请假修改
	public int updateLeaveApplication(AskForLeaveBean afl);
	
	//请假 --- 人员级别查看审查列表
	public List<EmployeeOfCheck>checkOfEmpList(@Param(value = "level") String level, @Param(value = "positionId") String positionId
			, @Param(value = "departId") String departId, @Param(value = "clickTimes") String clickTimes);
	
	//倒休列表
	public List<RestDownBean> selectRestDownList(PLOParam ploParam);
	
	//倒休申请
	public int insertRestDownApplication(RestDownBean rdb);
	
	//倒休修改
	public int updateRestDownApplication(RestDownBean rdb);
	
	//人员需求列表
	public int selectEmpRequireLsit(RestDownBean rdb);
	
	
	public List<RestDownBean> selectApplyReason(RestDownBean rdb);
	public List<RestDownBean> selectWorkAge();
	public List<RestDownBean> selectMajor();
	public List<RestDownBean> selectJobHopFrequency();
	public List<RestDownBean> selectIndustryBackground();
	public List<RestDownBean> selectAgeLsit();
	public List<RestDownBean> selectEducationList();
	
	
}





