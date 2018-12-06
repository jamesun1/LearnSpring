package com.sunxu.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import okhttp3.OkHttpClient;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConf {
	private Logger logger = LoggerFactory.getLogger(RedisConf.class);

	@Bean
	public JedisPool openJedis() {
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		// 设置最大10个连接
		jedisPoolConfig.setMaxTotal(10);
		JedisPool pool = new JedisPool(jedisPoolConfig, "119.29.108.164", 6379, 2000, "123456");
		logger.info("redis注入成功");
		return pool;
	}

	@Bean
	public OkHttpClient openOkHttpClient() {
		OkHttpClient okHttpClient = new OkHttpClient();
		return okHttpClient;
	}
}
