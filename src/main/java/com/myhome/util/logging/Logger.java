package com.myhome.util.logging;

import com.myhome.util.logging.constants.LogType;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Logger {

	// 2021-03-24 16:48:05
	private static final SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static void log(LogType type, Class location, String... messages) {

		String current = sdf3.format(new Timestamp(System.currentTimeMillis()));

		StringBuilder message = new StringBuilder();
		for (Object s : messages)
			message.append(s.toString()).append(" | ");

		System.out.printf("%s - [%s] at %s\t- %s%n",
				current, type.getValue(), location , message);
	}
}
