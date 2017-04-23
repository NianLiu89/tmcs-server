package com.shengtian.service.tmcs.config.ws_via_handler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(myHandler(), "/chat")  // http://localhost:8080/chat
                .addInterceptors(new HttpSessionHandshakeInterceptor())
                .setAllowedOrigins("*")
//        .withSockJS()
        ;
    }

    @Bean
    public MyHandler myHandler() {
        return new MyHandler();
    }

}
