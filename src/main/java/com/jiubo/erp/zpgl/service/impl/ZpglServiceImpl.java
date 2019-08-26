package com.jiubo.erp.zpgl.service.impl;

import com.jiubo.erp.common.MessageException;
import com.jiubo.erp.zpgl.bean.RecruitChannelBean;
import com.jiubo.erp.zpgl.bean.RecruitDataBean;
import com.jiubo.erp.zpgl.bean.ZpPlanBean;
import com.jiubo.erp.zpgl.bean.ZpPublishBean;
import com.jiubo.erp.zpgl.dao.ZpglDao;
import com.jiubo.erp.zpgl.service.ZpglService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ZpglServiceImpl implements ZpglService {

    private final static Logger logger = LoggerFactory.getLogger(ZpglServiceImpl.class);

    @Autowired
    private ZpglDao zpglDao;

    @Override
    public List<RecruitChannelBean> queryRecruitChannel() throws MessageException {
        List<RecruitChannelBean> list;
        logger.info("----------开始查询招聘渠道信息,方法:queryRecruitChannel----------");
        try {
            list = zpglDao.queryRecruitChannel();

        } catch (Exception e) {
            throw new MessageException(e.getMessage());
        }
        return list;
    }

    @Override
    public void addRecruitChannel(RecruitChannelBean recruitChannelBean) throws MessageException {
        logger.info("----------开始添加招聘渠道信息,方法:addRecruitChannel----------");
        try {
            zpglDao.addRecruitChannel(recruitChannelBean);
        } catch (Exception e) {
            throw new MessageException(e.getMessage());
        }
    }

    @Override
    public void updateRecruitChannel(RecruitChannelBean recruitChannelBean) throws MessageException {
        logger.info("----------开始修改招聘渠道信息,方法:updateRecruitChannel----------");
        try {
            zpglDao.updateRecruitChannel(recruitChannelBean);
        } catch (Exception e) {
            throw new MessageException(e.getMessage());
        }
    }

    @Override
    public void deleteRecruitChannel(String id) throws MessageException {
        logger.info("----------开始删除招聘渠道信息,方法:deleteRecruitChannel----------");
        try {
            zpglDao.deleteRecruitChannel(id);
        } catch (Exception e) {
            throw new MessageException(e.getMessage());
        }
    }

    @Override
    public List<RecruitDataBean> queryRecruitData(RecruitDataBean recruitDataBean) throws MessageException {
        List<RecruitDataBean> list;
        logger.info("----------开始查询面试信息,方法:queryRecruitData----------");
        try {
            list = zpglDao.queryRecruitData(recruitDataBean);

        } catch (Exception e) {
            throw new MessageException(e.getMessage());
        }
        return list;
    }

    @Override
    public void addRecruitData(RecruitDataBean recruitDataBean) throws MessageException {
        logger.info("----------开始添加面试信息,方法:addRecruitData----------");
        try {
            if (StringUtils.isNotEmpty(recruitDataBean.getHeight())) {
                float f = Float.parseFloat(recruitDataBean.getHeight());
                String s = String.valueOf(Math.round(f));
                recruitDataBean.setHeight(s);
            }
            if (StringUtils.isNotEmpty(recruitDataBean.getWeight())) {
                float f = Float.parseFloat(recruitDataBean.getWeight());
                String s = String.valueOf(Math.round(f));
                recruitDataBean.setWeight(s);
            }
            // 户口性质
            if ("0".equals(recruitDataBean.getAccountProp())) {
                recruitDataBean.setAccountProp("农业");
            }
            if ("1".equals(recruitDataBean.getAccountProp())) {
                recruitDataBean.setAccountProp("非农业");
            }
            // 血型
            if ("0".equals(recruitDataBean.getBloodType())) {
                recruitDataBean.setBloodType("A");
            }
            if ("1".equals(recruitDataBean.getBloodType())) {
                recruitDataBean.setBloodType("B");
            }
            if ("2".equals(recruitDataBean.getBloodType())) {
                recruitDataBean.setBloodType("O");
            }
            if ("3".equals(recruitDataBean.getBloodType())) {
                recruitDataBean.setBloodType("AB");
            }
            if ("4".equals(recruitDataBean.getBloodType())) {
                recruitDataBean.setBloodType("特殊");
            }
            // 婚否
            if ("0".equals(recruitDataBean.getMarital())) {
                recruitDataBean.setMarital("未婚");
            }
            if ("1".equals(recruitDataBean.getMarital())) {
                recruitDataBean.setMarital("已婚");
            }
            // 政治面貌
            if ("0".equals(recruitDataBean.getPloitical())) {
                recruitDataBean.setPloitical("群众");
            }
            if ("1".equals(recruitDataBean.getPloitical())) {
                recruitDataBean.setPloitical("团员");
            }
            if ("2".equals(recruitDataBean.getPloitical())) {
                recruitDataBean.setPloitical("党员");
            }
            // 性别
            if ("0".equals(recruitDataBean.getSex())) {
                recruitDataBean.setSex("女");
            }
            if ("1".equals(recruitDataBean.getSex())) {
                recruitDataBean.setSex("男");
            }
            // 学历
            if ("0".equals(recruitDataBean.getEducation())) {
                recruitDataBean.setEducation("未知");
            }
            if ("1".equals(recruitDataBean.getEducation())) {
                recruitDataBean.setEducation("博士");
            }
            if ("2".equals(recruitDataBean.getEducation())) {
                recruitDataBean.setEducation("硕士研究生");
            }
            if ("3".equals(recruitDataBean.getEducation())) {
                recruitDataBean.setEducation("本科");
            }
            if ("4".equals(recruitDataBean.getEducation())) {
                recruitDataBean.setEducation("专科");
            }
            if ("5".equals(recruitDataBean.getEducation())) {
                recruitDataBean.setEducation("高中/中专");
            }
            if ("6".equals(recruitDataBean.getEducation())) {
                recruitDataBean.setEducation("初中及以下");
            }
            // 是否合格
            if ("0".equals(recruitDataBean.getIsQualified())) {
                recruitDataBean.setIsQualified("否");
            }
            if ("1".equals(recruitDataBean.getIsQualified())) {
                recruitDataBean.setIsQualified("是");
            }
            if ("2".equals(recruitDataBean.getIsQualified())) {
                recruitDataBean.setIsQualified("待定");
            }
            //是否有效（ 0：有效，1：失效）
            recruitDataBean.setIsDelete("0");
            //是否入职（0：未入职 1：在职 2：离职）
            recruitDataBean.setIsEntry("0");
            zpglDao.addRecruitData(recruitDataBean);
        } catch (Exception e) {
            throw new MessageException(e.getMessage());
        }
    }

    @Override
    public void updateRecruitData(RecruitDataBean recruitDataBean) throws MessageException {
        logger.info("----------开始修改面试信息,方法:updateRecruitData----------");
        try {
            zpglDao.updateRecruitData(recruitDataBean);
        } catch (Exception e) {
            throw new MessageException(e.getMessage());
        }
    }

    @Override
    public void updateRecruitData(String id) throws MessageException {
        logger.info("----------开始删除面试信息,方法:updateRecruitData----------");
        try {
            zpglDao.updateRecruitDataById(id);
        } catch (Exception e) {
            throw new MessageException(e.getMessage());
        }
    }

    @Override
    public List<ZpPlanBean> queryZpPlan(ZpPlanBean zpPlanBean) throws MessageException {
        logger.info("----------开始查询招聘计划信息,方法:queryZpPlan----------");
        List<ZpPlanBean> list;
        try {
            list = zpglDao.queryZpPlan(zpPlanBean);
        } catch (Exception e) {
            throw new MessageException(e.getMessage());
        }
        return list;
    }

    @Override
    public void addZpPlan(ZpPlanBean zpPlanBean) throws MessageException {
        logger.info("----------开始添加招聘计划信息,方法:addZpPlan----------");
        try {
            zpglDao.addZpPlan(zpPlanBean);
        } catch (Exception e) {
            throw new MessageException(e.getMessage());
        }
    }

    @Override
    public void updateZpPlan(ZpPlanBean zpPlanBean) throws MessageException {
        logger.info("----------开始修改招聘计划信息,方法:updateZpPlan----------");
        try {
            zpglDao.updateZpPlan(zpPlanBean);
        } catch (Exception e) {
            throw new MessageException(e.getMessage());
        }
    }

    @Override
    public void deleteZpPlan(String id) throws MessageException {
        logger.info("----------开始删除招聘计划信息,方法:deleteZpPlan----------");
        try {
            zpglDao.deleteZpPlan(id);
        } catch (Exception e) {
            throw new MessageException(e.getMessage());
        }
    }

    @Override
    public List<ZpPublishBean> queryZpPublish(ZpPublishBean zpPublishBean) throws MessageException {
        logger.info("----------开始查询招聘发布信息,方法:queryZpPublish----------");
        List<ZpPublishBean> list;
        try {
            list = zpglDao.queryZpPublish(zpPublishBean);
        } catch (Exception e) {
            throw new MessageException(e.getMessage());
        }
        return list;
    }

    @Override
    public void addZpPublish(ZpPublishBean zpPublishBean) throws MessageException {
        logger.info("----------开始添加招聘发布信息,方法:addZpPublish----------");
        try {
            zpglDao.addZpPublish(zpPublishBean);
        } catch (Exception e) {
            throw new MessageException(e.getMessage());
        }
    }

    @Override
    public void updateZpPublish(ZpPublishBean zpPublishBean) throws MessageException {
        logger.info("----------开始修改招聘发布信息,方法:updateZpPublish----------");
        try {
            zpglDao.updateZpPublish(zpPublishBean);
        } catch (Exception e) {
            throw new MessageException(e.getMessage());
        }
    }

    @Override
    public void deleteZpPublish(String id) throws MessageException {
        logger.info("----------开始删除招聘发布信息,方法:deleteZpPublish----------");
        try {
            zpglDao.deleteZpPublish(id);
        } catch (Exception e) {
            throw new MessageException(e.getMessage());
        }
    }

    /**
     * @param recruitDataBean
     * @return
     * @Description: 入职员工关联面试信息
     * @author: DingDong
     * @date: 2019年8月26日
     * @version: V1.0
     */
    @Override
    public void relateRecruitData(RecruitDataBean recruitDataBean) throws MessageException {
        logger.info("----------开始关联面试信息,方法:relateRecruitData----------");
        try {
            zpglDao.relateRecruitData(recruitDataBean);
        } catch (Exception e) {
            throw new MessageException(e.getMessage());
        }
    }

    @Override
    public void test() throws MessageException {
        //测试bind待解决
        //System.out.println(zpglDao.queryRecruitDataTest("亮"));
    }
}
