package com.jiubo.erp.webSocket.controller;

import com.jiubo.erp.webSocket.service.CustomWebSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc:
 * @date: 2019-08-14 09:37
 * @author: dx
 * @version: 1.0
 */
@RestController
@RequestMapping("/webSocketController")
public class WebSocketController {
    @Autowired
    private CustomWebSocketService webSocketService;

    @GetMapping("/sendMessage")
    public String sendMessage(String accountId, String message) throws Exception {
        webSocketService.sendInfo(message, accountId);
        return "发送成功!";
    }
}
