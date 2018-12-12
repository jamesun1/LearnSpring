package com.sunxu.vo;

import java.util.List;

import com.sunxu.entity.DataSource;

public class DataSourceVo extends DataSource {
	private static final long serialVersionUID = 1L;

	private String digit;

	private String[] number;

	private String issue;

	private List<List<String>> dataList;

	private Double winningRate;
	
	private String times;
	
	private String maxContinue;
	
	private String maxNoContinue;
	
	private String currentNoContinue;

	public String getMaxContinue() {
		return maxContinue;
	}

	public void setMaxContinue(String maxContinue) {
		this.maxContinue = maxContinue;
	}

	public String getMaxNoContinue() {
		return maxNoContinue;
	}

	public void setMaxNoContinue(String maxNoContinue) {
		this.maxNoContinue = maxNoContinue;
	}

	public String getCurrentNoContinue() {
		return currentNoContinue;
	}

	public void setCurrentNoContinue(String currentNoContinue) {
		this.currentNoContinue = currentNoContinue;
	}

	public String getTimes() {
		return times;
	}

	public void setTimes(String times) {
		this.times = times;
	}

	public Double getWinningRate() {
		return winningRate;
	}

	public void setWinningRate(Double winningRate) {
		this.winningRate = winningRate;
	}

	public List<List<String>> getDataList() {
		return dataList;
	}

	public void setDataList(List<List<String>> dataList) {
		this.dataList = dataList;
	}

	public String getDigit() {
		return digit;
	}

	public void setDigit(String digit) {
		this.digit = digit;
	}
	
	public String[] getNumber() {
		return number;
	}

	public void setNumber(String[] number) {
		this.number = number;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

}
