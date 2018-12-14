package com.sunxu.service;

import com.sunxu.dao.DataSourceMapper;
import com.sunxu.dao.DataSourceProMapper;
import com.sunxu.dao.HistoryInfoMapper;
import com.sunxu.utils.ApiResult;
import com.sunxu.utils.LogicException;
import com.sunxu.vo.DataSourceVo;

public interface DataSourceService {
	void getDataSource(DataSourceProMapper dataSourceProMapper, DataSourceMapper dataSourceMapper, HistoryInfoMapper historyInfoMapper) throws LogicException;

	ApiResult getDataSource(DataSourceVo dataSourceVo) throws LogicException;
}
