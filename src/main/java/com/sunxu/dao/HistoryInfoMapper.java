package com.sunxu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sunxu.entity.HistoryInfo;

import tk.mybatis.mapper.common.Mapper;

public interface HistoryInfoMapper extends Mapper<HistoryInfo> {

	List<HistoryInfo> getDataSourceByType(@Param("type") String type);

	Integer selectCountByType(@Param("type") String type);
}