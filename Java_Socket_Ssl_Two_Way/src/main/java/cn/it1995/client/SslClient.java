package cn.it1995.client;

import cn.it1995.SslContextProvider;
import cn.it1995.SslUtil;

import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.GeneralSecurityException;

public class SslClient implements SslContextProvider {


    public static void main(String[] args) throws Exception {

        if(args.length != 2){

            System.out.println("Usage: SslClient <host> <port>");
            System.exit(1);
        }

        String host = args[0];
        Integer port = Integer.parseInt(args[1]);
        new SslClient().run(host, port);
    }

    @Override
    public TrustManager[] getTrustManagers() throws GeneralSecurityException, IOException {

        return SslUtil.createTrustManagers("client.jks", "cccccc");
    }

    @Override
    public KeyManager[] getKeyManagers() throws GeneralSecurityException, IOException {

        return SslUtil.createKeyManagers("client.jks", "cccccc");
    }

    @Override
    public String getProtocol() {

        return "TLSv1.2";
    }

    public void run(String host, Integer port) throws Exception {

        try(SSLSocket sslSocket = createSSLSocket(host, port); OutputStream os = sslSocket.getOutputStream(); InputStream is = sslSocket.getInputStream()){

            System.out.println("已成功连接到服务端.......");

            os.write("hehe".getBytes());
            os.flush();

            System.out.println("已发送 hehe 到服务端");

            byte[] buf = new byte[1024];
            is.read(buf);

            System.out.println("接收到服务端消息：" + new String(buf));
        }
        catch (Exception e){

            e.printStackTrace();
        }
    }

    private SSLSocket createSSLSocket(String host, Integer port) throws Exception {

        return SslUtil.createSSLSocket(host, port, this);
    }
}
