package cn.it1995.ipHash.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
public class Server1Controller {

    @GetMapping("/login")
    public Object userLogin(@RequestParam("username") String username,
                            @RequestParam("password") String password,
                            HttpSession session){

        session.setAttribute("username", username);
        session.setAttribute("password", password);

        Map<String, Object> ret = new HashMap<>();
        ret.put("result", "登录成功");


        return ret;
    }

    @GetMapping("getUser")
    public Object getUser(HttpSession session){

        Object username = session.getAttribute("username");
        Object password = session.getAttribute("password");
        Map<String, Object> ret = new HashMap<>();
        ret.put("用户名", username);
        ret.put("密码", password);
        ret.put("当前服务器名称", "IPHashServer1");

        return ret;
    }
}
