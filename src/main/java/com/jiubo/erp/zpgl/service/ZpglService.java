package com.jiubo.erp.zpgl.service;

import com.jiubo.erp.common.MessageException;
import com.jiubo.erp.zpgl.bean.RecruitChannelBean;
import com.jiubo.erp.zpgl.bean.RecruitDataBean;
import com.jiubo.erp.zpgl.bean.ZpPlanBean;
import com.jiubo.erp.zpgl.bean.ZpPublishBean;

import java.util.List;

public interface ZpglService {

    /**
     * @desc:查询招聘渠道
     * @param:
     * @return: List<RecruitChannelBean>
     * @Create at: 2019-05-09
     * @author: dx
     * @version: 1.0
     */
    List<RecruitChannelBean> queryRecruitChannel() throws MessageException;

    /**
     * @desc:添加招聘渠道
     * @param:
     * @return: void
     * @Create at: 2019-05-13
     * @author: dx
     * @version: 1.0
     */
    void addRecruitChannel(RecruitChannelBean recruitChannelBean) throws MessageException;

    /**
     * @desc:修改招聘渠道
     * @param:
     * @return: void
     * @Create at: 2019-05-13
     * @author: dx
     * @version: 1.0
     */
    void updateRecruitChannel(RecruitChannelBean recruitChannelBean) throws MessageException;

    /**
     * @desc:删除招聘渠道
     * @param:
     * @return: void
     * @Create at: 2019-05-09
     * @author: dx
     * @version: 1.0
     */
    void deleteRecruitChannel(String id) throws MessageException;

    /**
     * @desc:查询面试信息
     * @param:
     * @return: List<RecruitDataBean>
     * @Create at: 2019-05-09
     * @author: dx
     * @version: 1.0
     */
    List<RecruitDataBean> queryRecruitData(RecruitDataBean recruitDataBean) throws MessageException;

    /**
     * @desc:添加面试信息
     * @param:
     * @return: void
     * @Create at: 2019-05-10
     * @author: dx
     * @version: 1.0
     */
    void addRecruitData(RecruitDataBean recruitDataBean) throws MessageException;

    /**
     * @desc:修改面试信息
     * @param:
     * @return: void
     * @Create at: 2019-05-09
     * @author: dx
     * @version: 1.0
     */
    void updateRecruitData(RecruitDataBean recruitDataBean) throws MessageException;

    /**
     * @desc:删除面试信息（逻辑删除）
     * @param:
     * @return: void
     * @Create at: 2019-05-09
     * @author: dx
     * @version: 1.0
     */
    void updateRecruitData(String id) throws MessageException;

    /**
     * @desc:查询招聘计划
     * @param:
     * @return: List<ZpPlanBean>
     * @Create at: 2019-05-10
     * @author: dx
     * @version: 1.0
     */
    List<ZpPlanBean> queryZpPlan(ZpPlanBean zpPlanBean) throws MessageException;

    /**
     * @desc:添加招聘计划
     * @param:
     * @return: void
     * @Create at: 2019-05-10
     * @author: dx
     * @version: 1.0
     */
    void addZpPlan(ZpPlanBean zpPlanBean) throws MessageException;

    /**
     * @desc:修改招聘计划
     * @param:
     * @return: void
     * @Create at: 2019-05-10
     * @author: dx
     * @version: 1.0
     */
    void updateZpPlan(ZpPlanBean zpPlanBean) throws MessageException;

    /**
     * @desc:删除招聘计划
     * @param:
     * @return: void
     * @Create at: 2019-05-10
     * @author: dx
     * @version: 1.0
     */
    void deleteZpPlan(String id) throws MessageException;

    /**
     * @desc:查询招聘发布信息
     * @param:
     * @return: List<ZpPublishBean>
     * @Create at: 2019-05-11
     * @author: dx
     * @version: 1.0
     */
    List<ZpPublishBean> queryZpPublish(ZpPublishBean zpPublishBean) throws MessageException;

    /**
     * @desc:添加招聘发布信息
     * @param:
     * @return: void
     * @Create at: 2019-05-11
     * @author: dx
     * @version: 1.0
     */
    void addZpPublish(ZpPublishBean zpPublishBean) throws MessageException;

    /**
     * @desc:修改招聘发布信息
     * @param:
     * @return: void
     * @Create at: 2019-05-11
     * @author: dx
     * @version: 1.0
     */
    void updateZpPublish(ZpPublishBean zpPublishBean) throws MessageException;

    /**
     * @desc:删除招聘发布信息
     * @param:
     * @return: void
     * @Create at: 2019-05-11
     * @author: dx
     * @version: 1.0
     */
    void deleteZpPublish(String id) throws MessageException;

    /**
     * @param recruitDataBean
     * @return
     * @Description: 入职员工关联面试信息
     * @author: DingDong
     * @date: 2019年8月26日
     * @version: V1.0
     */
    void relateRecruitData(RecruitDataBean recruitDataBean) throws MessageException;

    void test() throws MessageException;
}
