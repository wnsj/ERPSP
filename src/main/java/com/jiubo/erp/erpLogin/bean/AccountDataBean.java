package com.jiubo.erp.erpLogin.bean;


//登录账号
public class AccountDataBean {
    private String Account_ID;//账号编号
    private String Account_Name;//账号名称
    private String Account_Pwd;//密码
    private String Account_State;//账号状态
    private String Position_ID;//职位
    private String Account_Mac;//绑定机器mac
    
    //添加部门和岗位
    private String departId;
    private String departName;
    private String positionName;
    private String positionTypeId;


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

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public String getAccount_ID() {
        return Account_ID;
    }

    public void setAccount_ID(String account_ID) {
        Account_ID = account_ID;
    }

    public String getAccount_Name() {
        return Account_Name;
    }

    public void setAccount_Name(String account_Name) {
        Account_Name = account_Name;
    }

    public String getAccount_Pwd() {
        return Account_Pwd;
    }

    public void setAccount_Pwd(String account_Pwd) {
        Account_Pwd = account_Pwd;
    }

    public String getAccount_State() {
        return Account_State;
    }

    public void setAccount_State(String account_State) {
        Account_State = account_State;
    }

    public String getPosition_ID() {
        return Position_ID;
    }

    public void setPosition_ID(String position_ID) {
        Position_ID = position_ID;
    }

    public String getAccount_Mac() {
        return Account_Mac;
    }

    public void setAccount_Mac(String account_Mac) {
        Account_Mac = account_Mac;
    }

    public String getPositionTypeId() {
        return positionTypeId;
    }

    public void setPositionTypeId(String positionTypeId) {
        this.positionTypeId = positionTypeId;
    }
}
