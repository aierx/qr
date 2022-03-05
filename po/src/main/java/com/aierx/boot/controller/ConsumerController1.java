package com.aierx.boot.controller;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ConsumerController1 {

    @KafkaListener(topics = "demo",groupId = "10086")
    public void listen (ConsumerRecord<?, ?> record){
        System.out.printf("1111topic is %s, offset is %d, value is %s \n", record.topic(), record.offset(), record.value());
    }

}
