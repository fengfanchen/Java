package cn.it1995;

import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import java.io.InputStream;
import java.io.OutputStream;

public class SslClient implements SslContextProvider{


    public static void main(String[] args) throws Exception {

        new SslClient().run("127.0.0.1", 19999);
    }

    public TrustManager[] getTrustManagers() throws Exception {

        return SslUtil.createTrustManagers("D:\\IDEAProject\\SSLDemo\\src\\main\\resources\\client.jks", "cccccc");
    }

    public KeyManager[] getKeyManagers() throws Exception {

        return SslUtil.createKeyManagers("D:\\IDEAProject\\SSLDemo\\src\\main\\resources\\client.jks", "cccccc");
    }

    public String getProtocol() {

        return "TLSv1.2";
    }

    private SSLSocket createSSLSocket(String host, Integer port) throws Exception{

        return SslUtil.createSSLSocket(host, port, this);
    }

    public void run(String host, Integer port) throws Exception {

        try(SSLSocket sslSocket = createSSLSocket(host, port); OutputStream os = sslSocket.getOutputStream(); InputStream is = sslSocket.getInputStream()){

            System.out.println("已成功连接到服务端.......");

            os.write("Hello Server".getBytes());
            os.flush();

            System.out.println("已发送 Hello Server 到服务端");

            byte[] buf = new byte[1024];
            is.read(buf);

            System.out.println("接收到服务端消息：" + new String(buf));
        }
        catch (Exception e){

            e.printStackTrace();
        }
    }
}
