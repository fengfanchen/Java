package cn.com.webxml.client;

import cn.com.webxml.QqOnlineWebService;
import cn.com.webxml.QqOnlineWebServiceSoap;

public class Main {

    public static void main(String[] args){

        QqOnlineWebService qqOnlineWebService = new QqOnlineWebService();
        QqOnlineWebServiceSoap qqOnlineWebServiceSoap = qqOnlineWebService.getQqOnlineWebServiceSoap();

        String s = qqOnlineWebServiceSoap.qqCheckOnline("570176391");
        System.out.println("570176391 is online: " + s);
        String s2 = qqOnlineWebServiceSoap.qqCheckOnline("12");
        System.out.println("78442761 is online: " + s2);
    }
}
