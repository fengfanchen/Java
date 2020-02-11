package com.example.demo.conf;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class JavaConf {

    @Value("${my.string}")
    private String string1;

    @Value("${my.string2}")
    private String string2;

    @Value("${redis.ip}")
    private String redisIP;

    @Value("${redis.port}")
    private Integer redisPort;

    @Value("${redis.passwd}")
    private String redisPW;


}
