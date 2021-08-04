package cn.it1995;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class DataSecret {

    private static final String SELECT_ALGORITHM = "AES";   //DES、DESede或者AES

    public static byte[] encrypt(byte[] data, byte[] key) throws Exception {

        //生成本地密钥
        SecretKey secretKey = new SecretKeySpec(key, SELECT_ALGORITHM);

        //加密
        Cipher cipher = Cipher.getInstance(secretKey.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return cipher.doFinal(data);
    }

    public static byte[] decrypt(byte[] data, byte[] key) throws Exception {

        SecretKey secretKey = new SecretKeySpec(key, SELECT_ALGORITHM);
        Cipher cipher = Cipher.getInstance(secretKey.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return cipher.doFinal(data);
    }
}
