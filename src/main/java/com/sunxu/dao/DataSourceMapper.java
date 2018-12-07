package com.sunxu.dao;

import java.util.List;

import com.sunxu.entity.DataResult;
import com.sunxu.entity.DataSource;

import tk.mybatis.mapper.common.Mapper;

public interface DataSourceMapper extends Mapper<DataSource> {

	void insertDataResult(List<DataResult> dataResult);
}