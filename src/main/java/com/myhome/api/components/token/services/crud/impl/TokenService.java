package com.myhome.api.components.token.services.crud.impl;

import com.myhome.api.components.account.dto.in.AccountInDTO;
import com.myhome.api.components.token.dto.in.TokenInDTO;
import com.myhome.api.components.token.dto.out.TokenOutDTO;
import com.myhome.api.components.token.services.crud.ITokenService;

public class TokenService implements ITokenService {

	@Override
	public TokenOutDTO generateNewToken(TokenInDTO tokenIn) {
		return null;
	}

	@Override
	public TokenOutDTO updateToken(AccountInDTO accountIn) {
		return null;
	}

	@Override
	public TokenOutDTO getToken(AccountInDTO accountIn) {
		return null;
	}
}
