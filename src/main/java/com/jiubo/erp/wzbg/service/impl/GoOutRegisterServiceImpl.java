package com.jiubo.erp.wzbg.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jiubo.erp.common.MessageException;
import com.jiubo.erp.wzbg.bean.GoOutRegisterBean;
import com.jiubo.erp.wzbg.dao.GoOutRegisterDao;
import com.jiubo.erp.wzbg.service.GoOutRegisterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author dx
 * @since 2019-08-11
 */
@Service
public class GoOutRegisterServiceImpl extends ServiceImpl<GoOutRegisterDao, GoOutRegisterBean> implements GoOutRegisterService {

    @Autowired
    private GoOutRegisterDao goOutRegisterDao;

    @Override
    public List<GoOutRegisterBean> queryGoOutRegister(GoOutRegisterBean goOutRegisterBean) {
        return goOutRegisterDao.queryGoOutRegister(goOutRegisterBean);
    }

    @Override
    public void addGoOutRegister(GoOutRegisterBean goOutRegisterBean) throws MessageException {
        JSONArray goOutNameArr = goOutRegisterBean.getGoOutNameArr();
        JSONArray goOutDateArr = goOutRegisterBean.getGotOutDateArr();
        if (goOutNameArr == null || goOutNameArr.size() <= 0) throw new MessageException("外出人不能为空!");
        if (goOutDateArr == null || goOutDateArr.size() <= 0) throw new MessageException("外出时间不能为空!");
        List<GoOutRegisterBean> beanList = new ArrayList<GoOutRegisterBean>();
        for (int j = 0; j < goOutDateArr.size(); j++) {
            JSONObject jsonObject = goOutDateArr.getJSONObject(j);
            goOutRegisterBean.setGoOutGoTime(jsonObject.getString("begDate"));
            goOutRegisterBean.setGoOutComeTime(jsonObject.getString("endDate"));
            for (int i = 0; i < goOutNameArr.size(); i++) {
                GoOutRegisterBean targetBean = new GoOutRegisterBean();
                BeanUtils.copyProperties(goOutRegisterBean, targetBean);
                targetBean.setGoOutName(goOutNameArr.getString(i));
                beanList.add(targetBean);
            }
        }
        if (beanList.size() > 0) {
            int i = goOutRegisterDao.addGoOutRegister(beanList);
        }
    }

    @Override
    public void updateGoOutRegister(GoOutRegisterBean goOutRegisterBean) throws MessageException {
        if(goOutRegisterDao.updateGoOutRegister(goOutRegisterBean) <= 0)throw new MessageException("修改失败!");
    }

    @Override
    public List<Map<String, Object>> getOutData(Map<String, Object> params) throws MessageException {
        if(params.get("deptId") == null || StringUtils.isBlank(String.valueOf(params.get("deptId"))))throw new MessageException("部门id不能为空!");
        return goOutRegisterDao.getOutData(params);
    }
}
