package com.jiubo.erp.wzbg.dao;

import com.jiubo.erp.wzbg.bean.ComputerBean;
import com.jiubo.erp.wzbg.vo.LeaderInfo;
import com.jiubo.erp.wzbg.vo.PositionInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @version: V1.0
 * @author: DingDong
 * @className: ComputerDao
 * @description: 电脑数据访问层
 * @data: 2019-07-30
 **/
public interface ComputerDao {
	
	// 查询电脑预申请
	public List<ComputerBean> queryPreApplication(ComputerBean computerBean);
	// 添加电脑预申请
	public void addPreApplication(ComputerBean computerBean);
	// 查询所有岗位信息
	public List<PositionInfo> queryPositionInfo();
	// 根据部门查询主管信息
	public List<LeaderInfo> queryLeaderInfo(@Param("deptId") String deptId);
}
