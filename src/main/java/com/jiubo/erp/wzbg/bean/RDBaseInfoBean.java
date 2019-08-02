package com.jiubo.erp.wzbg.bean;   
/** 
 * 倒休的申请中基本信息的不同列表，
 * 都是用ID和Name 统一用这个Bean
 * @author :mwl
 * @version:    1.0   
 * @since:  JDK 1.8 
 * Create at:   2019年7月27日 下午4:42:12   
 */
public class RDBaseInfoBean {
	private static final long serialVersionUID = -1632154974077532588L;
	private String id;
	private String name;
	
	public RDBaseInfoBean() {
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public String toString() {
		return "RDBaseInfoBean [id=" + id + ", name=" + name + "]";
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
  
