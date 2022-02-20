package com.aierx.atx.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:/rs.client.xml")
public class CxfConfig {
}
