package com.sunxu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sunxu.entity.UserInfo;
import com.sunxu.service.LogInService;
import com.sunxu.utils.ApiResult;
import com.sunxu.utils.LogicException;

@RestController
@RequestMapping("login")
public class LogInControlelr {

	@Autowired
	private LogInService logInService;

	@RequestMapping(value = "loginIndex", method = { RequestMethod.POST })
	public ApiResult loginIndex(@RequestBody UserInfo userInfo) {
		try {
			return logInService.loginIndex(userInfo);
		} catch (LogicException e) {
			return ApiResult.fail(e.getMessage());
		} catch (Exception e) {
			return ApiResult.fail(e.getMessage());
		}
	}
}
