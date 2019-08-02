package com.jiubo.erp.wzbg.service;

import com.jiubo.erp.common.MessageException;
import com.jiubo.erp.wzbg.bean.ComputerBean;
import com.jiubo.erp.wzbg.vo.LeaderInfo;
import com.jiubo.erp.wzbg.vo.PositionInfo;

import java.util.List;

/**
 * @version: V1.0
 * @author: DingDong
 * @className: ComputerService
 * @description: 电脑业务层
 * @data: 2019-07-30
 **/
public interface ComputerService   {
	
	/**
	 * @Description: 查询电脑预申请
	 * @param  computerBean
	 * @return List<ComputerBean>
	 * @author: DingDong
	 * @date: 2019年7月30日
	 * @version: V1.0
	 */
	public List<ComputerBean> queryPreApplication(ComputerBean computerBean) throws MessageException;
	
	/**
	 * @Description: 添加电脑预申请
	 * @param  computerBean
	 * @return 
	 * @author: DingDong
	 * @date: 2019年7月31日
	 * @version: V1.0
	 */
	public void addPreApplication(ComputerBean computerBean) throws MessageException;
	
	/**
	 * @Description: 查询岗位信息
	 * @param  
	 * @return List<PositionInfo>
	 * @author: DingDong
	 * @date: 2019年7月31日
	 * @version: V1.0
	 */
	public List<PositionInfo> queryPositionInfo() throws MessageException;
	
	/**
	 * @Description: 查询所在部门的主管信息
	 * @param  deptId
	 * @return List<LeaderInfo>
	 * @author: DingDong
	 * @date: 2019年8月1日
	 * @version: V1.0
	 */
	public List<LeaderInfo> queryLeaderInfo(String deptId) throws MessageException;
}
