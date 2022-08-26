package com.myhome.api.components.token.dto.out;

import com.myhome.api.util.validation.ValidationResult;
import com.myhome.util.annotation.OutDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@OutDTO
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TokenOutDTO {

	private String token;

	private Date createdAt;

	private ValidationResult validationResult = ValidationResult.Ok();
}
