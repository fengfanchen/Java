package cn.it1995.demo.socket;

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

@Component
@ServerEndpoint("/websocket")
public class WebSocket {

    //与某个客户端连接对话，通过此对客户端发送消息
    private Session session;

    //存放所有连接的客户端
    private static ConcurrentLinkedQueue<WebSocket> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();

    @OnOpen
    public void onOpen(Session session){

        //默认客户端，没有重名
        this.session = session;
        concurrentLinkedQueue.add(this);
        System.out.println("【webSocket连接成功】当前连接人数为：" + concurrentLinkedQueue.size());
    }

    @OnClose
    public void onClose() {

        Iterator<WebSocket> iterator = concurrentLinkedQueue.iterator();
        while (iterator.hasNext()){

            WebSocket next = iterator.next();
            if(next == this){

                concurrentLinkedQueue.remove(next);
            }
        }
    }

    @OnError
    public void onError(Session session, Throwable throwable){

        System.out.println("error:");
        throwable.printStackTrace();
    }

    @OnMessage
    public void onMessage(String message){


        Iterator<WebSocket> iterator = concurrentLinkedQueue.iterator();
        while (iterator.hasNext()){

            WebSocket next = iterator.next();
            try {

                next.session.getBasicRemote().sendText(message);
            }
            catch (IOException e) {

                e.printStackTrace();
            }
        }
    }

}
