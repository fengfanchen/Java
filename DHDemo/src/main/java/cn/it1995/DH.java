package cn.it1995;

import javax.crypto.KeyAgreement;
import javax.crypto.SecretKey;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

public abstract class DH {

    private static final String KEY_ALGORITHM = "DH";
    private static final int KEY_SIZE = 512;
    private static final String PUBLIC_KEY = "DHPublicKey";
    private static final String PRIVATE_KEY = "DHPrivateKey";
    private static final String SELECT_ALGORITHM = "AES";   //DES、DESede或者AES

    /***
     * 初始化服务端密钥
     * @return
     * @throws Exception
     */
    public static Map<String, Object> initKey() throws Exception {

        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        keyPairGenerator.initialize(KEY_SIZE);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        DHPublicKey publicKey = (DHPublicKey)keyPair.getPublic();
        DHPrivateKey privateKey = (DHPrivateKey)keyPair.getPrivate();

        Map<String, Object> keyMap = new HashMap<>();
        keyMap.put(PUBLIC_KEY, publicKey);
        keyMap.put(PRIVATE_KEY, privateKey);

        return keyMap;
    }

    public static byte[] getSecretKey(byte[] publicKey, byte[] privateKey) throws Exception {

        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(publicKey);
        PublicKey pubKey = keyFactory.generatePublic(x509KeySpec);

        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(privateKey);
        PrivateKey priKey = keyFactory.generatePrivate(pkcs8KeySpec);

        KeyAgreement keyAgree = KeyAgreement.getInstance(keyFactory.getAlgorithm());

        keyAgree.init(priKey);
        keyAgree.doPhase(pubKey, true);
        SecretKey secretKey = keyAgree.generateSecret(SELECT_ALGORITHM);
        return secretKey.getEncoded();
    }

    public static byte[] getPublicKey(Map<String, Object> keyMap){

        Key key = (Key) keyMap.get(PUBLIC_KEY);
        return key.getEncoded();
    }

    public static byte[] getPrivateKey(Map<String, Object> keyMap){

        Key key = (Key) keyMap.get(PRIVATE_KEY);
        return key.getEncoded();
    }

}
