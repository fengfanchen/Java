package com.example.demo;

import com.example.demo.conf.JavaConf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Autowired
    JavaConf javaConf;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("\n\n\n");
        System.out.println("\n\n\n");
        System.out.println("\n\n\n");

        System.out.println("begin");

        System.out.println(javaConf);

        System.out.println("---------- 华丽的分割线 ----------");
        System.out.println("\n\n\n");
        System.out.println("\n\n\n");
    }
}
