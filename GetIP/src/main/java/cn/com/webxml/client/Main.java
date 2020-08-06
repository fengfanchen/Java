package cn.com.webxml.client;

import cn.com.webxml.IpAddressSearchWebService;
import cn.com.webxml.IpAddressSearchWebServiceSoap;

import java.util.List;

public class Main {

    public static void main(String[] args){

        IpAddressSearchWebService ipAddressSearchWebService = new IpAddressSearchWebService();
        IpAddressSearchWebServiceSoap ipAddressSearchWebServiceSoap = ipAddressSearchWebService.getIpAddressSearchWebServiceSoap();

        List<String> strings = ipAddressSearchWebServiceSoap.getCountryCityByIp("8.8.8.8").getString();

        for(String item : strings){

            System.out.println(item);
        }

        System.out.println("-------- 华丽的分割线 ----------");

        List<String> strings2 = ipAddressSearchWebServiceSoap.getCountryCityByIp("211.99.9.68").getString();
        for(String item : strings2){

            System.out.println(item);
        }
    }
}
