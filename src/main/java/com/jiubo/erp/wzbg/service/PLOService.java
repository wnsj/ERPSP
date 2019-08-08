package com.jiubo.erp.wzbg.service;


import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface PLOService {
	
	//请假列表
	public JSONObject askOfLeaveList(HttpServletResponse response, HttpServletRequest request);
	
	public JSONObject selectDepartOfEmpList(HttpServletResponse response, HttpServletRequest request);
	
	//请假申请
	public JSONObject insertLeaveApplication(HttpServletResponse response, HttpServletRequest request);
	
	//请假修改
	public JSONObject updateLeaveApplication(HttpServletResponse response, HttpServletRequest request);
	
	public JSONObject checkOfEmpList(HttpServletResponse response, HttpServletRequest request);
	
	
	//倒休
	public JSONObject restDownList(HttpServletResponse response, HttpServletRequest request);
	
	
	//倒休申请
	public JSONObject restDownApply(HttpServletResponse response, HttpServletRequest request);
	
	//倒休修改
	public JSONObject restDownModify(HttpServletResponse response, HttpServletRequest request);

	// 人员需求列表
	public JSONObject selectEmpRequireLsit(HttpServletResponse response, HttpServletRequest request);

	//人员需求申请
	public JSONObject insertEmpRequireApply(HttpServletResponse response, HttpServletRequest request);

	// 修改需求列表
	public JSONObject updateRYRequire(HttpServletResponse response, HttpServletRequest request);

	// 工作年限
	public JSONObject selectWorkAge(HttpServletResponse response, HttpServletRequest request);

	// 专业
	public JSONObject selectMajor(HttpServletResponse response, HttpServletRequest request);

	// 跳槽频率
	public JSONObject selectJobHopFrequency(HttpServletResponse response, HttpServletRequest request);

	// 行业
	public JSONObject selectIndustryBackground(HttpServletResponse response, HttpServletRequest request);

	// 年龄段列表
	public JSONObject selectAgeLsit(HttpServletResponse response, HttpServletRequest request);

	//审查人
	public JSONObject empRequireCheckList(HttpServletResponse response, HttpServletRequest request);

	//审批人
	public JSONObject empRequireApprolList(HttpServletResponse response, HttpServletRequest request);
}
