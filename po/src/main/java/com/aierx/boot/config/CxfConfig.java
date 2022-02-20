package com.aierx.boot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:/rs.service.xml")
public class CxfConfig {

//    @Bean
//    public ServletRegistrationBean createCxfServletRegistrationBean(){
//        CXFServlet cxfServlet = new CXFServlet();
//        ServletRegistrationBean<CXFServlet> registrationBean = new ServletRegistrationBean<>();
//        registrationBean.addUrlMappings("/rs");
//        registrationBean.setServlet(cxfServlet);
//        return registrationBean;
//    }
}
