package com.jiubo.erp.kqgl.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jiubo.erp.common.Constant;
import com.jiubo.erp.common.MapUtil;
import com.jiubo.erp.common.MessageException;
import com.jiubo.erp.common.TimeUtil;
import com.jiubo.erp.erpLogin.util.ResponseMessageUtils;
import com.jiubo.erp.kqgl.bean.AttRuleTypeBean;
import com.jiubo.erp.kqgl.bean.PersonalKQBean;
import com.jiubo.erp.kqgl.service.KqParamSetService;
import com.jiubo.erp.kqgl.service.KqService;
import com.jiubo.erp.kqgl.vo.AttParam;
import com.jiubo.erp.kqgl.vo.DepartKQ;
import com.jiubo.erp.kqgl.vo.KqInfoResult;
import com.jiubo.erp.kqgl.vo.PunchRecord;
import com.jiubo.erp.rygl.controller.EmpController;
import com.quicksand.push.ToolClass;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/kqgl")
public class KqController {

    @Autowired
    private KqService service;

    public static Logger log = LoggerFactory.getLogger(EmpController.class);

    @Autowired
    private KqParamSetService kpService;

    /**
     * 公司考勤-修改
     *
     * @param request
     * @param response
     * @return
     * @throws ParseException
     */
    @SuppressWarnings("finally")
    @ResponseBody
    @RequestMapping(value = "/allFirmKQ")
    private JSONObject allEMPOfFirmKQList(HttpServletRequest request, HttpServletResponse response){
        AttParam ap = new AttParam();

        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str))
                throw new MessageException("参数接收失败！");
            ap = MapUtil.transJsonStrToObjectIgnoreCase(str, AttParam.class);

            result.put("resData", this.service.allEMPOfFirmKQList(ap));
        } catch (MessageException e) {
            retCode = Constant.Result.ERROR;
            retMsg = e.getMessage();
        } catch (Exception e) {
            retCode = Constant.Result.ERROR;
            retMsg = Constant.Result.ERROR_MSG;
            log.error(Constant.Result.RETMSG, e);
        } finally {
            result.put(Constant.Result.RETCODE, retCode);
            result.put(Constant.Result.RETMSG, retMsg);
            return result;
        }
    }


    /**
     * 部门考勤-修改
     *
     * @param request
     * @param response
     * @return
     * @throws ParseException
     */
    @SuppressWarnings("finally")
    @ResponseBody
    @RequestMapping(value = "/departOfFirmKQList")
    private JSONObject departOfFirmKQList(HttpServletRequest request, HttpServletResponse response){
        AttParam ap = new AttParam();

        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str))
                throw new MessageException("参数接收失败！");
            ap = MapUtil.transJsonStrToObjectIgnoreCase(str, AttParam.class);

            result.put("resData", this.service.departOfFirmKQList(ap));
        } catch (MessageException e) {
            retCode = Constant.Result.ERROR;
            retMsg = e.getMessage();
        } catch (Exception e) {
            retCode = Constant.Result.ERROR;
            retMsg = Constant.Result.ERROR_MSG;
            log.error(Constant.Result.RETMSG, e);
        } finally {
            result.put(Constant.Result.RETCODE, retCode);
            result.put(Constant.Result.RETMSG, retMsg);
            return result;
        }
    }


    /**
     * 部门考勤--双击单个部门考勤--修改
     *
     * @param request
     * @param response
     * @return
     * @throws ParseException
     */
    @SuppressWarnings("finally")
    @ResponseBody
    @RequestMapping(value = "/sdofkqList")
    private JSONObject singleDepartOfFirmKQList(HttpServletRequest request, HttpServletResponse response){
        AttParam ap = new AttParam();

        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str))
                throw new MessageException("参数接收失败！");
            ap = MapUtil.transJsonStrToObjectIgnoreCase(str, AttParam.class);

            result.put("resData", this.service.singleDepartOfFirmKQList(ap));
        } catch (MessageException e) {
            retCode = Constant.Result.ERROR;
            retMsg = e.getMessage();
        } catch (Exception e) {
            retCode = Constant.Result.ERROR;
            retMsg = Constant.Result.ERROR_MSG;
            log.error(Constant.Result.RETMSG, e);
        } finally {
            result.put(Constant.Result.RETCODE, retCode);
            result.put(Constant.Result.RETMSG, retMsg);
            return result;
        }
    }

    /**
     * 人员考勤----改
     *
     * @param request
     * @param response
     * @return
     * @throws ParseException
     */
    @SuppressWarnings("finally")
    @ResponseBody
    @RequestMapping(value = "/empkqList")
    private JSONObject empkqList(HttpServletRequest request, HttpServletResponse response){
        AttParam ap = new AttParam();

        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str))
                throw new MessageException("参数接收失败！");
            ap = MapUtil.transJsonStrToObjectIgnoreCase(str, AttParam.class);

            result.put("resData", this.service.empkqList(ap));
        } catch (MessageException e) {
            retCode = Constant.Result.ERROR;
            retMsg = e.getMessage();
        } catch (Exception e) {
            retCode = Constant.Result.ERROR;
            retMsg = Constant.Result.ERROR_MSG;
            log.error(Constant.Result.RETMSG, e);
        } finally {
            result.put(Constant.Result.RETCODE, retCode);
            result.put(Constant.Result.RETMSG, retMsg);
            return result;
        }
    }

    /**
     * 人员考勤统计报表----改
     *
     * @param request
     * @param response
     * @return
     * @throws ParseException
     */
    @SuppressWarnings("finally")
    @ResponseBody
    @RequestMapping(value = "/kqCountTable")
    private JSONObject kqCountTable(HttpServletRequest request, HttpServletResponse response){
        AttParam ap = new AttParam();

        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str))
                throw new MessageException("参数接收失败！");
            ap = MapUtil.transJsonStrToObjectIgnoreCase(str, AttParam.class);

            result.put("resData", this.service.kqCountTable(ap));
        } catch (MessageException e) {
            retCode = Constant.Result.ERROR;
            retMsg = e.getMessage();
        } catch (Exception e) {
            retCode = Constant.Result.ERROR;
            retMsg = Constant.Result.ERROR_MSG;
            log.error(Constant.Result.RETMSG, e);
        } finally {
            result.put(Constant.Result.RETCODE, retCode);
            result.put(Constant.Result.RETMSG, retMsg);
            return result;
        }
    }







    /**
     * 公司考勤
     *
     * @param request
     * @param response
     * @return
     * @throws ParseException
     */
    @SuppressWarnings("finally")
    @ResponseBody
    @RequestMapping(value = "/allKQBaseInfo")
    private JSONObject allKQInfo(HttpServletRequest request, HttpServletResponse response)
            throws ParseException {

        AttParam ap = new AttParam();

        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {

            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str))
                throw new MessageException("参数接收失败！");
            ap = MapUtil.transJsonStrToObjectIgnoreCase(str, AttParam.class);

            ap.setBeginDate(TimeUtil.YYYYMMDD_SHIFT_YYYYMMDDHHMMSSSSS(ap.getBeginDate()));

            List<KqInfoResult> kqInfoRes = this.service.selectKqInfoList(ap);

            result.put("resData", kqInfoRes);
        } catch (MessageException e) {
            retCode = Constant.Result.ERROR;
            retMsg = e.getMessage();
        } catch (Exception e) {
            retCode = Constant.Result.ERROR;
            retMsg = Constant.Result.ERROR_MSG;
            log.error(Constant.Result.RETMSG, e);
        } finally {
            result.put(Constant.Result.RETCODE, retCode);
            result.put(Constant.Result.RETMSG, retMsg);
            return result;
        }
    }

    /**
     * 公司考勤--->条件搜索
     *
     * @param request
     * @param response
     * @return
     */
    @SuppressWarnings("finally")
    @ResponseBody
    @RequestMapping(value = "/searchKQInfo")
    private JSONObject searchKQInfo(HttpServletRequest request, HttpServletResponse response) {

        AttParam ap = new AttParam();

        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {

            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str))
                throw new MessageException("参数接收失败！");
            ap = MapUtil.transJsonStrToObjectIgnoreCase(str, AttParam.class);

            ap.setBeginDate(TimeUtil.YYYYMMDD_SHIFT_YYYYMMDDHHMMSSSSS(ap.getBeginDate()));


            List<KqInfoResult> kqInfoRes = this.service.searchKqInfoList(ap);
			System.out.println("kqInfoRes"+kqInfoRes.size()+ ap.toString());
            if (kqInfoRes.size() < 1) {
                kqInfoRes = this.service.selectKqInfoList(ap);
            } else {
                kqInfoRes = kquClassTime(kqInfoRes);
            }
            result.put("resData", kqInfoRes);
        } catch (MessageException e) {
            retCode = Constant.Result.ERROR;
            retMsg = e.getMessage();
        } catch (Exception e) {
            retCode = Constant.Result.ERROR;
            retMsg = Constant.Result.ERROR_MSG;
            log.error(Constant.Result.RETMSG, e);
        } finally {
            result.put(Constant.Result.RETCODE, retCode);
            result.put(Constant.Result.RETMSG, retMsg);
            return result;
        }
    }

    /**
     * 将班次信息赋值给所有查询到的考勤人员
     *
     * @param kqInfoRes 考勤人员列表
     * @return
     */
    public List<KqInfoResult> kquClassTime(List<KqInfoResult> kqInfoRes) {
        try {
            for (int i = 0; i < kqInfoRes.size(); i++) {
                KqInfoResult kqInfoResult = kqInfoRes.get(i);
                // System.out.println("getClassTimeType"+kqInfoResult.getClassTimeType());
                if (StringUtils.isNotBlank(kqInfoResult.getShiftDate())&& ("1").equals(kqInfoResult.getClassTimeType())) {
//					System.out.println("getShiftDate" + kqInfoResult.getShiftDate());
                    PunchRecord pRecord = new PunchRecord();
                    pRecord.setYear(kqInfoResult.getShiftDate().substring(0, 4));
                    pRecord.setMonth(kqInfoResult.getShiftDate().substring(5, 7));
                    pRecord.setDay(kqInfoResult.getShiftDate().substring(8, 10));
                    pRecord.setAccountId(kqInfoResult.getAccountId());
                    // System.out.println("打卡参数"+pRecord.getYear()+"-"+pRecord.getMonth()+"-"+pRecord.getDay());

                    List<PunchRecord> prList = this.service.selectPunchRecordList(pRecord);
                    pRecord = prList.get(0);
                    if (prList.size() > 0 && pRecord != null) {
                        kqInfoResult.setFirstTime(pRecord.getMinAttTime());
                        kqInfoResult.setFirstTimeState(completForeKQInfo(pRecord.getMinAttTime(),
                                kqInfoResult.getStartTime(), kqInfoResult.getEndTime()));
                        kqInfoResult.setLastTime(pRecord.getMaxAttTime());
                        kqInfoResult.setLastTimeState(completAfterKQInfo(pRecord.getMaxAttTime(),
                                kqInfoResult.getStartTime(), kqInfoResult.getEndTime()));

                    } else {
                        kqInfoResult.setFirstTimeState("旷工");
                        kqInfoResult.setLastTimeState("旷工");
                    }

                } else {
                    kqInfoResult.setFirstTimeState(kqInfoResult.getClassTimeName());
                }
            }
//			System.out.println("kqInfoRes:" + kqInfoRes.size());
            return kqInfoRes;
        } catch (Exception e) {
            e.printStackTrace();
            return kqInfoRes;
        }
    }

    /**
     * 用来判断打卡时间在那个时间段 上班时间之前---------------返回1-------正常
     * 上班时间之后30分钟内-------返回2-------迟到 上班时间之后30-120分钟内---返回3-------旷工----------
     * 区间----------------------返回4-------上班打卡异常 |
     * 下班时间之前30-180分钟内---返回5-------旷工---------- 上班时间之前30分钟内-------返回6-------早退
     * 上班时间------------------返回7--------正常
     *
     * @param mTime     打卡时间
     * @param beginTime 班次的上班时间
     * @param endTime   下班时间
     * @return 上午
     */
    public String completForeKQInfo(String mTime, String beginTime, String endTime) {
        List<AttRuleTypeBean> aRuleList;
        Integer lateBegin = 0;// 迟到时间的起点
        Integer lateEnd = 0;// 迟到时间结束点
        Integer absentBegin = 0;// 旷工时间的起点
        Integer absentEnd = 0;// 旷工时间的结束点
        Integer punchExceptionBegin = 0;// 打卡异常时间的起点
        try {
            aRuleList = this.kpService.queryAttRuleType();

            for (AttRuleTypeBean attRuleTypeBean : aRuleList) {
                if (("迟到").equals(attRuleTypeBean.getName())) {
                    lateBegin = Integer.valueOf(attRuleTypeBean.getEarlyMinutes());
                    lateEnd = Integer.valueOf(attRuleTypeBean.getLateMinutes());
                }
                if (("旷工").equals(attRuleTypeBean.getName())) {
                    absentBegin = Integer.valueOf(attRuleTypeBean.getEarlyMinutes());
                    absentEnd = Integer.valueOf(attRuleTypeBean.getLateMinutes());
                }
                if (("打卡异常").equals(attRuleTypeBean.getName())) {
                    punchExceptionBegin = Integer.valueOf(attRuleTypeBean.getEarlyMinutes());

                }
            }
        } catch (MessageException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (ToolClass.compare_date(mTime, beginTime) <= 0) {
            return "正常";
        } else if (ToolClass.compare_date(mTime, beginTime) > 0
                && ToolClass.compare_date(mTime, ToolClass.strDateTimeShiftStr(beginTime, lateEnd)) <= 0) {
            return "迟到";
        } else if (ToolClass.compare_date(mTime, ToolClass.strDateTimeShiftStr(beginTime, lateEnd)) > 0
                && ToolClass.compare_date(mTime, ToolClass.strDateTimeShiftStr(beginTime, absentEnd)) <= 0) {
            return "旷工";
        } else {
            return "打卡异常";
        }
    }

    /**
     * 下午
     *
     * @param mTime
     * @param beginTime
     * @param endTime
     * @return
     */
    public String completAfterKQInfo(String mTime, String beginTime, String endTime) {
        List<AttRuleTypeBean> aRuleList;
        Integer lateBegin = 0;// 迟到时间的起点
        Integer lateEnd = 0;// 迟到时间结束点
        Integer absentBegin = 0;// 旷工时间的起点
        Integer absentEnd = 0;// 旷工时间的结束点
        Integer punchExceptionBegin = 0;// 打卡异常时间的起点
        try {
            aRuleList = this.kpService.queryAttRuleType();

            for (AttRuleTypeBean attRuleTypeBean : aRuleList) {
                if (("迟到").equals(attRuleTypeBean.getName())) {
                    lateBegin = Integer.valueOf(attRuleTypeBean.getEarlyMinutes());
                    lateEnd = Integer.valueOf(attRuleTypeBean.getLateMinutes());
                }else  if (("旷工").equals(attRuleTypeBean.getName())) {
                    absentBegin = Integer.valueOf(attRuleTypeBean.getEarlyMinutes());
                    absentEnd = Integer.valueOf(attRuleTypeBean.getLateMinutes());
                }else  if (("打卡异常").equals(attRuleTypeBean.getName())) {
                    punchExceptionBegin = Integer.valueOf(attRuleTypeBean.getEarlyMinutes());

                }
            }
        } catch (MessageException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (ToolClass.compare_date(mTime, ToolClass.strDateTimeShiftStr(endTime, -absentEnd)) <= 0) {
            return "打卡异常";
        } else if (ToolClass.compare_date(mTime, ToolClass.strDateTimeShiftStr(endTime, -absentEnd)) > 0
                && ToolClass.compare_date(mTime, ToolClass.strDateTimeShiftStr(endTime, -lateEnd)) <= 0) {
            return "旷工";
        } else if (ToolClass.compare_date(mTime, ToolClass.strDateTimeShiftStr(endTime, -lateEnd)) > 0
                && ToolClass.compare_date(mTime, endTime) < 0) {
            return "早退";
        } else {
            return "正常";
        }
    }

    /**
     * 部门考勤
     *
     * @param request
     * @param response
     * @return 返回值类型 List<DepartKQ>
     * @throws ParseException
     * @author 作者 mwl
     * @date 时间 2019年5月11日上午11:08:18
     */
    @SuppressWarnings("finally")
    @ResponseBody
    @RequestMapping(value = "/searchDepartKQList")
    private JSONObject departKQList(HttpServletRequest request, HttpServletResponse response)
            throws ParseException {

        AttParam ap = new AttParam();

        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {

            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str))
                throw new MessageException("参数接收失败！");
            ap = MapUtil.transJsonStrToObjectIgnoreCase(str, AttParam.class);

            ap.setBeginDate(TimeUtil.YYYYMMDD_SHIFT_YYYYMMDDHHMMSSSSS(ap.getBeginDate()));
//			ap.setEndDate(TimeUtil.YYYYMMDD_SHIFT_YYYYMMDDHHMMSSSSS(ap.getEndDate()));


            List<KqInfoResult> kqInfoRes = this.service.searchKqInfoList(ap);
//			System.out.println("kqTableList+kqInfoRes:" + kqInfoRes.size());

            List<DepartKQ> dpkqLsit = this.service.selectDepartKqInfoList(ap);
//			System.out.println("dpkqLsit:" + dpkqLsit.size());
            if (ap.getDepartName() != null && !ap.getDepartName().equals("")) {
                DepartKQ departKQ = new DepartKQ();
                dpkqLsit = new ArrayList<>();
                departKQ.setDepartKQName(ap.getDepartName());
                departKQ.setDownPA("0");
                departKQ.setLaterTimes("0");
                departKQ.setLeaveEarlyTimes("0");
                departKQ.setMinersTimes("0");
                departKQ.setOnPA("0");
                departKQ.setOverTimesDays("0");
                departKQ.setRestDays("0");
                dpkqLsit.add(departKQ);
            } else {
                for (DepartKQ dpKQ : dpkqLsit) {
                    dpKQ.setDownPA("0");
                    dpKQ.setLaterTimes("0");
                    dpKQ.setLeaveEarlyTimes("0");
                    dpKQ.setMinersTimes("0");
                    dpKQ.setOnPA("0");
                    dpKQ.setOverTimesDays("0");
                    dpKQ.setRestDays("0");
                }
            }

            // 查询班次数据为空时执行，返回基本信息
            if (kqInfoRes.size() > 0) {
                kqInfoRes = kquClassTime(kqInfoRes);
                dpkqLsit = selectDepartKqInfo(kqInfoRes, dpkqLsit);
            }
            result.put("resData", dpkqLsit);
        } catch (MessageException e) {
            retCode = Constant.Result.ERROR;
            retMsg = e.getMessage();
        } catch (Exception e) {
            retCode = Constant.Result.ERROR;
            retMsg = Constant.Result.ERROR_MSG;
            log.error(Constant.Result.RETMSG, e);
        } finally {
            result.put(Constant.Result.RETCODE, retCode);
            result.put(Constant.Result.RETMSG, retMsg);
            return result;
        }

    }

    /**
     * 部门考勤--->单个部门考勤
     *
     * @param request
     * @param response
     * @return 返回值类型 List<KqInfoResult>
     * @throws ParseException
     * @author 作者 mwl
     * @date 时间 2019年5月11日上午11:07:07
     */
    @SuppressWarnings("finally")
    @ResponseBody
    @RequestMapping(value = "/singleDepartKQList")
    private JSONObject singleDepartKQList(HttpServletRequest request, HttpServletResponse response)
            throws ParseException {

        AttParam ap = new AttParam();

        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {

            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str))
                throw new MessageException("参数接收失败！");
            ap = MapUtil.transJsonStrToObjectIgnoreCase(str, AttParam.class);

            ap.setBeginDate(TimeUtil.YYYYMMDD_SHIFT_YYYYMMDDHHMMSSSSS(ap.getBeginDate()));
//			ap.setEndDate(TimeUtil.YYYYMMDD_SHIFT_YYYYMMDDHHMMSSSSS(ap.getEndDate()));

            List<KqInfoResult> kqInfoRes = this.service.searchKqInfoList(ap);
//			System.out.println("---班型测试kqInfoRes----" + kqInfoRes.size() + ap.getEndDate() + ap.getBeginDate());

            // 查询班次数据为空时执行，返回基本信息
            if (kqInfoRes.size() < 1) {
                kqInfoRes = this.service.selectKqInfoList(ap);

            } else {
                kqInfoRes = kquClassTime(kqInfoRes);
            }
            result.put("resData", kqInfoRes);
        } catch (MessageException e) {
            retCode = Constant.Result.ERROR;
            retMsg = e.getMessage();
        } catch (Exception e) {
            retCode = Constant.Result.ERROR;
            retMsg = Constant.Result.ERROR_MSG;
            log.error(Constant.Result.RETMSG, e);
        } finally {
            result.put(Constant.Result.RETCODE, retCode);
            result.put(Constant.Result.RETMSG, retMsg);
            return result;
        }

    }

    /**
     * 部门考勤--->单个部门考勤--->个人考勤统计
     *
     * @param dpkqLsit      部门列表
     * @param kqInfoResults
     * @return
     */
    public List<DepartKQ> selectDepartKqInfo(List<KqInfoResult> kqInfoResults, List<DepartKQ> dpkqLsit) {

        for (DepartKQ dp : dpkqLsit) {
            for (KqInfoResult ryKQ : kqInfoResults) {
                if (ryKQ.getDepartname().equals(dp.getDepartKQName())) {
                    if (("2").equals(ryKQ.getClassTimeType())) {
                        dp.setRestDays(String.valueOf(Integer.valueOf(dp.getRestDays()) + 1));
                    } else {
                        String upStatus = ryKQ.getFirstTimeState();
                        String downStatus = ryKQ.getLastTimeState();

                        if (("迟到").equals(upStatus)) {
                            dp.setLaterTimes(String.valueOf(Integer.valueOf(dp.getLaterTimes()) + 1));
                        }else  if (("早退").equals(upStatus)) {
                            dp.setLeaveEarlyTimes(String.valueOf(Integer.valueOf(dp.getLeaveEarlyTimes()) + 1));
                        }else  if (("旷工").equals(upStatus) || ("旷工").equals(downStatus)) {
                            dp.setMinersTimes(String.valueOf(Integer.valueOf(dp.getMinersTimes()) + 1));
                        }else  if (("打卡异常").equals(upStatus)) {
                            dp.setOnPA(String.valueOf(Integer.valueOf(dp.getOnPA()) + 1));
                        }else  if(("打卡异常").equals(downStatus)) {
                            dp.setDownPA(String.valueOf(Integer.valueOf(dp.getDownPA()) + 1));
                        }
                    }

                }
            }
        }

        return dpkqLsit;
    }

    /**
     * 个人考勤
     *
     * @param request
     * @param response
     * @return
     * @throws ParseException
     */
    @SuppressWarnings("finally")
    @ResponseBody
    @RequestMapping(value = "/singleKQList")
    private JSONObject singleKQList(HttpServletRequest request, HttpServletResponse response)
            throws ParseException {
        AttParam ap = new AttParam();

        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {

            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str))
                throw new MessageException("参数接收失败！");
            ap = MapUtil.transJsonStrToObjectIgnoreCase(str, AttParam.class);

            ap.setBeginDate(TimeUtil.YYYYMMDD_SHIFT_YYYYMMDDHHMMSSSSS(ap.getBeginDate()));
//			ap.setEndDate(TimeUtil.YYYYMMDD_SHIFT_YYYYMMDDHHMMSSSSS(ap.getEndDate()));

            List<KqInfoResult> kqInfoRes = this.service.searchKqInfoList(ap);
//			System.out.println("---班型测试singleKQList----" + kqInfoRes.size() + ap.getEndDate() + ap.getBeginDate()+ap.toString());

            // 查询班次数据为空时执行，返回基本信息
            if (kqInfoRes.size() < 1) {
                kqInfoRes = this.service.selectKqInfoList(ap);
            } else {
                kqInfoRes = kquClassTime(kqInfoRes);
            }
            result.put("resData", kqInfoRes);
        } catch (MessageException e) {
            retCode = Constant.Result.ERROR;
            retMsg = e.getMessage();
        } catch (Exception e) {
            retCode = Constant.Result.ERROR;
            retMsg = Constant.Result.ERROR_MSG;
            log.error(Constant.Result.RETMSG, e);
        } finally {
            result.put(Constant.Result.RETCODE, retCode);
            result.put(Constant.Result.RETMSG, retMsg);
            return result;
        }

    }

    /**
     * 人员考勤
     *
     * @param request
     * @param response
     * @return
     * @throws ParseException
     */
    @SuppressWarnings("finally")
    @ResponseBody
    @RequestMapping(value = "/ryKQList")
    private JSONObject ryKQList(HttpServletRequest request, HttpServletResponse response)
            throws ParseException {


        AttParam ap = new AttParam();

        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {

            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str))
                throw new MessageException("参数接收失败！");
            ap = MapUtil.transJsonStrToObjectIgnoreCase(str, AttParam.class);

            ap.setBeginDate(TimeUtil.YYYYMMDD_SHIFT_YYYYMMDDHHMMSSSSS(ap.getBeginDate()));
//			ap.setEndDate(TimeUtil.YYYYMMDD_SHIFT_YYYYMMDDHHMMSSSSS(ap.getEndDate()));


            List<PersonalKQBean> rykqLsit = new ArrayList<>();


            List<KqInfoResult> kqInfoRes = this.service.selectKqInfoList(ap);
            System.out.println("kqInfoRes:" + kqInfoRes.size() + ap.toString());
            for (KqInfoResult kqInfoResult : kqInfoRes) {
                PersonalKQBean pKqBean = new PersonalKQBean();
                pKqBean.setRyKQName(kqInfoResult.getName());
                pKqBean.setRyPositionKQName(kqInfoResult.getDepartname());
                pKqBean.setRyJobNum(kqInfoResult.getJobNum());
                pKqBean.setRyPositionKQName(kqInfoResult.getPositionName());
                pKqBean.setRyDepartKQId(kqInfoResult.getDepartId());
                pKqBean.setRyDepartKQName(kqInfoResult.getDepartname());
                pKqBean.setRyLaterTimes("0");
                pKqBean.setRyLeaveEarlyTimes("0");
                pKqBean.setRyMinersTimes("0");
                pKqBean.setRyOnNomalPA("0");
                pKqBean.setRyDownNomalPA("0");
                pKqBean.setRyOnPA("0");
                pKqBean.setRyDownPA("0");
                pKqBean.setRyRestDays("0");
                pKqBean.setRyOverTimesDays("0");
                rykqLsit.add(pKqBean);
            }

            kqInfoRes = this.service.searchKqInfoList(ap);
            // 查询班次数据为空时执行，返回基本信息
            if (kqInfoRes.size() > 1) {
                kqInfoRes = kquClassTime(kqInfoRes);
                rykqLsit = selectRYKqInfo(kqInfoRes, rykqLsit);
            }
            result.put("resData", rykqLsit);
        } catch (MessageException e) {
            retCode = Constant.Result.ERROR;
            retMsg = e.getMessage();
        } catch (Exception e) {
            retCode = Constant.Result.ERROR;
            retMsg = Constant.Result.ERROR_MSG;
            log.error(Constant.Result.RETMSG, e);
        } finally {
            result.put(Constant.Result.RETCODE, retCode);
            result.put(Constant.Result.RETMSG, retMsg);
            return result;
        }
    }

    /**
     * 人员的考勤--->单个人员
     *
     * @param request
     * @param response
     * @return 返回值类型 List<KqInfoResult>
     * @throws ParseException
     * @author 作者 mwl
     * @date 时间 2019年5月10日下午4:40:33
     */
    @SuppressWarnings("finally")
    @ResponseBody
    @RequestMapping(value = "/singleRYKQList")
    private JSONObject singleRYKQList(HttpServletRequest request, HttpServletResponse response)
            throws ParseException {


        AttParam ap = new AttParam();

        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {

            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str))
                throw new MessageException("参数接收失败！");
            ap = MapUtil.transJsonStrToObjectIgnoreCase(str, AttParam.class);

            ap.setBeginDate(TimeUtil.YYYYMMDD_SHIFT_YYYYMMDDHHMMSSSSS(ap.getBeginDate()));


            List<KqInfoResult> kqInfoRes = this.service.searchKqInfoList(ap);
            System.out.println("kqInfoRes:" + kqInfoRes.size() + ap.toString());
            // 查询班次数据为空时执行，返回基本信息
//			if (kqInfoRes.size() < 1) {
//				kqInfoRes = this.service.selectKqInfoList(ap);
////				
//			} else {
//				kqInfoRes = kquClassTime(kqInfoRes);
//			}
            result.put("resData", kqInfoRes);
        } catch (MessageException e) {
            retCode = Constant.Result.ERROR;
            retMsg = e.getMessage();
        } catch (Exception e) {
            retCode = Constant.Result.ERROR;
            retMsg = Constant.Result.ERROR_MSG;
            log.error(Constant.Result.RETMSG, e);
        } finally {
            result.put(Constant.Result.RETCODE, retCode);
            result.put(Constant.Result.RETMSG, retMsg);
            return result;
        }


    }

    /**
     * 人员的考勤--->单个人员--->考勤汇总
     *
     * @param rykqLsit      部门列表
     * @param kqInfoResults
     * @return
     */
    public List<PersonalKQBean> selectRYKqInfo(List<KqInfoResult> kqInfoResults, List<PersonalKQBean> rykqLsit) {

        for (PersonalKQBean ry : rykqLsit) {
            for (KqInfoResult ryKQ : kqInfoResults) {
                if (ryKQ.getName().equals(ry.getRyKQName())) {
                    if (("2").equals(ryKQ.getClassTimeType())) {
                        ry.setRyRestDays(String.valueOf(Integer.valueOf(ry.getRyRestDays()) + 1));
                    } else {
                        String upStatus = ryKQ.getFirstTimeState();
                        String downStatus = ryKQ.getLastTimeState();
//						System.out.println("upStatus:" + upStatus + "downStatus:" + downStatus);
                        if (("迟到").equals(upStatus)) {
                            ry.setRyLaterTimes(String.valueOf(Integer.valueOf(ry.getRyLaterTimes()) + 1));
                        }else if(("早退").equals(upStatus)) {
                            ry.setRyLeaveEarlyTimes(String.valueOf(Integer.valueOf(ry.getRyLaterTimes()) + 1));
                        }else 
                        if (("旷工").equals(upStatus) || ("旷工").equals(downStatus)) {
                            ry.setRyMinersTimes(String.valueOf(Integer.valueOf(ry.getRyMinersTimes()) + 1));
                        }else 
                        if (("打卡异常").equals(upStatus)) {
                            ry.setRyOnPA(String.valueOf(Integer.valueOf(ry.getRyOnPA()) + 1));
                        }else 
                        if (("打卡异常").equals(downStatus)) {
                            ry.setRyDownPA(String.valueOf(Integer.valueOf(ry.getRyDownPA()) + 1));
                        }else 
                        if (("正常").equals(upStatus)) {
                            ry.setRyOnNomalPA(String.valueOf(Integer.valueOf(ry.getRyOnNomalPA()) + 1));
                        }else 
                        if (("正常").equals(downStatus)) {
                            ry.setRyDownNomalPA(String.valueOf(Integer.valueOf(ry.getRyDownNomalPA()) + 1));
                        }
                    }

                }
            }
        }

        return rykqLsit;
    }

    /**
     * 考勤报表
     *
     * @param request
     * @param response
     * @return 返回值类型 List<PersonalKQBean>
     * @author 作者 mwl
     * @date 时间 2019年5月11日上午11:02:59
     */
    @SuppressWarnings("finally")
    @ResponseBody
    @RequestMapping(value = "/kqTableList")
    private JSONObject kqTableList(HttpServletRequest request, HttpServletResponse response) {

        AttParam ap = new AttParam();

        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {

            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str))
                throw new MessageException("参数接收失败！");
            ap = MapUtil.transJsonStrToObjectIgnoreCase(str, AttParam.class);

            ap.setBeginDate(TimeUtil.YYYYMMDD_SHIFT_YYYYMMDDHHMMSSSSS(ap.getBeginDate()));

            List<PersonalKQBean> rykqLsit = new ArrayList<>();

            System.out.println("kqTableList:" + ap.toString());
            List<KqInfoResult> kqInfoRes = this.service.selectKqInfoList(ap);
            System.out.println("kqTableList:" + kqInfoRes.size() + ap.toString());
            for (KqInfoResult kqInfoResult : kqInfoRes) {
                PersonalKQBean pKqBean = new PersonalKQBean();
                pKqBean.setRyKQId(kqInfoResult.getuId());
                pKqBean.setRyKQName(kqInfoResult.getName());
                pKqBean.setRyPositionKQName(kqInfoResult.getDepartname());
                pKqBean.setRyJobNum(kqInfoResult.getJobNum());
                pKqBean.setRyPositionKQName(kqInfoResult.getPositionName());
                pKqBean.setRyDepartKQId(kqInfoResult.getDepartId());
                pKqBean.setRyDepartKQName(kqInfoResult.getDepartname());
                pKqBean.setRyLaterTimes("0");
                pKqBean.setRyLeaveEarlyTimes("0");
                pKqBean.setRyMinersTimes("0");
                pKqBean.setRyOnNomalPA("0");
                pKqBean.setRyDownNomalPA("0");
                pKqBean.setRyOnPA("0");
                pKqBean.setRyDownPA("0");
                pKqBean.setRyRestDays("0");
                rykqLsit.add(pKqBean);
            }


            kqInfoRes = this.service.kqTableInfoList(ap);
            // System.out.println("---班型测试kqInfoRes----："+kqr.getDepartname());
            // System.out.println("---班型测试kqInfoRes----："+kqInfoRes.size());
            // System.out.println("---班型测试kqInfoRes----："+kqr.getEndDate());
            // System.out.println("---班型测试kqInfoRes----："+kqr.getStartDate());

            // 查询班次数据为空时执行，返回基本信息
            if (kqInfoRes.size() > 0) {
                kqInfoRes = kquClassTime(kqInfoRes);
                rykqLsit = selectKqTableInfo(kqInfoRes, rykqLsit);
                // System.out.println("dpkqLsit2:"+kqInfoRes.size());
            }
            result.put("resData", rykqLsit);
        } catch (MessageException e) {
            retCode = Constant.Result.ERROR;
            retMsg = e.getMessage();
        } catch (Exception e) {
            retCode = Constant.Result.ERROR;
            retMsg = Constant.Result.ERROR_MSG;
            log.error(Constant.Result.RETMSG, e);
        } finally {
            result.put(Constant.Result.RETCODE, retCode);
            result.put(Constant.Result.RETMSG, retMsg);
            return result;
        }

    }

    /**
     * 考勤报表--->个人考勤
     *
     * @param kqInfoResults
     * @param rykqLsit
     * @return 返回值类型 List<PersonalKQBean>
     * @author 作者 mwl
     * @date 时间 2019年5月11日下午1:52:22
     */
    public List<PersonalKQBean> selectKqTableInfo(List<KqInfoResult> kqInfoResults, List<PersonalKQBean> rykqLsit) {

        for (PersonalKQBean ry : rykqLsit) {
            List<Map<String, String>> ryList = new ArrayList<>();
            Map<String, String> ryMap;
            for (KqInfoResult ryKQ : kqInfoResults) {
                ryMap = new HashMap<>();
                if (ryKQ.getuId().equals(ry.getRyKQId())) {

                    String upAndDownTime;
                    if (!StringUtils.isEmpty(ryKQ.getClassTimeType()) && ("2").equals(ryKQ.getClassTimeType())) {
                        upAndDownTime = ryKQ.getClassTimeName();
                        try {
                            if (upAndDownTime == null) {
                                upAndDownTime = "";
                            }
                            ryMap.put("dateTime",
                                    TimeUtil.getDateMM_DD(TimeUtil.parseDateYYYY_MM_DD(ryKQ.getYYYYMMDD())));
                            ryMap.put("punchTime", upAndDownTime);
                        } catch (ParseException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        } catch (Exception e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    } else if (!StringUtils.isEmpty(ryKQ.getClassTimeType()) && ("1").equals(ryKQ.getClassTimeType())) {

                        String upStatus = ryKQ.getFirstTimeState();
                        String downStatus = ryKQ.getLastTimeState();
                        try {
                            if (ryKQ.getShiftDate() != null) {
                                if (ryKQ.getFirstTime() != null) {
                                    upAndDownTime = TimeUtil.getDateHH_MM_SS(
                                            TimeUtil.parseDateYYYY_MM_DD_HH_MM_SS_SSS(ryKQ.getFirstTime())) + "-"
                                            + TimeUtil.getDateHH_MM_SS(
                                            TimeUtil.parseDateYYYY_MM_DD_HH_MM_SS_SSS(ryKQ.getEndTime()));
                                } else {
                                    upAndDownTime = "当日未打卡";
                                }
                                ryMap.put("dateTime",
                                        TimeUtil.getDateMM_DD(TimeUtil.parseDateYYYY_MM_DD(ryKQ.getYYYYMMDD())));
                                ryMap.put("punchTime", upAndDownTime);
                            }
                        } catch (ParseException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        } catch (Exception e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
//						System.out.println("upStatus:" + upStatus + "downStatus:" + downStatus);
                        if (("迟到").equals(upStatus)) {
                            ry.setRyLaterTimes(String.valueOf(Integer.valueOf(ry.getRyLaterTimes()) + 1));
                        }else
                        if (("早退").equals(upStatus)) {
                            ry.setRyLeaveEarlyTimes(String.valueOf(Integer.valueOf(ry.getRyLaterTimes()) + 1));
                        }else
                        if (("旷工").equals(upStatus) || ("旷工").equals(downStatus)) {
                            ry.setRyMinersTimes(String.valueOf(Integer.valueOf(ry.getRyMinersTimes()) + 1));
                        }else
                        if (("打卡异常").equals(upStatus) || ("打卡异常").equals(downStatus)) {
                            ry.setRyOnPA(String.valueOf(Integer.valueOf(ry.getRyOnPA()) + 1));
                        }
                    } else {
                        upAndDownTime = ryKQ.getClassTimeName();
                        try {
                            if (upAndDownTime == null) {
                                upAndDownTime = "未排班";
                            }
                            ryMap.put("dateTime",
                                    TimeUtil.getDateMM_DD(TimeUtil.parseDateYYYY_MM_DD(ryKQ.getYYYYMMDD())));
                            ryMap.put("punchTime", upAndDownTime);
                        } catch (ParseException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        } catch (Exception e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                    ryList.add(ryMap);
                }
            }
            ry.setPunchTime(ryList);
        }

        return rykqLsit;
    }

    /**
     * 考勤统计报表
     *
     * @param request
     * @param response
     * @return 返回值类型 JSONObject
     * @author 作者 mwl
     * @date 时间 2019年5月17日上午9:30:03
     */
    @SuppressWarnings("finally")
    @RequestMapping(value = "/kqTableCountList")
    @ResponseBody
    private JSONObject kqTableCountList(HttpServletRequest request, HttpServletResponse response) {

        AttParam ap = new AttParam();

        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str))
                throw new MessageException("参数接收失败！");
            ap = MapUtil.transJsonStrToObjectIgnoreCase(str, AttParam.class);

            ap.setBeginDate(TimeUtil.YYYYMMDD_SHIFT_YYYYMMDDHHMMSSSSS(ap.getBeginDate()));

            List<PersonalKQBean> rykqLsit = new ArrayList<>();

            List<KqInfoResult> kqInfoRes = this.service.selectKqInfoList(ap);
            for (KqInfoResult kqInfoResult : kqInfoRes) {
                PersonalKQBean pKqBean = new PersonalKQBean();
                pKqBean.setRyKQId(kqInfoResult.getuId());
                pKqBean.setRyKQName(kqInfoResult.getName());
                pKqBean.setRyPositionKQName(kqInfoResult.getDepartname());
                pKqBean.setRyJobNum(kqInfoResult.getJobNum());
                pKqBean.setRyPositionKQName(kqInfoResult.getPositionName());
                pKqBean.setRyDepartKQId(kqInfoResult.getDepartId());
                pKqBean.setRyDepartKQName(kqInfoResult.getDepartname());
                pKqBean.setBeginDate(ap.getBeginDate());
                pKqBean.setEndDate(ap.getEndDate());
                pKqBean.setRyLaterTimes("0");
                pKqBean.setRyLeaveEarlyTimes("0");
                pKqBean.setRyMinersTimes("0");
                pKqBean.setRyOnNomalPA("0");
                pKqBean.setRyDownNomalPA("0");
                pKqBean.setRyOnPA("0");
                pKqBean.setRyDownPA("0");
                pKqBean.setRyRestDays("0");
                pKqBean.setRyNoScheduleTimes("0");
                pKqBean.setRyEnteryTime(kqInfoResult.getEntryDate() + "入职");
                pKqBean.setRyLeaveTime(kqInfoResult.getResignDate() + "离职");
                rykqLsit.add(pKqBean);
            }

            kqInfoRes = this.service.kqTableInfoList(ap);
            System.out.println("kqInfoRes:" + kqInfoRes.size() + "--" + "rykqLsit:" + rykqLsit.size() + ap.toString());
            // 查询班次数据为空时执行，返回基本信息
            if (kqInfoRes.size() > 0) {
                kqInfoRes = kquClassTime(kqInfoRes);
                rykqLsit = selectKqTableCountInfo(kqInfoRes, rykqLsit);
            }
            System.out.println("kqInfoRes:" + kqInfoRes.size() + "--" + "rykqLsit:" + rykqLsit.size() + ap.toString());
            result.put("resData", rykqLsit);
        } catch (MessageException e) {
            retCode = Constant.Result.ERROR;
            retMsg = e.getMessage();
        } catch (Exception e) {
            retCode = Constant.Result.ERROR;
            retMsg = Constant.Result.ERROR_MSG;
            log.error(Constant.Result.RETMSG, e);
        } finally {
            result.put(Constant.Result.RETCODE, retCode);
            result.put(Constant.Result.RETMSG, retMsg);
            return result;
        }

    }

    /**
     * 考勤报表统计--->个人数据统计
     *
     * @param kqInfoResults
     * @param rykqLsit
     * @return 返回值类型 List<PersonalKQBean>
     * @throws ParseException
     * @throws NumberFormatException
     * @author 作者 mwl
     * @date 时间 2019年5月17日上午11:27:22
     */
    public List<PersonalKQBean> selectKqTableCountInfo(List<KqInfoResult> kqInfoResults, List<PersonalKQBean> rykqLsit)
            throws NumberFormatException, ParseException {

        for (PersonalKQBean ry : rykqLsit) {
            for (KqInfoResult ryKQ : kqInfoResults) {
                // 查询的开始时间要<=结束时间

                if (ryKQ.getuId().equals(ry.getRyKQId())
                        && ToolClass.compare_date(ry.getBeginDate(), ry.getEndDate()) <= 0) {
                    // 入职时间在开始和结束时间之前
//					 System.out.println("selectKqTableCountInfo-----getEntryDate:"+ryKQ.getEntryDate()+ry.getBeginDate());
                    if (StringUtils.isNotBlank(ryKQ.getEntryDate())
                            && ToolClass.compare_date(ryKQ.getEntryDate(), ry.getBeginDate()) <= 0) {
                        // 离职时间在结束时间之后或者为null=在职
                        // System.out.println("selectKqTableCountInfo-----3");
                        if (StringUtils.isBlank(ryKQ.getResignDate())
                                || ToolClass.compare_date(ryKQ.getResignDate(), ry.getEndDate()) >= 0) {
                            // System.out.println("selectKqTableCountInfo-----4");
                            ry = this.countKQTimes(ry, ryKQ);
                            // 离职时间在开始和结束时间中间
                        } else if (StringUtils.isNotBlank(ryKQ.getResignDate())
                                && ToolClass.compare_date(ryKQ.getResignDate(), ry.getEndDate()) < 0
                                && ToolClass.compare_date(ryKQ.getResignDate(), ry.getBeginDate()) >= 0) {
                            if (ToolClass.compare_date(TimeUtil.YYYYMMDD_SHIFT_YYYYMMDDHHMMSSSSS(ryKQ.getYYYYMMDD()),
                                    ryKQ.getResignDate()) <= 0) {
                                ry = this.countKQTimes(ry, ryKQ);
                            }
                        }

                        // 入职时间在开始和结束时间中间
                    } else if (StringUtils.isNotBlank(ryKQ.getEntryDate())
                            && ToolClass.compare_date(ryKQ.getEntryDate(), ry.getBeginDate()) > 0
                            && ToolClass.compare_date(ryKQ.getEntryDate(), ry.getEndDate()) <= 0) {
                        // 离职时间在结束时间之后或者为null=在职
                        ry.setKqTableCount(ryKQ.getEntryDate() + "入职");
                        if (StringUtils.isBlank(ryKQ.getResignDate())
                                || ToolClass.compare_date(ryKQ.getResignDate(), ry.getEndDate()) >= 0) {
                            if (ToolClass.compare_date(TimeUtil.YYYYMMDD_SHIFT_YYYYMMDDHHMMSSSSS(ryKQ.getYYYYMMDD()),
                                    ryKQ.getEntryDate()) >= 0) {
                                ry = this.countKQTimes(ry, ryKQ);
                            }
                            // 离职时间在开始和结束时间中间
                        } else if (StringUtils.isNotBlank(ryKQ.getResignDate())
                                && ToolClass.compare_date(ryKQ.getResignDate(), ry.getEndDate()) < 0
                                && ToolClass.compare_date(ryKQ.getResignDate(), ry.getBeginDate()) >= 0) {
                            if (ToolClass.compare_date(TimeUtil.YYYYMMDD_SHIFT_YYYYMMDDHHMMSSSSS(ryKQ.getYYYYMMDD()),
                                    ryKQ.getEntryDate()) >= 0
                                    && ToolClass.compare_date(
                                    TimeUtil.YYYYMMDD_SHIFT_YYYYMMDDHHMMSSSSS(ryKQ.getYYYYMMDD()),
                                    ryKQ.getResignDate()) <= 0) {
                                ry = this.countKQTimes(ry, ryKQ);
                            }
                        }

                    } else {
                        ry.setKqTableCount("全勤");
                    }
                }
            }
//			System.out.println("getRyLaterTimes-----8" + ry.getRyLaterTimes() + "--" + ry.getRyNoScheduleTimes() + "--"
//					+ ry.getRyLeaveEarlyTimes() + "--" + ry.getRyMinersTimes() + "--"
//					+ Integer.valueOf(ry.getRyOnPA()));
            if (Integer.valueOf(ry.getRyLaterTimes()) > 0) {
//				System.out.println("getRyLaterTimes-----8");
                if (StringUtils.isNotBlank(ry.getKqTableCount())) {
                    ry.setKqTableCount(ry.getKqTableCount() + "," + ry.getRyLaterTimes() + "次迟到");
                } else {
                    ry.setKqTableCount(ry.getRyLaterTimes() + "次迟到");
                }
            }
            if (Integer.valueOf(ry.getRyLeaveEarlyTimes()) > 0) {
                if (StringUtils.isNotBlank(ry.getKqTableCount())) {
                    ry.setKqTableCount(ry.getKqTableCount() + "," + ry.getRyLeaveEarlyTimes() + "次早退");
                } else {
                    ry.setKqTableCount(ry.getRyLeaveEarlyTimes() + "次早退");
                }
            }
            if (Integer.valueOf(ry.getRyMinersTimes()) > 0) {
                if (StringUtils.isNotBlank(ry.getKqTableCount())) {
                    ry.setKqTableCount(ry.getKqTableCount() + "," + ry.getRyMinersTimes() + "次旷工");
                } else {
                    ry.setKqTableCount(ry.getRyMinersTimes() + "次旷工");
                }
            }
            if (Integer.valueOf(ry.getRyOnPA()) > 0) {
                if (StringUtils.isNotBlank(ry.getKqTableCount())) {
                    ry.setKqTableCount(ry.getKqTableCount() + "," + ry.getRyMinersTimes() + "次打卡异常");
                } else {
                    ry.setKqTableCount(ry.getRyMinersTimes() + "次打卡异常");
                }
            }
            if (Integer.valueOf(ry.getRyNoScheduleTimes()) > 0) {
//				System.out.println("getRyNoScheduleTimes-----8" + "--" + ry.getRyNoScheduleTimes());
                if (StringUtils.isNotBlank(ry.getKqTableCount())) {
//					System.out.println("getRyNoScheduleTimes-----9-1" + "--" + ry.getKqTableCount());
                    ry.setKqTableCount(ry.getKqTableCount() + "," + ry.getRyNoScheduleTimes() + "次未排班");
                } else {
//					System.out.println("getRyNoScheduleTimes-----9-2" + "--" + ry.getRyNoScheduleTimes());
                    ry.setKqTableCount(ry.getRyNoScheduleTimes() + "次未排班");
//					System.out.println("getRyNoScheduleTimes-----9-3" + "--" + ry.getKqTableCount());
                }
            }
            if (Integer.valueOf(ry.getRyLaterTimes()) == 0 && Integer.valueOf(ry.getRyLeaveEarlyTimes()) == 0
                    && Integer.valueOf(ry.getRyMinersTimes()) == 0 && Integer.valueOf(ry.getRyOnPA()) == 0
                    && Integer.valueOf(ry.getRyNoScheduleTimes()) == 0) {
                ry.setKqTableCount("全勤");
            }
        }

        return rykqLsit;
    }

    /**
     * 通过考勤的基本信息计算迟到、早退、打卡异常等的次数
     *
     * @param ry   PersonalKQBean
     * @param ryKQ KqInfoResult
     * @return 返回值类型 PersonalKQBean
     * @author 作者 mwl
     * @date 时间 2019年6月10日下午4:52:05
     */
    private PersonalKQBean countKQTimes(PersonalKQBean ry, KqInfoResult ryKQ) {
        if (StringUtils.isNotBlank(ryKQ.getClassTimeType()) && ("2").equals(ryKQ.getClassTimeType())) {
            ry.setRyRestDays(String.valueOf(Integer.valueOf(ry.getRyRestDays()) + 1));
        } else if (StringUtils.isNotBlank(ryKQ.getClassTimeType()) && ("1").equals(ryKQ.getClassTimeType())) {
            // System.out.println("selectKqTableCountInfo-----5");
            String upStatus = ryKQ.getFirstTimeState();
            String downStatus = ryKQ.getLastTimeState();
//			System.out.println("upStatus:" + upStatus + "downStatus:" + downStatus);
            if (("迟到").equals(upStatus)) {
                ry.setRyLaterTimes(String.valueOf(Integer.valueOf(ry.getRyLaterTimes()) + 1));
            }else 
            if (("早退").equals(upStatus)) {
                ry.setRyLeaveEarlyTimes(String.valueOf(Integer.valueOf(ry.getRyLaterTimes()) + 1));
            }else 
            if (("旷工").equals(upStatus) || ("旷工").equals(downStatus)) {
                ry.setRyMinersTimes(String.valueOf(Integer.valueOf(ry.getRyMinersTimes()) + 1));
            }else 
            if (("打卡异常").equals(upStatus)) {
                ry.setRyOnPA(String.valueOf(Integer.valueOf(ry.getRyOnPA()) + 1));
            }else 
            if (("打卡异常").equals(downStatus)) {
                ry.setRyDownPA(String.valueOf(Integer.valueOf(ry.getRyDownPA()) + 1));
            }else 
            if (("正常").equals(upStatus)) {
                ry.setRyOnNomalPA(String.valueOf(Integer.valueOf(ry.getRyOnNomalPA()) + 1));
            }else 
            if (("正常").equals(downStatus)) {
                ry.setRyDownNomalPA(String.valueOf(Integer.valueOf(ry.getRyDownNomalPA()) + 1));
            }
        } else {
            ry.setRyNoScheduleTimes(String.valueOf(Integer.valueOf(ry.getRyNoScheduleTimes()) + 1));
        }
        return ry;
    }

    /**
     * 部门考勤考勤的全部信息
     *
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/departKQList")
    private List<KqInfoResult> departKQList1(HttpServletRequest request, HttpServletResponse response) {

        try {
            // List<KqInfoResult> kqList = this.service.selectKqInfoList(request);
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            ResponseMessageUtils.responseMessage(response, "查询错误,请重试!");
            return null;
        }
    }

}
