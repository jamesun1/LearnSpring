package com.sunxu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sunxu.entity.UserInfo;
import com.sunxu.service.DataSourceService;
import com.sunxu.utils.ApiResult;
import com.sunxu.utils.LogicException;

@RestController
@RequestMapping("dataSource")
public class DataSourceController {

	@Autowired
	private DataSourceService dataSourceService;
	
	@RequestMapping(value = "getDataSource", method = { RequestMethod.GET })
	public ApiResult getDataSource(String number) {
		try {
			return dataSourceService.getDataSource(number);
		} catch (LogicException e) {
			return ApiResult.fail(e.getMessage());
		} catch (Exception e) {
			return ApiResult.fail(e.getMessage());
		}
	}
}
