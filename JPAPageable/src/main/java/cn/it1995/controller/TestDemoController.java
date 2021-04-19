package cn.it1995.controller;

import cn.it1995.Response.CommonResp;
import cn.it1995.Response.PageResp;
import cn.it1995.object.TestDemo;
import cn.it1995.req.PageRequest;
import cn.it1995.req.TestDemoRequest;
import cn.it1995.service.TestDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestDemoController {

    @Autowired
    TestDemoService testDemoService;

    @GetMapping("/getData")
    public Object getData(@RequestParam("pageNum") Integer pageNum, Integer size) {

        PageResp<ArrayList> arrayListPageResp = testDemoService.listAll(pageNum, size);
        return arrayListPageResp;
    }

    @GetMapping("/get/{id}")
    public Object getId(@PathVariable Long id,
                        @RequestParam("name") String name){

        System.out.println("id:" + id);
        System.out.println("name:" + name);

        Map<String, Object> ret = new HashMap<>();
        ret.put("code", 200);
        ret.put("msg", "成功");
        return ret;
    }

    @GetMapping("/validGet")
    public Object validGet(@Valid PageRequest pageRequest){

        System.out.println(pageRequest);

        PageResp<ArrayList> arrayListPageResp = testDemoService.listAll(pageRequest.getPage(), pageRequest.getSize());

        CommonResp commonResp = new CommonResp();
        commonResp.setMessage("成功");
        commonResp.setContent(arrayListPageResp);

        return commonResp;
    }
}