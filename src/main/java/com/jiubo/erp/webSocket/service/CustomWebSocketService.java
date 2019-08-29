package com.jiubo.erp.webSocket.service;

import com.alibaba.fastjson.JSONObject;
import com.jiubo.erp.common.Constant;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @desc:spring WebSocket 使用
 * @date: 2019-08-13 14:36
 * @author: dx
 * @version: 1.0
 */
@Component
@Scope("prototype")
@ServerEndpoint("/websocket/{accountId}")
public class CustomWebSocketService {

    private static Logger log = LoggerFactory.getLogger(CustomWebSocketService.class);

    private String accountId = null;

    private Date firstDate = null;

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    //连接成功返回代码
    private String retCode = "1111";

    //concurrent包的线程安全Map，用来存放每个客户端对应的CustomWebSocketService对象。
    private static Map<String, CustomWebSocketService> webSocketMap = new ConcurrentHashMap<String, CustomWebSocketService>();

    private static Map<String, List<Session>> accountIdSessionIdMap = new ConcurrentHashMap<String, List<Session>>();

    public static Map<String, CustomWebSocketService> getWebSocketMap() {
        return webSocketMap;
    }

    public static Map<String, List<Session>> getAccountIdSessionIdMap() {
        return accountIdSessionIdMap;
    }

    public Session getSession() {
        return session;
    }

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("accountId") String accountId) {
        this.session = session;
        this.accountId = accountId;
        firstDate = new Date();
        String sessionId = "sessionId_".concat(session.getId());
        //log.info("客户端【{}】用户【{}】连接成功!",sessionId,accountId);
        webSocketMap.put(sessionId, this);
        List<Session> sessions = accountIdSessionIdMap.get(accountId);
        if (sessions == null) {
            sessions = new ArrayList<Session>();
        }
        sessions.add(session);
        accountIdSessionIdMap.put(accountId, sessions);
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put(Constant.Result.RETCODE, retCode);
            jsonObject.put(Constant.Result.RETMSG, Constant.Result.SUCCESS_MSG);
            Map<String, Object> context = new HashMap<String, Object>();
            context.put("title", "通知");
            context.put("body", "websocket连接成功!");
            context.put("icon", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1565946516414&di=2f925456dfc0bbfc8ba457c6e38fb0ce&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201607%2F13%2F20160713110827_vyiPR.thumb.700_0.png");
            context.put("url", "http://www.baidu.com");
            jsonObject.put(Constant.Result.RETDATA, context);
            sendMessage(jsonObject.toJSONString());
        } catch (IOException e) {
            log.error("websocket IO异常");
        }
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(Session session) {
        String sessionId = "sessionId_".concat(session.getId());
        //log.info("客户端【{}】连接关闭！", sessionId);
        CustomWebSocketService socketService = webSocketMap.get(sessionId);
        if (socketService != null) {
            webSocketMap.remove(sessionId);
            List<Session> sessions = accountIdSessionIdMap.get(socketService.accountId);
            if (sessions != null) sessions.remove(session);
        }
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message, Session session, @PathParam("accountId") String accountId) throws Exception {
        String sessionId = "sessionId_".concat(session.getId());
        //log.info("收到客户端【" + sessionId + "】的信息:" + message);
        //心跳更新时间
        CustomWebSocketService socketService = webSocketMap.get(sessionId);
        if (socketService != null) socketService.firstDate = new Date();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.Result.RETCODE, retCode);
        jsonObject.put(Constant.Result.RETMSG, Constant.Result.SUCCESS_MSG);
        Map<String, Object> context = new HashMap<String, Object>();
        context.put("title", "通知");
        context.put("body", "你有一条新信息!");
        context.put("icon", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1565946516414&di=2f925456dfc0bbfc8ba457c6e38fb0ce&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201607%2F13%2F20160713110827_vyiPR.thumb.700_0.png");
        context.put("url", "http://www.baidu.com");
        jsonObject.put(Constant.Result.RETDATA, context);
        session.getBasicRemote().sendText(jsonObject.toJSONString());
    }

    /**
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        String sessionId = "sessionId_".concat(session.getId());
        CustomWebSocketService socketService = webSocketMap.get(sessionId);
        if (socketService != null) {
            webSocketMap.remove(sessionId);
            List<Session> sessions = accountIdSessionIdMap.get(socketService.accountId);
            if (sessions != null) sessions.remove(session);
        }
        //log.error("客户端【{}】发生错误!错误信息【{}】",sessionId, error.getMessage());
        //error.printStackTrace();
    }

    /**
     * 实现服务器主动推送
     */
    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }


    /**
     * 推送消息
     */
    public void sendInfo(String message, String accountId) throws Exception {
        //log.info("推送消息到窗口【" + accountId + "】，推送内容:【" + message + "】");
        if (StringUtils.isNotBlank(accountId)) {
            //给某个人推送消息
            List<Session> sessions = accountIdSessionIdMap.get(accountId);
            if (sessions != null){
                for(Session session : sessions){
                    session.getBasicRemote().sendText(message);
                }
            }
        } else {
            //给所有在线的人推送消息
            for (Map.Entry<String, CustomWebSocketService> entry : webSocketMap.entrySet()) {
                entry.getValue().sendMessage(message);
            }
        }
    }

    //心跳检测
    public void checkState(Map<String, Object> map) {
        webSocketMap.forEach((key, value) -> {
            //log.info("开始检查客户端:【" + key + "】");
            if (!value.getSession().isOpen()) {
                webSocketMap.remove(key);
                List<Session> sessions = accountIdSessionIdMap.get(value.accountId);
                if(sessions != null)sessions.remove(value.getSession());
                //log.info("客户端【" + key + "】关闭了。。。");
            } else if (new Date().getTime() - value.firstDate.getTime() > 30 * 1000) {
                webSocketMap.remove(key);
                List<Session> sessions = accountIdSessionIdMap.get(value.accountId);
                if(sessions != null)sessions.remove(value.getSession());
                try {
                    value.getSession().close();
                } catch (IOException e) {
                    //e.printStackTrace();
                    log.error("webSocket 关闭异常",e);
                }
                //log.info("客户端【" + key + "】超过30s未与服务器联系！");
            }
        });
    }
}
