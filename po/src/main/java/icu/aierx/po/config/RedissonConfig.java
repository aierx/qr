package icu.aierx.po.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;

/**
 * @author leiwenyong
 * @since 2022-08-11
 */
public class RedissonConfig {
	
	@Bean
	public RedissonClient redisson() {
		Config config = new Config();
		config.useSingleServer()
				.setAddress(String.format("%s%s", "redis://", "127.0.0.01"))
				.setConnectionPoolSize(64)              // 连接池大小
				.setConnectionMinimumIdleSize(8)        // 保持最小连接数
				.setConnectTimeout(1500)                // 建立连接超时时间
				.setTimeout(2000)                       // 执行命令的超时时间, 从命令发送成功时开始计时
				.setRetryAttempts(2)                    // 命令执行失败重试次数
				.setRetryInterval(1000);                // 命令重试发送时间间隔
		return Redisson.create(config);
	}
}
