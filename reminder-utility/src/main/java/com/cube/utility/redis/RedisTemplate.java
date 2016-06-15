/*
 * Copyright (c) 2012 CitrusPay. All Rights Reserved.
 *
 * This software is the proprietary information of CitrusPay.
 * Use is subject to license terms.
 */

package com.cube.utility.redis;

import org.springframework.stereotype.Component;

import redis.clients.jedis.Jedis;

@Component
public class RedisTemplate extends RedisBase{
	public <R> R execute(RedisCallback<R> callback){
		Jedis jedis = this.jedisPool.getResource();
		try{
			return callback.doInRedis(jedis);
		} finally{
			this.jedisPool.returnResource(jedis);
		}
	}
}
