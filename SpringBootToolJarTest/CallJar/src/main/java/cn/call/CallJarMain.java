package cn.call;

import cn.it1995.EnableTestService;
import cn.it1995.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableTestService
public class CallJarMain implements CommandLineRunner {

    @Autowired
    TestService testService;

    public static void main(String[] args) {

        SpringApplication.run(CallJarMain.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        testService.printAll();
    }
}
