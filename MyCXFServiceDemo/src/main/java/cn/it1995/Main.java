package cn.it1995;

import cn.it1995.service.MyService;
import cn.it1995.service.impl.MyServiceImpl;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

public class Main {

    public static void main(String[] args) {

        MyService myService = new MyServiceImpl();
        JaxWsServerFactoryBean factoryBean = new JaxWsServerFactoryBean();
        factoryBean.setAddress("http://127.0.0.1/MyService");   //设置暴露地址
        factoryBean.setServiceClass(MyService.class);   //接口
        factoryBean.setServiceBean(myService);  //设置实现类
        factoryBean.create();   //创建webservice接口
    }
}
