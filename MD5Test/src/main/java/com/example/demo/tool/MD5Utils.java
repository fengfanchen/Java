package com.example.demo.tool;

import org.springframework.util.DigestUtils;

public class MD5Utils {

    public static String generateMD5(String originStr){

        return new String(DigestUtils.md5DigestAsHex(originStr.getBytes()));
    }
}
