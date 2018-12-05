package com.sunxu.dao;

import com.sunxu.entity.DataSource;

public interface DataSourceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DataSource record);

    int insertSelective(DataSource record);

    DataSource selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DataSource record);

    int updateByPrimaryKey(DataSource record);
}