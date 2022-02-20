package org.example.rs;

import org.apache.cxf.feature.LoggingFeature;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.example.rs.service.rs.IUserService;
import org.example.rs.service.ws.IUserWebService;

import java.util.Collections;

public class WSClient {
    public static void main(String[] args) {
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
        jaxWsProxyFactoryBean.setAddress("http://localhost:8080/ws");
        jaxWsProxyFactoryBean.setServiceClass(IUserWebService.class);
        jaxWsProxyFactoryBean.setFeatures(Collections.singletonList(new LoggingFeature()));
        IUserWebService webService = (IUserWebService)jaxWsProxyFactoryBean.create();
        System.out.println(webService.getUser(10));
    }
}
