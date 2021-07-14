package cn.it1995.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class HttpThread implements Runnable{

    private Socket mSocket;
    private HttpCallback mCallback;

    public HttpThread(Socket socket, HttpCallback httpCallback){

        mSocket = socket;
        mCallback = httpCallback;
    }

    @Override
    public void run() {

        try {

            BufferedReader reader = new BufferedReader(new InputStreamReader(mSocket.getInputStream()));
            String content;
            StringBuffer request = new StringBuffer();

            while((content = reader.readLine()) != null
                    && !content.trim().isEmpty()){

                request.append(content).append("\n");
            }

            System.out.println("request:\n" + request);
            byte[] response = new byte[0];
            if(mCallback != null){

                response = mCallback.onResponse(request.toString());
            }

            String responseFirstLine = "HTTP/1.1 200 OK \r\n";
            String responseHead = "Content-type:" + "text/html" + "\r\n";
            OutputStream outputStream = mSocket.getOutputStream();
            outputStream.write(responseFirstLine.getBytes());
            outputStream.write(responseHead.getBytes());
            outputStream.write("\r\n".getBytes());
            outputStream.write(response);

            mSocket.close();
        }
        catch (IOException e) {

            e.printStackTrace();
        }
    }
}
