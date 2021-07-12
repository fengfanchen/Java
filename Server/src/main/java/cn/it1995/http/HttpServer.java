package cn.it1995.http;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServer {

    private boolean mRunning;
    private HttpCallback mCallback;

    public HttpServer(HttpCallback Callback) {

        this.mCallback = Callback;
    }

    public void startHttpServer(){

        if(mRunning){

            return;
        }
        mRunning = true;

        try {

            ServerSocket serverSocket = new ServerSocket(80);
            while (mRunning){

                Socket accept = serverSocket.accept();
                ExecutorService threadPool = Executors.newCachedThreadPool();
                threadPool.execute(new HttpThread(accept, mCallback));
            }
        }
        catch (IOException e) {

            e.printStackTrace();
        }
    }
}
