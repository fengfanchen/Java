package com.websocket.demo.code;


import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

@Component
@ServerEndpoint("/websocket/{name}")
public class WebSocket {

    //与某个客户端连接对话，通过此对客户端发送消息
    private Session session;

    //存放所有连接的客户端
    private static ConcurrentHashMap<String, WebSocket> webSocketConcurrentHashMap = new ConcurrentHashMap<>();

    @OnOpen
    public void onOpen(Session session, @PathParam(value = "name") String name){

        //默认客户端，没有重名
        this.session = session;
        webSocketConcurrentHashMap.put(name, this);
        System.out.println("【webSocket连接成功】当前连接人数为：" + webSocketConcurrentHashMap.size() + "，此人为：" + name);
    }

    @OnClose
    public void onClose(){

        //这里判断不周，仅实验用

        for(String name : webSocketConcurrentHashMap.keySet()){

            if(this == webSocketConcurrentHashMap.get(name)){

                webSocketConcurrentHashMap.remove(name);
                break;
            }
        }


        System.out.println("【webSocket退出成功】当前连接人数为：" + webSocketConcurrentHashMap.size());
    }

    @OnError
    public void onError(Session session, Throwable throwable){

        System.out.println("error:");
        throwable.printStackTrace();
    }

    @OnMessage
    public void onMessage(Session session, String message){

        System.out.println("【webSocket接收成功】内容为：" + message);
        //此处可以指定发送，或者群发，或者xxxx的

        if(message.indexOf("name:") == 0){

            String name = message.substring(message.indexOf("name") + 5, message.indexOf(";"));

            //获取sender的Stirng
            for(String senderStr : webSocketConcurrentHashMap.keySet()){

                if(webSocketConcurrentHashMap.get(senderStr).getSession() == session){

                    appointSending(senderStr, name, message.substring(message.indexOf(";") + 1));
                }
            }
        }
        else{

            groupSending(message, session);
        }
    }

    //群发
    public void groupSending(String message, Session exIncludeSession){

        for(String name : webSocketConcurrentHashMap.keySet()){

            try {
                if(exIncludeSession == webSocketConcurrentHashMap.get(name).session)
                    continue;

                webSocketConcurrentHashMap.get(name).session.getBasicRemote().sendText(name + ":" +message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //指定发
    public void appointSending(String sender, String name, String message){

        try {
            webSocketConcurrentHashMap.get(name).session.getBasicRemote().sendText(sender + ":" + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Session getSession() {
        return session;
    }
}
