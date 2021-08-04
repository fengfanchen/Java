package cn.it1995;

import org.apache.commons.codec.binary.Base64;

import java.util.Map;

public class Test {

    private static byte[] publicKey1;
    private static byte[] privateKey1;
    private static byte[] key1;

    private static byte[] publicKey2;
    private static byte[] privateKey2;
    private static byte[] key2;

    public static void main(String[] args) throws Exception {

        System.getProperties().setProperty("jdk.crypto.KeyAgreement.legacyKDF", "true");

        //服务端密钥
        Map<String, Object> keyMap1 = DH.initKey();
        publicKey1 = DH.getPublicKey(keyMap1);
        privateKey1 = DH.getPrivateKey(keyMap1);
        System.out.println("服务端公钥:" + Base64.encodeBase64String(publicKey1));
        System.out.println("服务端私钥:" + Base64.encodeBase64String(privateKey1));

        //客户端密钥
        Map<String, Object> keyMap2 = DH.initKey();
        publicKey2 = DH.getPublicKey(keyMap2);
        privateKey2 = DH.getPrivateKey(keyMap2);
        System.out.println("客户端公钥:" + Base64.encodeBase64String(publicKey2));
        System.out.println("客户端私钥:" + Base64.encodeBase64String(privateKey2));

        //服务端公钥和客户端私钥生成密钥
        key1 = DH.getSecretKey(publicKey1, privateKey2);
        System.out.println("客户端计算出的AES密钥:" + Base64.encodeBase64String(key1));

        //客户端公钥和服务端私钥生成密钥
        key2 = DH.getSecretKey(publicKey2, privateKey1);
        System.out.println("服务端计算出的AES密钥:" + Base64.encodeBase64String(key2));

        //开始进行加密
        String string = "Hello world, 中文";
        byte[] encrypt = DataSecret.encrypt(string.getBytes(), key1);
        byte[] decrypt = DataSecret.decrypt(encrypt, key2);

        System.out.println("原文:" + string);
        System.out.println("密文:" + new String(encrypt));
        System.out.println("解密:" + new String(decrypt));
    }
}
