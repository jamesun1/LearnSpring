package com.sunxu.service.imp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sunxu.service.LogInService;
import com.sunxu.utils.ApiResult;
import com.sunxu.utils.LogicException;

@Service
public class LogInServiceImp implements LogInService {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public ApiResult loginIndex() throws LogicException {
		try {
			
			return null;
		} catch (Exception e) {
			logger.warn(e.getMessage());
			throw new LogicException("操作失败");
		}
	}

}
