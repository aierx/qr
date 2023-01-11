package icu.aierx.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

@Configuration
class AppConfig {

  @Bean
  public JedisConnectionFactory redisConnectionFactory() {
//    new JedisClientConfiguration()
    RedisStandaloneConfiguration config = new RedisStandaloneConfiguration("192.168.31.150", 6379);
//    config.setPassword("123456");
    return new JedisConnectionFactory(config);
  }
}