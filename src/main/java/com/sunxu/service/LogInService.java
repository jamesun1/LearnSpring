package com.sunxu.service;

import javax.servlet.http.HttpServletRequest;

import com.sunxu.entity.UserInfo;
import com.sunxu.utils.ApiResult;
import com.sunxu.utils.LogicException;

public interface LogInService {

	ApiResult loginIndex(UserInfo userInfo) throws LogicException;

	ApiResult generateRoutes(HttpServletRequest request) throws LogicException;

}
