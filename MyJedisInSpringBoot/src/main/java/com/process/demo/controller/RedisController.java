package com.process.demo.controller;

import com.process.demo.service.RedisService;
import com.process.demo.utils.ResultUtil;
import com.process.demo.vo.RedisListVO;
import com.process.demo.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/it1995")
public class RedisController {

    @Autowired
    RedisService service;

    @GetMapping("/it1995_1")
    public ResultVO getSysNodeInfo(){

        List<Map<String, String>> sysNodeInfo = service.getit1995_1();

        RedisListVO listVO = new RedisListVO();

        for(Map<String, String> map : sysNodeInfo){

            listVO.getRedisVOS().add(map);
        }

        return ResultUtil.success(listVO);
    }

    @GetMapping("/it1995_2")
    public ResultVO getAppInfo(){

        List<Map<String, String>> appInfo = service.getit1995_2();
        RedisListVO listVO = new RedisListVO();

        for(Map<String, String> map : appInfo){

            listVO.getRedisVOS().add(map);
        }

        return ResultUtil.success(listVO);
    }

    @GetMapping("/it1995_3")
    public ResultVO getProcInfo(){

        List<Map<String, String>> procInfo = service.getit1995_3();
        RedisListVO listVO = new RedisListVO();

        for(Map<String, String> map : procInfo){

            listVO.getRedisVOS().add(map);
        }

        return ResultUtil.success(listVO);
    }
}
