package icu.aierx.boot.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author leiwenyong
 * @since 2023-01-08
 */
public class UserEvent extends ApplicationEvent {
	/**
	 * Create a new {@code ApplicationEvent}.
	 *
	 * @param source the object on which the event initially occurred or with
	 *               which the event is associated (never {@code null})
	 */
	public UserEvent(Object source) {
		super(source);
	}
}
