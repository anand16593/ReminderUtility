/*
 * Copyright (c) 2012 CitrusPay. All Rights Reserved.
 *
 * This software is the proprietary information of CitrusPay.
 * Use is subject to license terms.
 */

package com.cube.utility.redis;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import redis.clients.jedis.BinaryClient.LIST_POSITION;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.SortingParams;
import redis.clients.jedis.Tuple;

@Component
public class RedisDAOImpl implements RedisDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(RedisDAOImpl.class);

	@Autowired
	RedisTemplate redisTemplate;

	@Override
	public String set(final String key, final String value) {
		return redisTemplate.execute(new RedisCallback<String>() {
			@Override
			public String doInRedis(Jedis jedis) {
				return jedis.set(key, value);
			}
		});
	
	}

	@Override
	public String get(final String key) {
		return redisTemplate.execute(new RedisCallback<String>() {
			@Override
			public String doInRedis(Jedis jedis) {
				return jedis.get(key);
			}
		});
	}

	@Override
	public Boolean exists(final String key) {
		return redisTemplate.execute(new RedisCallback<Boolean>() {
			@Override
			public Boolean doInRedis(Jedis jedis) {
				return jedis.exists(key);
			}
		});
	}

	@Override
	public String type(String key) {
		return null;
	}

	@Override
	public Long expire(final String key, final int seconds) {
		return redisTemplate.execute(new RedisCallback<Long>() {
			@Override
			public Long doInRedis(Jedis jedis) {
				return jedis.expire(key, seconds);
			}
		});
	}

	@Override
	public Long expireAt(final String key, final long unixTime) {
		return redisTemplate.execute(new RedisCallback<Long>() {
			@Override
			public Long doInRedis(Jedis jedis) {
				return jedis.expireAt(key, unixTime);
			}
		});
	}

	@Override
	public Long ttl(String key) {
		return null;
	}

	@Override
	public boolean setbit(String key, long offset, boolean value) {
		return false;
	}

	@Override
	public boolean getbit(String key, long offset) {
		return false;
	}

	@Override
	public long setrange(String key, long offset, String value) {
		return 0;
	}

	@Override
	public String getrange(String key, long startOffset, long endOffset) {
		return null;
	}

	@Override
	public String getSet(final String key, final String value) {
		return redisTemplate.execute(new RedisCallback<String>() {
			@Override
			public String doInRedis(Jedis jedis) {
				return jedis.getSet(key, value);
			}
		});
	}

	@Override
	public Long setnx(final String key, final String value) {
		return redisTemplate.execute(new RedisCallback<Long>() {
			@Override
			public Long doInRedis(Jedis jedis) {
				return jedis.setnx(key, value);
			}
		});
	}

	@Override
	public String setex(final String key, final int seconds, final String value) {
		return redisTemplate.execute(new RedisCallback<String>() {
			@Override
			public String doInRedis(Jedis jedis) {
				return jedis.setex(key, seconds, value);
			}
		});
	}

	@Override
	public Long decrBy(String key, long integer) {
		return null;
	}

	@Override
	public Long decr(String key) {
		return null;
	}

	@Override
	public Long incrBy(final String key, final long integer) {
		return redisTemplate.execute(new RedisCallback<Long>() {
			@Override
			public Long doInRedis(Jedis jedis) {
				return jedis.incrBy(key, integer);
			}
		});
	}

	@Override
	public Long incr(String key) {
		return incrBy(key, 1L);
	}

	@Override
	public Long append(String key, String value) {
		return null;
	}

	@Override
	public String substr(String key, int start, int end) {
		return null;
	}

	@Override
	public Long hset(final String key, final String field, final String value) {
		return redisTemplate.execute(new RedisCallback<Long>() {
			@Override
			public Long doInRedis(Jedis jedis) {
				return jedis.hset(key, field, value);
			}
		});
	}

	@Override
	public String hget(final String key, final String field) {
		return redisTemplate.execute(new RedisCallback<String>() {
			@Override
			public String doInRedis(Jedis jedis) {
				return jedis.hget(key, field);
			}
		});
	}

	@Override
	public Long hsetnx(String key, String field, String value) {
		return null;
	}

	@Override
	public String hmset(final String key,
			final Map<String, String> binMasterData) {
		String result = redisTemplate.execute(new RedisCallback<String>() {
			@Override
			public String doInRedis(Jedis jedis) {
				return jedis.hmset(key, binMasterData);
			}
		});
		LOGGER.info("Response from redis for hmset: " + result);
		return result;
	}

	@Override
	public List<String> hmget(final String key, final String... fields) {
		return redisTemplate
				.execute(new RedisCallback<List<String>>() {
					@Override
					public List<String> doInRedis(Jedis jedis) {
						return jedis.hmget(key, fields);
					}
				});
	}

	@Override
	public String hmgetSingle(final String key, final String field) {
		List<String> result = this.hmget(key, field);
		return result == null || result.isEmpty() ? null : result.get(0);
	}

	@Override
	public Long hincrBy(String key, String field, long value) {
		return null;
	}

	@Override
	public Boolean hexists(final String key, final String field) {
		return redisTemplate.execute(new RedisCallback<Boolean>() {
			@Override
			public Boolean doInRedis(Jedis jedis) {
				return jedis.hexists(key, field);
			}
		});
	}

	@Override
	public Long hdel(final String key, final String field) {
		return redisTemplate.execute(new RedisCallback<Long>() {
			@Override
			public Long doInRedis(Jedis jedis) {
				return jedis.hdel(key, field);
			}
		});
	}

	@Override
	public Long hlen(String key) {
		return null;
	}

	@Override
	public Set<String> hkeys(final String key) {
		return redisTemplate
				.execute(new RedisCallback<Set<String>>() {
					@Override
					public Set<String> doInRedis(Jedis jedis) {
						return jedis.hkeys(key);
					}
				});
		
	}

	@Override
	public List<String> hvals(final String key) {
		return redisTemplate
				.execute(new RedisCallback<List<String>>() {
					@Override
					public List<String> doInRedis(Jedis jedis) {
						return jedis.hvals(key);
					}
				});
	}

	@Override
	public Map<String, String> hgetAll(final String key) {
		return redisTemplate
				.execute(new RedisCallback<Map<String, String>>() {
					@Override
					public Map<String, String> doInRedis(Jedis jedis) {
						return jedis.hgetAll(key);
					}
				});
	}

	@Override
	public Long rpush(String key, String string) {
		return null;
	}

	@Override
	public Long lpush(final String key, final String string) {
		return redisTemplate.execute(new RedisCallback<Long>() {
			@Override
			public Long doInRedis(Jedis jedis) {
				return jedis.lpush(key, string);
			}
		});
	}

	@Override
	public Long llen(String key) {
		return null;
	}

	@Override
	public List<String> lrange(final String key, final long start,
			final long end) {
		return redisTemplate
				.execute(new RedisCallback<List<String>>() {
					@Override
					public List<String> doInRedis(Jedis jedis) {
						return jedis.lrange(key, start, end);
					}
				});
	}

	@Override
	public String ltrim(final String key, final long start, final long end) {
		return redisTemplate.execute(new RedisCallback<String>() {
			@Override
			public String doInRedis(Jedis jedis) {
				return jedis.ltrim(key, start, end);
			}
		});
	}

	@Override
	public String lindex(String key, long index) {
		return null;
	}

	@Override
	public String lset(String key, long index, String value) {
		return null;
	}

	@Override
	public Long lrem(String key, long count, String value) {
		return null;
	}

	@Override
	public String lpop(String key) {
		return null;
	}

	@Override
	public String rpop(String key) {
		return null;
	}

	@Override
	public Long sadd(final String key, final String member) {
		return redisTemplate.execute(new RedisCallback<Long>() {
			@Override
			public Long doInRedis(Jedis jedis) {
				return jedis.sadd(key, member);
			}
		});
	}

	@Override
	public Long sadd(String key, List<String> values) {
		Long count = 0l;
		for (String value : values) {
			count += sadd(key, value);
		}
		return count;
	}

	@Override
	public Set<String> smembers(final String key) {
		return redisTemplate
				.execute(new RedisCallback<Set<String>>() {
					@Override
					public Set<String> doInRedis(Jedis jedis) {
						return jedis.smembers(key);
					}
				});
	}

	@Override
	public Long srem(String key, String member) {
		return null;
	}

	@Override
	public String spop(String key) {
		return null;
	}

	@Override
	public Long scard(String key) {
		return null;
	}

	@Override
	public Boolean sismember(final String key, final String member) {
		return redisTemplate.execute(new RedisCallback<Boolean>() {
			@Override
			public Boolean doInRedis(Jedis jedis) {
				return jedis.sismember(key, member);
			}
		});
	}

	@Override
	public String srandmember(String key) {
		return null;
	}

	@Override
	public Long zadd(String key, double score, String member) {
		return null;
	}

	@Override
	public Set<String> zrange(String key, int start, int end) {
		return new HashSet<String>();
	}

	@Override
	public Long zrem(String key, String member) {
		return null;
	}

	@Override
	public Double zincrby(String key, double score, String member) {
		return null;
	}

	@Override
	public Long zrank(String key, String member) {
		return null;
	}

	@Override
	public Long zrevrank(String key, String member) {
		return null;
	}

	@Override
	public Set<String> zrevrange(String key, int start, int end) {
		return new HashSet<String>();
	}

	@Override
	public Set<Tuple> zrangeWithScores(String key, int start, int end) {
		return new HashSet<Tuple>();
	}

	@Override
	public Set<Tuple> zrevrangeWithScores(String key, int start, int end) {
		return new HashSet<Tuple>();
	}

	@Override
	public Long zcard(String key) {
		
		return null;
	}

	@Override
	public Double zscore(String key, String member) {
		
		return null;
	}

	@Override
	public List<String> sort(String key) {
		
		return new ArrayList<String>();
	}

	@Override
	public List<String> sort(String key, SortingParams sortingParameters) {
		
		return new ArrayList<String>();
	}

	@Override
	public Long zcount(String key, double min, double max) {
		
		return null;
	}

	@Override
	public Set<String> zrangeByScore(String key, double min, double max) {
		
		return new HashSet<String>();
	}

	@Override
	public Set<String> zrevrangeByScore(String key, double max, double min) {
		
		return new HashSet<String>();
	}

	@Override
	public Set<String> zrangeByScore(String key, double min, double max,
			int offset, int count) {
		
		return new HashSet<String>();
	}

	@Override
	public Set<String> zrevrangeByScore(String key, double max, double min,
			int offset, int count) {
		
		return new HashSet<String>();
	}

	@Override
	public Set<Tuple> zrangeByScoreWithScores(String key, double min, double max) {
		
		return new HashSet<Tuple>();
	}

	@Override
	public Set<Tuple> zrevrangeByScoreWithScores(String key, double max,
			double min) {
		
		return new HashSet<Tuple>();
	}

	@Override
	public Set<Tuple> zrangeByScoreWithScores(String key, double min,
			double max, int offset, int count) {
		
		return new HashSet<Tuple>();
	}

	@Override
	public Set<Tuple> zrevrangeByScoreWithScores(String key, double max,
			double min, int offset, int count) {
		
		return new HashSet<Tuple>();
	}

	@Override
	public Long zremrangeByRank(String key, int start, int end) {
		
		return null;
	}

	@Override
	public Long zremrangeByScore(String key, double start, double end) {
		
		return null;
	}

	@Override
	public Long linsert(String key, LIST_POSITION where, String pivot,
			String value) {
		
		return null;
	}

	@Override
	public Long delete(final String key) {
		return  redisTemplate.execute(new RedisCallback<Long>() {
			@Override
			public Long doInRedis(Jedis jedis) {
				return jedis.del(key);
			}
		});
	}

	@Override
	public Long delete(final String... keys) {
		return redisTemplate.execute(new RedisCallback<Long>() {
			@Override
			public Long doInRedis(Jedis jedis) {
				return jedis.del(keys);
			}
		});
	}

	@Override
	public Set<String> keysMatchingPattern(final String pattern) {
		return redisTemplate
				.execute(new RedisCallback<Set<String>>() {
					@Override
					public Set<String> doInRedis(Jedis jedis) {
						return jedis.keys(pattern);
					}
				});
	}

}
