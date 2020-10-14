package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class controller {

    @GetMapping("/test1")
    public String test1(){

        log.info("test1");
        return "test1";
    }

    @GetMapping("/test2")
    public String test2(){

        log.error("test2");
        return "test2";
    }


    @GetMapping("/test3")
    public String test3(){

        log.debug("test3");
        return "test3";
    }
}
