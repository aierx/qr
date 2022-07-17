package com.aierx.boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class ProducerController {
//    @Autowired
//    private KafkaTemplate<String,Object> kafkaTemplate;

    @GetMapping("produce")
    public String send(String msg){
//        GenericMessage<UserPO> userPOGenericMessage = new GenericMessage<>(new UserPO("asdada", "asdadsad"));
//        kafkaTemplate.send(userPOGenericMessage);
//        kafkaTemplate.send("demo",msg);
        return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
    }
}
