package icu.aierx.boot.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * @author leiwenyong
 * @since 2023-01-08
 */
@Component
public class UserRegisterService implements ApplicationEventPublisherAware {
	private ApplicationEventPublisher applicationEventPublisher;
	public void registerUser(String name){
		applicationEventPublisher.publishEvent(new OrderCreateEvent(this,10001L));
	}
	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher = applicationEventPublisher;
	}
}
