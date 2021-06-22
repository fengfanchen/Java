package cn.it1995;

import javax.net.ssl.KeyManager;
import javax.net.ssl.TrustManager;

public interface SslContextProvider {

    TrustManager[] getTrustManagers() throws Exception;
    KeyManager[] getKeyManagers() throws Exception;
    String getProtocol();
}
