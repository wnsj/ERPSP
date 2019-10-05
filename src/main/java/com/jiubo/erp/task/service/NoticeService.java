package com.jiubo.erp.task.service;

import com.alibaba.fastjson.JSONObject;
import com.jiubo.erp.common.Constant;
import com.jiubo.erp.common.InstantContextAfterProcessor;
import com.jiubo.erp.config.ScheduleConfig;
import com.jiubo.erp.task.dao.NoticeDao;
import com.jiubo.erp.webSocket.service.CustomWebSocketService;
import com.jiubo.erp.wzbg.bean.ComputerManageBean;
import com.jiubo.erp.wzbg.service.ComputerManageService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.Query;
import javax.websocket.Session;
import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @desc:
 * @date: 2019-08-26 11:53
 * @author: dx
 * @version: 1.0
 */
@Component
public class NoticeService {

    private final static Logger log = LoggerFactory.getLogger(NoticeService.class);

    //请求参数对象key
    private final String requestParamKey = "requestParam";

    //请求地址key
    private final String requestUrlKey = "requestUrl";

    @Value("${projectRequestUrl}")
    private String projectRequestUrl;

    @Autowired
    private NoticeDao noticeDao;

    @Autowired
    private ScheduleConfig scheduleConfig;

    @Autowired
    private ComputerManageService computerManageService;

    private Map<String, List<Session>> accountIdSessionIdMap = CustomWebSocketService.getAccountIdSessionIdMap();

    //办公用品申请通知(每5分钟提醒一次，若已查看则不再提醒)
    @Async
    @Scheduled(cron = "0 0/5 * * * ?")
    public void notificationOfOfficeSupplies() throws Exception {
        if (accountIdSessionIdMap.isEmpty()) {
            log.error("当前没有用户在线!");
            return;
        }
        for (int i = 1; i < 8; i++) {
            List<String> office = noticeDao.getOffice(i);
            if (office.size() == 0) continue;
            JSONObject jsonObject = new JSONObject();
            jsonObject.put(Constant.Result.RETCODE, Constant.Result.SUCCESS);
            jsonObject.put(Constant.Result.RETMSG, Constant.Result.SUCCESS_MSG);
            Map<String, Object> context = new HashMap<String, Object>();
            Map<String, Object> requestParam = new HashMap<String, Object>();
            context.put("icon", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1565946516414&di=2f925456dfc0bbfc8ba457c6e38fb0ce&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201607%2F13%2F20160713110827_vyiPR.thumb.700_0.png");
            String url = "#/paperlessOffice/officeSuppliesManage";
            String requestUrl = "".concat(projectRequestUrl).concat("/officeAction/updateOfficeSuppliesSee");
            //log.error("requestUrl:{}", requestUrl);
            context.put(requestUrlKey, requestUrl);
            if (i == 1) {
                //通知主管或组长
                requestParam.put("zhuSee", "1");
                requestParam.put(Constant.TASK_PARAM.ID_1001, "accountId2");
                context.put("title", "办公用品申请提醒");
                context.put("body", "有办公用品申请需要审批,详情请查看 【办公用品申领】");
            } else if (i == 2) {
                //通知前台
                requestParam.put("renSee", "1");
                context.put("title", "办公用品准备提醒");
                context.put("body", "有办公用品申请,详情请查看 【办公用品申领】");
            } else if (i == 3) {
                //审核未通过，通知申请人
                requestParam.put(Constant.TASK_PARAM.ID_1001, "accountId1");
                requestParam.put("shenSee", "1");
                context.put("title", "办公用品提醒");
                context.put("body", "您的办公用品申请审批没通过,详情请查看 【办公用品申领】");
            } else if (i == 4) {
                //通知人事
                requestParam.put(Constant.TASK_PARAM.ID_1001, "renShiId");
                requestParam.put("renShiSee", "1");
                context.put("title", "办公用品本月汇总结果");
                context.put("body", "办公用品汇总审核,详情请查看 【办公用品汇总】");
            } else if (i == 5) {
                //通知副总
                requestParam.put(Constant.TASK_PARAM.ID_1001, "fuZongId");
                requestParam.put("fuZongSee", "1");
                context.put("title", "办公用品本月汇总结果");
                context.put("body", "办公用品汇总审核,详情请查看 【办公用品汇总】");
            } else if (i == 6) {
                //通知财务
                requestParam.put(Constant.TASK_PARAM.ID_1001, "caiWuId");
                requestParam.put("caiWuSee", "1");
                context.put("title", "办公用品本月汇总结果");
                context.put("body", "办公用品汇总审核,详情请查看 【办公用品汇总】");
            } else if (i == 7) {
                //通知申请人
                requestParam.put(Constant.TASK_PARAM.ID_1001, "accountId1");
                requestParam.put("renOtherSee", "1");
                context.put("title", "办公用品本月汇总审核结果");
                context.put("body", "办公用品汇总审核结果,详情请查看 【办公用品汇总】");
            }
            context.put("url", url);
            context.put(requestParamKey, requestParam);
            jsonObject.put(Constant.Result.RETDATA, context);
            Callable<Integer> call = new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    sendMessage(jsonObject, office);
                    return 0;
                }
            };
            FutureTask<Integer> task = new FutureTask<Integer>(call);
            scheduleConfig.excuete(task);
        }
    }

    //例会预约提醒（每月26,28,30日10点发送提醒）
    @Async
    @Scheduled(cron = "0 0 10 26,28,30 * ?")
    public void regularMeetingNotice() throws Exception {
        List<String> accountList = noticeDao.queryAccountIdByRule("69");
        this.timelyExecute(accountList, "例会预约提示", "#/paperlessOffice/conferenceRoomManage", "若次月例会没有预约，记得预约哦。若已预约，则忽略。");
    }

    //请假通知
    @Async
    @Scheduled(cron = "0 0/5 * * * ?")
    public void schedulingAskForLeave() throws Exception {
        List<String> accountList = new ArrayList<>();
        //请假提醒
        accountList = noticeDao.askOfLeave();
        this.timelyExecute(accountList, "请假审批提醒", "#/paperlessOffice/askForLeave", "有请假需要申请<br>详情请查看【无纸化办公】--请假");
    }

    //倒休提醒
    @Async
    @Scheduled(cron = "0 0/5 * * * ?")
    public void schedulingOfRestDown() throws Exception {
        List<String> accountList = new ArrayList<>();
        accountList = noticeDao.restDown();
        this.timelyExecute(accountList, "倒休审批提醒", "#/paperlessOffice/restdown", "有倒休需要申请<br>详情请查看【无纸化办公】--倒休");
    }

    //电脑用品通知
    @Async
    @Scheduled(cron = "0 0/1 * * * ?")
    public void computerNotice() throws Exception {
        //{1, 11, 2, 22, 3, 9, 33, 4, 5, 6, 7, 77, 55}
        int[] flag = {1, 2, 3, 9, 5, 55, 6, 7};
        for (int f : flag) {
            List<ComputerManageBean> computerManageBeans = computerManageService.queryComputerNotice(f);
            if (computerManageBeans == null || computerManageBeans.isEmpty()) continue;
            Callable<Integer> call = new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    computerNoticeSend(f, computerManageBeans);
                    return 0;
                }
            };
            scheduleConfig.excuete(new FutureTask<Integer>(call));
        }
    }

    //负责电脑用品发送通知
    private void computerNoticeSend(int flag, List<ComputerManageBean> computerManageBeans) throws Exception {
        if (computerManageBeans == null || computerManageBeans.isEmpty()) return;
        List<String> accountList = new ArrayList<>();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.Result.RETCODE, Constant.Result.SUCCESS);
        jsonObject.put(Constant.Result.RETMSG, Constant.Result.SUCCESS_MSG);
        Map<String, Object> context = new HashMap<String, Object>();
        Map<String, Object> requestParam = new HashMap<String, Object>();
        context.put("icon", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1565946516414&di=2f925456dfc0bbfc8ba457c6e38fb0ce&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201607%2F13%2F20160713110827_vyiPR.thumb.700_0.png");
        String url = "#/paperlessOffice/computerManage";
        String requestUrl = "".concat(projectRequestUrl).concat("/computerManageController/updateComputer");
        //log.error("requestUrl:{}", requestUrl);
        context.put(requestUrlKey, requestUrl);
        for (ComputerManageBean computerManageBean : computerManageBeans) {
            accountList.clear();
            switch (flag) {
                case 1:
                    //ZHU_ID--zhuSee
                    requestParam.put("zhuSee", "0");
                    accountList.add(computerManageBean.getZhuId());
                    context.put("title", "电脑用品需求提醒");
                    context.put("body", "有电脑用品需求单需要审批,单号:【" + computerManageBean.getId() + "】,详情请查看 【电脑用品管理】");
                    break;
                case 2:
                    //FU_ID--fuSee
                    requestParam.put("fuSee", "1");
                    accountList.add(computerManageBean.getFuId());
                    context.put("title", "电脑用品提醒");
                    context.put("body", "有电脑用品需求单需要审批,单号:【" + computerManageBean.getId() + "】,详情请查看 【电脑用品管理】");
                    break;
                case 3:
                    //--duiSee
                    requestParam.put("duiSee", "1");
                    accountList = noticeDao.queryAccountIdByRule("71");
                    context.put("title", "电脑用品提醒");
                    context.put("body", "有电脑用品需求需要准备,单号:【" + computerManageBean.getId() + "】,详情请查看 【电脑用品管理】");
                    break;
                case 9:
                    //PEI_JIEDAN_ID
                    requestParam.put("caiWuSee", "1");
                    //accountList.add(computerManageBean.getPeiJiedanId());
                    accountList = noticeDao.queryAccountIdByRule("71");
                    context.put("title", "电脑用品提醒");
                    context.put("body", "此单已对接，请及时进行,单号:【" + computerManageBean.getId() + "】,详情请查看 【电脑用品管理】");
                    break;
                case 5:
                    //USER_ID--userSee
                    requestParam.put("userSee", "1");
                    accountList.add(computerManageBean.getUserId());
                    context.put("title", "电脑用品提醒");
                    context.put("body", "电脑用品已接单，请您耐心等待!单号:【" + computerManageBean.getId() + "】,详情请查看 【电脑用品管理】");
                    break;
                case 6:
                    //FU_ID--fuSee
                    requestParam.put("fuSee", "2");
                    accountList.add(computerManageBean.getFuId());
                    context.put("title", "电脑用品提醒");
                    context.put("body", "电脑用品完成,单号:【" + computerManageBean.getId() + "】,详情请查看 【电脑用品管理】");
                    break;
                case 7:
                    //PEI_JIEDAN_ID--peiJiedanIdSee
                    requestParam.put("peiJiedanIdSee", "1");
                    accountList.add(computerManageBean.getPeiJiedanId());
                    context.put("title", "电脑用品提醒");
                    context.put("body", "电脑用品指配,单号:【" + computerManageBean.getId() + "】,详情请查看 【电脑用品管理】");
                    break;
                case 55:
                    //USER_ID--userSee
                    requestParam.put("userSee", "1");
                    accountList.add(computerManageBean.getUserId());
                    context.put("title", "电脑用品提醒");
                    context.put("body", "电脑用品未通过，请修改数据重新提交!单号:【" + computerManageBean.getId() + "】,详情请查看 【电脑用品管理】");
                    break;
                //case 77://PEI_JIEDAN_ID break;
                //case 33: break;
                //case 4://APPLY_ID break;
                //case 22://FU_ID break;
                //case 11://ZHU_ID break;
            }
            context.put("url", url);
            requestParam.put("id", computerManageBean.getId());
            context.put(requestParamKey, requestParam);
            jsonObject.put(Constant.Result.RETDATA, context);
            if (accountList.size() > 0) {
                sendMessage(jsonObject, accountList);
            }
        }
    }

    /**
     * 提醒内容合并
     *
     * @param accountList 需要被提醒人的账号集合
     * @param title       被提醒的title
     * @param url         点击提醒弹窗后，通过这个url跳转到指定页面
     * @param body        提醒的内容
     * @throws Exception
     */
    public void timelyExecute(List<String> accountList, String title, String url, String body) throws Exception {
        if (accountIdSessionIdMap.isEmpty()) {
            log.error("当前没有用户在线!");
            return;
        }
        if (accountList == null || accountList.size() <= 0) return;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.Result.RETCODE, Constant.Result.SUCCESS);
        jsonObject.put(Constant.Result.RETMSG, Constant.Result.SUCCESS_MSG);
        Map<String, Object> context = new HashMap<String, Object>();
        context.put("icon", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1565946516414&di=2f925456dfc0bbfc8ba457c6e38fb0ce&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201607%2F13%2F20160713110827_vyiPR.thumb.700_0.png");
        context.put("title", title);
        context.put("url", url);
        context.put("body", body);
        jsonObject.put(Constant.Result.RETDATA, context);
        sendMessage(jsonObject, accountList);
    }


    //推送通知
    private int sendMessage(JSONObject data, List<String> peopleList) throws Exception {
        for (String accountId : peopleList) {
            List<Session> sessions = accountIdSessionIdMap.get(accountId);
            if (sessions == null || sessions.size() <= 0) continue;
            JSONObject jsonObject = (JSONObject) data.clone();
            JSONObject retData = jsonObject.getJSONObject(Constant.Result.RETDATA);
            if (retData != null && StringUtils.isNotBlank(retData.getString(requestUrlKey))
                    && retData.get(requestParamKey) != null && StringUtils.isNotBlank(retData.getJSONObject(requestParamKey).getString(Constant.TASK_PARAM.ID_1001))) {
                JSONObject requestParam = retData.getJSONObject(requestParamKey);
                requestParam.put(requestParam.getString(Constant.TASK_PARAM.ID_1001), accountId);
                retData.put(requestParamKey, requestParam);
                jsonObject.put(Constant.Result.RETDATA, retData);
            }

            for (Session session : sessions) {
                synchronized (session) {
                    session.getBasicRemote().sendText(jsonObject.toJSONString());
                }
            }
        }
        return 0;
    }

    //获得本机IP
    public String getLocalIp() throws Exception {
        return InetAddress.getLocalHost().getHostAddress();
    }

    //获取端口
    public String getLoaclPort() throws Exception {
        MBeanServer beanServer = ManagementFactory.getPlatformMBeanServer();
        Set<ObjectName> objectNames = beanServer.queryNames(new ObjectName("*:type=Connector,*"),
                Query.match(Query.attr("protocol"), Query.value("HTTP/1.1")));
        String port = objectNames.iterator().next().getKeyProperty("port");
        return port;
    }

}
