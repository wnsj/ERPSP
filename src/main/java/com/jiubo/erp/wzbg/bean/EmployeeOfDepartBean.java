package com.jiubo.erp.wzbg.bean;

public class EmployeeOfDepartBean {
	
	private String departId;
	private String departName;
	private String employeeId;
	private String employeeName;
	private String positionId;
	private String positionName;
	
	public EmployeeOfDepartBean() {
		// TODO Auto-generated constructor stub
	}

	public String getDepartId() {
		return departId;
	}

	public String getPositionId() {
		return positionId;
	}

	public void setPositionId(String positionId) {
		this.positionId = positionId;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
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

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	@Override
	public String toString() {
		return "EmpolyeeOfDepartBean [departId=" + departId + ", departName=" + departName + ", employeeId="
				+ employeeId + ", employeeName=" + employeeName + "]";
	}
	
	
}
