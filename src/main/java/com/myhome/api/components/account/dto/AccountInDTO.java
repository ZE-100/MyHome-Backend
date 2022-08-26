package com.myhome.api.components.account.dto;

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
public abstract class AccountInDTO {

	private String email;

	private String password;

	private String token;
}
