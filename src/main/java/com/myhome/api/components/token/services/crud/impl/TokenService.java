package com.myhome.api.components.token.services.crud.impl;

import com.myhome.api.components.account.dto.in.AccountInDTO;
import com.myhome.api.components.token.dto.in.TokenInDTO;
import com.myhome.api.components.token.dto.out.TokenOutDTO;
import com.myhome.api.components.token.entity.Token;
import com.myhome.api.components.token.repository.ITokenRepository;
import com.myhome.api.components.token.services.crud.ITokenService;
import com.myhome.api.util.validation.ValidationResult;
import com.myhome.api.util.validation.http.ValidationStatus;
import com.myhome.util.ITokenGenerator;
import com.myhome.util.logging.Logger;
import com.myhome.util.logging.constants.LogType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class TokenService implements ITokenService {

	private final ITokenRepository repository;
	private final ITokenGenerator generator;

	@Override
	public TokenOutDTO generateNewToken(TokenInDTO tokenIn) {

		TokenOutDTO tokenOut = new TokenOutDTO();

		// Guard
		if (tokenIn.getDeviceSalt() == null) {
			Logger.log(LogType.ERROR, this.getClass(), "No device salt supplied");

			ValidationResult validationResult = new ValidationResult();
			validationResult.add(ValidationStatus.ERROR, "No device salt supplied", "sas", "sus");
			tokenOut.setValidationResult(validationResult);
			return tokenOut;
		}

		Token newToken = generator.createNewToken(tokenIn);

		repository.save(newToken);

		Optional<Token> savedToken = repository
				.findByUuidAndCreatedAt(newToken.getUuid(), newToken.getCreatedAt());

		// Guard
		if (savedToken.isEmpty()) {
			ValidationResult validationResult = new ValidationResult();
			validationResult.add(ValidationStatus.ERROR, "Failed to save token");
			tokenOut.setValidationResult(validationResult);
			return tokenOut;
		}

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
		return null;
	}
}
