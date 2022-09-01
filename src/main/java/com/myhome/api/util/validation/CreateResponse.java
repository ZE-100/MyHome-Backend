package com.myhome.api.util.validation;

import com.myhome.api.util.Response;
import com.myhome.api.util.validation.http.ValidationStatus;

public class CreateResponse {

	public static <T extends Response> T newError(T t, String message) {
		ValidationResult validationResult = new ValidationResult();
		validationResult.add(ValidationStatus.ERROR, message);
		t.setValidationResult(validationResult);
		return t;
	}

	public static <T extends Response> T newSuccess(T t, String message) {
		ValidationResult validationResult = new ValidationResult();
		validationResult.add(ValidationStatus.OK, message);
		t.setValidationResult(validationResult);
		return t;
	}
}
