package icu.aierx.springframework.context;

import icu.aierx.springframework.service.impl.HelloWordService;

/**
 * @author leiwenyong
 * @since 2022/3/12
 */
public class ApplicationContextTest {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        HelloWordService hello = (HelloWordService)context.getBean("hello");
        hello.helloWord();
    }
}
