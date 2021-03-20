package cn.it1995.controller;

import cn.it1995.service.GetDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    GetDataService getDataService;

    @GetMapping("/getAll")
    public Object getAll(){

        return getDataService.getAll();
    }

    @GetMapping("getOne")
    public Object getOne(@RequestParam("id") Integer id){

        return getDataService.getOne(id);
    }
}
