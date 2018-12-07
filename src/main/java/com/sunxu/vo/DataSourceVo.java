package com.sunxu.vo;

import java.util.List;

import com.sunxu.entity.DataSource;

public class DataSourceVo extends DataSource {
	private static final long serialVersionUID = 1L;

	private List<String> dataList;

	public List<String> getDataList() {
		return dataList;
	}

	public void setDataList(List<String> dataList) {
		this.dataList = dataList;
	}
}
