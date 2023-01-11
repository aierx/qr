package icu.aierx.boot.event;

/**
 * @author leiwenyong
 * @since 2023-01-08
 */
public interface AbstractListener<E extends AbstractEvent> {
	
	void  onEvent(E ev);
}
