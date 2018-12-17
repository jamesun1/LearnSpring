package com.sunxu.vo;

public class StatisticsVo {

	private Integer times;

	private String win;

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (this == obj)
			return true;
		if (obj instanceof StatisticsVo) {
			StatisticsVo vo = (StatisticsVo) obj;
			// 比较每个属性的值 一致时才返回true
			if (vo.times == this.times && vo.win.equals(this.win))
				return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return times.hashCode() * win.hashCode();
	}

	public String getWin() {
		return win;
	}

	public void setWin(String win) {
		this.win = win;
	}

	public int getTimes() {
		return times;
	}

	public void setTimes(int times) {
		this.times = times;
	}

}
