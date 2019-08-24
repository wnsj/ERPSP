package com.jiubo.erp.webSocket.controller;

import com.alibaba.fastjson.JSONObject;
import com.jiubo.erp.common.Constant;
import com.jiubo.erp.webSocket.service.CustomWebSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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
        Map<String, Object> context = new HashMap<String, Object>();
        context.put("title", "通知");
        context.put("body", message);
        context.put("icon", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1565946516414&di=2f925456dfc0bbfc8ba457c6e38fb0ce&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201607%2F13%2F20160713110827_vyiPR.thumb.700_0.png");
        context.put("url", "http://www.baidu.com");
        jsonObject.put(Constant.Result.RETDATA, context);
        webSocketService.sendInfo(jsonObject.toJSONString(), accountId);
        return jsonObject;
    }
}
