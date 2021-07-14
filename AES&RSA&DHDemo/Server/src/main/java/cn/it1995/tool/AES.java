package cn.it1995.tool;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

//AES没有公钥和私钥之分
public class AES {

    private SecretKey mKey;

    public AES(){

        try {

            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            //创建随机密码，并设置种子
            SecureRandom secureRandom = new SecureRandom();
            secureRandom.setSeed(System.currentTimeMillis());

            //初始化密钥对象
            keyGenerator.init(128, secureRandom);
            mKey = keyGenerator.generateKey();
        }
        catch (NoSuchAlgorithmException e) {

            e.printStackTrace();
        }
    }

    public SecretKey getKey() {

        return mKey;
    }

    public void setKey(byte[] mKey) {

        this.mKey = new SecretKeySpec(mKey, "AES");
    }


    public byte[] encrypt(String content){

        if(mKey == null){

            return new byte[]{-1};
        }

        try {

            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, mKey);
            return cipher.doFinal(content.getBytes());
        }
        catch (NoSuchAlgorithmException e) {

            e.printStackTrace();
        }
        catch (NoSuchPaddingException e) {

            e.printStackTrace();
        }
        catch (BadPaddingException e) {

            e.printStackTrace();
        }
        catch (IllegalBlockSizeException e) {

            e.printStackTrace();
        }
        catch (InvalidKeyException e) {

            e.printStackTrace();
        }

        return new byte[]{-1};
    }

    public byte[] decrypt(byte[] content){

        if(mKey == null){

            return new byte[]{-1};
        }

        try {

            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, mKey);
            return cipher.doFinal(content);
        }
        catch (NoSuchAlgorithmException e) {

            e.printStackTrace();
        }
        catch (NoSuchPaddingException e) {

            e.printStackTrace();
        }
        catch (BadPaddingException e) {

            e.printStackTrace();
        }
        catch (IllegalBlockSizeException e) {

            e.printStackTrace();
        }
        catch (InvalidKeyException e) {

            e.printStackTrace();
        }

        return new byte[]{-1};
    }
}
