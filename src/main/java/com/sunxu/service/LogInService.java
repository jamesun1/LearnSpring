package com.sunxu.service;

import com.sunxu.entity.UserInfo;
import com.sunxu.utils.ApiResult;
import com.sunxu.utils.LogicException;

public interface LogInService {

	ApiResult loginIndex(UserInfo userInfo) throws LogicException;

}
