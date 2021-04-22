package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.service.WsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    WsService wsService;

    @PostMapping("/msg")
    public Object sendMsg(@RequestBody String req){

        JSONObject jsonObject = JSONObject.parseObject(req);
        System.out.println(jsonObject.getString("msg"));
        wsService.sendInfo(jsonObject.getString("msg"));

        return "success";
    }
}
