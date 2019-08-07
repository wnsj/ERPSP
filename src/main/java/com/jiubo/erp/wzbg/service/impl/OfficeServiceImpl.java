package com.jiubo.erp.wzbg.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jiubo.erp.common.MapUtil;
import com.jiubo.erp.common.MessageException;
import com.jiubo.erp.common.TimeUtil;
import com.jiubo.erp.wzbg.bean.OfficeNameBean;
import com.jiubo.erp.wzbg.bean.OfficeSuppliesDataBean;
import com.jiubo.erp.wzbg.bean.OfficeUserDataBean;
import com.jiubo.erp.wzbg.bean.SpecificationBean;
import com.jiubo.erp.wzbg.dao.OfficeDao;
import com.jiubo.erp.wzbg.service.OfficeService;
import com.jiubo.erp.wzbg.bean.OfficeDataBean;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.*;

/**
 * @desc:
 * @date: 2019-07-12 15:23
 * @author: dx
 * @version: 1.0
 */
@Service
@Transactional
public class OfficeServiceImpl implements OfficeService {

    @Autowired
    private OfficeDao wzbgDao;

    @Override
    public List<OfficeSuppliesDataBean> queryOfficeSuppliesData(OfficeSuppliesDataBean officeSuppliesDataBean) throws MessageException {
        if (StringUtils.isBlank(officeSuppliesDataBean.getMonth())) throw new MessageException("查询时间不能为空!");
        try {
            officeSuppliesDataBean.setMonth(TimeUtil.getYearMonthStr(TimeUtil.parseAnyDate(officeSuppliesDataBean.getMonth())));
        } catch (ParseException e) {
            e.printStackTrace();
            throw new MessageException("系统异常!");
        }
        List<OfficeSuppliesDataBean> officeSuppliesDataBeans = wzbgDao.queryOfficeSuppliesData(officeSuppliesDataBean);
        /*for (OfficeSuppliesDataBean suppliesDataBean : officeSuppliesDataBeans) {
            SpecificationBean spec = new SpecificationBean();
			spec.setNameId(suppliesDataBean.getOfficeId());
			//该办公用品的所有规格
			suppliesDataBean.setSpecificationList(wzbgDao.querySpecification(spec));
		}*/
        return officeSuppliesDataBeans;
    }

    @Override
    public List<Map<String, Object>> queryOfficeNames() throws MessageException {
        List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
        List<OfficeNameBean> officeNameBeans = wzbgDao.queryOfficeName(null);
        for (OfficeNameBean officeNameBean : officeNameBeans) {
            Map<String, Object> dataMap = new HashMap<String, Object>();
            dataMap.put("id", officeNameBean.getId());
            dataMap.put("name", officeNameBean.getName());
            SpecificationBean spec = new SpecificationBean();
            spec.setNameId(officeNameBean.getId());
            dataMap.put("specification", wzbgDao.querySpecification(spec));
            dataList.add(dataMap);
        }
        return dataList;
    }

    @Override
    public void addUpdateOfficeSupplies(Map<String, Object> params) throws MessageException {
        String param = null;
        String delParam = null;
        try {
            param = MapUtil.getStringIgnoreCase(params, "officeInfo", MapUtil.ALLOW_NULL);
            delParam = MapUtil.getStringIgnoreCase(params, "delOffice", MapUtil.ALLOW_NULL);
        } catch (Exception e) {
            e.printStackTrace();
            throw new MessageException(e.getMessage());
        }
        List<OfficeSuppliesDataBean> officeList = null;
        if (StringUtils.isNotBlank(param)) {
            officeList = JSONObject.parseArray(param, OfficeSuppliesDataBean.class);
            int count = wzbgDao.addUpdateOfficeSupplies(officeList);
        }
        if (StringUtils.isNotBlank(delParam)) {
            officeList = JSONObject.parseArray(delParam, OfficeSuppliesDataBean.class);
            wzbgDao.deleteOfficeSupplies(officeList);
        }
    }

    @Override
    public Map<String, Object> isHuiZong(Map<String, Object> params) throws MessageException {
        Map<String, Object> dataMap = new HashMap<String, Object>();
        OfficeSuppliesDataBean office = new OfficeSuppliesDataBean();
        try {
            dataMap.put("isHuiZong", "0000");
            String month = MapUtil.getStringIgnoreCase(params, "month", MapUtil.NOT_NULL);
            office.setMonth(TimeUtil.getYearMonthStr(TimeUtil.parseAnyDate(month)));
        } catch (Exception e) {
            e.printStackTrace();
            throw new MessageException(e.getMessage());
        }
        List<OfficeSuppliesDataBean> officeSuppliesDataBeanList = wzbgDao.getOfficeSuppliesData(office);
        //if (officeSuppliesDataBeanList.size() <= 0) throw new MessageException("数据异常!");
        for (OfficeSuppliesDataBean officeSuppliesDataBean : officeSuppliesDataBeanList) {
            //判断本月是否已经汇总
            if (StringUtils.isNotBlank(officeSuppliesDataBean.getIsTiJiao())) {
                dataMap.put("isHuiZong", "9999");
                dataMap.put("huiZongRenId",officeSuppliesDataBean.getAccountId3());
                dataMap.put("huiZongRenName",officeSuppliesDataBean.getAccount3Name());
                return dataMap;
            }
        }

        return dataMap;
    }

    @Override
    public void shenHeOfficeSupplies(Map<String, Object> params) throws MessageException {
        OfficeSuppliesDataBean office = new OfficeSuppliesDataBean();
        List<OfficeSuppliesDataBean> officeList = null;
        try {
            String month = MapUtil.getStringIgnoreCase(params, "month", MapUtil.NOT_NULL);
            String param = MapUtil.getStringIgnoreCase(params, "officeInfo", MapUtil.NOT_NULL);
            officeList = JSONObject.parseArray(param, OfficeSuppliesDataBean.class);
            if (officeList.size() <= 0) throw new MessageException("数据异常不可审核!");
            office.setMonth(TimeUtil.getYearMonthStr(TimeUtil.parseAnyDate(month)));
        } catch (Exception e) {
            e.printStackTrace();
            throw new MessageException(e.getMessage());
        }
        List<OfficeSuppliesDataBean> officeSuppliesDataBeanList = wzbgDao.getOfficeSuppliesData(office);
        //if (officeSuppliesDataBeanList.size() <= 0) throw new MessageException("数据异常不可审核!");
        for (int i = 0; i < officeSuppliesDataBeanList.size(); i++) {
            OfficeSuppliesDataBean officeSuppliesDataBean = officeSuppliesDataBeanList.get(i);
            //判断本月是否已经汇总
            if (StringUtils.isNotBlank(officeSuppliesDataBean.getIsTiJiao()))
                throw new MessageException("本月已汇总不可审核!");
            //判断审核的数据是否已经审核过
            for (int j = 0; j < officeList.size(); j++) {
                OfficeSuppliesDataBean dataBean = officeList.get(j);
                //同一条数据的审核意见（1：同意,2:不同意,3:未审核）
                if (officeSuppliesDataBean.getId().equals(dataBean.getId()) && !"3".equals(officeSuppliesDataBean.getAdvice2())) {
                    throw new MessageException("该数据已审核，不可重复审核!");
                }
            }
        }
        wzbgDao.addUpdateOfficeSupplies(officeList);
    }

    @Override
    public Map<String, Object> gatherOfficeSupplies(Map<String, Object> params) throws MessageException {
        Map<String, Object> dataMap = new HashMap<String, Object>();
        OfficeSuppliesDataBean office = new OfficeSuppliesDataBean();
        try {
            String month = MapUtil.getStringIgnoreCase(params, "month", MapUtil.NOT_NULL);
            office.setMonth(TimeUtil.getYearMonthStr(TimeUtil.parseAnyDate(month)));
        } catch (Exception e) {
            e.printStackTrace();
            throw new MessageException(e.getMessage());
        }
        dataMap.put("gatherOffice", wzbgDao.gatherOfficeSupplies(office));
        Map<String, Object> advMap = new HashMap<String, Object>();
        List<Map<String, Object>> advList = wzbgDao.queryAdvance(office);
        if (advList.size() > 0) advMap = advList.get(0);
        dataMap.put("advance", advMap);
        return dataMap;
    }

    @Override
    public Map<String, Object> queryAdvancePeo(Map<String, Object> params) throws MessageException {
        Map<String, Object> data = new HashMap<String, Object>();
        String param = null;
        try {
            param = MapUtil.getStringIgnoreCase(params, "params", MapUtil.NOT_NULL);
        } catch (Exception e) {
            e.printStackTrace();
            throw new MessageException(e.getMessage());
        }
        JSONArray jsonArray = JSONObject.parseArray(param);
        if (jsonArray == null || jsonArray.size() == 0) throw new MessageException("参数不能为空!");
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject json = jsonArray.getJSONObject(i);
            data.put(json.getString("key"), wzbgDao.queryAdvancePeo(json));
        }
        return data;
    }

    @Override
    public Map<String, Object> queryAdvance(Map<String, Object> params) throws MessageException {
        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("advance", "");
        OfficeSuppliesDataBean office = new OfficeSuppliesDataBean();
        try {
            String month = MapUtil.getStringIgnoreCase(params, "month", MapUtil.NOT_NULL);
            office.setMonth(TimeUtil.getYearMonthStr(TimeUtil.parseAnyDate(month)));
        } catch (Exception e) {
            e.printStackTrace();
            throw new MessageException(e.getMessage());
        }
        Map<String, Object> advMap = new HashMap<String, Object>();
        List<Map<String, Object>> advList = wzbgDao.queryAdvance(office);
        if (advList.size() > 0) advMap = advList.get(0);
        dataMap.put("advance", advMap);
        return dataMap;
    }

    @Override
    public void commitAndSheHe(Map<String, Object> params) throws MessageException {
        String param = null;
        List<OfficeSuppliesDataBean> officeList = null;
        try {
            //if (StringUtils.isBlank(officeSuppliesDataBean.getMonth()))throw new MessageException("时间不能为空！");
            param = MapUtil.getStringIgnoreCase(params, "officeInfo", MapUtil.NOT_NULL);
            officeList = JSONObject.parseArray(param, OfficeSuppliesDataBean.class);
            if (officeList.size() <= 0) throw new MessageException("数据异常!");
            for (OfficeSuppliesDataBean officeSuppliesDataBean : officeList) {
                officeSuppliesDataBean.setMonth(TimeUtil.getYearMonthStr(TimeUtil.parseAnyDate(officeSuppliesDataBean.getMonth())));
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new MessageException(e.getMessage());
        }
        wzbgDao.commitAndSheHe(officeList);
    }

    @Override
    public List<Map<String, Object>> queryDeptConscientious(Map<String, Object> params) throws MessageException {
        String deptId = null;
        String level = null;
        List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
        try {
            deptId = MapUtil.getStringIgnoreCase(params, "deptId", MapUtil.NOT_NULL);
            level = MapUtil.getStringIgnoreCase(params, "level", MapUtil.ALLOW_NULL);
        } catch (Exception e) {
            e.printStackTrace();
            throw new MessageException(e.getMessage());
        }
        if (StringUtils.isNotBlank(level)) {
            //组长
            mapList = wzbgDao.queryDeptConscientious(3, deptId);
        } else {
            //主管及组长
            for (int i = 0; i < 3; i++) {
                if (wzbgDao.queryDeptLevel(i, deptId) > 0) {
                    mapList = wzbgDao.queryDeptConscientious(i, deptId);
                }
            }
        }
        return mapList;
    }

    @Override
    public List<Map<String, Object>> queryDeptResponsible(Map<String, Object> params) throws MessageException {
        String deptId = null;
        List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
        try {
            deptId = MapUtil.getStringIgnoreCase(params, "deptId", MapUtil.NOT_NULL);
        } catch (Exception e) {
            e.printStackTrace();
            throw new MessageException(e.getMessage());
        }
        //主管
        for (int i = 0; i < 3; i++) {
            if (wzbgDao.queryDeptLevel(i, deptId) > 0) {
                mapList = wzbgDao.queryDeptResponsible(i, deptId);
            }
        }
        return mapList;
    }

    @Override
    public List<Map<String, Object>> queryDeptExpandResponsible(Map<String, Object> params) throws MessageException {
        String deptId = null;
        List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
        try {
            deptId = MapUtil.getStringIgnoreCase(params, "deptId", MapUtil.NOT_NULL);
        } catch (Exception e) {
            e.printStackTrace();
            throw new MessageException(e.getMessage());
        }
        //主管
        for (int i = 0; i < 3; i++) {
            if (wzbgDao.queryDeptLevel(i, deptId) > 0) {
                mapList = wzbgDao.queryDeptExpandResponsible(i, deptId);
            }
        }
        return mapList;
    }

    @Override
    public List<Map<String, Object>> queryCensor(Map<String, Object> params) throws MessageException {
        String postId = null;
        String postName = null;
        String deptId = null;
        int deptLevel = 0;
        List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
        try {
            deptId = MapUtil.getStringIgnoreCase(params, "deptId", MapUtil.NOT_NULL);
            postId = MapUtil.getStringIgnoreCase(params, "postId", MapUtil.ALLOW_NULL);
            postName = MapUtil.getStringIgnoreCase(params, "postName", MapUtil.ALLOW_NULL);
        } catch (Exception e) {
            e.printStackTrace();
            throw new MessageException(e.getMessage());
        }
        for (int i = 0; i < 3; i++) {
            if (wzbgDao.queryDeptLevel(deptLevel = i, deptId) > 0) break;
        }
        if (wzbgDao.isPuGang(postId, postName) > 0)
            mapList = wzbgDao.queryCensors(0,deptLevel,deptId);
        else if (wzbgDao.isBuZhang(postId, postName) > 0)
            mapList = wzbgDao.queryCensors(1,deptLevel,deptId);
        else if (wzbgDao.isFuZong(postId, postName) > 0)
            mapList = wzbgDao.queryCensors(2,deptLevel,deptId);
        else
            mapList = wzbgDao.queryCensors(3,deptLevel,deptId);
        return mapList;
    }

    @Override
    public List<Map<String, Object>> queryComputerHandover(Map<String, Object> params) throws MessageException {
        return wzbgDao.queryComputerHandover();
    }

    @Override
    public List<Map<String, Object>> queryOfficeHandover(Map<String, Object> params) throws MessageException {
        return wzbgDao.queryOfficeHandover();
    }

    @Override
    public List<OfficeUserDataBean> queryOfficeUserData(OfficeUserDataBean officeUserDataBean) throws MessageException {
        return wzbgDao.queryOfficeUserData(officeUserDataBean);
    }

    @Override
    public void addOfficeUserData(OfficeUserDataBean officeUserDataBean) throws MessageException {
        Date startDate = null;
        Date endDate = null;
        try {
            startDate = TimeUtil.dateAdd(TimeUtil.parseAnyDate(officeUserDataBean.getStartTime()), TimeUtil.UNIT_SECOND, 1);
            endDate = TimeUtil.dateAdd(TimeUtil.parseAnyDate(officeUserDataBean.getEndTime()), TimeUtil.UNIT_SECOND, -1);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new MessageException("系统异常!");
        }

        OfficeUserDataBean bean = new OfficeUserDataBean();
        try {
            //取当天0点
            Date sT = TimeUtil.parseAnyDate(TimeUtil.getDateYYYY_MM_DD(startDate));
            bean.setStartTime(TimeUtil.getDateYYYY_MM_DD_HH_MM_SS(sT));
            //取当天23:59:59
            bean.setEndTime(TimeUtil.getDateYYYY_MM_DD_HH_MM_SS(TimeUtil.dateAdd(TimeUtil.dateAdd(sT, TimeUtil.UNIT_DAY, 1), TimeUtil.UNIT_SECOND, -1)));
        } catch (ParseException e) {
            e.printStackTrace();
            throw new MessageException("系统异常!");
        }
        bean.setStateArr(new String[]{"0", "1", "2"});
        List<OfficeUserDataBean> officeUserDataBeans = wzbgDao.queryOfficeUserData(bean);
        //判断时间是否冲突
        for (OfficeUserDataBean dataBean : officeUserDataBeans) {
            Date sDate = null;
            Date eDate = null;
            try {
                sDate = TimeUtil.StrToDate(dataBean.getStartTime(), "yyyy-MM-dd HH:mm");
                eDate = TimeUtil.StrToDate(dataBean.getEndTime(), "yyyy-MM-dd HH:mm");
            } catch (Exception e) {
                e.printStackTrace();
                throw new MessageException("系统异常!");
            }
            if ("1".equals(officeUserDataBean.getOfficeId()) && "3".equals(dataBean.getOfficeId()) ||
                    "2".equals(officeUserDataBean.getOfficeId()) && "3".equals(dataBean.getOfficeId()) ||
                    "3".equals(officeUserDataBean.getOfficeId()) && "1".equals(dataBean.getOfficeId()) ||
                    "3".equals(officeUserDataBean.getOfficeId()) && "2".equals(dataBean.getOfficeId())) {
                //开始时间小于开始时间，结束时间大于开始时间
                if (startDate.getTime() <= sDate.getTime() && endDate.getTime() >= sDate.getTime())
                    throw new MessageException("时间冲突!");
                    //开始时间小于结束时间，结束时间大于结束时间
                else if (startDate.getTime() <= eDate.getTime() && endDate.getTime() >= eDate.getTime())
                    throw new MessageException("时间冲突!");
                    //开始时间小于开始时间，结束时间大于结束时间
                else if (startDate.getTime() <= sDate.getTime() && endDate.getTime() >= eDate.getTime())
                    throw new MessageException("时间冲突!");
                    //开始时间等于开始时间，结束时间等于结束时间
                else if (startDate.getTime() == sDate.getTime() && endDate.getTime() == eDate.getTime())
                    throw new MessageException("时间冲突!");
                    //开始时间大于开始时间，结束时间小于结束时间
                else if (startDate.getTime() >= sDate.getTime() && endDate.getTime() <= eDate.getTime())
                    throw new MessageException("时间冲突!");
            } else if (officeUserDataBean.getOfficeId().equals(dataBean.getOfficeId())) {
                //开始时间小于开始时间，结束时间大于开始时间
                if (startDate.getTime() <= sDate.getTime() && endDate.getTime() >= sDate.getTime())
                    throw new MessageException("时间冲突!");
                    //开始时间小于结束时间，结束时间大于结束时间
                else if (startDate.getTime() <= eDate.getTime() && endDate.getTime() >= eDate.getTime())
                    throw new MessageException("时间冲突!");
                    //开始时间小于开始时间，结束时间大于结束时间
                else if (startDate.getTime() <= sDate.getTime() && endDate.getTime() >= eDate.getTime())
                    throw new MessageException("时间冲突!");
                    //开始时间等于开始时间，结束时间等于结束时间
                else if (startDate.getTime() == sDate.getTime() && endDate.getTime() == eDate.getTime())
                    throw new MessageException("时间冲突!");
                    //开始时间大于开始时间，结束时间小于结束时间
                else if (startDate.getTime() >= sDate.getTime() && endDate.getTime() <= eDate.getTime())
                    throw new MessageException("时间冲突!");
            }

        }
        wzbgDao.addOfficeUserData(officeUserDataBean);
    }

    @Override
    public void updateOfficeUserData(OfficeUserDataBean officeUserDataBean) throws MessageException {
        if (StringUtils.isBlank(officeUserDataBean.getId())) throw new MessageException("id不能为空!");
        Date startDate = null;
        Date endDate = null;
        Date sT = null;
        try {
            startDate = TimeUtil.dateAdd(TimeUtil.parseAnyDate(officeUserDataBean.getStartTime()), TimeUtil.UNIT_SECOND, 1);
            sT = TimeUtil.parseAnyDate(TimeUtil.getDateYYYY_MM_DD(startDate));
            endDate = TimeUtil.dateAdd(TimeUtil.parseAnyDate(officeUserDataBean.getEndTime()), TimeUtil.UNIT_SECOND, -1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        OfficeUserDataBean bean = new OfficeUserDataBean();
        //0点
        bean.setStartTime(TimeUtil.getDateYYYY_MM_DD_HH_MM_SS(sT));
        //取当天23:59:59
        bean.setEndTime(TimeUtil.getDateYYYY_MM_DD_HH_MM_SS(TimeUtil.dateAdd(TimeUtil.dateAdd(sT, TimeUtil.UNIT_DAY, 1), TimeUtil.UNIT_SECOND, -1)));
        bean.setStateArr(new String[]{"0", "1", "2"});
        List<OfficeUserDataBean> officeUserDataBeans = wzbgDao.queryOfficeUserData(bean);
        for (OfficeUserDataBean dataBean : officeUserDataBeans) {
            //同一条数据不校验时间冲突
            if (dataBean.getId().equals(officeUserDataBean.getId())) {
                if (!"未完成".equals(dataBean.getState())) throw new MessageException("该数据不可修改!");
                continue;
            }
            Date sDate = null;
            Date eDate = null;
            try {
                sDate = TimeUtil.StrToDate(dataBean.getStartTime(), "yyyy-MM-dd HH:mm");
                eDate = TimeUtil.StrToDate(dataBean.getEndTime(), "yyyy-MM-dd HH:mm");
            } catch (Exception e) {
                e.printStackTrace();
                throw new MessageException("系统异常!");
            }
            if ("1".equals(officeUserDataBean.getOfficeId()) && "3".equals(dataBean.getOfficeId()) ||
                    "2".equals(officeUserDataBean.getOfficeId()) && "3".equals(dataBean.getOfficeId()) ||
                    "3".equals(officeUserDataBean.getOfficeId()) && "1".equals(dataBean.getOfficeId()) ||
                    "3".equals(officeUserDataBean.getOfficeId()) && "2".equals(dataBean.getOfficeId())) {
                //开始时间小于开始时间，结束时间大于开始时间
                if (startDate.getTime() <= sDate.getTime() && endDate.getTime() >= sDate.getTime())
                    throw new MessageException("时间冲突!");
                    //开始时间小于结束时间，结束时间大于结束时间
                else if (startDate.getTime() <= eDate.getTime() && endDate.getTime() >= eDate.getTime())
                    throw new MessageException("时间冲突!");
                    //开始时间小于开始时间，结束时间大于结束时间
                else if (startDate.getTime() <= sDate.getTime() && endDate.getTime() >= eDate.getTime())
                    throw new MessageException("时间冲突!");
                    //开始时间等于开始时间，结束时间等于结束时间
                else if (startDate.getTime() == sDate.getTime() && endDate.getTime() == eDate.getTime())
                    throw new MessageException("时间冲突!");
                    //开始时间大于开始时间，结束时间小于结束时间
                else if (startDate.getTime() >= sDate.getTime() && endDate.getTime() <= eDate.getTime())
                    throw new MessageException("时间冲突!");
            } else if (officeUserDataBean.getOfficeId().equals(dataBean.getOfficeId())) {
                //开始时间小于开始时间，结束时间大于开始时间
                if (startDate.getTime() <= sDate.getTime() && endDate.getTime() >= sDate.getTime())
                    throw new MessageException("时间冲突!");
                    //开始时间小于结束时间，结束时间大于结束时间
                else if (startDate.getTime() <= eDate.getTime() && endDate.getTime() >= eDate.getTime())
                    throw new MessageException("时间冲突!");
                    //开始时间小于开始时间，结束时间大于结束时间
                else if (startDate.getTime() <= sDate.getTime() && endDate.getTime() >= eDate.getTime())
                    throw new MessageException("时间冲突!");
                    //开始时间等于开始时间，结束时间等于结束时间
                else if (startDate.getTime() == sDate.getTime() && endDate.getTime() == eDate.getTime())
                    throw new MessageException("时间冲突!");
                    //开始时间大于开始时间，结束时间小于结束时间
                else if (startDate.getTime() >= sDate.getTime() && endDate.getTime() <= eDate.getTime())
                    throw new MessageException("时间冲突!");
            }
        }
        wzbgDao.updateOfficeUserData(officeUserDataBean);
    }

    @Override
    public List<OfficeDataBean> queryOfficeData() {
        return wzbgDao.queryOfficeData();
    }

    @Override
    public void addUpdateOfficeUserData(OfficeUserDataBean officeUserDataBean) throws MessageException {
        if (StringUtils.isBlank(officeUserDataBean.getStartTime()) || StringUtils.isBlank(officeUserDataBean.getEndTime())
                || StringUtils.isBlank(officeUserDataBean.getType()) || StringUtils.isBlank(officeUserDataBean.getUserName())
                || StringUtils.isBlank(officeUserDataBean.getOfficeId()) || StringUtils.isBlank(officeUserDataBean.getAccountZt()))
            throw new MessageException("会议时间、会议类型、主持人、会议室或会议主题为空!");
        Date startDate = null;
        Date endDate = null;
        Date now = null;
        try {
            startDate = TimeUtil.parseAnyDate(officeUserDataBean.getStartTime());
            endDate = TimeUtil.parseAnyDate(officeUserDataBean.getEndTime());
            //当前时间0点
            now = TimeUtil.parseAnyDate(TimeUtil.getDateYYYY_MM_DD(new Date()));
        } catch (ParseException e) {
            e.printStackTrace();
            throw new MessageException("系统异常!");
        }
        if (StringUtils.isNotBlank(officeUserDataBean.getId())) {
            //修改申请
            //if(startTime < nowTime) throw new MessageException("该时间小于当前时间不可更改!");
            updateOfficeUserData(officeUserDataBean);
        } else {
            //申请会议室
            if (startDate.getTime() < now.getTime()) throw new MessageException("该时间小于当前时间不可申请!");
            officeUserDataBean.setYuYueTime(TimeUtil.getDateYYYY_MM_DD_HH_MM_SS(new Date()));
            if (!"2".equals(officeUserDataBean.getType())) {
                //普通申请
                addOfficeUserData(officeUserDataBean);
            } else {
                //例会申请
                int days = 0;
                String week = null;
                Date firstDate = null;
                Date lastDate = null;
                if (StringUtils.isBlank(officeUserDataBean.getWeek())) throw new MessageException("星期不能为空!");
                try {
                    week = officeUserDataBean.getWeek();
                    firstDate = TimeUtil.parseDateYYYY_MM_DD_HH_MM_SS(TimeUtil.DateToStr(startDate, "yyyy-MM-01 HH:mm:ss"));
                    lastDate = TimeUtil.parseDateYYYY_MM_DD_HH_MM_SS(TimeUtil.DateToStr(endDate, "yyyy-MM-01 HH:mm:ss"));
                    days = Integer.parseInt(TimeUtil.getDayStr(TimeUtil.getLastDayOfMonth(startDate)));
                } catch (ParseException e) {
                    e.printStackTrace();
                    throw new MessageException("系统异常!");
                }
                for (int i = 0; i < days; i++) {
                    Date firstTargetDate = TimeUtil.dateAdd(firstDate, TimeUtil.UNIT_DAY, i);
                    Date lastTargetDate = TimeUtil.dateAdd(lastDate, TimeUtil.UNIT_DAY, i);
                    if (!week.equals(TimeUtil.getWeekOfDate(firstTargetDate))) continue;
                    officeUserDataBean.setStartTime(TimeUtil.getDateYYYY_MM_DD_HH_MM_SS(firstTargetDate));
                    officeUserDataBean.setEndTime(TimeUtil.getDateYYYY_MM_DD_HH_MM_SS(lastTargetDate));
                    addOfficeUserData(officeUserDataBean);
                }
            }
        }
    }

    @Override
    public void updateOfficeUserDataState(OfficeUserDataBean officeUserDataBean) throws MessageException {
        if (StringUtils.isBlank(officeUserDataBean.getId())) throw new MessageException("id不能为空!");
        if (wzbgDao.updateOfficeUserDataState(officeUserDataBean) <= 0) throw new MessageException("修改失败!");
        //int i = 1 / 0;
    }
}
  /*if ("1".equals(officeUserDataBean.getOfficeId()) && "3".equals(dataBean.getOfficeId())||
                "2".equals(officeUserDataBean.getOfficeId()) && "3".equals(dataBean.getOfficeId())||
                "3".equals(officeUserDataBean.getOfficeId()) && "1".equals(dataBean.getOfficeId())||
                "3".equals(officeUserDataBean.getOfficeId()) && "2".equals(dataBean.getOfficeId())){
                //开始时间小于开始时间，结束时间大于开始时间
                if (startDate.getTime() < sDate.getTime() && endDate.getTime() > sDate.getTime())
                    throw new MessageException("时间冲突!");
                //开始时间小于结束时间，结束时间大于结束时间
                if (startDate.getTime() < eDate.getTime() && endDate.getTime() > eDate.getTime())
                    throw new MessageException("时间冲突!");
                //开始时间小于开始时间，结束时间大于结束时间
                if (startDate.getTime() < sDate.getTime() && endDate.getTime() > eDate.getTime())
                    throw new MessageException("时间冲突!");
                //开始时间等于开始时间，结束时间等于结束时间
                if (startDate.getTime() == sDate.getTime() && endDate.getTime() == eDate.getTime())
                    throw new MessageException("时间冲突!");
                //开始时间大于开始时间，结束时间小于结束时间
                if (startDate.getTime() >= sDate.getTime() && endDate.getTime() <= eDate.getTime())
                    throw new MessageException("时间冲突!");
            } else if (officeUserDataBean.getOfficeId().equals(dataBean.getOfficeId())) {
                if (startDate.getTime() < sDate.getTime() && endDate.getTime() > sDate.getTime())
                    throw new MessageException("时间冲突!");
                //开始时间小于结束时间，结束时间大于结束时间
                if (startDate.getTime() < eDate.getTime() && endDate.getTime() > eDate.getTime())
                    throw new MessageException("时间冲突!");
                //开始时间小于开始时间，结束时间大于结束时间
                if (startDate.getTime() < sDate.getTime() && endDate.getTime() > eDate.getTime())
                    throw new MessageException("时间冲突!");
                //开始时间等于开始时间，结束时间等于结束时间
                if (startDate.getTime() == sDate.getTime() && endDate.getTime() == eDate.getTime())
                    throw new MessageException("时间冲突!");
                //开始时间大于开始时间，结束时间小于结束时间
                if (startDate.getTime() >= sDate.getTime() && endDate.getTime() <= eDate.getTime())
                    throw new MessageException("时间冲突!");
            }*/