package com.sunxu.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisUtils {

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
		byte[] b = SerializeUtil.serialize(value);
		jedis = getJedis();
		jedis.append(key, b);
	}

	/**
	 * 传入字符串作为键值对
	 * 
	 * @param key
	 * @param value
	 */
	public static void append(String key, String value) {
		jedis = getJedis();
		jedis.append(key, value);
	}

	public static void set(String key, String value) {
		jedis = getJedis();
		jedis.set(key, value);
	}

	public static void set(String key, String value, int timeOut) {
		jedis = getJedis();
		jedis.set(key, value);
		jedis.expire(key, timeOut);
	}

	/**
	 * 根据字符串key获取值
	 * 
	 * @param key
	 * @return
	 */
	public static String getValue(String key) {
		jedis = getJedis();
		String value = jedis.get(key);
		return value;
	}

	/**
	 * 根据对象key查找
	 * 
	 * @param key
	 * @return
	 */
	public static Object getValue(byte[] key) {
		jedis = getJedis();
		byte[] b = jedis.get(key);
		Object o = SerializeUtil.unserialize(b);
		return o;
	}

	/**
	 * 删除
	 * 
	 * @param key
	 */
	public static void remove(String key) {
		jedis = getJedis();
		jedis.del(key);
	}

	/**
	 * 删除
	 * 
	 * @param key
	 */
	public static void remove(byte[] key) {
		jedis = getJedis();
		jedis.del(key);
	}
}
