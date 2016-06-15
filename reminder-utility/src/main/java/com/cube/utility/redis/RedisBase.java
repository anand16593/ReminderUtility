/*
 * Copyright (c) 2012 CitrusPay. All Rights Reserved.
 *
 * This software is the proprietary information of CitrusPay.
 * Use is subject to license terms.
 */
package com.cube.utility.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author AbidK
 * 
 */
public class RedisBase implements DisposableBean {
	
	private static Logger LOGGER = LoggerFactory.getLogger(RedisBase.class);
	
	@Autowired
	protected JedisPool jedisPool;

	public Long deleteKey(String key) {
		Jedis jedis = null;
		Long count = null;
		try {
			jedis = jedisPool.getResource();
			count = jedis.del(key);
			jedis.bgrewriteaof();

		} catch (Exception ex) {
			LOGGER.error("delete failed",ex);
		} finally {
			jedisPool.returnResource(jedis);
		}

		return count;
	}

	@Override
	public void destroy() {
		if (jedisPool != null) {
			LOGGER.debug("destroying jedis pool as container shutdown process");
			jedisPool.destroy();
		}
	}
}
