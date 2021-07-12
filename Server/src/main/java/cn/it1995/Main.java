package cn.it1995;

import cn.it1995.http.HttpCallback;
import cn.it1995.http.HttpServer;

public class Main {

    public static void main(String[] args) {

        System.out.println("start http server");
        HttpServer server = new HttpServer(new HttpCallback() {
            @Override
            public byte[] onResponse(String request) {

                return "Hello World".getBytes();
            }
        });

        server.startHttpServer();
    }
}
