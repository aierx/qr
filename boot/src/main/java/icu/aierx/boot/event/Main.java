package icu.aierx.boot.event;

import org.springframework.context.event.SimpleApplicationEventMulticaster;

/**
 * @author leiwenyong
 * @since 2023-01-08
 */
public class Main {
	public static void main(String[] args) {
		SimpleApplicationEventMulticaster multicaster = new SimpleApplicationEventMulticaster();
		multicaster.addApplicationListener(new SendEmailOnOrderCreateListener());
		multicaster.multicastEvent(new OrderCreateEvent(multicaster,10001L));
	}
}
