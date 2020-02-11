package com.kafkatest.kafkatest.consumer;

import com.google.gson.Gson;
import com.kafkatest.kafkatest.common.MessageEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SimpleConsumer {

    private final Gson gson = new Gson();

    @KafkaListener(topics = "${kafka.topic.default}", containerFactory = "kafkaListenerContainerFactory")
    public void receive(MessageEntity messageEntity){

        log.info(gson.toJson(messageEntity));
    }
}
