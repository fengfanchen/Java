package cn.it1995.server;

import cn.it1995.SslContextProvider;
import cn.it1995.SslUtil;

import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.security.GeneralSecurityException;

public class SslServer implements SslContextProvider {

    public TrustManager[] getTrustManagers() throws GeneralSecurityException, IOException {

        return SslUtil.createTrustManagers("server.jks", "cccccc");
    }

    public KeyManager[] getKeyManagers() throws GeneralSecurityException, IOException {

        return SslUtil.createKeyManagers("server.jks", "cccccc");
    }

    public String getProtocol() {

        return "TLSv1.2";
    }

    private ServerSocket createSSLSocket(int port) throws GeneralSecurityException, IOException {

        SSLServerSocket sslServerSocket = SslUtil.createSSLServerSocket(port, this);
        return sslServerSocket;
    }

    public void run(int port) throws GeneralSecurityException, IOException {

        ServerSocket serverSocket = createSSLSocket(port);
        System.out.println("服务端启动成功，等待客户端连接.... .... .... ....");

        try(SSLSocket client = (SSLSocket) serverSocket.accept(); OutputStream os = client.getOutputStream(); InputStream is = client.getInputStream()){

            System.out.println("客户端: " + SslUtil.getPeerIdentity(client) + " 成功连接！");

            int available = is.available();
            byte[] b = new byte[1024];
            is.read(b);
            System.out.println("接收到客户端消息：" + new String(b));
            System.out.println("发送消息给客户端！");
            os.write("Hello!".getBytes());
            os.flush();
            System.out.println("发送完成!");
        }
        catch (Exception e){

            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws GeneralSecurityException, IOException {

        if(args.length != 1){

            System.out.println("Usage: SslServer <port>");
            System.exit(1);
        }

        Integer port = Integer.parseInt(args[0]);
        new SslServer().run(port);
    }
}
