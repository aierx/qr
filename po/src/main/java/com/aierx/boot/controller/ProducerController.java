package com.aierx.boot.controller;

import com.aierx.boot.model.po.UserPO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@Validated
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
}
