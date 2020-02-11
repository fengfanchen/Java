package com.process.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        new ClassPathXmlApplicationContext("springRedis.xml");
        SpringApplication.run(DemoApplication.class, args);
    }

}
