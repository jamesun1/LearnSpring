package com.sunxu.utils;

import java.sql.Timestamp;
import java.util.Date;

public class DataUtils {

	private static DataUtils dataUtils = new DataUtils();

	private DataUtils() {
	}

	public static DataUtils getInstance() {
		if (dataUtils == null) {
			return new DataUtils();
		} else {
			return dataUtils;
		}
	}

	public Date TimestampToDate(Integer time) {
		long temp = (long) time * 1000;
		Timestamp ts = new Timestamp(temp);
		Date date = new Date();
		try {
			date = ts;
			// System.out.println(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}
}
