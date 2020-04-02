package com.example.demo;

import com.example.demo.object.TestDemo;
import com.example.demo.service.TestDemoService;
import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    TestDemoService service;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("begin");

        System.out.println("例子1：获取所有数据 ");
        List<TestDemo> all = service.getAll();
        for(TestDemo item : all){

            System.out.println(item);
        }

        System.out.println("例子2：分页，每页2个，第1页的数据");
        List<TestDemo> limitedData = service.getLimitedData(1, 2);
        for(TestDemo item : limitedData){

            System.out.println(item);
        }

        System.out.println("例子2：分页，每页3个，第2页的数据");
        List<TestDemo> limitedData2 = service.getLimitedData(2, 3);
        for(TestDemo item : limitedData2){

            System.out.println(item);
        }


        System.out.println("end");
    }
}
