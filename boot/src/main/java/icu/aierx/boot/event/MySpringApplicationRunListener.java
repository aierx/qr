package icu.aierx.boot.event;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author leiwenyong
 * @since 2023-01-08
 */
@Component
public class MySpringApplicationRunListener implements ApplicationListener<ApplicationStartingEvent> {

	
	@Override
	public void onApplicationEvent(ApplicationStartingEvent event) {
		System.out.println("情动");
	}
}
