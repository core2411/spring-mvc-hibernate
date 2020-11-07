package com.ankur.superhero.app.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	public static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	public static Date convertToDate(String date) {
		try {
			if (date != null) {
				Date formattedDate = dateFormat.parse(date);
				if (!dateFormat.format(formattedDate).equals(date)) {
					throw new ParseException("Unparseable date: \"" + date + "\"", -1);
				}
				return formattedDate;
			} else {
				throw new ParseException("Empty date", -1);
			}
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String convertToString(Date date) {
		try {
			return dateFormat.format(date);
		} catch (Exception e) {
			return null;
		}
	}
	
	public static String convertToString(Date date, String format) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(format);
			return dateFormat.format(date);
		} catch (Exception e) {
			return null;
		}
	}

}
