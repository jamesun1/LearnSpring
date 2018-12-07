package com.sunxu.vo;

import com.sunxu.entity.DataSource;

public class DataSourceVo extends DataSource {
	private static final long serialVersionUID = 1L;

	private String digit;

	private String number;

	private String issue;

	public String getDigit() {
		return digit;
	}

	public void setDigit(String digit) {
		this.digit = digit;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

}
