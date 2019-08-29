package com.jiubo.erp.wzbg.vo;

public class PLOParam {
	
	private String accountId;
	private String departId;
	private String positionId;
	private String positionTypeId;
	private String clickTimes;//点击次数
	private String departName;
	private String beginDate;
	private String endDate;
	private String dayNum;//天数
	private String name;
	private String handleState;//处理状态
	private String restReason;//倒休原因
	private String conferenceRoom;// 会议室

	
	
	

	public PLOParam() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "PLOParam{" +
				"accountId='" + accountId + '\'' +
				", departId='" + departId + '\'' +
				", positionId='" + positionId + '\'' +
				", positionTypeId='" + positionTypeId + '\'' +
				", clickTimes='" + clickTimes + '\'' +
				", departName='" + departName + '\'' +
				", beginDate='" + beginDate + '\'' +
				", endDate='" + endDate + '\'' +
				", dayNum='" + dayNum + '\'' +
				", name='" + name + '\'' +
				", handleState='" + handleState + '\'' +
				", restReason='" + restReason + '\'' +
				", conferenceRoom='" + conferenceRoom + '\'' +
				'}';
	}

	public String getDayNum() {
		return dayNum;
	}

	public void setDayNum(String dayNum) {
		this.dayNum = dayNum;
	}

	public String getPositionTypeId() {
		return positionTypeId;
	}

	public void setPositionTypeId(String positionTypeId) {
		this.positionTypeId = positionTypeId;
	}

	public String getPositionId() {
		return positionId;
	}

	public void setPositionId(String positionId) {
		this.positionId = positionId;
	}

	public String getClickTimes() {
		return clickTimes;
	}

	public void setClickTimes(String clickTimes) {
		this.clickTimes = clickTimes;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getDepartId() {
		return departId;
	}

	public void setDepartId(String departId) {
		this.departId = departId;
	}

	public String getDepartName() {
		return departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHandleState() {
		return handleState;
	}

	public void setHandleState(String handleState) {
		this.handleState = handleState;
	}

	public String getRestReason() {
		return restReason;
	}

	public void setRestReason(String restReason) {
		this.restReason = restReason;
	}

	public String getConferenceRoom() {
		return conferenceRoom;
	}

	public void setConferenceRoom(String conferenceRoom) {
		this.conferenceRoom = conferenceRoom;
	}
	
	
	
}
