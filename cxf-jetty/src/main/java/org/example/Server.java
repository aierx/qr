package org.example;

import org.apache.cxf.feature.LoggingFeature;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.example.service.rs.UserService;
import org.example.service.ws.UserWebService;

import java.util.Collections;

public class Server {
    public static void main(String[] args) {
        // restful
        JAXRSServerFactoryBean rsServerBean = new JAXRSServerFactoryBean();
        rsServerBean.setAddress("http://localhost:8080/rs");
        rsServerBean.setServiceBean(new UserService());
        rsServerBean.setFeatures(Collections.singletonList(new LoggingFeature()));
        rsServerBean.create();
        // webservice
        JaxWsServerFactoryBean wsServerBean = new JaxWsServerFactoryBean();
        wsServerBean.setAddress("http://localhost:8080/ws");
        wsServerBean.setFeatures(Collections.singletonList(new LoggingFeature()));
        wsServerBean.setServiceBean(new UserWebService());
        wsServerBean.create();
    }
}
