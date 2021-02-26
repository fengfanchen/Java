package cn.it1995;

import javax.naming.ldap.LdapName;
import javax.naming.ldap.Rdn;
import javax.net.ssl.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Socket;
import java.security.*;
import java.security.cert.CertificateException;

public class SslUtil {

    private static final String JKS = "JKS";

    public static KeyManager[] createKeyManagers(String keyStorePath, String password) throws NoSuchAlgorithmException, KeyStoreException, IOException {

        return createKeyManagers(keyStorePath, password, password);
    }

    public static KeyManager[] createKeyManagers(String keyStorePath, String storePassword, String keyPassword) throws NoSuchAlgorithmException, KeyStoreException, IOException {

        String defaultAlgorithm = KeyManagerFactory.getDefaultAlgorithm();
        KeyManagerFactory kmInstance = KeyManagerFactory.getInstance(defaultAlgorithm);

        KeyStore ksInstance = KeyStore.getInstance(JKS);
        FileInputStream fileInputStream = new FileInputStream(keyStorePath);

        try {

            ksInstance.load(fileInputStream, storePassword.toCharArray());
        }
        catch (IOException e) {

            e.printStackTrace();
        }
        catch (CertificateException e) {

            e.printStackTrace();
        }
        finally {

            if(fileInputStream != null){

                fileInputStream.close();
            }
        }

        try {

            kmInstance.init(ksInstance, keyPassword.toCharArray());

        }
        catch (UnrecoverableKeyException e) {

            e.printStackTrace();
        }

        return kmInstance.getKeyManagers();
    }

    public static SSLContext createSSLContext(SslContextProvider provider) throws GeneralSecurityException, IOException {

        SSLContext context = SSLContext.getInstance(provider.getProtocol());
        context.init(provider.getKeyManagers(), provider.getTrustManagers(), new SecureRandom());
        return context;
    }

    public static SSLServerSocket createSSLServerSocket(int port, SslContextProvider provider) throws GeneralSecurityException, IOException {

        SSLContext context = createSSLContext(provider);
        SSLServerSocketFactory serverSocketFactory = context.getServerSocketFactory();
        SSLServerSocket sslServerSocket = (SSLServerSocket) serverSocketFactory.createServerSocket(port);
        sslServerSocket.setEnabledProtocols(new String[]{provider.getProtocol()});
        sslServerSocket.setNeedClientAuth(true);
        return sslServerSocket;
    }

    public static SSLSocket createSSLSocket(String host, int port, SslContextProvider provider) throws GeneralSecurityException, IOException {

        SSLContext sslContext = createSSLContext(provider);
        SSLSocketFactory socketFactory = sslContext.getSocketFactory();
        SSLSocket sslSocket = (SSLSocket) socketFactory.createSocket(host, port);
        sslSocket.setEnabledProtocols(new String[]{provider.getProtocol()});
        return sslSocket;
    }

    public static TrustManager[] createTrustManagers(String keyStorePath, String password) throws NoSuchAlgorithmException, KeyStoreException, IOException {

        String defaultAlgorithm = TrustManagerFactory.getDefaultAlgorithm();
        TrustManagerFactory tmInstance = TrustManagerFactory.getInstance(defaultAlgorithm);
        KeyStore ksInstance = KeyStore.getInstance(JKS);
        FileInputStream fileInputStream = new FileInputStream(keyStorePath);

        try{

            ksInstance.load(fileInputStream, password.toCharArray());
        }
        catch(IOException e){

            e.printStackTrace();
        }
        catch(CertificateException e){

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

        SSLSession session = ((SSLSocket) socket).getSession();

        try {

            Principal peerPrincipal = session.getPeerPrincipal();
            return getCommonName(peerPrincipal);
        }
        catch(SSLPeerUnverifiedException e){

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
