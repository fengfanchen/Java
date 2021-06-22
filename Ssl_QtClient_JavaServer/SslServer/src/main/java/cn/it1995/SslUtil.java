package cn.it1995;

import javax.naming.ldap.LdapName;
import javax.naming.ldap.Rdn;
import javax.net.ssl.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Socket;
import java.security.*;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;

public class SslUtil {

    private static final String JKS = "JKS";

    public static KeyManager[] createKeyManagers(String keyStorePath, String password) throws Exception {

        return createKeyManagers(keyStorePath, password, password);
    }

    public static KeyManager[] createKeyManagers(String keyStorePath, String storePassword, String keyPassword) throws Exception {

        String defaultAlgorithm = KeyManagerFactory.getDefaultAlgorithm();
        KeyManagerFactory kmInstance = KeyManagerFactory.getInstance(defaultAlgorithm);

        KeyStore ksInstance = KeyStore.getInstance(JKS);
        FileInputStream fileInputStream = new FileInputStream(keyStorePath);

        try{

            ksInstance.load(fileInputStream, storePassword.toCharArray());
        }
        catch (IOException e){

            e.printStackTrace();
        }
        catch (CertificateException e){

            e.printStackTrace();
        }
        finally {

            if(fileInputStream != null){

                fileInputStream.close();
            }
        }

        try{

            kmInstance.init(ksInstance, keyPassword.toCharArray());
        }
        catch (UnrecoverableKeyException e){

            e.printStackTrace();
        }

        return kmInstance.getKeyManagers();
    }

    public static SSLContext createSSLContext(SslContextProvider provider) throws Exception{

        SSLContext context = SSLContext.getInstance(provider.getProtocol());
        context.init(provider.getKeyManagers(), provider.getTrustManagers(), new SecureRandom());
        return context;
    }

    public static SSLServerSocket createSSLServerSocket(int port, SslContextProvider provider) throws Exception {

        SSLContext sslContext = createSSLContext(provider);
        SSLServerSocketFactory sslServerSocketFactory = sslContext.getServerSocketFactory();
        SSLServerSocket sslServerSocket = (SSLServerSocket)sslServerSocketFactory.createServerSocket(port);
        sslServerSocket.setEnabledProtocols(new String[]{provider.getProtocol()});
        sslServerSocket.setNeedClientAuth(true);
        return sslServerSocket;
    }

    public static SSLSocket createSSLSocket(String host, int port, SslContextProvider provider) throws Exception{

        SSLContext sslContext = createSSLContext(provider);
        SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
        SSLSocket sslSocket = (SSLSocket)sslSocketFactory.createSocket(host, port);
        sslSocket.setEnabledProtocols(new String[]{provider.getProtocol()});
        return sslSocket;
    }

    public static TrustManager[] createTrustManagers(String keyStorePath, String password) throws Exception{

        String defaultAlgorithm = TrustManagerFactory.getDefaultAlgorithm();
        TrustManagerFactory tmInstance = TrustManagerFactory.getInstance(defaultAlgorithm);
        KeyStore ksInstance = KeyStore.getInstance(JKS);
        FileInputStream fileInputStream = new FileInputStream(keyStorePath);

        try{

            ksInstance.load(fileInputStream, password.toCharArray());
        }
        catch (IOException e){

            e.printStackTrace();
        }
        catch (CertificateException e){

            e.printStackTrace();
        }
        finally {

            if(fileInputStream != null){

                fileInputStream.close();
            }
        }

        tmInstance.init(ksInstance);
        return tmInstance.getTrustManagers();
    }

    public static String getPeerIdentity(Socket socket){

        if(!(socket instanceof SSLSocket)){

            return null;
        }

        SSLSession sslSession = ((SSLSocket)socket).getSession();

        try{

            Principal peerPrincipal = sslSession.getPeerPrincipal();
            return getCommonName(peerPrincipal);
        }
        catch (SSLPeerUnverifiedException e){

            e.printStackTrace();
        }

        return "unknown client";
    }

    private static String getCommonName(Principal subject){

        try{

            LdapName ldapName = new LdapName(subject.getName());
            for(Rdn rdn : ldapName.getRdns()){

                if("cn".equalsIgnoreCase(rdn.getType())){

                    return (String)rdn.getValue();
                }
            }
        }
        catch (Exception e){

            e.printStackTrace();
        }

        return null;
    }
}
