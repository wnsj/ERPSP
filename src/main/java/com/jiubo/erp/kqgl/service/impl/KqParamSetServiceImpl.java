package com.jiubo.erp.kqgl.service.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.jiubo.erp.common.Constant;
import com.jiubo.erp.common.MapUtil;
import com.jiubo.erp.common.MessageException;
import com.jiubo.erp.common.TimeUtil;
import com.jiubo.erp.kqgl.bean.AttRuleTypeBean;
import com.jiubo.erp.kqgl.bean.AttShiftBean;
import com.jiubo.erp.kqgl.bean.AttShiftGroupBean;
import com.jiubo.erp.kqgl.bean.AttShiftScheduleBean;
import com.jiubo.erp.kqgl.bean.PositionDataBean;
import com.jiubo.erp.kqgl.bean.PositionTypeBean;
import com.jiubo.erp.kqgl.dao.KqParamSetDao;
import com.jiubo.erp.kqgl.service.KqParamSetService;
import com.jiubo.erp.kqgl.vo.Vacation;
import com.jiubo.erp.rygl.bean.DepartmentBean;
import com.jiubo.erp.rygl.bean.EmployeeBasicBean;


@Service
@Transactional
public class KqParamSetServiceImpl implements KqParamSetService {

    @Autowired
    private KqParamSetDao kqParamSetDao;

    @Override
    public List<Vacation> queryVacation() {
        return kqParamSetDao.queryVacation();
    }

    @Override
    public void updateVacation(Vacation vacation) throws MessageException {
        kqParamSetDao.updateVacation(vacation);
    }

    @Override
    public void addVacation(Vacation vacation) {
        kqParamSetDao.addVacation(vacation);
    }

    @Override
    public void deleteVacation(int id) throws MessageException {
        kqParamSetDao.deleteVacation(id);
    }

    @Override
    public List<AttRuleTypeBean> queryAttRuleType() {
        return kqParamSetDao.queryAttRuleType();
    }

    @Override
    public void addAttRuleType(AttRuleTypeBean attRuleType) {
        kqParamSetDao.addAttRuleType(attRuleType);
    }

    @Override
    public void deleteAttRuleType(int id) {
        kqParamSetDao.deleteAttRuleType(id);
    }

    @Override
    public void updateAttRuleType(AttRuleTypeBean attRuleType) {
        kqParamSetDao.updateAttRuleType(attRuleType);
    }

    @Override
    public List<AttShiftScheduleBean> queryAttShiftSchedule() {
        return kqParamSetDao.queryAttShiftSchedule();
    }

    @Override
    public void addAttShiftSchedule(AttShiftScheduleBean attShiftSchedule) {
        kqParamSetDao.addAttShiftSchedule(attShiftSchedule);
    }

    @Override
    public void deleteAttShiftSchedule(int id) {
        kqParamSetDao.deleteAttShiftSchedule(id);
    }

    @Override
    public void updateAttShiftSchedule(AttShiftScheduleBean attShiftSchedule) {
        kqParamSetDao.updateAttShiftSchedule(attShiftSchedule);
    }

    @Override
    public List<AttShiftGroupBean> queryAttShiftGroup() {
        return kqParamSetDao.queryAttShiftGroup();
    }

    @Override
    public void addAttShiftGroup(AttShiftGroupBean attShiftGroupBean) {
        kqParamSetDao.addAttShiftGroup(attShiftGroupBean);
    }

    @Override
    public void deleteAttShiftGroup(int id) {
        kqParamSetDao.deleteAttShiftGroup(id);
    }

    @Override
    public void updateAttShiftGroup(AttShiftGroupBean attShiftGroupBean) {
        kqParamSetDao.updateAttShiftGroup(attShiftGroupBean);
    }

    @Override
    public List<Map<String, Object>> queryDepartment() throws MessageException {
        return kqParamSetDao.queryDepartment();
    }

    @Override
    public void addDepartment(DepartmentBean departmentBean) throws MessageException {
        if (StringUtils.isBlank(departmentBean.getName())) throw new MessageException("部门名称不能为空!");
        if (StringUtils.isBlank(departmentBean.getParentID())) departmentBean.setParentID("0");
        if (StringUtils.isBlank(departmentBean.getOrderNum())) departmentBean.setOrderNum("0");
        kqParamSetDao.addDepartment(departmentBean);
    }

    @Override
    public void deleteDepartment(int id) throws MessageException {
        if (id <= 0) throw new MessageException("部门id不能为空！");
        kqParamSetDao.deleteDepartment(id);
    }

    @Override
    public void updateDepartment(DepartmentBean departmentBean) throws MessageException {
        if (StringUtils.isBlank(departmentBean.getName()) || StringUtils.isBlank(departmentBean.getID()))
            throw new MessageException("部门名或部门id为空！");
        kqParamSetDao.updateDepartment(departmentBean);
    }

    @Override
    public List<PositionTypeBean> queryPositionType() throws MessageException {
        return kqParamSetDao.queryPositionType();
    }

    @Override
    public void addPositionType(PositionTypeBean positionTypeBean) throws MessageException {
        kqParamSetDao.addPositionType(positionTypeBean);
    }

    @Override
    public void deletePositionType(int id) throws MessageException {
        kqParamSetDao.deletePositionType(id);
    }

    @Override
    public void updatePositionType(PositionTypeBean positionTypeBean) throws MessageException {
        kqParamSetDao.updatePositionType(positionTypeBean);
    }

    @Override
    public List<Map<String, Object>> queryPositionData() throws MessageException {
        return kqParamSetDao.queryPositionData();
    }

    @Override
    public void addPositionData(PositionDataBean positionDataBean) throws MessageException {
        if (StringUtils.isBlank(positionDataBean.getPosition_Name()))
            throw new MessageException("职位名为空！");
        kqParamSetDao.addPositionData(positionDataBean);
    }

    @Override
    public void updatePositionData(PositionDataBean positionDataBean) throws MessageException {
        if (StringUtils.isBlank(positionDataBean.getPosition_ID()) || StringUtils.isBlank(positionDataBean.getPosition_Name()))
            throw new MessageException("职位id或职位名为空！");
        kqParamSetDao.updatePositionData(positionDataBean);
    }

    @Override
    public List<DepartmentBean> queryDepartmentEmployee(boolean flag, boolean flag2) throws MessageException {
        //查询父级目录
        List<DepartmentBean> departmentList = queryDepartmentByPId("0");
        Iterator<DepartmentBean> iterator = departmentList.iterator();
        for (; iterator.hasNext(); ) {
            DepartmentBean departmentBean = iterator.next();
            //查询子目录
            departmentBean.setChildren(getChildren(departmentBean.getID(), flag, flag2));
            //查询部门下的员工
            departmentBean.setEmployeeList(queryEmployeeBasic(flag, departmentBean.getID(), "1"));
            //查询部门下的岗位
            departmentBean.setPositionDataList(queryPositionDataByDeptId(departmentBean.getID(), flag2));
        }
        return departmentList;
    }

    public List<DepartmentBean> queryDepartmentByPId(String pId) {
        return kqParamSetDao.queryDepartmentByPId(pId);
    }

    public List<EmployeeBasicBean> queryEmployeeBasic(boolean flag, String departmentId, String state) {
        if (flag) return kqParamSetDao.queryEmployeeBasic(departmentId, state);
        else return new ArrayList<EmployeeBasicBean>();
    }

    //获取所有子目录
    private List<DepartmentBean> getChildren(String pId, boolean flag, boolean flag2) {
        List<DepartmentBean> list = new ArrayList<DepartmentBean>();
        List<DepartmentBean> departmentList = queryDepartmentByPId(pId);
        Iterator<DepartmentBean> iterator = departmentList.iterator();
        for (; iterator.hasNext(); ) {
            DepartmentBean departmentBean = iterator.next();
            //递归查询子目录
            departmentBean.setChildren(getChildren(departmentBean.getID(), flag, flag2));
            //查询部门下的员工
            departmentBean.setEmployeeList(queryEmployeeBasic(flag, departmentBean.getID(), "1"));
            //查询部门下的岗位
            departmentBean.setPositionDataList(queryPositionDataByDeptId(departmentBean.getID(), flag2));
            list.add(departmentBean);
        }
        return list;
    }

    //查询部门下的职位
    public List<PositionDataBean> queryPositionDataByDeptId(String deptId, boolean flag) {
        if (flag) return kqParamSetDao.queryPositionDataByDeptId(deptId, null, null);
        return new ArrayList<PositionDataBean>();
    }

    @Override
    public List<DepartmentBean> queryDeptTree(Map<String, Object> param) throws MessageException {
        //第一层
        List<DepartmentBean> departmentBeans = getDept();

        List<DepartmentBean> departmentBeanList = new ArrayList<DepartmentBean>();

        addDeptPreFix(departmentBeans, departmentBeanList);

        return departmentBeanList;
    }

    @Override
    public List<DepartmentBean> getDept() throws MessageException {
        List<DepartmentBean> deptList = kqParamSetDao.queryDeptTree();
        List<DepartmentBean> departmentBeans = composeDept(deptList);
        return departmentBeans;
    }

    @Override
    public List<DepartmentBean> composeDept(List<DepartmentBean> deptList) throws MessageException {
        List<DepartmentBean> departmentBeans = new ArrayList<DepartmentBean>();
        if (deptList == null) throw new MessageException("部门List为空!");
        Map<String, List<DepartmentBean>> sonMap = new HashMap<String, List<DepartmentBean>>();
        for (DepartmentBean departmentBean : deptList) {
            if ("0".equals(departmentBean.getParentID())) {
                departmentBeans.add(departmentBean);
            } else {
                List<DepartmentBean> sonDeptList = sonMap.get(departmentBean.getParentID());
                if (sonDeptList == null) sonDeptList = new ArrayList<DepartmentBean>();
                sonDeptList.add(departmentBean);
                sonMap.put(departmentBean.getParentID(), sonDeptList);
            }
        }

        for (DepartmentBean departmentBean : departmentBeans) {
            setDeptChildren(departmentBean, sonMap);
        }
        return departmentBeans;
    }

    @Override
    public List<PositionDataBean> queryDeptPost(String deptId, String postId, String isPoint) {
        return kqParamSetDao.queryPositionDataByDeptId(deptId, postId, isPoint);
    }

    //为list中bean的名字添加前缀
    public void addDeptPreFix(List<DepartmentBean> sourceList, List<DepartmentBean> targetList) throws MessageException {
        if (sourceList == null || targetList == null) throw new MessageException("sourceList or targetList is null!");
        for (int i = 0; i < sourceList.size(); i++) {
            DepartmentBean departmentBean = sourceList.get(i);
            DepartmentBean deptBean = new DepartmentBean();
            //copy DepartmentBean，children属性除外
            BeanUtils.copyProperties(departmentBean, deptBean, "children");
            //编号
            //deptBean.setID(departmentBean.getID());
            //名称
            //deptBean.setName(departmentBean.getName());
            //父级编号
            //deptBean.setParentID(departmentBean.getParentID());
            //顺序号
            //deptBean.setOrderNum(departmentBean.getOrderNum());
            //部门级别
            //deptBean.setLevel(departmentBean.getLevel());
            //带前缀的名字
            String preFix = i == sourceList.size() - 1 ? "└" : "├";
            deptBean.setPreFixName(getSpace(departmentBean.getLevel()) + preFix + departmentBean.getName());
            targetList.add(deptBean);
            //获取子部门
            if (departmentBean.getChildren() != null && departmentBean.getChildren().size() > 0)
                addDeptPreFix(departmentBean.getChildren(), targetList);
        }
    }

    //获取空格
    private String getSpace(int level) {
        int i = 1;
        StringBuffer stringBuffer = new StringBuffer("&nbsp;");
        while (i < level * 2) {
            stringBuffer.append("&nbsp;");
            i++;
        }
        return stringBuffer.toString();
    }

    //将父级部门与子部门对应
    private void setDeptChildren(DepartmentBean parentBean, Map<String, List<DepartmentBean>> sonMap) {
        List<DepartmentBean> sonBeanList = sonMap.get(parentBean.getID());
        if (sonBeanList == null) {
            sonBeanList = new ArrayList<DepartmentBean>();
        } else {
            for (DepartmentBean departmentBean : sonBeanList) {
                List<DepartmentBean> childBeanList = sonMap.get(departmentBean.getID());
                if (childBeanList != null) setDeptChildren(departmentBean, sonMap);
            }
        }
        parentBean.setChildren(sonBeanList);
    }

    @Override
    public JSONObject queryEmpAttShift(String userId, String userName, String startTime, String endTime, String flag) throws MessageException {
        JSONObject jsonObject = new JSONObject();
        try {
            Map<String, Object> dataMap = new HashMap<String, Object>();
            Date startDate = TimeUtil.parseAnyDate(startTime);
            int day = 0;
            if ("30".equals(flag)) {
                List<String> dataList = new ArrayList<String>();
                Date endDate = TimeUtil.getFirstDayOfMonth(TimeUtil.dateAdd(startDate, TimeUtil.UNIT_MONTH, 1));
                startDate = TimeUtil.getFirstDayOfMonth(startDate);
                day = Integer.parseInt(TimeUtil.getDayStr(TimeUtil.getLastDayOfMonth(startDate)));
                List<AttShiftBean> attShiftList = kqParamSetDao.queryAttShift(userId, userName, TimeUtil.getDateYYYY_MM_DD_HH_MM_SS(startDate), TimeUtil.getDateYYYY_MM_DD_HH_MM_SS(endDate));
                if(day == attShiftList.size())
                    for (AttShiftBean attShiftBean : attShiftList)
                        dataList.add(attShiftBean.getName());
                else
                    for (int i = 0;i < day; i++){
                        if(i > attShiftList.size() - 1) {
                            dataList.add("");
                        }else {
                            AttShiftBean attShiftBean = attShiftList.get(i);
                            dataList.add(attShiftBean.getName());
                        }
                    }
                dataMap.put("monData", dataList);
            } else {
                //开始上班时间
                List<Double> startList = new ArrayList<Double>();
                //上班时长
                List<Double> timeList = new ArrayList<Double>();
                //下班时间
                List<Double> endList = new ArrayList<Double>();

                Date endDate = TimeUtil.dateAdd(TimeUtil.parseAnyDate(endTime), TimeUtil.UNIT_DAY, 1);
                List<AttShiftBean> attShiftList = kqParamSetDao.queryAttShift(userId, userName, startTime, TimeUtil.getDateYYYY_MM_DD_HH_MM_SS(endDate));
                for (AttShiftBean attShiftBean : attShiftList) {
                    double sTime = 0.0;    //工作开始时间
                    double eTime = 0;
                    double t = 0;
                    Date staTime = TimeUtil.parseAnyDate(attShiftBean.getStartTime());
                    Date enTime = TimeUtil.parseAnyDate(attShiftBean.getEndTime());
                    if ("2".equals(attShiftBean.getType())) {
                        //2：休息
                    } else {
                        //1：工作
                        sTime = TimeUtil.getHourHex(staTime);
                        //判断是否是跨日工作
                        if (enTime.getTime() == staTime.getTime() || enTime.getTime() < staTime.getTime()) {
                            //工作时长 = 结束时间 + 1天 - 开始时间
                            enTime = TimeUtil.dateAdd(enTime, TimeUtil.UNIT_DAY, 1);
                            //eTime = "0 - ".concat(TimeUtil.getHourStr(enTime));
                            double d = TimeUtil.getHourHex(enTime);
                            eTime = (double) (0 - d);
                            t = TimeUtil.DateDiffHours(staTime, enTime) - d;
                        } else {
                            //不跨日工作
                            t = TimeUtil.DateDiffHours(staTime, enTime);
                        }
                    }
                    startList.add(sTime);
                    timeList.add(t);
                    endList.add(eTime);
                }
                dataMap.put("startTime", startList);
                dataMap.put("timeList", timeList);
                dataMap.put("endTime", endList);
                dataMap.put("realData", attShiftList);
            }
            jsonObject.put(Constant.Result.RETDATA, dataMap);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    @Override
    public List<Map<String, Object>> queryAllEmpAttShift(String begDate, String endDate) throws MessageException {
        List<Map<String, Object>> list = null;
        try {
            list = kqParamSetDao.queryAllEmpAttShift(TimeUtil.getDateYYYY_MM_DD_HH_MM_SS(TimeUtil.parseAnyDate(begDate)), TimeUtil.getDateYYYY_MM_DD_HH_MM_SS(TimeUtil.dateAdd(TimeUtil.parseAnyDate(endDate), TimeUtil.UNIT_DAY, 1)));
            for (Map<String, Object> map : list) {
                if (map.get("SHIFTDATE") != null)
                    map.put("SHIFTDATE", TimeUtil.getDateYYYY_MM_DD_HH_MM(TimeUtil.parseAnyDate(String.valueOf(map.get("SHIFTDATE")))));
                if (map.get("STARTTIME") != null)
                    map.put("STARTTIME", TimeUtil.getDateYYYY_MM_DD_HH_MM(TimeUtil.parseAnyDate(String.valueOf(map.get("STARTTIME")))));
                if (map.get("ENDTIME") != null)
                    map.put("ENDTIME", TimeUtil.getDateYYYY_MM_DD_HH_MM(TimeUtil.parseAnyDate(String.valueOf(map.get("ENDTIME")))));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void updateEmpAttShift(Map<String, Object> paraMap) throws MessageException {
        //kqParamSetDao.deleteAttPeopleShift(id);
        String begDate = null;
        String endDate = null;
        try {
            begDate = MapUtil.getString(paraMap, "begDate", MapUtil.NOT_NULL);
            endDate = MapUtil.getString(paraMap, "endDate", MapUtil.NOT_NULL);
            endDate = TimeUtil.getDateYYYY_MM_DD_HH_MM_SS(TimeUtil.dateAdd(TimeUtil.parseAnyDate(endDate), TimeUtil.UNIT_DAY, 1));
        } catch (Exception e) {
            e.printStackTrace();
            throw new MessageException(e.getMessage());
        }
        kqParamSetDao.updateAttShift(begDate, endDate);
    }
}
/*
 * private static Map<String,List<DepartmentBean>> dptMap = new HashMap<String,List<DepartmentBean>>();
	
	private static Set<String> keySet = new HashSet<String>();
	
	public void queryDpt(String pid) {
		List<DepartmentBean> departmentList = queryDepartmentByPId(pid);
		for(DepartmentBean departmentBean : departmentList) {
			List<DepartmentBean> dptList = dptMap.get("PID_"+departmentBean.getParentID());
			if(dptList != null) {
				dptList.add(departmentBean);
			}else { 
				dptList = new ArrayList<DepartmentBean>();
				dptList.add(departmentBean);
				dptMap.put("PID_"+departmentBean.getParentID(),dptList);
			}	
			queryDpt(departmentBean.getID());
		}
	}
 */
/*
 List<Map<String,Object>> oneList = new ArrayList<Map<String,Object>>();
		List<DepartmentBean> departmentList = queryDepartmentByPId("0");
		for(DepartmentBean departmentBean : departmentList) {
			//第一层
			Map<String,Object> beanMap = new HashMap<String,Object>();
			beanMap.put("depId", departmentBean.getID());
			beanMap.put("depName", departmentBean.getName());
			beanMap.put("depParentID",departmentBean.getParentID());
			beanMap.put("depOrderNum", departmentBean.getOrderNum());
			beanMap.put("employees",queryEmployeeBasic(departmentBean.getID(),"1"));//部门下的员工
			
			List<Map<String,Object>> twoList = new ArrayList<Map<String,Object>>();
			List<DepartmentBean> sonList = queryDepartmentByPId(departmentBean.getID());
			for(DepartmentBean bean : sonList) {
				//第二层
				Map<String,Object> twoMap = new HashMap<String,Object>();
				twoMap.put("depId", bean.getID());
				twoMap.put("depName", bean.getName());
				twoMap.put("depParentID",bean.getParentID());
				twoMap.put("depOrderNum", bean.getOrderNum());
				twoMap.put("employees",queryEmployeeBasic(departmentBean.getID(),"1"));//部门下的员工
				twoList.add(twoMap);
				
				List<Map<String,Object>> threeList = new ArrayList<Map<String,Object>>();
				List<DepartmentBean> sList = queryDepartmentByPId(bean.getID());
				for(DepartmentBean depBean : sList) {
					//第三层
					Map<String,Object> threeMap = new HashMap<String,Object>();
					threeMap.put("depId", depBean.getID());
					threeMap.put("depName", depBean.getName());
					threeMap.put("depParentID",depBean.getParentID());
					threeMap.put("depOrderNum", depBean.getOrderNum());
					threeMap.put("employees",queryEmployeeBasic(departmentBean.getID(),"1"));//部门下的员工
				}
				beanMap.put("sonDep", threeList);//子部门
			}
			
			beanMap.put("sonDep", twoList);//子部门
			oneList.add(beanMap);
		}
 */
/*
                Date targetDate =  TimeUtil.dateAdd(startDate, TimeUtil.UNIT_DAY, 7);
				//判断是否同月
				if(TimeUtil.dateEqualsDate(startDate,targetDate,2)) {
					//同月
					//取当前月第一天
					startDate = TimeUtil.getFirstDayOfMonth(startDate);
					//下月
					endDate = TimeUtil.dateAdd(startDate, TimeUtil.UNIT_MONTH, 1);
				}else {
					//不同月
					//下月第一天
					startDate = TimeUtil.getFirstDayOfMonth(targetDate);
					endDate = TimeUtil.dateAdd(startDate, TimeUtil.UNIT_MONTH, 1);
				}
 */
/*
 * public List<DepartmentBean> queryDepartmentByLevel(int level)throws
 * MessageException{ //查询父级目录 List<DepartmentBean> departmentList =
 * queryDepartmentByPId("0"); if(level == 1) {
 *
 * }else if(level == 2) { for(DepartmentBean departmentBean : departmentList) {
 * departmentBean.setChildren(queryDepartmentByPId(departmentBean.getID())); }
 * }else if(level == 3) { for(DepartmentBean departmentBean : departmentList) {
 * List<DepartmentBean> beanList = queryDepartmentByPId(departmentBean.getID());
 * for(DepartmentBean depBean : beanList) {
 * depBean.setChildren(queryDepartmentByPId(depBean.getID())); }
 * departmentBean.setChildren(beanList); } }else if(level == 4) {
 * for(DepartmentBean departmentBean : departmentList) { List<DepartmentBean>
 * beanList = queryDepartmentByPId(departmentBean.getID()); for(DepartmentBean
 * depBean : beanList) { List<DepartmentBean> list =
 * queryDepartmentByPId(depBean.getID()); for(DepartmentBean b : list) {
 * b.setChildren(queryDepartmentByPId(b.getID())); } depBean.setChildren(list);
 * } departmentBean.setChildren(beanList); } } return departmentList; }
 */
 