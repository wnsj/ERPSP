package com.jiubo.erp.wzbg.service.impl;

import com.jiubo.erp.common.MessageException;
import com.jiubo.erp.wzbg.bean.LeaveForgetBean;
import com.jiubo.erp.wzbg.dao.LeaveForgetDao;
import com.jiubo.erp.wzbg.service.LeaveForgetService;
import com.jiubo.erp.wzbg.vo.DeptWithEmp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @version: V1.0
 * @author: DingDong
 * @className: 
 * @description: 忘记打卡证明业务实现层
 * @data: 2019-07-12
 **/
@Service
@Transactional
public class LeaveForgetServiceImpl implements LeaveForgetService {
	
	private final static Logger logger  = LoggerFactory.getLogger(LeaveForgetServiceImpl.class);
	
	@Autowired
	private LeaveForgetDao leaveForgetDao;
	
	/**
	 * @Description: 查询忘记打卡证明
	 * @param  leaveForgetBean
	 * @return List<LeaveForgetBean>
	 * @author: DingDong
	 * @date: 2019年7月12日
	 * @version: V1.0
	 */
	@Override
	public List<LeaveForgetBean> queryLeaveForgetBean(LeaveForgetBean leaveForgetBean) throws MessageException {
		List<LeaveForgetBean> list;
		logger.info("----------开始查询忘记打卡证明,方法:queryLeaveForgetBean----------");
		try {
			list = leaveForgetDao.queryLeaveForget(leaveForgetBean);
		} catch (Exception e) {
			throw new MessageException(e.getMessage());
		}
		return list;
	}
	
	/**
	 * @Description: 新增忘记打卡证明
	 * @param  leaveForgetBean
	 * @return List<LeaveForgetBean>
	 * @author: DingDong
	 * @date: 2019年7月13日
	 * @version: V1.0
	 */
	@Override
	public void addLeaveForgetBean(LeaveForgetBean leaveForgetBean) throws MessageException {
		logger.info("----------开始新增忘记打卡证明,方法:addLeaveForgetBean----------");
		try {
			leaveForgetDao.addLeaveForget(leaveForgetBean);
		} catch (Exception e) {
			throw new MessageException(e.getMessage());
		}
	}
	
	/**
	 * @Description: 通过账户ID查询某员工部门和职位
	 * @param  deptWithEmp
	 * @return DeptWithEmp
	 * @author: DingDong
	 * @date: 2019年7月16日
	 * @version: V1.0
	 */
	@Override
	public DeptWithEmp queryEmpInfoByAccount(DeptWithEmp deptWithEmp) throws MessageException {
		logger.info("----------开始通过账户ID查询某员工部门和职位,方法:queryEmpInfoByAccount----------");
		DeptWithEmp empInfo;
		try {
			empInfo = leaveForgetDao.queryEmpInfoByAccount(deptWithEmp);
		} catch (Exception e) {
			throw new MessageException(e.getMessage());
		}
		return empInfo;
	}

	@Override
	public void updateLeaveForget(LeaveForgetBean leaveForgetBean) throws MessageException {
		logger.info("----------开始通过账户ID查询某员工部门和职位,方法:queryEmpInfoByAccount----------");
		try {
			 leaveForgetDao.updateLeaveForget(leaveForgetBean);
		} catch (Exception e) {
			throw new MessageException(e.getMessage());
		}
	}

}
