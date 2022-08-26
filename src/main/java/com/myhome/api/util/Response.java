package com.myhome.api.util;

import com.myhome.api.util.validation.ValidationResult;
import com.myhome.util.annotation.OutDTO;
import lombok.Getter;
import lombok.Setter;

@OutDTO
@Setter
@Getter
public abstract class Response {

	private ValidationResult validationResult;
}
