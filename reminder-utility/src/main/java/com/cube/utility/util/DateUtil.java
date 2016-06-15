package com.cube.utility.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	private static final String MONGO_UTC_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

	public static Date getDateFromMongo(String dateStr) {
		SimpleDateFormat format = new SimpleDateFormat(MONGO_UTC_FORMAT);
		Date date = null;
		try {
			return date = format.parse(dateStr);
		} catch (Exception e) {
			return date;
		}
	}
}
