package com.example.demo;

import com.example.demo.tool.MD5Utils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        String rootStr = "root";
        String adminStr = "admin";

        System.out.println(MD5Utils.generateMD5(rootStr));
        System.out.println(MD5Utils.generateMD5(adminStr));
    }
}
