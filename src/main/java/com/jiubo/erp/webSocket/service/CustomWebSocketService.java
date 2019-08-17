package com.jiubo.erp.webSocket.service;

import com.alibaba.fastjson.JSONObject;
import com.jiubo.erp.common.Constant;
import com.jiubo.erp.common.MessageException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @desc:spring WebSocket 使用
 * @date: 2019-08-13 14:36
 * @author: dx
 * @version: 1.0
 */
@Component
@ServerEndpoint("/websocket/{accountId}")
public class CustomWebSocketService {

    private static Logger log = LoggerFactory.getLogger(CustomWebSocketService.class);

    private String accountId = null;

    private Date firstDate = null;

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    //concurrent包的线程安全Map，用来存放每个客户端对应的CustomWebSocketService对象。
    private static Map<String, CustomWebSocketService> webSocketMap = new ConcurrentHashMap<String, CustomWebSocketService>();

    public static Map<String, CustomWebSocketService> getWebSocketMap() {
        return webSocketMap;
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
        firstDate = new Date();
        webSocketMap.put(accountId, this);
        webSocketMap.put("sessinId_" + session.getId(), this);
        try {
            sendMessage("连接成功");
        } catch (IOException e) {
            log.error("websocket IO异常");
        }
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        CustomWebSocketService socketService = webSocketMap.get("sessionId_" + this.getSession().getId());
        if (socketService != null) webSocketMap.remove("sessionId_" + this.getSession().getId());
        webSocketMap.forEach((key, value) -> {
            if (value == this) {
                log.info("连接关闭！" + key);
                webSocketMap.remove(key);
            }
        });
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message, Session session, @PathParam("accountId") String accountId) throws Exception {
        log.info("收到" + accountId + "的信息:" + message);
        //心跳更新时间
        CustomWebSocketService socketService = webSocketMap.get(accountId);
        if (socketService != null) socketService.firstDate = new Date();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.Result.RETCODE, "6666");
        jsonObject.put(Constant.Result.RETDATA, "成功!");
        session.getBasicRemote().sendText(jsonObject.toJSONString());
    }

    /**
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error("发生错误!");
        error.printStackTrace();
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
        log.info("推送消息到窗口" + accountId + "，推送内容:" + message);
        if (StringUtils.isNotBlank(accountId)) {
            //给某个人推送消息
            CustomWebSocketService socketService = webSocketMap.get(accountId);
            if (socketService == null || !socketService.getSession().isOpen())
                throw new MessageException("id错误或客户端断开连接！");
            socketService.sendMessage(message);
        } else {
            //给所有在线的人推送消息
            for (Map.Entry<String, CustomWebSocketService> entry : webSocketMap.entrySet()) {
                try {
                    entry.getValue().sendMessage(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //心跳检测
    public void checkState(Map<String, Object> map) {
        webSocketMap.forEach((key, value) -> {
            System.out.println("开始检查客户端:" + key);
            if (!value.getSession().isOpen()) {
                webSocketMap.remove(key);
                System.out.println("客户端【" + key + "】关闭了。。。");
            } else if (new Date().getTime() - value.firstDate.getTime() > 30 * 1000) {
                webSocketMap.remove(key);
                try {
                    value.getSession().close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("客户端【" + key + "】超过30s未与服务器联系！");
            }
        });
    }
}
