package com.jiubo.erp.wzbg.service;

import com.jiubo.erp.common.MessageException;
import com.jiubo.erp.wzbg.bean.ComputerBean;
import com.jiubo.erp.wzbg.vo.HandInfo;
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
public interface ComputerService {

    /**
     * @param computerBean
     * @return List<ComputerBean>
     * @Description: 查询电脑预申请
     * @author: DingDong
     * @date: 2019年7月30日
     * @version: V1.0
     */
    List<ComputerBean> queryPreApplication(ComputerBean computerBean) throws MessageException;

    /**
     * @param computerBean
     * @return
     * @Description: 添加电脑预申请
     * @author: DingDong
     * @date: 2019年7月31日
     * @version: V1.0
     */
    void addPreApplication(ComputerBean computerBean) throws MessageException;

    /**
     * @param computerBean
     * @return
     * @Description: 修改电脑预申请
     * @author: DingDong
     * @date: 2019年8月31日
     * @version: V1.0
     */
    void updatePreApplication(ComputerBean computerBean) throws MessageException;


    /**
     * @param
     * @return List<PositionInfo>
     * @Description: 查询岗位信息
     * @author: DingDong
     * @date: 2019年7月31日
     * @version: V1.0
     */
    List<PositionInfo> queryPositionInfo() throws MessageException;

    /**
     * @param leaderInfo
     * @return List<LeaderInfo>
     * @Description: 查询所在部门的主管信息
     * @author: DingDong
     * @date: 2019年8月1日
     * @version: V1.0
     */
    List<LeaderInfo> queryLeaderInfo(LeaderInfo leaderInfo) throws MessageException;

    /**
     * @param
     * @return List<HandInfo>
     * @Description: 查询对接人信息
     * @author: DingDong
     * @date: 2019年8月1日
     * @version: V1.0
     */
    List<HandInfo> queryHandInfo() throws MessageException;

    /**
     * @param computerBean
     * @return
     * @Description: 负责人审批
     * @author: DingDong
     * @date: 2019年8月5日
     * @version: V1.0
     */
    void checkPreApp(ComputerBean computerBean) throws MessageException;

    /**
     * @return
     * @Description: 判断部门等级
     * @param    deptId
     * @author: DingDong
     * @date: 2019年8月22日
     * @version: V1.0
     */
    String judgeDeptLeave(String deptId) throws MessageException;
}
