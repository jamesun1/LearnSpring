package com.sunxu.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisUtils {

	static Logger logger = LoggerFactory.getLogger(JedisUtils.class);
	private static JedisPool pool = SpringContextUtil.getBean(JedisPool.class);

	private static Jedis jedis;

	public static Jedis getJedis() {
		return pool.getResource();
	}

	/**
	 * 传入对象最为键值对
	 * 
	 * @param key
	 * @param value
	 */
	public static void append(byte[] key, Object value) {
		try {
			byte[] b = SerializeUtil.serialize(value);
			jedis = getJedis();
			jedis.append(key, b);
		} catch (Exception e) {
			logger.warn(e.getMessage());
		} finally {
			returnResource(jedis);
		}
	}

	/**
	 * 传入字符串作为键值对
	 * 
	 * @param key
	 * @param value
	 */
	public static void append(String key, String value) {
		try {
			jedis = getJedis();
			jedis.append(key, value);
		} catch (Exception e) {
			logger.warn(e.getMessage());
		} finally {
			returnResource(jedis);
		}
	}

	public static void set(String key, String value) {
		try {
			jedis = getJedis();
			jedis.set(key, value);
		} catch (Exception e) {
			logger.warn(e.getMessage());
		} finally {
			returnResource(jedis);
		}
	}

	public static void set(String key, String value, int timeOut) {
		try {
			jedis = getJedis();
			jedis.set(key, value);
			jedis.expire(key, timeOut);
		} catch (Exception e) {
			logger.warn(e.getMessage());
		} finally {
			returnResource(jedis);
		}
	}

	/**
	 * 根据字符串key获取值
	 * 
	 * @param key
	 * @return
	 */
	public static String getValue(String key) {
		String value = null;
		try {
			jedis = getJedis();
			value = jedis.get(key);
			return value;
		} catch (Exception e) {
			logger.warn(e.getMessage());
		} finally {
			returnResource(jedis);
		}
		return value;
	}

	/**
	 * 根据对象key查找
	 * 
	 * @param key
	 * @return
	 */
	public static Object getValue(byte[] key) {
		Object o = null;
		try {
			jedis = getJedis();
			byte[] b = jedis.get(key);
			o = SerializeUtil.unserialize(b);
			return o;
		} catch (Exception e) {
			logger.warn(e.getMessage());
		} finally {
			returnResource(jedis);
		}
		return o;
	}

	/**
	 * 删除
	 * 
	 * @param key
	 */
	public static void remove(String key) {
		try {
			jedis = getJedis();
			jedis.del(key);
		} catch (Exception e) {
			logger.warn(e.getMessage());
		} finally {
			returnResource(jedis);
		}
	}

	/**
	 * 删除
	 * 
	 * @param key
	 */
	public static void remove(byte[] key) {
		try {
			jedis = getJedis();
			jedis.del(key);
		} catch (Exception e) {
			logger.warn(e.getMessage());
		} finally {
			returnResource(jedis);
		}
	}

	public static boolean isExit(String key) {
		try {
			return jedis.exists(key);
		} catch (Exception e) {
			logger.warn(e.getMessage());
		} finally {
			returnResource(jedis);
		}
		return false;
	}

	@SuppressWarnings("deprecation")
	public synchronized static void returnResource(Jedis jedis) {
		if (jedis != null) {
			pool.returnResource(jedis);
		}
	}
}
