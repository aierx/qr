package icu.aierx.boot.event;

import java.util.EventListener;

/**
 * @author leiwenyong
 * @since 2023-01-08
 */
public interface EventMulticaster {

	void multicastEvent(AbstractEvent event);
	
	void addEventListener(EventListener listener);

	void removeEventListener(EventListener listener);

}
