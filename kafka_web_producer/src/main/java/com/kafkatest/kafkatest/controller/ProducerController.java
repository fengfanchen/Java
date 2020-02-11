package com.kafkatest.kafkatest.controller;

import com.google.gson.Gson;
import com.kafkatest.kafkatest.common.MessageEntity;
import com.kafkatest.kafkatest.producer.SimpleProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/kafka")
@ResponseBody
@Controller
public class ProducerController {

    @Autowired
    private SimpleProducer simpleProducer;

    @Value("${kafka.topic.default}")
    private String topic;

    private Gson gson = new Gson();

    @GetMapping("/hello")
    public String sendKafka(){

        MessageEntity entity = new MessageEntity();
        entity.setTitle("First");
        entity.setBody("HOW ARE YOU");
        simpleProducer.send(topic, entity);

        return "<h1>HelloWorld</h1>";
    }
}
