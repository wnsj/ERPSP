package com.jiubo.erp.wzbg.vo;

import lombok.Data;

/**
 * @version: V1.0
 * @author: DingDong
 * @className: CheckInfo
 * @description: 审查人信息
 * @data: 2019-07-24
 **/
@Data
public class CheckInfo {
	private String accountId;
	private String accountName;
	private String deptId;
	private String positionId;
	private String[] typeIds;
	private String[] deptIds;
}
