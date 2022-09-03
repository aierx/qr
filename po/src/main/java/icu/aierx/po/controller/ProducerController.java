package icu.aierx.po.controller;

import icu.aierx.po.model.po.UserPO;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@Validated
@Slf4j
public class ProducerController {
//    @Autowired
//    private KafkaTemplate<String,Object> kafkaTemplate;

    @PostMapping("produce")
    public String send(@NotEmpty @RequestParam(value = "aa") String aa , @RequestBody() UserPO userPO){
//        GenericMessage<UserPO> userPOGenericMessage = new GenericMessage<>(new UserPO("asdada", "asdadsad"));
//        kafkaTemplate.send(userPOGenericMessage);
//        kafkaTemplate.send("demo",msg);
        return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
    }
    
    
    
    @Autowired
    RocketMQTemplate template;
    
    String TOPIC = "leiwenyong";
    
    @GetMapping("/rmq")
    public String send(){
        Date date = new Date();
        log.info("开始发送消息");
        template.syncSend(TOPIC+":tag1","leiwenyong"+date.toString());
        
        return  date.toString();
    }
}
