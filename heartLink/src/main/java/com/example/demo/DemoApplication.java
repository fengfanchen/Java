package com.example.demo;

import com.example.demo.Thead.HeartThread;
import com.example.demo.service.JDBCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    JDBCService jdbcService;

    @Autowired
    HeartThread heartThread;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        heartThread.start();
    }
}
