package cn.it1995;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.HexUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.SM2;

import javax.swing.*;
import java.security.KeyPair;

public class Main {

    static String txt = "Hello World";

    /***
     * 随机生成的密钥对加密或解密
     */
    public static void test1(){

        SM2 sm2 = SmUtil.sm2();

        System.out.println("私钥:" + sm2.getPrivateKey());
        System.out.println("公钥:" + sm2.getPublicKey());

        String encryptStr = sm2.encryptBcd(txt, KeyType.PublicKey);
        String decryptStr = StrUtil.utf8Str(sm2.decryptFromBcd(encryptStr, KeyType.PrivateKey));

        System.out.println("密文:" + encryptStr);
        System.out.println("明文:" + decryptStr);
    }

    /***
     * 自定义密钥对加密或解密
     */
    public static void test2(){

        KeyPair pair = SecureUtil.generateKeyPair("SM2");
        byte[] privateKey = pair.getPrivate().getEncoded();
        byte[] publicKey = pair.getPublic().getEncoded();

        System.out.println("私钥:");
        for(Integer i = 0; i < privateKey.length; i++){

            System.out.print(privateKey[i] + " ");
        }

        System.out.println();
        System.out.println("公钥:");
        for(Integer i = 0; i < publicKey.length; i++){

            System.out.print(publicKey[i] + " ");
        }
        System.out.println();

        SM2 sm2 = SmUtil.sm2(privateKey, publicKey);

        String encryptStr = sm2.encryptBcd(txt, KeyType.PublicKey);
        String decryptStr = StrUtil.utf8Str(sm2.decryptFromBcd(encryptStr, KeyType.PrivateKey));

        System.out.println("密文:" + encryptStr);
        System.out.println("明文:" + decryptStr);
    }

    /***
     * 使用OpenSSL生成的SM2公钥和私钥加密或解密
     */
    public static void test3(){

        String privateKey = "MHcCAQEEIE8DQeWXexdeDsDh/e/SeZsT3SXFFxYTPvQrp2wO3Zc9oAoGCCqBHM9VAYItoUQDQgAE5SMhCzQHRkg5cjVY4NgnZbniyslJG9hsmcibn8Q/vpqUOV7jE428SuQ9qo/gH9US3oVoEC40xmmJ6yswZhG1GA==";
        String publicKey = "MFkwEwYHKoZIzj0CAQYIKoEcz1UBgi0DQgAE5SMhCzQHRkg5cjVY4NgnZbniyslJG9hsmcibn8Q/vpqUOV7jE428SuQ9qo/gH9US3oVoEC40xmmJ6yswZhG1GA==";

        SM2 sm2 = SmUtil.sm2(Base64.decode(privateKey), Base64.decode(publicKey));
        String encryptStr = sm2.encryptBcd(txt, KeyType.PublicKey);
        String decryptStr = StrUtil.utf8Str(sm2.decryptFromBcd(encryptStr, KeyType.PrivateKey));

        System.out.println("密文:" + encryptStr);
        System.out.println("明文:" + decryptStr);
    }

    /***
     * 随机密钥 签名和验签
     */
    public static void test4(){

        SM2 sm2 = SmUtil.sm2();
        String sign = sm2.signHex(HexUtil.encodeHexStr(txt));
        System.out.println("sign:" + sign);
        boolean verify = sm2.verifyHex(HexUtil.encodeHexStr(txt), sign);
        System.out.println("verify:" + verify);
    }

    /***
     * 自定义密钥对 签名和验签
     */
    public static void test5(){

        KeyPair pair = SecureUtil.generateKeyPair("SM2");
        final SM2 sm2 = new SM2(pair.getPrivate(), pair.getPublic());

        byte[] sign = sm2.sign(txt.getBytes());
        System.out.println("sign");
        for(Integer i = 0; i < sign.length; i++){

            System.out.print(sign[i] + " ");
        }
        System.out.println();

        boolean verify = sm2.verify(txt.getBytes(), sign);
        System.out.print("verify:" + verify);
    }

    /**
     * OpenSSL密钥对 签名和验签
     */
    public static void test6(){

        String privateKey = "MHcCAQEEIE8DQeWXexdeDsDh/e/SeZsT3SXFFxYTPvQrp2wO3Zc9oAoGCCqBHM9VAYItoUQDQgAE5SMhCzQHRkg5cjVY4NgnZbniyslJG9hsmcibn8Q/vpqUOV7jE428SuQ9qo/gH9US3oVoEC40xmmJ6yswZhG1GA==";
        String publicKey = "MFkwEwYHKoZIzj0CAQYIKoEcz1UBgi0DQgAE5SMhCzQHRkg5cjVY4NgnZbniyslJG9hsmcibn8Q/vpqUOV7jE428SuQ9qo/gH9US3oVoEC40xmmJ6yswZhG1GA==";

        SM2 sm2 = SmUtil.sm2(Base64.decode(privateKey), Base64.decode(publicKey));
        byte[] sign = sm2.sign(txt.getBytes());

        System.out.println("sign");
        for(Integer i = 0; i < sign.length; i++){

            System.out.print(sign[i] + " ");
        }
        System.out.println();

        boolean verify = sm2.verify(txt.getBytes(), sign);
        System.out.print("verify:" + verify);
    }

    /***
     * 分开的：私钥签名，公钥验签
     * 密钥使用OpenSSL生成
     */
    public static void test7(){

        String privateKey = "MHcCAQEEIE8DQeWXexdeDsDh/e/SeZsT3SXFFxYTPvQrp2wO3Zc9oAoGCCqBHM9VAYItoUQDQgAE5SMhCzQHRkg5cjVY4NgnZbniyslJG9hsmcibn8Q/vpqUOV7jE428SuQ9qo/gH9US3oVoEC40xmmJ6yswZhG1GA==";
        String publicKey = "MFkwEwYHKoZIzj0CAQYIKoEcz1UBgi0DQgAE5SMhCzQHRkg5cjVY4NgnZbniyslJG9hsmcibn8Q/vpqUOV7jE428SuQ9qo/gH9US3oVoEC40xmmJ6yswZhG1GA==";

        SM2 sm2Sign = SmUtil.sm2(Base64.decode(privateKey), null);
        sm2Sign.usePlainEncoding();
        byte[] sign = sm2Sign.sign(txt.getBytes(), null);

        System.out.println("sign");
        for(Integer i = 0; i < sign.length; i++){

            System.out.print(sign[i] + " ");
        }
        System.out.println();

        SM2 sm2 = SmUtil.sm2(null, Base64.decode(publicKey));
        sm2.usePlainEncoding();
        boolean verify = sm2.verify(txt.getBytes(), sign);
        System.out.print("verify:" + verify);
    }

    public void test8(){


    }

    public static void main(String[] args) {

        test1();
        System.out.println("--------------------华丽的分割线------------------------");
        test2();
        System.out.println("--------------------华丽的分割线------------------------");
        test3();
        System.out.println("--------------------华丽的分割线------------------------");
        test4();
        System.out.println("--------------------华丽的分割线------------------------");
        test5();
        System.out.println("--------------------华丽的分割线------------------------");
        test6();
        System.out.println("--------------------华丽的分割线------------------------");
        test7();
    }
}
