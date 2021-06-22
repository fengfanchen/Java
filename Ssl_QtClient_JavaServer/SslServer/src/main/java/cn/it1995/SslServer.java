package cn.it1995;

import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;

public class SslServer implements SslContextProvider{
    @Override
    public TrustManager[] getTrustManagers() throws Exception {

        return SslUtil.createTrustManagers("D:\\IDEAProject\\SSLDemo\\src\\main\\resources\\server.jks", "cccccc");
    }

    @Override
    public KeyManager[] getKeyManagers() throws Exception {

        return SslUtil.createKeyManagers("D:\\IDEAProject\\SSLDemo\\src\\main\\resources\\server.jks", "cccccc");
    }

    @Override
    public String getProtocol() {

        return "TLSv1.2";
    }

    private ServerSocket createSSLSocket(int port) throws Exception {

        SSLServerSocket sslServerSocket = SslUtil.createSSLServerSocket(port, this);
        return sslServerSocket;
    }

    public void run(int port) throws Exception {

        ServerSocket serverSocket = createSSLSocket(port);
        System.out.println("服务端启动成功，等待客户端连接 ...... ...... ...... ......");

        while(true){

            try(SSLSocket client = (SSLSocket) serverSocket.accept(); OutputStream os = client.getOutputStream(); InputStream is = client.getInputStream()){

                System.out.println("客户端: " + SslUtil.getPeerIdentity(client) + " 成功连接！");

                byte[] b = new byte[1024];
                is.read(b);
                System.out.println("接收到客户端消息：" + new String(b));
                System.out.println("发送消息给客户端！");
                os.write("Hello Client".getBytes());
                os.flush();
                System.out.println("发送完成!");
            }
            catch (Exception e){

                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {

        new SslServer().run(19999);
    }
}
