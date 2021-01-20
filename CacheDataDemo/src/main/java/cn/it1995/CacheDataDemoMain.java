package cn.it1995;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CacheDataDemoMain {

    public static void main(String[] args){

        SpringApplication.run(CacheDataDemoMain.class);
    }
}
