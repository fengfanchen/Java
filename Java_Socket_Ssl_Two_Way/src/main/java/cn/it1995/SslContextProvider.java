package cn.it1995;

import javax.net.ssl.KeyManager;
import javax.net.ssl.TrustManager;
import java.io.IOException;
import java.security.GeneralSecurityException;

public interface SslContextProvider {

    TrustManager[] getTrustManagers() throws GeneralSecurityException, IOException;
    KeyManager[] getKeyManagers() throws GeneralSecurityException, IOException;
    String getProtocol();
}
