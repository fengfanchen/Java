package com.example.demo.websocket;

import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;

@Component
@ServerEndpoint("/ws/{token}")
public class WebSocketServer {

    //每个客户端有一个token
    private String token = "";

    private static HashMap<String, Session> map = new HashMap<>();

    @OnOpen
    public void onOpen(Session session, @PathParam("token") String token){

        map.put(token, session);
        this.token = token;
        System.out.println("新连接:" + session);
    }

    @OnClose
    public void onClose(Session session){

        map.remove(this.token);
        System.out.println("连接关闭:" + session);
    }

    @OnError
    public void onError(Session session, Throwable error){

        System.out.println("错误:" + session + "," + error);
    }

    public void onMessage(String message, Session session){

        System.out.println("接收到消息:" + message);
    }

    //群发
    public void sendInfo(String message){

        for (String token : map.keySet()) {
            Session session = map.get(token);
            try {
                session.getBasicRemote().sendText(message);
            }
            catch (IOException e) {

                e.printStackTrace();
            }
        }
    }
}