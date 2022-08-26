package com.myhome.util.logging;

import com.myhome.util.logging.constants.LoggerLevel;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Logger {

	// 2021-03-24 16:48:05
	private static final SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static String log(LoggerLevel level, String message) {

		String current = sdf3.format(new Timestamp(System.currentTimeMillis()));

		System.out.printf("%s\t-\t%s\t%s%n", current, level.getValue(), message);

		return message;
	}
}
