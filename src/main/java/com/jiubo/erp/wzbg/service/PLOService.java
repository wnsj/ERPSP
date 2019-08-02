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
}
