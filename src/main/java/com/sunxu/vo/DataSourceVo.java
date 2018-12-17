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

	private String num;

	private List<DataSourceVo> fourMax;

	private List<DataSourceVo> fiveMax;

	private List<DataSourceVo> sixMax;

	private String lastNum;

	private double fourProbability;

	private double fiveProbability;

	private double sixProbability;

	private double fourMaxContinue;

	private double fiveMaxContinue;

	private double sixMaxContinue;

	private double fourMinContinue;

	private double fiveMinContinue;

	private double sixMinContinue;
	
	private List<StatisticsVo> winList;
	
	private List<StatisticsVo> lossList;

	public List<StatisticsVo> getWinList() {
		return winList;
	}

	public void setWinList(List<StatisticsVo> winList) {
		this.winList = winList;
	}

	public List<StatisticsVo> getLossList() {
		return lossList;
	}

	public void setLossList(List<StatisticsVo> lossList) {
		this.lossList = lossList;
	}

	public double getFourMaxContinue() {
		return fourMaxContinue;
	}

	public void setFourMaxContinue(double fourMaxContinue) {
		this.fourMaxContinue = fourMaxContinue;
	}

	public double getFiveMaxContinue() {
		return fiveMaxContinue;
	}

	public void setFiveMaxContinue(double fiveMaxContinue) {
		this.fiveMaxContinue = fiveMaxContinue;
	}

	public double getSixMaxContinue() {
		return sixMaxContinue;
	}

	public void setSixMaxContinue(double sixMaxContinue) {
		this.sixMaxContinue = sixMaxContinue;
	}

	public double getFourMinContinue() {
		return fourMinContinue;
	}

	public void setFourMinContinue(double fourMinContinue) {
		this.fourMinContinue = fourMinContinue;
	}

	public double getFiveMinContinue() {
		return fiveMinContinue;
	}

	public void setFiveMinContinue(double fiveMinContinue) {
		this.fiveMinContinue = fiveMinContinue;
	}

	public double getSixMinContinue() {
		return sixMinContinue;
	}

	public void setSixMinContinue(double sixMinContinue) {
		this.sixMinContinue = sixMinContinue;
	}

	public double getFourProbability() {
		return fourProbability;
	}

	public void setFourProbability(double fourProbability) {
		this.fourProbability = fourProbability;
	}

	public double getFiveProbability() {
		return fiveProbability;
	}

	public void setFiveProbability(double fiveProbability) {
		this.fiveProbability = fiveProbability;
	}

	public double getSixProbability() {
		return sixProbability;
	}

	public void setSixProbability(double sixProbability) {
		this.sixProbability = sixProbability;
	}

	public String getLastNum() {
		return lastNum;
	}

	public void setLastNum(String lastNum) {
		this.lastNum = lastNum;
	}

	public DataSourceVo() {
		super();
	}

	public DataSourceVo(String num, String times) {
		this.num = num;
		this.times = times;
	}

	public List<DataSourceVo> getFourMax() {
		return fourMax;
	}

	public void setFourMax(List<DataSourceVo> fourMax) {
		this.fourMax = fourMax;
	}

	public List<DataSourceVo> getFiveMax() {
		return fiveMax;
	}

	public void setFiveMax(List<DataSourceVo> fiveMax) {
		this.fiveMax = fiveMax;
	}

	public List<DataSourceVo> getSixMax() {
		return sixMax;
	}

	public void setSixMax(List<DataSourceVo> sixMax) {
		this.sixMax = sixMax;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

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
