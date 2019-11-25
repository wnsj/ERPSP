package com.jiubo.erp.wzbg.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jiubo.erp.common.MessageException;
import com.jiubo.erp.wzbg.bean.GoOutRegisterBean;
import com.jiubo.erp.wzbg.dao.GoOutRegisterDao;
import com.jiubo.erp.wzbg.service.GoOutRegisterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sun.org.apache.xerces.internal.xs.StringList;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        if (goOutRegisterDao.updateGoOutRegister(goOutRegisterBean) <= 0) throw new MessageException("修改失败!");
    }

    @Override
    public List<Map<String, Object>> getOutData(Map<String, Object> params) throws MessageException {
        if (params.get("deptId") == null || StringUtils.isBlank(String.valueOf(params.get("deptId"))))
            throw new MessageException("部门id不能为空!");
        return goOutRegisterDao.getOutData(params);
    }

    @Override
    public List<Map<String, Object>> selectDeptLeaderById(Map<String, Object> map) throws MessageException {
        List<String> deptids = (List<String>) map.get("deptids");
        if (deptids == null || deptids.size() <= 0) throw new MessageException("部门id不能为空!");
        List<String> content = new ArrayList<>();
        for (Object deptid : deptids) {
            content.add(deptid.toString());
        }

        map.put("deptids", content.stream().distinct().collect(Collectors.toList()));
        return goOutRegisterDao.selectDeptLeaderById(map);
    }

    @Override
    public Map<String, Object> expandDeptLeaderById(String counts, String deptid) {
        HashMap<String, Object> result = new HashMap<>();
        if ("1".equals(counts)) {
            //根据parentId查询同级的部门id集合
            List<Object> tongJiDeptids = goOutRegisterDao.selectDeptLeaderByParentId(deptid);
            if (tongJiDeptids != null && tongJiDeptids.size() > 0) {
                result.put("deptids", tongJiDeptids);
                result.put("parentId", deptid);
                return result;
            }
        } else {
            Map<String, Object> map = goOutRegisterDao.selectDeptById(deptid);
            //判断如果不等于0，说明还有上一级

            if (!map.isEmpty()) {
                int parentID = Integer.parseInt(map.get("ParentID") + "");
                if (parentID != 0) {

                    List<Object> deptids = goOutRegisterDao.expandDeptLeaderById(deptid);
                    result.put("deptids", deptids);
                    result.put("parentId", parentID);
                    return result;
                }
                ArrayList<Object> objects = new ArrayList<>();
                objects.add(map.get("ID"));
                //添加办公室主任
                //objects.add(39);
                result.put("deptids", objects);
                result.put("parentId", parentID);
                return result;
            }
        }


        return null;
    }

    @Override
    public void updateGoOutDeleteById(String id) {
        goOutRegisterDao.updateGoOutDeleteById(id);
    }

    @Override
    public void updateAdvice(Map<String, String> map) throws MessageException {
        if (map.isEmpty()) {
            throw new MessageException("参数接收失败!");
        }
        if (goOutRegisterDao.updateAdvice(map) <= 0) {
            throw new MessageException("修改失败!");
        }
    }
}
