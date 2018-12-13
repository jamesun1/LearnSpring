package com.sunxu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sunxu.entity.DataResult;
import com.sunxu.entity.DataSource;
import com.sunxu.vo.DataSourceVo;

import tk.mybatis.mapper.common.Mapper;

public interface DataSourceMapper extends Mapper<DataSource> {

	void insertDataResult(List<DataResult> dataResult);

	List<DataSource> getDataSource(@Param("issue") String issue);

	DataSourceVo getContinuousDataSource(@Param("issue") String issueNum, @Param("str") String str);

	DataSourceVo getNotContinuousDataSource(@Param("issue") String issueNum, @Param("str") String str);

	DataSourceVo getCurrentNotContinuousDataSource(@Param("issue") String issueNum, @Param("str") String str);

	List<List<String>> getAllCurrentNotCon(@Param("issue")String issueNum);
}