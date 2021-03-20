package cn.it1995;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DataServerMain {

    public static void main(String[] args) {

        SpringApplication.run(DataServerMain.class, args);
    }
}