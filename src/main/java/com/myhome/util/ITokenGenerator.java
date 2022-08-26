package com.myhome.util;

import com.myhome.api.components.token.dto.in.TokenInDTO;
import com.myhome.api.components.token.entity.Token;

public interface ITokenGenerator {

	Token createNewToken(TokenInDTO tokenIn);
}
