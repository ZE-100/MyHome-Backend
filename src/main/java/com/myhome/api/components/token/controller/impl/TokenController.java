package com.myhome.api.components.token.controller.impl;

import com.myhome.api.components.account.dto.in.AccountInDTO;
import com.myhome.api.components.token.controller.ITokenController;
import com.myhome.api.components.token.dto.in.TokenInDTO;
import com.myhome.api.components.token.dto.out.TokenOutDTO;
import com.myhome.api.components.token.services.crud.ITokenService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TokenController implements ITokenController {

	private ITokenService service;

	@Override
	public TokenOutDTO generateNewToken(TokenInDTO tokenIn) {
		return service.generateNewToken(tokenIn);
	}

	@Override
	public TokenOutDTO updateToken(AccountInDTO accountIn) {
		return service.updateToken(accountIn);
	}

	@Override
	public TokenOutDTO getToken(AccountInDTO accountIn) {
		return service.getToken(accountIn);
	}
}
