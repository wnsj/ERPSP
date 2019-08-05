package com.jiubo.erp.wzbg.service.impl;

import com.jiubo.erp.common.MessageException;
import com.jiubo.erp.wzbg.bean.ComputerBean;
import com.jiubo.erp.wzbg.dao.ComputerDao;
import com.jiubo.erp.wzbg.service.ComputerService;
import com.jiubo.erp.wzbg.vo.HandInfo;
import com.jiubo.erp.wzbg.vo.LeaderInfo;
import com.jiubo.erp.wzbg.vo.PositionInfo;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @version: V1.0
 * @author: DingDong
 * @className: ComputerServiceImpl
 * @description: 电脑业务实现层
 * @data: 2019-07-30
 **/
@Service
@Transactional
public class ComputerServiceImpl implements ComputerService {
	
	private final static Logger logger  = LoggerFactory.getLogger(ComputerServiceImpl.class);
	
	@Autowired
	private ComputerDao computerDao;
	
	/**
	 * @Description: 查询电脑预申请
	 * @param  computerBean
	 * @return List<ComputerBean>
	 * @author: DingDong
	 * @date: 2019年7月30日
	 * @version: V1.0
	 */
	@Override
	public List<ComputerBean> queryPreApplication(ComputerBean computerBean) throws MessageException {
		List<ComputerBean> list;
		logger.info("----------开始查询电脑预申请,方法:queryPreApplication----------");
		try {
			list = computerDao.queryPreApplication(computerBean);
			
		} catch (Exception e) {
			throw new MessageException(e.getMessage());
		}
		return list;
	}
	
	/**
	 * @Description: 添加电脑预申请
	 * @param  computerBean
	 * @return 
	 * @author: DingDong
	 * @date: 2019年7月31日
	 * @version: V1.0
	 */
	@Override
	public void addPreApplication(ComputerBean computerBean) throws MessageException {
		logger.info("----------开始添加电脑预申请,方法:addPreApplication----------");
		try {
			//	主管
			computerBean.setLeaderId("0");
			computerBean.setLeaderAudit("5");
			computerBean.setLeaderIsSee("0");
			//	负责人
			computerBean.setPrincipalId("666");
			computerBean.setPrincipalAudit("0");
			computerBean.setPrincipalIsSee("0");
			// 交接人
			computerBean.setHandIsSee("0");
			// 申请人
			computerBean.setApplyIsSee("1");
			// 申请类型
			computerBean.setIsReserve("1");
			computerBean.setTypeId("0");
			computerBean.setTypeName("领用电脑: 电脑");
			computerDao.addPreApplication(computerBean);
		} catch (Exception e) {
			throw new MessageException(e.getMessage());
		}
	}

	/**
	 * @Description: 修改电脑预申请
	 * @param  computerBean
	 * @return
	 * @author: DingDong
	 * @date: 2019年7月31日
	 * @version: V1.0
	 */
	@Override
	public void updatePreApplication(ComputerBean computerBean) throws MessageException {
		logger.info("----------开始修改电脑预申请,方法:updatePreApplication----------");
		try {
			computerBean.setHandId(" ");
			computerBean.setHandName(" ");
			computerBean.setPrincipalIsSee("0");
			computerBean.setPrincipalAudit("0");
			computerBean.setIsConfig(" ");
			computerDao.updatePreApplication(computerBean);
		} catch (Exception e) {
			throw new MessageException(e.getMessage());
		}
	}

	/**
	 * @Description: 查询岗位信息
	 * @param  
	 * @return 
	 * @author: DingDong
	 * @date: 2019年7月31日
	 * @version: V1.0
	 */
	@Override
	public List<PositionInfo> queryPositionInfo() throws MessageException {
		logger.info("----------开始查询岗位信息,方法:queryPositionInfo----------");
		List<PositionInfo> list;
		try {
			list = computerDao.queryPositionInfo();
		} catch (Exception e) {
			throw new MessageException(e.getMessage());
		}
		return list;
	}
	
	/**
	 * @Description: 查询所在部门的主管信息
	 * @param  deptId
	 * @return List<LeaderInfo>
	 * @author: DingDong
	 * @date: 2019年8月1日
	 * @version: V1.0
	 */
	@Override
	public List<LeaderInfo> queryLeaderInfo(String deptId) throws MessageException {
		logger.info("----------开始查询所在部门的主管信息,方法:queryLeaderInfo----------");
		List<LeaderInfo> list;
		try {
			list = computerDao.queryLeaderInfo(deptId);
		} catch (Exception e) {
			throw new MessageException(e.getMessage());
		}
		return list;
	}

	/**
	 * @Description: 查询对接人信息
	 * @param
	 * @return List<HandInfo>
	 * @author: DingDong
	 * @date: 2019年8月5日
	 * @version: V1.0
	 */
	@Override
	public List<HandInfo> queryHandInfo() throws MessageException {
		logger.info("----------开始查询对接人信息,方法:queryHandInfo----------");
		List<HandInfo> list;
		try {
			list = computerDao.queryHandInfo();
		} catch (Exception e) {
			throw new MessageException(e.getMessage());
		}
		return list;
	}

	@Override
	public void checkPreApp(ComputerBean computerBean) throws MessageException {
		logger.info("----------开始审批,方法:check----------");
		try {
			//	负责人
			computerBean.setPrincipalIsSee("1");
			if(StringUtils.isNotEmpty(computerBean.getHandId())){
				computerBean.setIsConfig("1");
			}
			computerDao.updatePreApplication(computerBean);
		} catch (Exception e) {
			throw new MessageException(e.getMessage());
		}
	}

}
