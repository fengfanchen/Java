package com.example.myclient.http;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class HttpRequest {

    private static final String HANDSHAKE = "handshake";
    private Request.Builder mBuilder;

    public HttpRequest(String url) {

        mBuilder = new Request
                .Builder()
                .get()
                .url(url);
    }

    //握手请求
    public void handshake(Callback callback, String pubKey){

        mBuilder.addHeader(HANDSHAKE, pubKey);
        request(callback);
        mBuilder.removeHeader(HANDSHAKE);
    }

    public void request(Callback callback){

        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(mBuilder.build());
        call.enqueue(callback);
    }
}
