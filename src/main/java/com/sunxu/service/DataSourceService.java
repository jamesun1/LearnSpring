package com.sunxu.service;

import com.sunxu.dao.DataSourceMapper;
import com.sunxu.dao.DataSourceProMapper;
import com.sunxu.dao.HistoryInfoMapper;
import com.sunxu.entity.PageBean;
import com.sunxu.utils.ApiResult;
import com.sunxu.utils.LogicException;
import com.sunxu.vo.DataSourceVo;

public interface DataSourceService {
	void getDataSource(DataSourceProMapper dataSourceProMapper, DataSourceMapper dataSourceMapper,
			HistoryInfoMapper historyInfoMapper) throws LogicException;

	ApiResult getDataSource(DataSourceVo dataSourceVo) throws LogicException;

	ApiResult getDataSourceByType(PageBean<String> params) throws LogicException;

	ApiResult getDataCategary(String type) throws LogicException;
}
