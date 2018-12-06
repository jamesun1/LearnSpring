package com.sunxu.service.imp;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunxu.dao.UserInfoMapper;
import com.sunxu.entity.UserInfo;
import com.sunxu.service.LogInService;
import com.sunxu.utils.ApiResult;
import com.sunxu.utils.JedisUtils;
import com.sunxu.utils.LogicException;
import com.sunxu.utils.RequestUtils;

import redis.clients.jedis.Jedis;

@Service
public class LogInServiceImp implements LogInService {

	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private UserInfoMapper userInfoMapper;

	@Override
	public ApiResult loginIndex(UserInfo userInfo) throws LogicException {
		try {
			UserInfo userInfoExample = userInfoMapper.selectOne(userInfo);
			if (userInfoExample == null) {
				throw new LogicException("用户名或密码错误");
			} else {
				String userId = userInfoExample.getUserId();
				String token = UUID.randomUUID().toString();
				JedisUtils.set(token, userId, 60 * 1000);
				return ApiResult.success(token);
			}
		} catch (Exception e) {
			logger.warn(e.getMessage());
			throw new LogicException(e.getMessage());
		}
	}

	@Override
	public ApiResult generateRoutes(HttpServletRequest request) throws LogicException {
		try {
			String userId = RequestUtils.getCurrentUserId(request);
			
			return null;
		} catch (Exception e) {
			logger.warn(e.getMessage());
			throw new LogicException(e.getMessage());
		}
	}

}
