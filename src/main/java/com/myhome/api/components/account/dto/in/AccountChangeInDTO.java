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
public class AccountChangeInDTO extends AccountInDTO {

	private String newEmail;

	private String newPassword;
}
