package cn.com.webxml.client;

import cn.com.webxml.ArrayOfString;
import cn.com.webxml.MobileCodeWS;
import cn.com.webxml.MobileCodeWSSoap;

import java.util.List;

public class Main {

    public static void main(String[] args){

        MobileCodeWS mobileCodeWS = new MobileCodeWS();
        MobileCodeWSSoap mobileCodeWSSoap = mobileCodeWS.getMobileCodeWSSoap();
        String mobileCodeInfo = mobileCodeWSSoap.getMobileCodeInfo("13151111111", null);
        System.out.println(mobileCodeInfo);

        System.out.println("----------------- 华丽的分割线 -----------------");

        List<String> strings = mobileCodeWSSoap.getDatabaseInfo().getString();
        for(String item : strings){

            System.out.println(item);
        }
    }
}
