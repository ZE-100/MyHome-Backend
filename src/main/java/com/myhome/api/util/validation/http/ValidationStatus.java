package com.myhome.api.util.validation.http;

import lombok.Getter;

public enum ValidationStatus {
	OK(200, Series.SUCCESSFUL, "OK"),
	INFO(204, Series.INFORMATIONAL, "Information"),
	WARNING(400, Series.SUCCESSFUL, "Warning"),
	ERROR(401, Series.SERVER_ERROR, "Error");

	ValidationStatus(int value, Series series, String reasonPhrase) {}

	@Getter
	public enum Series {
		INFORMATIONAL(1),
		SUCCESSFUL(2),
		SERVER_ERROR(5);

		private final int value;

		Series(int value) {
			this.value = value;
		}

		boolean isSuccessful(int status) {
			return status == SUCCESSFUL.value;
		}
	}
}
