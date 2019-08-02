package com.jiubo.erp.zpgl.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.jiubo.erp.common.MessageException;
import com.jiubo.erp.zpgl.bean.RecruitChannelBean;
import com.jiubo.erp.zpgl.bean.RecruitDataBean;
import com.jiubo.erp.zpgl.bean.ZpPlanBean;
import com.jiubo.erp.zpgl.bean.ZpPublishBean;

public interface ZpglDao {

    //查询招聘渠道
    public List<RecruitChannelBean> queryRecruitChannel();

    //添加招聘渠道
    public void addRecruitChannel(RecruitChannelBean recruitChannelBean);

    //删除招聘渠道
    public void deleteRecruitChannel(String id);

    //修改招聘渠道
    public void updateRecruitChannel(RecruitChannelBean recruitChannelBean);

    //查询面试信息
    public List<RecruitDataBean> queryRecruitData(RecruitDataBean recruitDataBean);

    //添加面试信息
    public void addRecruitData(RecruitDataBean recruitDataBean);

    //删除面试信息
    public void updateRecruitDataById(String id);

    //修改面试信息
    public void updateRecruitData(RecruitDataBean recruitDataBean);

    //查询招聘计划
    public List<ZpPlanBean> queryZpPlan(ZpPlanBean zpPlanBean);

    //添加招聘计划
    public void addZpPlan(ZpPlanBean zpPlanBean);

    //删除招聘计划
    public void deleteZpPlan(String id);

    //修改招聘计划
    public void updateZpPlan(ZpPlanBean zpPlanBean);

    //查询招聘发布信息
    public List<ZpPublishBean> queryZpPublish(ZpPublishBean zpPublishBean);

    //添加招聘发布信息
    public void addZpPublish(ZpPublishBean zpPublishBean);

    //删除招聘发布信息
    public void deleteZpPublish(String id);

    //修改招聘发布信息
    public void updateZpPublish(ZpPublishBean zpPublishBean);

    //查询请假信息
    //public List<AttLeaveBean> queryAttLeaveBean(AttLeaveBean attLeaveBean);

    //添加请假信息
    //public void addAttLeaveBean(AttLeaveBean attLeaveBean);

    //修改请假信息
    //public void updateAttLeaveBean(AttLeaveBean attLeaveBean);


    //public List<RecruitDataBean> queryRecruitDataTest(@Param("name")String name);
}
