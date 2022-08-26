package com.myhome.api.components.account.controller.impl;

import com.myhome.api.components.account.controller.IAccountController;
import com.myhome.api.components.account.dto.in.AccountChangeInDTO;
import com.myhome.api.components.account.dto.in.AccountInDTO;
import com.myhome.api.components.account.dto.out.AccountOutDTO;
import com.myhome.api.components.account.dto.in.AccountRegistrationInDTO;
import com.myhome.api.components.account.services.crud.impl.AccountService;
import com.myhome.api.util.Response;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class AccountController implements IAccountController {

	private final AccountService accountService;

	@Override
	public AccountOutDTO login(AccountInDTO account) {
		return accountService.login(account);
	}

	@Override
	public AccountOutDTO register(AccountRegistrationInDTO registration) {
		return accountService.register(registration);
	}

	@Override
	public AccountOutDTO getAccount(AccountInDTO account) {
		return accountService.getAccount(account);
	}

	@Override
	public AccountOutDTO updateAccount(AccountChangeInDTO accountChangeIn) {
		return accountService.update(accountChangeIn);
	}

	@Override
	public Response deleteAccount(AccountInDTO account) {
		return accountService.delete(account);
	}

	@Override
	public void passwordForgotten(AccountInDTO account) {
		accountService.delete(account);
	}
}

