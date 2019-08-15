package com.jiubo.erp.zpgl.dao;

import com.jiubo.erp.zpgl.bean.RecruitChannelBean;
import com.jiubo.erp.zpgl.bean.RecruitDataBean;
import com.jiubo.erp.zpgl.bean.ZpPlanBean;
import com.jiubo.erp.zpgl.bean.ZpPublishBean;

import java.util.List;

public interface ZpglDao {

    //查询招聘渠道
    List<RecruitChannelBean> queryRecruitChannel();

    //添加招聘渠道
    void addRecruitChannel(RecruitChannelBean recruitChannelBean);

    //删除招聘渠道
    void deleteRecruitChannel(String id);

    //修改招聘渠道
    void updateRecruitChannel(RecruitChannelBean recruitChannelBean);

    //查询面试信息
    List<RecruitDataBean> queryRecruitData(RecruitDataBean recruitDataBean);

    //添加面试信息
    void addRecruitData(RecruitDataBean recruitDataBean);

    //删除面试信息
    void updateRecruitDataById(String id);

    //修改面试信息
    void updateRecruitData(RecruitDataBean recruitDataBean);

    //查询招聘计划
    List<ZpPlanBean> queryZpPlan(ZpPlanBean zpPlanBean);

    //添加招聘计划
    void addZpPlan(ZpPlanBean zpPlanBean);

    //删除招聘计划
    void deleteZpPlan(String id);

    //修改招聘计划
    void updateZpPlan(ZpPlanBean zpPlanBean);

    //查询招聘发布信息
    List<ZpPublishBean> queryZpPublish(ZpPublishBean zpPublishBean);

    //添加招聘发布信息
    void addZpPublish(ZpPublishBean zpPublishBean);

    //删除招聘发布信息
    void deleteZpPublish(String id);

    //修改招聘发布信息
    void updateZpPublish(ZpPublishBean zpPublishBean);

    //查询请假信息
    // List<AttLeaveBean> queryAttLeaveBean(AttLeaveBean attLeaveBean);

    //添加请假信息
    // void addAttLeaveBean(AttLeaveBean attLeaveBean);

    //修改请假信息
    // void updateAttLeaveBean(AttLeaveBean attLeaveBean);


    // List<RecruitDataBean> queryRecruitDataTest(@Param("name")String name);
}
