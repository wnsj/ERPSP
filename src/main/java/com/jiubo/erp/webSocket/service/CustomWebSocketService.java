package com.jiubo.erp.webSocket.service;

import freemarker.cache.FileTemplateLoader;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
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

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    //concurrent包的线程安全Map，用来存放每个客户端对应的CustomWebSocketService对象。
    private static Map<String, CustomWebSocketService> webSocketMap = new ConcurrentHashMap<String, CustomWebSocketService>();

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("accountId") String accountId) {
        this.session = session;
        webSocketMap.put(accountId, this);
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
        webSocketMap.forEach((key, value) -> {
            if (value == this) webSocketMap.remove(key);
        });
        log.info("连接关闭！");
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("收到信息:" + message);
        //群发消息
        for (Map.Entry<String, CustomWebSocketService> entry : webSocketMap.entrySet()) {
            try {
                entry.getValue().sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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
    public void sendInfo(String message, String accountId) throws IOException {
        log.info("推送消息到窗口" + accountId + "，推送内容:" + message);
        if (StringUtils.isNotBlank(accountId)) {
            //给某个人推送消息
            CustomWebSocketService socketService = webSocketMap.get(accountId);
            if (socketService == null) return;
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
}
