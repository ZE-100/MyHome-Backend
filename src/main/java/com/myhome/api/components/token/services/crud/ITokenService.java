package com.myhome.api.components.token.services.crud;

import com.myhome.api.components.account.dto.in.AccountInDTO;
import com.myhome.api.components.token.dto.in.TokenInDTO;
import com.myhome.api.components.token.dto.out.TokenOutDTO;

public interface ITokenService {

	TokenOutDTO generateNewToken(TokenInDTO tokenIn);

	TokenOutDTO updateToken(AccountInDTO accountIn);

	TokenOutDTO getToken(AccountInDTO accountIn);
}
