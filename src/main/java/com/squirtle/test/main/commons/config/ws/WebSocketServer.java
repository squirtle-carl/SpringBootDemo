package com.squirtle.test.main.commons.config.ws;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author caihuaxin
 * @version 1.0.0
 * @describe webSocket服务器 监听地址/myWs
 * @date 2024/04/16
 */
@ServerEndpoint(value = "/myWs")
@Component
@Slf4j
public class WebSocketServer {
    static ConcurrentHashMap<String, Session> sessionMap = new ConcurrentHashMap<>();
    @OnOpen
    public void onOpen(Session session) {
        sessionMap.put(session.getId(), session);
        log.info("webSocket is open");
    }
    @OnMessage
    public String onMessage(String message) {
        log.info("webSocket receive message: {}", message);
        return "webSocket 连接反馈:"+message;
    }
    @OnClose
    public void onClose(Session session) {
        sessionMap.remove(session.getId());
        log.info("webSocket is close");
    }
    @Scheduled(fixedRate = 2000)
    public void sendMsg() throws IOException {
        for (String key : sessionMap.keySet()) {
            sessionMap.get(key).getBasicRemote().sendText("心跳");
        }
    }
}
