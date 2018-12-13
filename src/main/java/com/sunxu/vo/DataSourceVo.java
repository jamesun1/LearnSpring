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

	private String zero;

	private String one;

	private String two;

	private String three;

	private String four;

	private String five;

	private String six;

	private String seven;

	private String eight;

	private String nine;
	
	public String getZero() {
		return zero;
	}

	public void setZero(String zero) {
		this.zero = zero;
	}

	public String getOne() {
		return one;
	}

	public void setOne(String one) {
		this.one = one;
	}

	public String getTwo() {
		return two;
	}

	public void setTwo(String two) {
		this.two = two;
	}

	public String getThree() {
		return three;
	}

	public void setThree(String three) {
		this.three = three;
	}

	public String getFour() {
		return four;
	}

	public void setFour(String four) {
		this.four = four;
	}

	public String getFive() {
		return five;
	}

	public void setFive(String five) {
		this.five = five;
	}

	public String getSix() {
		return six;
	}

	public void setSix(String six) {
		this.six = six;
	}

	public String getSeven() {
		return seven;
	}

	public void setSeven(String seven) {
		this.seven = seven;
	}

	public String getEight() {
		return eight;
	}

	public void setEight(String eight) {
		this.eight = eight;
	}

	public String getNine() {
		return nine;
	}

	public void setNine(String nine) {
		this.nine = nine;
	}

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
