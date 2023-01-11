package icu.aierx.boot.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author leiwenyong
 * @since 2023-01-08
 */
public class OrderCreateEvent extends ApplicationEvent {
	
	private Long orderId;
	/**
	 * Create a new {@code ApplicationEvent}.
	 *
	 * @param source the object on which the event initially occurred or with
	 *               which the event is associated (never {@code null})
	 */
	public OrderCreateEvent(Object source,Long oderId1) {
		super(source);
		this.orderId = oderId1;
	}
	
	public Long getOrderId() {
		return orderId;
	}
	
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
}
