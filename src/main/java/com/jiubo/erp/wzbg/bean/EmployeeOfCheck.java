package com.jiubo.erp.wzbg.bean;   
/** 
 * @author :mwl
 * @version:    1.0   
 * @since:  JDK 1.8 
 * Create at:   2019年7月8日 上午10:29:54   
 */
public class EmployeeOfCheck {
	
	private String accountId;
	private String accountName;
	
	public EmployeeOfCheck() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "EmployeeOfCheck [accountId=" + accountId + ", accountName=" + accountName + "]";
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	
	
}
  
