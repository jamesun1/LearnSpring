package com.sunxu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sunxu.entity.PageBean;
import com.sunxu.entity.UserInfo;
import com.sunxu.service.DataSourceService;
import com.sunxu.utils.ApiResult;
import com.sunxu.utils.LogicException;
import com.sunxu.vo.DataSourceVo;

@RestController
@RequestMapping("dataSource")
public class DataSourceController {

	@Autowired
	private DataSourceService dataSourceService;

	@RequestMapping(value = "getDataSource", method = { RequestMethod.POST })
	public ApiResult getDataSource(@RequestBody DataSourceVo dataSourceVo) {
		try {
			return dataSourceService.getDataSource(dataSourceVo);
		} catch (LogicException e) {
			return ApiResult.fail(e.getMessage());
		} catch (Exception e) {
			return ApiResult.fail(e.getMessage());
		}
	}

	@RequestMapping(value = "getDataSourceByType", method = { RequestMethod.POST })
	public ApiResult getDataSourceByType(@RequestBody PageBean<String> params) {
		try {
			return dataSourceService.getDataSourceByType(params);
		} catch (LogicException e) {
			return ApiResult.fail(e.getMessage());
		} catch (Exception e) {
			return ApiResult.fail(e.getMessage());
		}
	}
}
