package cn.it1995.qqServer.controller;

import cn.it1995.qqServer.util.JwtUtil;
import cn.it1995.qqServer.util.Result;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentMap;


@Controller
public class UserController {

    @ResponseBody
    @RequestMapping("/login")
    public Object login(@RequestParam("username") String username,
                        @RequestParam("password") String password){

        Map<String, Object> map = new HashMap<>();
        map.put("username", username);
        map.put("password", password);
        String jwt = JwtUtil.createJWT(UUID.randomUUID().toString(), JSON.toJSONString(map), 3600 * 24);
        return jwt;
    }

    @ResponseBody
    @RequestMapping("/getLoginInfo")
    public Object getLoginInfo(String token){

        String subject = JwtUtil.parseJWT(token).getSubject();
        return Result.success().data(subject);
    }

}
