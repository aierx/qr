package icu.aierx.boot.event;

import java.util.EventListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author leiwenyong
 * @since 2023-01-08
 */
public class SimpleEventMulticaster implements EventMulticaster{
	
	private Map<Class<?>, List<AbstractListener<?>>> eventObjectListenerMap = new HashMap<>();
	
	@Override
	public void multicastEvent(AbstractEvent event) {
		List<AbstractListener<?>> abstractEvents = this.eventObjectListenerMap.get(event);
		if (abstractEvents!=null){
			for (AbstractListener eventListener : abstractEvents) {
				eventListener.onEvent(event);
			}
		}
	}
	
	@Override
	public void addEventListener(EventListener listener) {
		this.getEventType(listener);
	}
	
	private void getEventType(EventListener listener) {
	}
	
	@Override
	public void removeEventListener(EventListener listener) {
	
	}
}
