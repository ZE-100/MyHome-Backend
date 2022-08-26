package com.myhome.api.components.account.dto.in;

import com.myhome.api.components.token.dto.in.TokenInDTO;
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
public class AccountInDTO {

	private String email;

	private String password;

	private TokenInDTO token;
}
