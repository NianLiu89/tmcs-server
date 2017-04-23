package com.shengtian.service.tmcs.config.ws_via_handler;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MyHandler extends TextWebSocketHandler {

    private List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println(String.format("[new session] id-%s, uri-%s", session.getId(), session.getUri()));
        sessions.add(session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println("[new message] " + message.getPayload());
        for (WebSocketSession s : sessions) {
            try {
                s.sendMessage(new TextMessage("Hello from the server!"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
