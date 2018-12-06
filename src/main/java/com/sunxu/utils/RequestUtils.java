package com.sunxu.utils;

import javax.servlet.http.HttpServletRequest;

public class RequestUtils {

	public static String getCurrentUserId(HttpServletRequest request) throws LogicException {
		try {
			String token = request.getHeader("X-Token");
			String userId = JedisUtils.getValue(token);
			return userId;
		} catch (Exception e) {
			throw new LogicException(e.getMessage());
		}
	}
}
