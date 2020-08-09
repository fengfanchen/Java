package cn.it1995.service.impl;

import cn.it1995.entity.Role;
import cn.it1995.service.MyService;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebService
public class MyServiceImpl implements MyService {


    public String say(String str) {

        return "Hello" + str;
    }

    public Map<String, List<Role>> getRoles() {

        Map<String, List<Role>> map = new HashMap<String, List<Role>>();
        List<Role> roleList1 = new ArrayList<Role>();
        roleList1.add(new Role(1, "架构师"));
        roleList1.add(new Role(2, "技术总监"));
        map.put("xxx", roleList1);

        List<Role> roleList2 = new ArrayList<Role>();
        roleList2.add(new Role(3, "程序员"));
        map.put("yyy", roleList2);

        return map;
    }
}
