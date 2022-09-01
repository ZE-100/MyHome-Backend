package com.myhome.api.components.token.services.crud.impl;

import com.myhome.api.components.account.dto.in.AccountInDTO;
import com.myhome.api.components.token.dto.in.TokenInDTO;
import com.myhome.api.components.token.dto.out.TokenOutDTO;
import com.myhome.api.components.token.entity.Token;
import com.myhome.api.components.token.repository.ITokenRepository;
import com.myhome.api.components.token.services.crud.ITokenService;
import com.myhome.api.util.validation.CreateResponse;
import com.myhome.service.validation.IValidationService;
import com.myhome.util.ITokenGenerator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class TokenService implements ITokenService {

	private final ITokenRepository repository;
	private final ITokenGenerator generator;
	private final IValidationService validator;

	@Override
	public TokenOutDTO generateNewToken(TokenInDTO tokenIn) {

		TokenOutDTO tokenOut = new TokenOutDTO();

		if (tokenIn.getDeviceSalt() == null) // Guard
			return CreateResponse.newError(tokenOut, "No device salt supplied");

		Token newToken = generator.createNewToken(tokenIn);

		repository.save(newToken);

		Optional<Token> savedToken = repository
				.findByUuidAndCreatedAt(newToken.getUuid(), newToken.getCreatedAt());

		if (savedToken.isEmpty()) // Guard
			return CreateResponse.newError(tokenOut, "Failed to save token");

		tokenOut.setToken(savedToken.get().getUuid());
		tokenOut.setCreatedAt(savedToken.get().getCreatedAt());

		return tokenOut;
	}

	@Override
	public TokenOutDTO updateToken(AccountInDTO accountIn) {
		return null;
	}

	@Override
	public TokenOutDTO getToken(AccountInDTO accountIn) {

		TokenOutDTO tokenOut = new TokenOutDTO();

		if (accountAlreadyHasCorrectToken(accountIn, tokenOut))
			return CreateResponse.newSuccess(tokenOut, "Token already saved correctly");


		if (!validator.hasValidLogin(accountIn.getEmail(), accountIn.getPassword()))
			return CreateResponse.newError(tokenOut, "No valid login present");


		return null;
	}

	private boolean accountAlreadyHasCorrectToken(AccountInDTO accountIn, TokenOutDTO tokenOut) {
		if (accountIn.getToken() != null) {
			TokenInDTO tokenIn = accountIn.getToken();

			Optional<Token> potentialTokenFromDatabase =
					repository.findByUuidAndCreatedAt(tokenIn.getToken(), tokenIn.getCreatedAt());

			if (potentialTokenFromDatabase.isPresent()) {
				tokenOut.setToken(tokenIn.getToken());
				tokenOut.setCreatedAt(tokenIn.getCreatedAt());

				return true;
			}
		}
		return false;
	}
}
