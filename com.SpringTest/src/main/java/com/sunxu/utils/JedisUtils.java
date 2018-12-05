package com.sunxu.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisUtils {

	private static Jedis jedis = SpringContextUtil.getBean(Jedis.class);

	/**
	 * 传入对象最为键值对
	 * 
	 * @param key
	 * @param value
	 */
	public static void append(byte[] key, Object value) {
		byte[] b = SerializeUtil.serialize(value);
		jedis.append(key, b);
	}

	/**
	 * 传入字符串作为键值对
	 * 
	 * @param key
	 * @param value
	 */
	public static void append(String key, String value) {
		jedis.append(key, value);
	}

	public static void set(String key, String value) {
		jedis.set(key, value);
	}

	/**
	 * 根据字符串key获取值
	 * 
	 * @param key
	 * @return
	 */
	public static String getValue(String key) {
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
		jedis.del(key);
	}

	/**
	 * 删除
	 * 
	 * @param key
	 */
	public static void remove(byte[] key) {
		jedis.del(key);
	}
}
