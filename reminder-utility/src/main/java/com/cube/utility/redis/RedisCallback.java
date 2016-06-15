/*
/*
 * Copyright (c) 2012 CitrusPay. All Rights Reserved.
 *
 * This software is the proprietary information of CitrusPay.
 * Use is subject to license terms.
 */
package com.cube.utility.redis;

import redis.clients.jedis.Jedis;

public interface RedisCallback<R> {
	public R doInRedis(Jedis jedis);
}
