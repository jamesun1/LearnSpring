package com.sunxu.service;

import com.sunxu.dao.DataSourceMapper;
import com.sunxu.utils.ApiResult;
import com.sunxu.utils.LogicException;

public interface DataSourceService {
	void getDataSource(DataSourceMapper dataSourceMapper) throws LogicException;

	ApiResult getDataSource(String number) throws LogicException;
}
