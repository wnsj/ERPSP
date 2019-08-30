package com.jiubo.erp.task.service;

import com.alibaba.fastjson.JSONObject;
import com.jiubo.erp.common.Constant;
import com.jiubo.erp.config.ScheduleConfig;
import com.jiubo.erp.task.dao.NoticeDao;
import com.jiubo.erp.webSocket.service.CustomWebSocketService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    private  final String requestParamKey = "requestParam";

    //请求地址key
    private final String requestUrlKey = "requestUrl";

    @Autowired
    private NoticeDao noticeDao;

    @Autowired
    private ScheduleConfig scheduleConfig;

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
            String requestUrl = "http://".concat(getLocalIp()).concat("/ERP/officeAction/updateOfficeSuppliesSee");
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
        if (accountIdSessionIdMap.isEmpty()) {
            log.error("当前没有用户在线!");
            return;
        }
        List<String> accountList = noticeDao.queryAccountIdByRule("69");
        if(accountList == null || accountList.size() <= 0)return;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.Result.RETCODE, Constant.Result.SUCCESS);
        jsonObject.put(Constant.Result.RETMSG, Constant.Result.SUCCESS_MSG);
        Map<String, Object> context = new HashMap<String, Object>();
        context.put("icon", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1565946516414&di=2f925456dfc0bbfc8ba457c6e38fb0ce&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201607%2F13%2F20160713110827_vyiPR.thumb.700_0.png");
        context.put("title", "例会预约提示");
        context.put("url", "#/paperlessOffice/conferenceRoomManage");
        context.put("body", "若次月例会没有预约，记得预约哦。若已预约，则忽略。");
        jsonObject.put(Constant.Result.RETDATA, context);
        sendMessage(jsonObject, accountList);
    }

    //推送通知
    private int sendMessage(JSONObject data, List<String> peopleList) throws Exception {
        for (String accountId : peopleList) {
            List<Session> sessions = accountIdSessionIdMap.get(accountId);
            if(sessions == null || sessions.size() <= 0)continue;
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
                session.getBasicRemote().sendText(jsonObject.toJSONString());
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
