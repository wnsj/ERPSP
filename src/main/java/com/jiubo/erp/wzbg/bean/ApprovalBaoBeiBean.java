package com.jiubo.erp.wzbg.bean;

/**
 * @version: V1.0
 * @author: DingDong
 * @className: ApprovalBaoBeiBean
 * @description: 报备审批权限POJO
 * @data: 2019-07-02
 **/
public class ApprovalBaoBeiBean {
	private String id;
	private String leavePositionID;
	private String checkPositionID;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLeavePositionID() {
		return leavePositionID;
	}
	public void setLeavePositionID(String leavePositionID) {
		this.leavePositionID = leavePositionID;
	}
	public String getCheckPositionID() {
		return checkPositionID;
	}
	public void setCheckPositionID(String checkPositionID) {
		this.checkPositionID = checkPositionID;
	}
	
}
