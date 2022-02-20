package com.aierx.atx;

import com.aierx.atx.model.po.UserPO;
import com.aierx.atx.service.IUserService;
import org.apache.cxf.feature.LoggingFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AtxApp {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(AtxApp.class, args);
        IUserService bean = run.getBean(IUserService.class);
        UserPO adadaa = bean.updateUser(new UserPO("asdsdasd", null));
        System.out.println(adadaa);
        System.exit(0);
    }
}
