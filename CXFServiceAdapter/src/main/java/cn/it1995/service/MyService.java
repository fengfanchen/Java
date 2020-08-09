package cn.it1995.service;

import cn.it1995.adapter.MapAdapter;
import cn.it1995.entity.Role;

import javax.jws.WebService;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.List;
import java.util.Map;

@WebService
public interface MyService {

    public String say(String str);

    @XmlJavaTypeAdapter(MapAdapter.class)
    public Map<String, List<Role>> getRoles();
}
