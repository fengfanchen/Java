package com.example.demo.controller;

import com.example.demo.dao.AppInfoMapper;

import com.example.demo.object.AppInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@ResponseBody
public class TestController {

    @Resource
    private AppInfoMapper mapper;

    @GetMapping("/select")
    public String select(){

        System.out.println(mapper.getAllAPPInfo());
        return "<h1>Hello World</h1>";
    }

    @GetMapping("/insert")
    public String insert(){

        AppInfo appInfo = new AppInfo();
        appInfo.setAppXXId("10086");
        appInfo.setNodeXXId("10010");
        appInfo.setAppXXChnName("呵呵哒");
        appInfo.setAppXXEngName("English");
        mapper.addAPPInfo(appInfo);
        System.out.println(mapper.getAllAPPInfo());
        return "<h1>Hello World</h1>";
    }

    @GetMapping("/update")
    public String update(){

        AppInfo appInfo = new AppInfo();
        appInfo.setAppXXId("10086");
        appInfo.setNodeXXId("10000");
        appInfo.setAppXXChnName("哦！是吗");
        appInfo.setAppXXEngName("Chinese");
        mapper.updateAPPInfo(appInfo);
        System.out.println(mapper.getAllAPPInfo());
        return "<h1>Hello World</h1>";
    }

    @GetMapping("/delete")
    public String delete(){

        AppInfo appInfo = new AppInfo();
        appInfo.setAppXXId("10086");
        mapper.deleteAPPInfo(appInfo);
        System.out.println(mapper.getAllAPPInfo());
        return "<h1>Hello World</h1>";
    }
}
