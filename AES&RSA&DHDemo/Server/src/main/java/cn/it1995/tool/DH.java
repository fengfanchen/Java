package cn.it1995.tool;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class DH {

    private static final int dhP = 45;
    private static final  int dhG = 9;

    private int mPriKey;

    //构造函数随机私钥
    public DH(){

        Random r = new Random();
        mPriKey = r.nextInt(20);
        System.out.println("dh priKey is : " + mPriKey);
    }

    //公钥计算公式计算出公钥
    public int getPublicKey(){

        return (int) (Math.pow(dhG, mPriKey) % dhP);
    }

    //使用对方公钥与自己私钥生成密钥
    //在把结果转256字节，AES密钥需要128字节或256字节
    public byte[] getSecretKey(long publicKey){

        int buf = (int) (Math.pow(publicKey, mPriKey) % dhP);
        return sha256(buf);
    }

    //转换成byte[256]类型，作为AES密钥
    private byte[] sha256(int data){

        try {

            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(DataSecret.int2Byte(data));
            return messageDigest.digest();
        }
        catch (NoSuchAlgorithmException e) {
            
            e.printStackTrace();
        }

        return new byte[]{-1};
    }
}
