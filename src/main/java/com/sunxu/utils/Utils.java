package com.sunxu.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.sunxu.vo.DataSourceVo;

public class Utils {

	public static List<DataSourceVo> listSort(DataSourceVo dataSourceVo) {
		List<DataSourceVo> dtList = new ArrayList<DataSourceVo>();
		dtList.add(new DataSourceVo("0", dataSourceVo.getZero()));
		dtList.add(new DataSourceVo("1", dataSourceVo.getOne()));
		dtList.add(new DataSourceVo("2", dataSourceVo.getTwo()));
		dtList.add(new DataSourceVo("3", dataSourceVo.getThree()));
		dtList.add(new DataSourceVo("4", dataSourceVo.getFour()));
		dtList.add(new DataSourceVo("5", dataSourceVo.getFive()));
		dtList.add(new DataSourceVo("6", dataSourceVo.getSix()));
		dtList.add(new DataSourceVo("7", dataSourceVo.getSeven()));
		dtList.add(new DataSourceVo("8", dataSourceVo.getEight()));
		dtList.add(new DataSourceVo("9", dataSourceVo.getNine()));

		Collections.sort(dtList, new Comparator<DataSourceVo>() {

			@Override
			public int compare(DataSourceVo o1, DataSourceVo o2) {
				if (Integer.parseInt(o1.getTimes()) < Integer.parseInt(o2.getTimes())) {
					return 1;
				} else if (Integer.parseInt(o1.getTimes()) == Integer.parseInt(o2.getTimes())) {
					return 0;
				} else {
					return -1;
				}
			}
		});
		return dtList;
	}

	public static boolean findStr(String[] args, String str) {
		for (String s : args) {
			if (s.equals(str)) {
				return true;
			}
		}
		return false;
	}

	public static String dataToString(String[] dataList) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < dataList.length; i++) {
			if (sb.length() > 0) {// 该步即不会第一位有逗号，也防止最后一位拼接逗号！
				sb.append(",");
			}
			sb.append(dataList[i]);
		}
		return sb.toString();
	}

	public static String dataToString(List<DataSourceVo> dataList) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < dataList.size(); i++) {
			if (sb.length() > 0) {// 该步即不会第一位有逗号，也防止最后一位拼接逗号！
				sb.append(",");
			}
			sb.append(dataList.get(i).getNum());
		}
		return sb.toString();
	}

	public static double formatDouble(double d) {
		// 新方法，如果不需要四舍五入，可以使用RoundingMode.DOWN
		BigDecimal bg = new BigDecimal(d).setScale(3, RoundingMode.UP);
		return bg.doubleValue();
	}
}
