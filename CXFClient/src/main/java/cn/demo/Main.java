package cn.demo;

import cn.demo.webservice.WeatherService;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {

    public static void main(String[] args){

        SpringApplication.run(Main.class, args);
    }

    public void run(String... strings) throws Exception {

        JaxWsProxyFactoryBean proxyFactoryBean = new JaxWsProxyFactoryBean();

        //设置服务地址
        proxyFactoryBean.setAddress("http://localhost:9998/weatherService");

        //设置服务接口
        proxyFactoryBean.setServiceClass(WeatherService.class);

        //通过工厂获取对象
        WeatherService service = (WeatherService)proxyFactoryBean.create();
        String nj = service.query("南京");

        System.out.println(nj);
    }
}
