package com.example.springbootwebsocket.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author CJW
 * @since 2023/10/29
 */
@Component
/**
 * 定义websocket服务器端，它的功能主要是将目前的类定义成一个websocket服务器端。注解的值将被用于监听用户连接的终端访问URL地址
 */
@ServerEndpoint("/websocket1")
@Slf4j
public class WebSocket1 {
    /**
     * 实例一个session，这个session是websocket的session
     */
    private Session session;
    /**
     * 存放websocket的集合
     */
    private static CopyOnWriteArraySet<WebSocket1> webSocket1Set = new CopyOnWriteArraySet<>();

    /**
     * 前端请求时一个websocket时
     */
    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        webSocket1Set.add(this);
        log.info("【websocket消息】有新的连接, 总数:{}", webSocket1Set.size());
    }

    /**
     * 前端关闭时一个websocket时
     */
    @OnClose
    public void onClose() {
        webSocket1Set.remove(this);
        log.info("【websocket消息】连接断开, 总数:{}", webSocket1Set.size());
    }

    /**
     * 前端向后端发送消息
     */
    @OnMessage
    public void onMessage(String message) {
        log.info("【websocket消息】收到客户端发来的消息:{}", message);
    }

    /**
     * 新增一个方法用于主动向客户端发送消息
     */
    public void sendMessage(String message) {
        for (WebSocket1 webSocket1 : webSocket1Set) {
            log.info("【websocket消息】广播消息, message={}", message);
            try {
                webSocket1.session.getBasicRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
