package com.myhome.api.components.account.dto.in;

import com.myhome.util.annotation.InDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@InDTO
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountRegistrationInDTO {

	private String validationSentence;

	private String newHouseName;

	private String defaultMemberName;

	private AccountInDTO accountIn;
}
