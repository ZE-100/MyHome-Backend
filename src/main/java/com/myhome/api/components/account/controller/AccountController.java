package com.myhome.api.components.account.controller;

import com.myhome.api.components.account.dto.in.AccountChangeInDTO;
import com.myhome.api.components.account.dto.in.AccountInDTO;
import com.myhome.api.components.account.dto.out.AccountOutDTO;
import com.myhome.api.components.account.dto.in.AccountRegistrationInDTO;
import com.myhome.api.components.account.services.crud.impl.AccountService;
import com.myhome.api.util.Response;
import com.myhome.other.Constants;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(Constants.API.URL_ACCOUNT)
public class AccountController {

	private final AccountService accountService;

	@PostMapping(Constants.API.CRUD.URL_LOGIN)
	public AccountOutDTO login(@RequestHeader(name = "account") AccountInDTO account) {
		return accountService.login(account);
	}

	@PostMapping(value = Constants.API.CRUD.URL_REGISTER)
	public AccountOutDTO register(@RequestParam("accountRegistration") AccountRegistrationInDTO registration) {
		return accountService.register(registration);
	}

	@GetMapping(Constants.API.CRUD.URL_GET)
	public AccountOutDTO getAccount(@RequestParam("account") AccountInDTO account) {
		return accountService.getAccount(account);
	}

	@PostMapping(Constants.API.CRUD.URL_UPDATE)
	public AccountOutDTO updateAccount(@RequestParam("account") AccountChangeInDTO accountChangeIn) {
		return accountService.update(accountChangeIn);
	}

	@DeleteMapping(Constants.API.CRUD.URL_DELETE)
	public Response deleteAccount(@RequestParam("account") AccountInDTO account) {
		return accountService.delete(account);
	}

	@PutMapping(Constants.API.CRUD.URL_PW_FORGOTTEN)
	public void passwordForgotten(@RequestParam("account") AccountInDTO account) {
		accountService.delete(account);
	}
}

