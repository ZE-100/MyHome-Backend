package com.myhome.util.logging.constants;

public enum LoggerLevel {
	INFO("[INFO]"),
	DEBUG("[DEBUG]"),
	ERROR("[ERROR]");

	final String value;

	LoggerLevel(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
