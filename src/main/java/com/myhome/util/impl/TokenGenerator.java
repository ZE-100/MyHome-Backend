package com.myhome.util.impl;

import com.myhome.api.components.token.dto.in.TokenInDTO;
import com.myhome.api.components.token.entity.Token;
import com.myhome.util.ITokenGenerator;
import com.myhome.util.TokenSaltGenerator;
import com.myhome.util.logging.Logger;
import com.myhome.util.logging.constants.LogType;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Component
public class TokenGenerator implements ITokenGenerator {

	public Token createNewToken(TokenInDTO tokenIn) {
		String uuid = UUID.randomUUID().toString();

		String[] parts = uuid.split("-", 3);

		String specialSecretTokenIngredient =
				TokenSaltGenerator.generateSpecialSecretTokenIngredient();

		String token = String.format("%s%s%s", parts[0], specialSecretTokenIngredient, parts[2]);

		if (token.length() != 39) {
			Logger.log(LogType.ERROR, this.getClass(), "Invalid UUID, Server side issue");
			throw new IllegalArgumentException("Invalid UUID, Server side issue");
		}

		Token newToken = new Token();
		newToken.setUuid(token);
		newToken.setDeviceSalt(tokenIn.getDeviceSalt());
		newToken.setCreatedAt(new Date());
		newToken.setFkAccountId(null); // ? Will be set, once user logs in

		return newToken;
	}
}
