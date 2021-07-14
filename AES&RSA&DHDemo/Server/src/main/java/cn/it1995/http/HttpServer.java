package cn.it1995.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
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

    public static Map<String, String> getHeader(String request){

        Map<String, String> header = new HashMap<>();
        BufferedReader reader = new BufferedReader(new StringReader(request));

        //逐行解析

        try{

            String line = reader.readLine();
            while (line != null && !line.trim().isEmpty()){

                int p = line.indexOf(":");
                if(p >= 0){

                    header.put(line.substring(0, p).trim().toLowerCase(),
                            line.substring(p + 1).trim());
                }
                line = reader.readLine();
            }
        }
        catch (Exception e){

            e.printStackTrace();
        }

        return header;
    }
}
