package com.myhome.api.util.validation;

import com.myhome.api.util.validation.http.ValidationStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ValidationResultEntry {

	private ValidationStatus status;

	private String reason;

	private String[] details;

	private boolean isInfo() {
		return this.status == ValidationStatus.INFO;
	}

	private boolean isWarning() {
		return this.status == ValidationStatus.WARNING;
	}

	private boolean isError() {
		return this.status == ValidationStatus.ERROR;
	}

	private boolean hasDetails() {
		return this.details.length > 0;
	}
}
