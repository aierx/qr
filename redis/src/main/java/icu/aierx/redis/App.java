package icu.aierx.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

/**
 * @author leiwenyong
 * @since 2022-12-31
 */
@SpringBootApplication
@EnableRedisRepositories
public class App {
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
		
		JedisConnectionFactory redisFactory = context.getBean(JedisConnectionFactory.class);
		RedisTemplate redisTemplate = new RedisTemplate();
		redisTemplate.setConnectionFactory(redisFactory);
		redisTemplate.afterPropertiesSet();
		byte[] bytes = new byte[1024 * 1024];
		for (int i = 0; i < 1024 * 1024; i++) {
			bytes[i] = 'a';
		}
		for (int i = 1;i<100;i++){
			redisTemplate.execute((RedisCallback) connection -> connection.execute("set","leiwen".getBytes(),bytes));
		}
		System.out.println("aa");
	}
}
