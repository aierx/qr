package icu.aierx.po.exception;

import lombok.extern.slf4j.Slf4j;
import org.apache.cxf.logging.FaultListener;
import org.apache.cxf.message.Message;

/**
 * @author leiwenyong
 * @since 2022-08-06
 */
@Slf4j
public class ValideLister implements FaultListener {
	@Override
	public boolean faultOccurred(Exception exception, String description, Message message) {
		log.error(exception.getMessage());
		return false;
	}
}
