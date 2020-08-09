package cn.it1995.service.impl;

import cn.it1995.service.MyService;

import javax.jws.WebService;

@WebService
public class MyServiceImpl implements MyService {


    public String say(String str) {

        return "Hello" + str;
    }
}
