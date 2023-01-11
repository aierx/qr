package icu.aierx.boot.event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author leiwenyong
 * @since 2023-01-08
 */
@Component
public class SendEmailOnOrderCreateListener implements ApplicationListener<OrderCreateEvent> {
	@Override
	public void onApplicationEvent(OrderCreateEvent event) {
		System.out.println(event.getOrderId());
		
	}
	
	@EventListener
	public void sendmail(OrderCreateEvent event){
		System.out.println(event.getOrderId());
	}
}
