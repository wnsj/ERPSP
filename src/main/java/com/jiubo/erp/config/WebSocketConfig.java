package com.jiubo.erp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @desc:
 * @date: 2019-08-13 14:17
 * @author: dx
 * @version: 1.0
 */
@Configuration
public class WebSocketConfig{

    //WebSocket配置（springboot使用内置Tomcat需要此配置，打成war包时请将此注释）
//    @Bean
//    public ServerEndpointExporter serverEndpointExporter() {
//        return new ServerEndpointExporter();
//    }

//    @EventListener
//    public void onDisconnectEvent(SessionDisconnectEvent event) {
//        System.out.println("Client with username {} disconnected" + event.getUser());
//    }


}

