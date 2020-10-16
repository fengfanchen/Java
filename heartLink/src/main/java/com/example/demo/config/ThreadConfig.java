package com.example.demo.config;

import com.example.demo.Thead.HeartThread;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ThreadConfig {

    @Bean
    public HeartThread heartThread(){

        HeartThread heartThread = new HeartThread();
        heartThread.setHeartSqlCmd("select * from v$version");
        return heartThread;
    }
}
