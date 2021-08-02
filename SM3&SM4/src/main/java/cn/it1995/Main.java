package cn.it1995;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.symmetric.SM4;
import cn.hutool.crypto.symmetric.SymmetricCrypto;

public class Main {

    static String txt = "HelloWorld";

    public static void test1(){

        String sm3 = SmUtil.sm3(txt);
        System.out.println("sm3:" + sm3);
    }

    public static void test2(){

        SymmetricCrypto sm4 = SmUtil.sm4();
        String encryptHex = sm4.encryptHex(txt);
        System.out.println("加密:" + encryptHex);

        String decryptStr = sm4.decryptStr(encryptHex, CharsetUtil.CHARSET_UTF_8);
        System.out.println("decryptStr:" + decryptStr);

    }

    public static void test3(){

        //密钥长度为128位
        SM4 sm4 = SmUtil.sm4("1234567891234567".getBytes());
        String encryptString = sm4.encryptHex(txt);
        System.out.println("encryptString:" + encryptString);
        String decryptString = sm4.decryptStr(encryptString, CharsetUtil.CHARSET_UTF_8);
        System.out.println("decryptString:" + decryptString);
    }

    public static void main(String[] args) {

        test1();
        System.out.println("--------------------华丽的分割线--------------------");
        test2();
        System.out.println("--------------------华丽的分割线--------------------");
        test3();
    }
}
