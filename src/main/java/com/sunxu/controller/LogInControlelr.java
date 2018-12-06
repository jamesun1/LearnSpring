package com.sunxu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.sunxu.service.LogInService;
import com.sunxu.utils.ApiResult;
import com.sunxu.utils.JedisUtils;
import com.sunxu.utils.LogicException;

@RestController
@RequestMapping("login")
public class LogInControlelr {

	@Autowired
	private LogInService logInService;

	@RequestMapping(value = "loginIndex", method = { RequestMethod.POST })
	public ApiResult loginIndex() {
		try {
			return logInService.loginIndex();
		} catch (LogicException e) {
			return ApiResult.fail(e.getMessage());
		} catch (Exception e) {
			return ApiResult.fail(e.getMessage());
		}
	}
}
