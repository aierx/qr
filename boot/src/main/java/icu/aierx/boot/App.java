package icu.aierx.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author leiwenyong
 * @since 2022-08-03
 */
@SpringBootApplication
@EnableAspectJAutoProxy
//@ComponentScan(basePackages = {"icu.aierx.boot.config"})
public class App {
	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(App.class,args);
		System.exit(1);
	}
}
