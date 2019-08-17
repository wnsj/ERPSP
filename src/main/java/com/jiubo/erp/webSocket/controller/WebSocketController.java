package com.jiubo.erp.webSocket.controller;

import com.alibaba.fastjson.JSONObject;
import com.jiubo.erp.common.Constant;
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
    public JSONObject sendMessage(String accountId, String message) throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.Result.RETCODE,Constant.Result.SUCCESS);
        jsonObject.put(Constant.Result.RETMSG, Constant.Result.SUCCESS_MSG);
        webSocketService.sendInfo(message, accountId);
        jsonObject.put(Constant.Result.RETDATA,"发送成功!");
        return jsonObject;
    }
}
