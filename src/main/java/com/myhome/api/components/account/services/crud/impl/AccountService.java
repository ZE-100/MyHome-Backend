package com.myhome.api.components.account.services.crud.impl;

import com.myhome.api.components.account.dto.AccountChangeInDTO;
import com.myhome.api.components.account.dto.AccountInDTO;
import com.myhome.api.components.account.dto.AccountOutDTO;
import com.myhome.api.components.account.dto.AccountRegistrationInDTO;
import com.myhome.api.components.account.entity.Account;
import com.myhome.api.components.account.repository.IAccountRepository;
import com.myhome.api.components.account.services.crud.IAccountService;
import com.myhome.api.components.account.services.crud.ILoginService;
import com.myhome.api.components.account.services.crud.IRegisterService;
import com.myhome.api.components.account.services.mapper.AAccountMapper;
import com.myhome.api.util.Response;
import com.myhome.api.util.ValidationResult;
import com.myhome.service.validation.IValidationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class AccountService implements IAccountService, IRegisterService, ILoginService {

	private final IAccountRepository accountRepository;

	private final IValidationService passwordValidation;
	private final AAccountMapper accountMapper;

	@Override
	public AccountOutDTO login(AccountInDTO account) {
		return null;
	}

	@Override
	public AccountOutDTO register(AccountRegistrationInDTO registration) {
		return null;
	}

	@Override
	public AccountOutDTO getAccount(AccountInDTO accountIn) {
		return null;
	}

	@Override
	public AccountOutDTO update(AccountChangeInDTO accountChangeIn) {
		return null;
	}

	@Override
	public Response delete(AccountInDTO accountIn) {
		return null;
	}

	@Override
	public void forgottenPassword(AccountInDTO accountIn) {
		//TODO Conformation E-Mail, with URL to change PW
	}
}
