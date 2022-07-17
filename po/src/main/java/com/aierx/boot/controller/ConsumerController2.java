package com.aierx.boot.controller;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ConsumerController2 {

//    @KafkaListener(topics = "demo")
    public void listen (ConsumerRecord<?, ?> record){
        System.out.printf("2222topic is %s, offset is %d, value is %s \n", record.topic(), record.offset(), record.value());
    }

}
