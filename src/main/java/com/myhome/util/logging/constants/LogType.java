package com.myhome.util.logging.constants;

public enum LogType {
	INFO("[INFO]"),
	DEBUG("[DEBUG]"),
	ERROR("[ERROR]");

	final String value;

	LogType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
