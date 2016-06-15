/*
 * Copyright (c) 2012 CitrusPay. All Rights Reserved.
 *
 * This software is the proprietary information of CitrusPay.
 * Use is subject to license terms.
 */
package com.cube.utility.redis;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class JedisConfig {
	
	@Value("${jedis.pool.host}")
	private String jedisHost;

	@Value("${jedis.pool.max.active}")
	private String maxActive;

	@Value("${jedis.pool.max.idle}")
	private String maxIdle;

	@Value("${jedis.pool.max.wait}")
	private String maxWait;

	@Value("${jedis.pool.default.timeout}")
	private String defaultTimeout;

	@Bean
	public JedisPool getJedisPool() throws URISyntaxException {
		try {
			JedisPoolConfig config = new JedisPoolConfig();
			config.setMaxTotal(Integer.valueOf(maxActive));
			config.setMaxIdle(Integer.valueOf(maxIdle));
			config.setMinIdle(1);
			config.setMaxWaitMillis(Integer.valueOf(maxWait));
			config.setNumTestsPerEvictionRun(3);
			config.setTestOnBorrow(true);
			config.setTestOnReturn(true);
			config.setTestWhileIdle(true);
			config.setTimeBetweenEvictionRunsMillis(30000);

			URI jedisURI = new URI(jedisHost);
			return new JedisPool(config, jedisURI.getHost(),
					jedisURI.getPort(), Integer.valueOf(defaultTimeout), null);
		} catch (URISyntaxException e) {
			throw e;
		}
	}
}
