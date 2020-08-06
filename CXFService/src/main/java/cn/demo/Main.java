package cn.demo;


import cn.demo.webService.WeatherService;
import cn.demo.webService.WeatherServiceImpl;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {

    public static void main(String[] args){

        SpringApplication.run(Main.class, args);
    }

    public void run(String... args) throws Exception {

        JaxWsServerFactoryBean factoryBean = new JaxWsServerFactoryBean();

        //设置发布的地址
        factoryBean.setAddress("http://localhost:9998/weatherService");

        //设置访问接口
        factoryBean.setServiceClass(WeatherService.class);

        //设置服务的实现对象
        factoryBean.setServiceBean(new WeatherServiceImpl());

        //通过工厂创建服务
        factoryBean.create();
        System.out.println("发布服务成功!");
    }
}
