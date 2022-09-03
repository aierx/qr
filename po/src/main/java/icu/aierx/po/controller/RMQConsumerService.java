package icu.aierx.po.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQReplyListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author leiwenyong
 * @since 2022-09-04
 */
@Slf4j
@Component
public class RMQConsumerService {

	@Service
	@RocketMQMessageListener(topic = "leiwenyong" ,selectorExpression = "tag1",consumerGroup = "l1")
	public class consumer implements RocketMQReplyListener<String,String>{
		@Override
		public String onMessage(String s) {
			log.info(s);
			throw new IllegalArgumentException();
		}
	}
}
