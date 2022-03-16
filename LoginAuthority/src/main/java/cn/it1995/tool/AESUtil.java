package cn.it1995.tool;


import org.apache.tomcat.util.codec.binary.Base64;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

public class AESUtil {

    public static String decrypt(String content, String key, String vi) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException, UnsupportedEncodingException, InvalidAlgorithmParameterException {

        Key k = toKey(key.getBytes());
        byte[] encoded = k.getEncoded();
        SecretKeySpec aes = new SecretKeySpec(encoded, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
        IvParameterSpec iv = new IvParameterSpec(vi.getBytes());
        cipher.init(Cipher.DECRYPT_MODE, aes, iv);

        byte[] bytes = cipher.doFinal(Base64.decodeBase64(content));

        return new String(bytes, "UTF-8");
    }

    public static String encrypt(String data, String key, String vi) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException {

        //Key k = toKey(Base64.decodeBase64(key));
        Key k = toKey(key.getBytes());
        byte[] encoded = k.getEncoded();
        SecretKeySpec aes = new SecretKeySpec(encoded, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
        IvParameterSpec iv = new IvParameterSpec(vi.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, aes, iv);
        byte[] bytes = cipher.doFinal(data.getBytes("UTF-8"));
        return Base64.encodeBase64String(bytes);
    }

    private static Key toKey(byte[] key){

        SecretKeySpec aes = new SecretKeySpec(key, "AES");
        return aes;
    }

    public static void main(String[] args) throws NoSuchPaddingException, BadPaddingException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, IllegalBlockSizeException, UnsupportedEncodingException, InvalidKeyException {

        String content = "7mv2MJPHj1o/rdar1I4i0Q==";
        String key = "sN1DEJAVZNf3OdM3";
        String vi = "GDHgt7hbKpsIR4b4";

        System.out.println("原文 : root");

        String e = AESUtil.encrypt("root", key, vi);
        System.out.println("密文 : " + e);
        String f = AESUtil.decrypt(e, key, vi);
        System.out.println("解密 : " + f);
    }

}