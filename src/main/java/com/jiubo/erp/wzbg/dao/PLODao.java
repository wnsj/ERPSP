package com.jiubo.erp.wzbg.dao;

import com.jiubo.erp.wzbg.bean.*;
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
	
	//请假 --- 审查列表
	public List<EmployeeOfCheck>checkOfEmpList(PLOParam ploParam);

	//请假 --- 审核列表
	public List<EmployeeOfCheck>verifyOfEmpList(PLOParam ploParam);

	//请假 --- 审批列表
	public List<EmployeeOfCheck>approveOfEmpList(PLOParam ploParam);
	
	//倒休列表
	public List<RestDownBean> selectRestDownList(PLOParam ploParam);
	
	//倒休申请
	public int insertRestDownApplication(RestDownBean rdb);
	
	//倒休修改
	public int updateRestDownApplication(RestDownBean rdb);
	


	//人员需求列表
	public List<EmpRequireBean> selectEmpRequireLsit(PLOParam ploParam);

	//人员需求申请
	public int insertEmpRequireApply(EmpRequireBean erb);

	//修改需求申请
	public int updateRYRequire(EmpRequireBean erb);

	//工作年限
	public List<RDBaseInfoBean> selectWorkAge();

	//专业
	public List<RDBaseInfoBean> selectMajor();

	//跳槽频率
	public List<RDBaseInfoBean> selectJobHopFrequency();

	//行业
	public List<RDBaseInfoBean> selectIndustryBackground();

	//年龄段列表
	public List<RDBaseInfoBean> selectAgeLsit();

	//查看岗位类型
	public int selectPositionType(@Param(value="positionId") String positionId);

	//人员需求---审查人
	public List<EmployeeOfCheck>checkEMPRequire(PLOParam ploParam);

    //人员需求---审核人
    public List<EmployeeOfCheck>verifyEMPRequire(PLOParam ploParam);

    //人员需求---审批人
    public List<EmployeeOfCheck>approvalEMPRequire(PLOParam ploParam);


}





