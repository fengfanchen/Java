package cn.it1995.cn.controller;

import cn.it1995.cn.service.MyObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    MyObjectService myObjectService;

    @GetMapping("getAll")
    public Object getAll(){

        return myObjectService.getAll();
    }

    @GetMapping("getOne")
    public Object getOne(@RequestParam("id") Integer id){

        return myObjectService.getMyObjectById(id);
    }
}