package cn.it1995.adapter;

import cn.it1995.entity.MyRole;
import cn.it1995.entity.Role;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapAdapter extends XmlAdapter<MyRole[], Map<String, List<Role>>> {

    /***
     * 适配器转换 MyRole[] -> Map<String, List<Role>>
     * @param v
     * @return
     * @throws Exception
     */
    public Map<String, List<Role>> unmarshal(MyRole[] v) throws Exception {

        Map<String, List<Role>> map = new HashMap<String, List<Role>>();

        for(int i = 0; i < v.length; i++){

            MyRole r = v[i];
            map.put(r.getKey(), r.getValue());
        }

        return map;
    }


    /***
     * 适配器转换 Map<String, List<Role>> -> MyRole[]
     * @param v
     * @return
     * @throws Exception
     */
    public MyRole[] marshal(Map<String, List<Role>> v) throws Exception {

        MyRole[] roles = new MyRole[v.size()];
        int i = 0;
        for(String key : v.keySet()){

            roles[i] = new MyRole();
            roles[i].setKey(key);
            roles[i].setValue(v.get(key));
        }

        return roles;
    }
}