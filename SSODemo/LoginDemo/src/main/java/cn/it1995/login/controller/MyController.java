package cn.it1995.login.controller;

import cn.it1995.login.util.CookieUtil;
import cn.it1995.login.util.Result;
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


@RestController
public class MyController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String USER_KEY="user_key";

    private ConcurrentMap<String, Object> user = new ConcurrentHashMap<>();

    @GetMapping("/getUser")
    public Object getUser(HttpServletRequest request, HttpServletResponse response){

        String loginCookie = CookieUtil.getLoginCookie(request, response);
        Object o = user.get(loginCookie);
        return Result.success(o);
    }

    @PostMapping("/loginByQQ")
    public Object loginByQQ(String token, HttpServletResponse response, HttpServletRequest request){

        MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap();
        paramMap.add("token", token);
        ResponseEntity<Object> objectResponseEntity = restTemplate.postForEntity("http://127.0.0.7:8081/getLoginInfo", paramMap, Object.class);
        Object body = objectResponseEntity.getBody();
        String uuid = CookieUtil.setLoginCookie(request, response);

        //json标准化
        String newJson = body.toString().replace("=", ":");
        System.out.println(newJson);

        Map map = JSON.parseObject(newJson, Map.class);
        Map data = JSON.parseObject(map.get("data").toString(), Map.class);
        user.put(uuid, data);
        return Result.success();
    }
}
