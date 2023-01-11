package icu.aierx.boot.config;

//import org.apache.catalina.connector.Connector;

import icu.aierx.boot.beanFactory.annonation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.scheduling.concurrent.ThreadPoolExecutorFactoryBean;

import java.util.concurrent.Executor;

//import org.springframework.web.socket.server.standard.ServerEndpointExporter;
@Configuration
public class WebSocketConfig {

	//
//    @Bean
//    public ServerEndpointExporter serverEndpointExporter(){
//        return new ServerEndpointExporter();
//    }
//
//    @Bean
//    public ServletWebServerFactory servletContainer() {
//        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
//        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
//        connector.setPort(8080);
//        tomcat.addAdditionalTomcatConnectors(connector);
//        return tomcat;
//    }
	@Bean
	public ApplicationEventMulticaster applicationEventMulticaster(){
		SimpleApplicationEventMulticaster multicaster = new SimpleApplicationEventMulticaster();
		Executor executor = this.applicationEventMulticasterThreadPool().getObject();
		multicaster.setTaskExecutor(executor);
		return multicaster;
	}
	
	@Bean
	public ThreadPoolExecutorFactoryBean applicationEventMulticasterThreadPool(){
		ThreadPoolExecutorFactoryBean result = new ThreadPoolExecutorFactoryBean();
		result.setThreadNamePrefix("leiwenyong");
		result.setCorePoolSize(5);
		return result;
	}
	
	
}